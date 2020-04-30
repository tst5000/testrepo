/*
 */
package com.tst5000.agricrafttfctngintegration.compat.vanilla;

import com.tst5000.agricrafttfctngintegration.api.v1.plugin.AgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.IAgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.adapter.IAgriAdapterizer;
import com.tst5000.agricrafttfctngintegration.api.v1.fertilizer.IAgriFertilizer;
import com.tst5000.agricrafttfctngintegration.api.v1.seed.AgriSeed;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStat;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStatCalculator;
import com.tst5000.agricrafttfctngintegration.farming.PlantStats;
import com.tst5000.agricrafttfctngintegration.farming.mutation.statcalculator.StatCalculatorHardcore;
import com.tst5000.agricrafttfctngintegration.farming.mutation.statcalculator.StatCalculatorNormal;
import com.tst5000.agricrafttfctngintegration.init.AgriItems;
import com.tst5000.agricrafttfctngintegration.items.ItemAgriSeed;

/**
 *
 * @author Ryan
 */
@AgriPlugin
public class VanillaPlugin implements IAgriPlugin {

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getId() {
        return "vanilla";
    }

    @Override
    public String getName() {
        return "Vanilla Minecraft Integration";
    }

    @Override
    public void initPlugin() {
        // Register the default MineCraft Ores
        // TBD
//        OreDictionary.registerOre("wheat_seed", new ItemStack(Items.WHEAT_SEEDS));
//        OreDictionary.registerOre("potato_seed", new ItemStack(Items.POTATO));
//        OreDictionary.registerOre("carrot_seed", new ItemStack(Items.CARROT));
//        OreDictionary.registerOre("pumpkin_seed", new ItemStack(Items.PUMPKIN_SEEDS));
//        OreDictionary.registerOre("melon_seed", new ItemStack(Items.MELON_SEEDS));
//        OreDictionary.registerOre("beet_seed", new ItemStack(Items.BEETROOT_SEEDS));
    }

    @Override
    public void registerSeeds(IAgriAdapterizer<AgriSeed> seedRegistry) {
        seedRegistry.registerAdapter(new SeedWrapper());
        seedRegistry.registerAdapter((ItemAgriSeed) AgriItems.getInstance().AGRI_SEED);
    }

    @Override
    public void registerStats(IAgriAdapterizer<IAgriStat> statRegistry) {
        statRegistry.registerAdapter(new PlantStats());
    }

    @Override
    public void registerStatCalculators(IAgriAdapterizer<IAgriStatCalculator> statCalculatorRegistry) {
        statCalculatorRegistry.registerAdapter(new StatCalculatorNormal());
        statCalculatorRegistry.registerAdapter(new StatCalculatorHardcore());
    }

    @Override
    public void registerFertilizers(IAgriAdapterizer<IAgriFertilizer> fertilizerRegistry) {
        fertilizerRegistry.registerAdapter(BonemealWrapper.INSTANCE);
    }

}
