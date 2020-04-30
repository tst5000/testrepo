package com.tst5000.agricrafttfctngintegration.compat.theoneprobe;

import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.AgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.IAgriPlugin;
import net.minecraftforge.fml.common.event.FMLInterModComms;

@AgriPlugin
public class TheOneProbePlugin implements IAgriPlugin {

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getId() {
        return "theoneprobe";
    }

    @Override
    public String getName() {
        return "The One Probe Integration";
    }

    @Override
    public void initPlugin() {
        AgriCore.getLogger("agricraft").debug("Calling One Probe Register! Result: {0}!",
                FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe", this.getClass().getPackage().getName() + ".GetTheOneProbe"));
    }

}
