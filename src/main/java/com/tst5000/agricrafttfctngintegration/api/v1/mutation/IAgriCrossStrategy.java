package com.tst5000.agricrafttfctngintegration.api.v1.mutation;

import com.tst5000.agricrafttfctngintegration.api.v1.crop.IAgriCrop;
import com.tst5000.agricrafttfctngintegration.api.v1.seed.AgriSeed;

import java.util.Optional;
import java.util.Random;
import javax.annotation.Nonnull;

/**
 * Base interface for different cross over strategies.
 */
public interface IAgriCrossStrategy {

    double getRollChance();

    @Nonnull
    Optional<AgriSeed> executeStrategy(@Nonnull IAgriCrop crop, @Nonnull Random rand);

}
