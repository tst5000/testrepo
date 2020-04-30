package com.tst5000.agricrafttfctngintegration.reference;

import com.tst5000.agricrafttfctngintegration.api.v1.plant.IAgriPlant;
import com.tst5000.agricrafttfctngintegration.blocks.properties.PropertyCropPlant;
import com.tst5000.agricrafttfctngintegration.blocks.properties.PropertyCustomWood;
import com.tst5000.agricrafttfctngintegration.blocks.properties.UnlistedPropertyBoolean;
import com.tst5000.agricrafttfctngintegration.blocks.properties.UnlistedPropertyInteger;
import com.tst5000.agricrafttfctngintegration.tiles.decoration.TileEntityGrate;
import com.tst5000.agricrafttfctngintegration.utility.CustomWoodType;
import com.infinityraider.infinitylib.block.blockstate.InfinityProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.property.IUnlistedProperty;

/**
 * A class containing AgriCraftTFCTNGIntegration block state properties
 */
public interface AgriProperties {

    InfinityProperty<Boolean> JOURNAL = new InfinityProperty<>(PropertyBool.create("journal"), true);
    InfinityProperty<EnumFacing> FACING = new InfinityProperty<>(PropertyDirection.create("facing"), EnumFacing.NORTH);

    IUnlistedProperty<IAgriPlant> CROP_PLANT = PropertyCropPlant.PROPERTY;
    IUnlistedProperty<Integer> GROWTH_STAGE = new UnlistedPropertyInteger("agri_growth_stage");
    IUnlistedProperty<Boolean> CROSS_CROP = new UnlistedPropertyBoolean("agri_cross_crop");

    InfinityProperty<TileEntityGrate.EnumVines> VINES = new InfinityProperty<>(PropertyEnum.create("vines", TileEntityGrate.EnumVines.class), TileEntityGrate.EnumVines.NONE);
    InfinityProperty<EnumFacing.Axis> AXIS = new InfinityProperty<>(PropertyEnum.create("axis", EnumFacing.Axis.class), EnumFacing.Axis.X);
    InfinityProperty<TileEntityGrate.EnumOffset> OFFSET = new InfinityProperty<>(PropertyEnum.create("offset", TileEntityGrate.EnumOffset.class), TileEntityGrate.EnumOffset.NEAR);

    InfinityProperty<Boolean> POWERED = new InfinityProperty<>(PropertyBool.create("powered"), false);

    IUnlistedProperty<CustomWoodType> CUSTOM_WOOD_TYPE = new PropertyCustomWood("wood_type");

}
