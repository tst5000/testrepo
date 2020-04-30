package com.tst5000.agricrafttfctngintegration.network;

import com.google.common.collect.ImmutableList;
import com.tst5000.agricrafttfctngintegration.api.v1.AgriApi;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStat;
import com.tst5000.agricrafttfctngintegration.tiles.storage.SeedStorageSlot;
import com.tst5000.agricrafttfctngintegration.tiles.storage.TileEntitySeedStorage;
import com.infinityraider.infinitylib.network.MessageBase;
import com.infinityraider.infinitylib.network.serialization.ByteBufUtil;
import com.infinityraider.infinitylib.network.serialization.IMessageReader;
import com.infinityraider.infinitylib.network.serialization.IMessageSerializer;
import com.infinityraider.infinitylib.network.serialization.IMessageWriter;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageTileEntitySeedStorage extends MessageBase<IMessage> {

    private BlockPos pos;
    private int slotId;
    private int amount;
    private IAgriStat stats;

    public MessageTileEntitySeedStorage() {
    }

    public MessageTileEntitySeedStorage(BlockPos pos, SeedStorageSlot slot) {
        this.pos = pos;
        if (slot != null) {
            this.slotId = slot.getId();
            this.amount = slot.count;
            this.stats = slot.getSeed().getStat();
        } else {
            this.slotId = -1;
        }
    }

    @Override
    public Side getMessageHandlerSide() {
        return Side.CLIENT;
    }

    @Override
    protected void processMessage(MessageContext ctx) {
        TileEntity te = FMLClientHandler.instance().getClient().world.getTileEntity(this.pos);
        if (te instanceof TileEntitySeedStorage) {
            TileEntitySeedStorage storage = (TileEntitySeedStorage) te;
            ItemStack stack = storage.getLockedSeed().map(s -> s.toStack()).orElse(null);
            if (stack != null) {
                stack.setCount(this.amount);
                NBTTagCompound tag = new NBTTagCompound();
                stats.writeToNBT(tag);
                stack.setTagCompound(tag);
                storage.setSlotContents(this.slotId, stack);
            }
        }
    }

    @Override
    protected IMessage getReply(MessageContext ctx) {
        return null;
    }

    @Override
    protected List<IMessageSerializer> getNecessarySerializers() {
        return ImmutableList.of(new IMessageSerializer<IAgriStat>() {
            @Override
            public boolean accepts(Class<IAgriStat> clazz) {
                return IAgriStat.class.isAssignableFrom(clazz);
            }

            @Override
            public IMessageWriter<IAgriStat> getWriter(Class<IAgriStat> clazz) {
                return (buf, data) -> {
                    NBTTagCompound tag = new NBTTagCompound();
                    data.writeToNBT(tag);
                    ByteBufUtil.writeNBT(buf, tag);
                };
            }

            @Override
            public IMessageReader<IAgriStat> getReader(Class<IAgriStat> clazz) {
                return buf -> AgriApi.getStatRegistry().valueOf(ByteBufUtil.readNBT(buf)).get();
            }
        });
    }
}
