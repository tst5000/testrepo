package com.tst5000.agricrafttfctngintegration.handler;

import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.agricrafttfctngintegration.agritfccore.log.AgriLogger;
import com.agricrafttfctngintegration.agritfccore.plant.AgriMutation;
import com.agricrafttfctngintegration.agritfccore.plant.AgriPlant;
import com.agricrafttfctngintegration.agritfccore.plant.AgriSoil;
import com.tst5000.agricrafttfctngintegration.network.json.MessageSyncMutationJson;
import com.tst5000.agricrafttfctngintegration.network.json.MessageSyncPlantJson;
import com.tst5000.agricrafttfctngintegration.network.json.MessageSyncSoilJson;
import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerConnectToServerHandler {

    private static final AgriLogger LOG = AgriCore.getLogger("agricraft-net");

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void onConnect(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayerMP player = (EntityPlayerMP) event.player;
        syncSoils(player);
        syncPlants(player);
        syncMutations(player);
    }

    private void syncSoils(EntityPlayerMP player) {
        LOG.debug("Sending soils to player: " + player.getDisplayNameString());
        final int count = AgriCore.getSoils().getAll().size();
        Iterator<AgriSoil> it = AgriCore.getSoils().getAll().iterator();
        for (int i = 0; it.hasNext(); i++) {
            AgriSoil soil = it.next();
            LOG.debug("Sending Soil: {0} ({1} of {2})", soil, i + 1, count);
            new MessageSyncSoilJson(soil, i, count).sendTo(player);
        }
        LOG.debug("Finished sending soils to player: " + player.getDisplayNameString());
    }

    private void syncPlants(EntityPlayerMP player) {
        LOG.debug("Sending plants to player: " + player.getDisplayNameString());
        final int count = AgriCore.getPlants().getAll().size();
        Iterator<AgriPlant> it = AgriCore.getPlants().getAll().iterator();
        for (int i = 0; it.hasNext(); i++) {
            AgriPlant plant = it.next();
            LOG.debug("Sending plant: {0} ({1} of {2})", plant.getPlantName(), i + 1, count);
            new MessageSyncPlantJson(plant, i, count).sendTo(player);
        }
        LOG.debug("Finished sending plants to player: " + player.getDisplayNameString());
    }

    private void syncMutations(EntityPlayerMP player) {
        LOG.debug("Sending mutations to player: " + player.getDisplayNameString());
        final int count = AgriCore.getMutations().getAll().size();
        final Iterator<AgriMutation> it = AgriCore.getMutations().getAll().iterator();
        for (int i = 0; it.hasNext(); i++) {
            AgriMutation mutation = it.next();
            LOG.debug("Sending mutation: ({0} of {1})", i + 1, count);
            new MessageSyncMutationJson(mutation, i, count).sendTo(player);
        }
        LOG.debug("Finished sending mutations to player: " + player.getDisplayNameString());
    }

}
