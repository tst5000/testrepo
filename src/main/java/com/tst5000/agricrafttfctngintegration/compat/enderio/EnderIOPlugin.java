package com.tst5000.agricrafttfctngintegration.compat.enderio;

import com.tst5000.agricrafttfctngintegration.api.v1.plugin.AgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.IAgriPlugin;
import net.minecraftforge.fml.common.Loader;

@AgriPlugin
public class EnderIOPlugin implements IAgriPlugin {

    @Override
    public boolean isEnabled() {
        return Loader.isModLoaded("enderio");
    }

    @Override
    public String getId() {
        return "enderio";
    }

    @Override
    public String getName() {
        return "EnderIO Integration";
    }

    @Override
    public void initPlugin() {
        // TODO!
    }

}
