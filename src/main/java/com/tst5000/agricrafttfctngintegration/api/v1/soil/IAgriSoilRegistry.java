/*
 */
package com.tst5000.agricrafttfctngintegration.api.v1.soil;

import com.tst5000.agricrafttfctngintegration.api.v1.misc.IAgriRegistry;
import com.tst5000.agricrafttfctngintegration.api.v1.util.FuzzyStack;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

/**
 * An interface for managing AgriCraftTFCTNGIntegration plants.
 *
 * @author AgriCraftTFCTNGIntegration Team
 */
public interface IAgriSoilRegistry extends IAgriRegistry<IAgriSoil> {

    boolean contains(@Nullable IBlockState state);

    boolean contains(@Nullable ItemStack stack);

    boolean contains(@Nullable FuzzyStack stack);

    @Nonnull
    Optional<IAgriSoil> get(@Nullable IBlockState state);

    @Nonnull
    Optional<IAgriSoil> get(@Nullable ItemStack stack);

    @Nonnull
    Optional<IAgriSoil> get(@Nullable FuzzyStack stack);

}
