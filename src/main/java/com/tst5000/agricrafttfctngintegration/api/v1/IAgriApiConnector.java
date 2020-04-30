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
 *
 * @author Ryan
 */
public interface IAgriApiConnector {

    IAgriApiConnector FAKE = new AgriApiConnectorFake();

    @Nonnull
    AgriApiState getState();

    @Nonnull
    IAgriRegistry<IAgriPlant> connectPlantRegistry();

    @Nonnull
    IAgriMutationRegistry connectMutationRegistry();

    @Nonnull
    IAgriSoilRegistry connectSoilRegistry();

    @Nonnull
    IAgriAdapterizer<IAgriStat> connectStatRegistry();

    @Nonnull
    IAgriAdapterizer<IAgriStatCalculator> connectStatCalculatorRegistry();

    @Nonnull
    IAgriMutationEngine connectMutationEngine();

    @Nonnull
    IAgriAdapterizer<AgriSeed> connectSeedRegistry();

    @Nonnull
    IAgriAdapterizer<IAgriFertilizer> connectFertilizerRegistry();

    @Nonnull
    IAgriRegistry<IAgriPeripheralMethod> connectPeripheralMethodRegistry();

}
