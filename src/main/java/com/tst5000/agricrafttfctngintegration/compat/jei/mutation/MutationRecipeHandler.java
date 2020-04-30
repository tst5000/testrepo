/*
 * AgriCraftTFCTNGIntegration JEI crop mutation recipe handler integration module.
 */
package com.tst5000.agricrafttfctngintegration.compat.jei.mutation;

import com.tst5000.agricrafttfctngintegration.api.v1.mutation.IAgriMutation;
import com.tst5000.agricrafttfctngintegration.compat.jei.AgriCraftJEIPlugin;
import javax.annotation.Nonnull;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

/**
 *
 *
 */
public class MutationRecipeHandler implements IRecipeHandler<IAgriMutation> {

    @Nonnull
    @Override
    public Class<IAgriMutation> getRecipeClass() {
        return IAgriMutation.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(IAgriMutation recipe) {
        return AgriCraftJEIPlugin.CATEGORY_MUTATION;
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull IAgriMutation recipe) {
        return new MutationRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(@Nonnull IAgriMutation recipe) {
        return !recipe.getParents().isEmpty();
    }

}
