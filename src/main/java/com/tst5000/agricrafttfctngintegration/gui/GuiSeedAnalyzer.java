package com.tst5000.agricrafttfctngintegration.gui;

import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.tst5000.agricrafttfctngintegration.container.ContainerSeedAnalyzer;
import com.tst5000.agricrafttfctngintegration.gui.component.BasicComponents;
import com.tst5000.agricrafttfctngintegration.gui.journal.GuiJournal;
import com.tst5000.agricrafttfctngintegration.reference.Reference;
import com.tst5000.agricrafttfctngintegration.tiles.analyzer.TileEntitySeedAnalyzer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSeedAnalyzer extends ComponentGui<ContainerSeedAnalyzer> {

    public static final ResourceLocation ANALYZER_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/gui_seed_analyzer.png");

    public TileEntitySeedAnalyzer seedAnalyzer;

    public GuiSeedAnalyzer(InventoryPlayer inventory, TileEntitySeedAnalyzer seedAnalyzer) {
        super(176, 176, new ContainerSeedAnalyzer(seedAnalyzer, inventory, ContainerSeedAnalyzer.SeedAnalyzerLayout.NORMAL));
        this.seedAnalyzer = seedAnalyzer;
    }

    @Override
    protected void onComponentGuiInit(AgriGuiWrapper wrapper) {
        final String name = AgriCore.getTranslator().translate("agricraft_gui.seedAnalyzer");
        this.addBackground(ANALYZER_TEXTURE);
        this.addComponent(BasicComponents.getButtonComponent("", 131, 67, 18, 18, (c, p) -> openJournal(wrapper)));
        this.addComponent(BasicComponents.getTextComponent(name, this.getWidth() / 2, 6, 1.0, true));
        this.addComponent(BasicComponents.getProgressBarComponent(() -> this.seedAnalyzer.getProgressScaled(100), 66, 78, 44, 8));
    }

    private boolean openJournal(AgriGuiWrapper wrapper) {
        final ItemStack journal = seedAnalyzer.getStackInSlot(ContainerSeedAnalyzer.JOURNAL_SLOT_ID);
        if (journal != ItemStack.EMPTY) {
            wrapper.pushGui(new GuiJournal(journal));
        }
        return true;
    }

}
