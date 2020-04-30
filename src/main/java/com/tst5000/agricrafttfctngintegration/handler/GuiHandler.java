package com.tst5000.agricrafttfctngintegration.handler;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityPeripheral;
import com.tst5000.agricrafttfctngintegration.container.ContainerSeedAnalyzer;
import com.tst5000.agricrafttfctngintegration.container.ContainerSeedStorage;
import com.tst5000.agricrafttfctngintegration.container.ContainerSeedStorageController;
import com.tst5000.agricrafttfctngintegration.gui.AgriGuiWrapper;
import com.tst5000.agricrafttfctngintegration.gui.GuiPeripheral;
import com.tst5000.agricrafttfctngintegration.gui.GuiSeedAnalyzer;
import com.tst5000.agricrafttfctngintegration.gui.journal.GuiJournal;
import com.tst5000.agricrafttfctngintegration.gui.storage.GuiSeedStorage;
import com.tst5000.agricrafttfctngintegration.gui.storage.GuiSeedStorageController;
import com.tst5000.agricrafttfctngintegration.items.ItemJournal;
import com.tst5000.agricrafttfctngintegration.tiles.analyzer.TileEntitySeedAnalyzer;
import com.tst5000.agricrafttfctngintegration.tiles.storage.TileEntitySeedStorage;
import com.tst5000.agricrafttfctngintegration.tiles.storage.TileEntitySeedStorageController;
import com.tst5000.agricrafttfctngintegration.utility.StackHelper;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Gui Handler.
 *
 * This class should be replaced with something automatic, since this stuff should be easily
 * automated...
 */
public class GuiHandler implements IGuiHandler {

    public static final int ANALYZER_GUI_ID = 1;
    public static final int JOURNAL_GUI_ID = 2;
    public static final int SEED_STORAGE_GUI_ID = 3;
    public static final int SEED_CONTROLLER_GUI_ID = 4;
    public static final int PERIPHERAL_GUI_ID = 5;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID) {
            case (ANALYZER_GUI_ID):
                if (te instanceof TileEntitySeedAnalyzer) {
                    return new ContainerSeedAnalyzer((TileEntitySeedAnalyzer) te, player.inventory, ContainerSeedAnalyzer.SeedAnalyzerLayout.NORMAL);
                }
            case (PERIPHERAL_GUI_ID):
                if (te instanceof TileEntityPeripheral) {
                    return new ContainerSeedAnalyzer((TileEntitySeedAnalyzer) te, player.inventory, ContainerSeedAnalyzer.SeedAnalyzerLayout.PERIPHERAL);
                }
            case (SEED_STORAGE_GUI_ID):
                if (te instanceof TileEntitySeedStorage) {
                    return new ContainerSeedStorage((TileEntitySeedStorage) te, player.inventory);
                }
            case (SEED_CONTROLLER_GUI_ID):
                if (te instanceof TileEntitySeedStorageController) {
                    return new ContainerSeedStorageController((TileEntitySeedStorageController) te, player.inventory);
                }
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Gui getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID) {
            case (ANALYZER_GUI_ID):
                if (te instanceof TileEntitySeedAnalyzer) {
                    return new AgriGuiWrapper(new GuiSeedAnalyzer(player.inventory, (TileEntitySeedAnalyzer) te));
                }
            case (JOURNAL_GUI_ID):
                if (StackHelper.isValid(player.getHeldItemMainhand(), ItemJournal.class)) {
                    return new AgriGuiWrapper(new GuiJournal(player.getHeldItemMainhand()));
                }
            case (SEED_STORAGE_GUI_ID):
                if (te instanceof TileEntitySeedStorage) {
                    return new AgriGuiWrapper(new GuiSeedStorage(player.inventory, (TileEntitySeedStorage) te));
                }
            case (SEED_CONTROLLER_GUI_ID):
                if (te instanceof TileEntitySeedStorageController) {
                    return new AgriGuiWrapper(new GuiSeedStorageController(player.inventory, (TileEntitySeedStorageController) te));
                }
            case (PERIPHERAL_GUI_ID):
                if (te instanceof TileEntityPeripheral) {
                    return new GuiPeripheral(player.inventory, (TileEntityPeripheral) te);
                }
            default:
                return null;
        }
    }
}
