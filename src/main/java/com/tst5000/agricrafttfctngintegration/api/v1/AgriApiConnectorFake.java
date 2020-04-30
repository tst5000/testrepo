/*
 */
package com.tst5000.agricrafttfctngintegration.api.v1;

import com.tst5000.agricrafttfctngintegration.api.v1.adapter.IAgriAdapterizer;
import com.tst5000.agricrafttfctngintegration.api.v1.fertilizer.IAgriFertilizer;
import com.tst5000.agricrafttfctngintegration.api.v1.misc.IAgriPeripheralMethod;
import com.tst5000.agricrafttfctngintegration.api.v1.misc.IAgriRegistry;
import com.tst5000.agricrafttfctngintegration.api.v1.mutation.IAgriMutationEngine;
import com.tst5000.agricrafttfctngintegration.api.v1.mutation.IAgriMutationRegistry;
import com.tst5000.agricrafttfctngintegration.api.v1.plant.IAgriPlant;
import com.tst5000.agricrafttfctngintegration.api.v1.seed.AgriSeed;
import com.tst5000.agricrafttfctngintegration.api.v1.soil.IAgriSoilRegistry;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStat;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStatCalculator;

import javax.annotation.Nonnull;

/**
 * A fake API connector, for when the API was not found.
 */
final class AgriApiConnectorFake implements IAgriApiConnector {

    @Override
    @Nonnull
    public AgriApiState getState() {
        return AgriApiState.INVALID;
    }

    @Override
    @Nonnull
    public IAgriRegistry<IAgriPlant> connectPlantRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    @Nonnull
    public IAgriMutationRegistry connectMutationRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    @Nonnull
    public IAgriSoilRegistry connectSoilRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    @Nonnull
    public IAgriAdapterizer<IAgriStat> connectStatRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    @Nonnull
    public IAgriAdapterizer<IAgriStatCalculator> connectStatCalculatorRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    @Nonnull
    public IAgriMutationEngine connectMutationEngine() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    @Nonnull
    public IAgriAdapterizer<AgriSeed> connectSeedRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    @Nonnull
    public IAgriAdapterizer<IAgriFertilizer> connectFertilizerRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

    @Override
    public IAgriRegistry<IAgriPeripheralMethod> connectPeripheralMethodRegistry() {
        throw new UnsupportedOperationException("The stand-in version of the AgriCraftTFCTNGIntegration API does not support this operation.");
    }

}
