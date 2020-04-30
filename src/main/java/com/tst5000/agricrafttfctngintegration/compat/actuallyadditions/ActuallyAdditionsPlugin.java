package com.tst5000.agricrafttfctngintegration.compat.actuallyadditions;

import com.agricrafttfctngintegration.agritfccore.config.AgriConfigCategory;
import com.agricrafttfctngintegration.agritfccore.config.AgriConfigurable;
import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.AgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.IAgriPlugin;
import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import net.minecraftforge.fml.common.Loader;

@AgriPlugin
public class ActuallyAdditionsPlugin implements IAgriPlugin {

    @AgriConfigurable(
            key = "ActuallyAdditions Farmer Energy Cost",
            category = AgriConfigCategory.COMPATIBILITY,
            comment = "The amount of energy that the ActuallyAdditions farmer expends to harvest or plant an AgriCraftTFCTNGIntegration crop.",
            min = "250",
            max = "10000"
    )
    public static int ENERGY_COST = 250;

    @Override
    public boolean isEnabled() {
        return Loader.isModLoaded(ActuallyAdditionsAPI.MOD_ID);
    }

    @Override
    public String getId() {
        return "actuallyadditions";
    }

    @Override
    public String getName() {
        return "ActuallyAdditions Integration";
    }

    @Override
    public void initPlugin() {
        ActuallyAdditionsAPI.addFarmerBehavior(new AgriCraftFarmerBehavior());
    }

    static {
        AgriCore.getConfig().addConfigurable(ActuallyAdditionsPlugin.class);
    }

}
