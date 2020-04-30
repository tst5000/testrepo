package com.tst5000.agricrafttfctngintegration.compat.thaumcraft;

import com.tst5000.agricrafttfctngintegration.api.v1.plugin.AgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.IAgriPlugin;
import com.tst5000.agricrafttfctngintegration.init.AgriBlocks;
import com.tst5000.agricrafttfctngintegration.reference.Constants;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;

@AgriPlugin
public class ThaumcraftPlugin implements IAgriPlugin {

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getId() {
        return "thaumcraft";
    }

    @Override
    public String getName() {
        return "Thaumcraft Integration";
    }

    @Override
    public void initPlugin() {

        // Fix Golems
        FMLInterModComms.sendMessage(
                "Thaumcraft",
                "harvestClickableCrop",
                new ItemStack(AgriBlocks.getInstance().CROP, 1, Constants.MATURE)
        );

    }

}
