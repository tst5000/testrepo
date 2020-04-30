package com.tst5000.agricrafttfctngintegration.gui;

import com.agricrafttfctngintegration.agritfccore.config.AgriConfigCategory;
import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.tst5000.agricrafttfctngintegration.core.CoreHandler;
import com.tst5000.agricrafttfctngintegration.reference.Reference;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AgriCraftGuiConfig extends GuiConfig {

    public AgriCraftGuiConfig(GuiScreen guiScreen) {
        super(guiScreen, getConfigElements(), Reference.MOD_ID, false, false,
                GuiConfig.getAbridgedConfigPath(AgriCore.getConfig().getLocation()));
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> configElements = new ArrayList<>();
        for (AgriConfigCategory e : AgriConfigCategory.values()) {
            String descr = "AgriCraftTFCTNGIntegration " + e.getDisplayName() + " Settings";
            String name = "agricraft.configgui.ctgy." + e.name();
            configElements.add(new DummyConfigElement.DummyCategoryElement(descr, name, new ConfigElement(CoreHandler.getConfig().getCategory(e.name().toLowerCase())).getChildElements()));
        }
        return configElements;
    }
}
