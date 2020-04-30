package com.tst5000.agricrafttfctngintegration.gui.journal;

import com.tst5000.agricrafttfctngintegration.gui.component.ComponentRenderer;
import com.tst5000.agricrafttfctngintegration.gui.component.GuiComponent;
import com.tst5000.agricrafttfctngintegration.gui.component.GuiComponentBuilder;
import com.tst5000.agricrafttfctngintegration.reference.Reference;
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class JournalPageIntroduction implements JournalPage {

    @Override
    public ResourceLocation getForeground() {
        return new ResourceLocation(Reference.MOD_ID, "textures/gui/journal/gui_journal_page_intro.png");
    }

    @Override
    public List<GuiComponent> getComponents() {
        return Arrays.asList(
                new GuiComponentBuilder<>("agricraft_journal.introduction", 24, 28, 0, 0)
                        .setRenderAction(ComponentRenderer::renderComponentText)
                        .setScale(0.5)
                        .build()
        );
    }

}
