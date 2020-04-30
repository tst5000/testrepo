package com.tst5000.agricrafttfctngintegration.compat.botania;

import com.tst5000.agricrafttfctngintegration.api.v1.plugin.AgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.IAgriPlugin;
import net.minecraftforge.fml.common.Loader;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.wiki.SimpleWikiProvider;

@AgriPlugin
public class BotaniaPlugin implements IAgriPlugin {

    @Override
    public boolean isEnabled() {
        return Loader.isModLoaded("botania");
    }

    @Override
    public String getId() {
        return "botania";
    }

    @Override
    public String getName() {
        return "Botania Integration";
    }

    @Override
    public void initPlugin() {
        // TODO!
        BotaniaAPI.registerModWiki("agricraft", new SimpleWikiProvider("AgriCraftTFCTNGIntegration Wiki", "https://agridocs.readthedocs.io/%s"));
    }

}
