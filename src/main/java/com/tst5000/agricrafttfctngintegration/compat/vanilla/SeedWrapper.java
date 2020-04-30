/*
 */
package com.tst5000.agricrafttfctngintegration.compat.vanilla;

import com.tst5000.agricrafttfctngintegration.api.v1.AgriApi;
import com.tst5000.agricrafttfctngintegration.api.v1.adapter.IAgriAdapter;
import com.tst5000.agricrafttfctngintegration.api.v1.plant.IAgriPlant;
import com.tst5000.agricrafttfctngintegration.api.v1.seed.AgriSeed;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStat;
import com.tst5000.agricrafttfctngintegration.api.v1.util.FuzzyStack;
import com.tst5000.agricrafttfctngintegration.farming.PlantStats;
import com.tst5000.agricrafttfctngintegration.utility.StackHelper;
import java.util.Optional;

import net.minecraft.item.ItemStack;

/**
 *
 *
 */
public class SeedWrapper implements IAgriAdapter<AgriSeed> {

    @Override
    public boolean accepts(Object obj) {
        return (obj instanceof ItemStack) && resolve((ItemStack) obj) != null;
    }

    @Override
    public Optional<AgriSeed> valueOf(Object obj) {
        if (obj instanceof ItemStack) {
            return Optional.ofNullable(resolve((ItemStack) obj));
        } else {
            return Optional.empty();
        }
    }

    private AgriSeed resolve(ItemStack stack) {
        if (!StackHelper.isValid(stack)) {
            return null;
        }
        final FuzzyStack toResolve = new FuzzyStack(stack);
        Optional<IAgriPlant> plant = AgriApi.getPlantRegistry().all().stream()
                .filter(p -> p.getSeedItems().contains(toResolve))
                .findFirst();
        if (plant.isPresent()) {
            Optional<IAgriStat> stats = AgriApi.getStatRegistry().valueOf(stack.getTagCompound());
            return new AgriSeed(plant.get(), stats.orElseGet(PlantStats::new));
        } else {
            return null;
        }
    }

}
