package com.tst5000.agricrafttfctngintegration.gui.journal;

import com.tst5000.agricrafttfctngintegration.reference.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class JournalPageTitle implements JournalPage {

    @Override
    public ResourceLocation getForeground() {
        return new ResourceLocation(Reference.MOD_ID, "textures/gui/journal/gui_journal_page_front.png");
    }

}
