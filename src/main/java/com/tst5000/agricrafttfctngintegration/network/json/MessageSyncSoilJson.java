package com.tst5000.agricrafttfctngintegration.network.json;

import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.agricrafttfctngintegration.agritfccore.json.AgriSaver;
import com.agricrafttfctngintegration.agritfccore.plant.AgriSoil;
import com.google.common.collect.ImmutableList;
import com.tst5000.agricrafttfctngintegration.api.v1.AgriApi;
import com.tst5000.agricrafttfctngintegration.core.CoreHandler;
import com.tst5000.agricrafttfctngintegration.core.JsonSoil;
import com.infinityraider.infinitylib.network.MessageBase;
import com.infinityraider.infinitylib.network.serialization.IMessageSerializer;
import java.nio.file.Path;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageSyncSoilJson extends MessageBase<IMessage> {

    private AgriSoil soil;
    private int index;
    private int count;

    @SuppressWarnings("unused")
    public MessageSyncSoilJson() {
    }

    public MessageSyncSoilJson(AgriSoil soil, int index, int count) {
        this.soil = soil;
        this.index = index;
        this.count = count;
    }

    @Override
    public Side getMessageHandlerSide() {
        return Side.CLIENT;
    }

    @Override
    protected IMessage getReply(MessageContext ctx) {
        return null;
    }

    @Override
    protected void processMessage(MessageContext ctx) {

        if (this.index == 0) {
            AgriCore.getSoils().clearElements();
        }

        // Add the soil
        AgriCore.getSoils().addSoil(soil);
        AgriCore.getLogger("agricraft-net").debug("Recieved Soil {0} ({1} of {2}).", soil.getName(), index + 1, count);

        if (this.index == this.count - 1) {
            final Path worldDir = CoreHandler.getJsonDir().resolve(this.getServerId());
            AgriSaver.saveElements(worldDir, AgriCore.getSoils().getAll());
            AgriCore.getSoils().getAll().stream()
                    .map(JsonSoil::new)
                    .forEach(AgriApi.getSoilRegistry()::add);
        }
    }

    @Override
    protected List<IMessageSerializer> getNecessarySerializers() {
        return ImmutableList.of(new JsonSerializer<AgriSoil>());
    }

    @SideOnly(Side.CLIENT)
    public final String getServerId() {
        final ServerData data = Minecraft.getMinecraft().getCurrentServerData();
        return "server_" + data.serverIP.replaceAll("\\.", "-").replaceAll(":", "_");
    }

}
