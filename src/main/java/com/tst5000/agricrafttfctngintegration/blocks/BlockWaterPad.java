/*
 * An intermediate for the water pad.
 */
package com.tst5000.agricrafttfctngintegration.blocks;

import com.tst5000.agricrafttfctngintegration.api.v1.util.AgriSideMetaMatrix;
import com.tst5000.agricrafttfctngintegration.reference.AgriProperties;
import com.tst5000.agricrafttfctngintegration.renderers.blocks.RenderWaterPad;
import com.tst5000.agricrafttfctngintegration.utility.FluidHandlerBlockWrapper;
import com.tst5000.agricrafttfctngintegration.utility.IFluidHandlerBlock;
import com.infinityraider.infinitylib.block.BlockCustomRenderedBase;
import com.infinityraider.infinitylib.block.blockstate.InfinityProperty;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWaterPad extends BlockCustomRenderedBase implements IFluidHandlerBlock {

    public static final AxisAlignedBB WATER_PAD_BOUNDS = new AxisAlignedBB(0, 0, 0, 1, 0.5, 1);

    public BlockWaterPad() {
        super("water_pad", Material.GROUND);
        this.setHardness(0.5F);
    }

    @Override
    protected InfinityProperty[] getPropertyArray() {
        return new InfinityProperty[]{
            AgriProperties.POWERED
        };
    }

    @Override
    protected IUnlistedProperty[] getUnlistedPropertyArray() {
        final List<IUnlistedProperty> props = new ArrayList<>();
        AgriSideMetaMatrix.addUnlistedProperties(props::add);
        return props.toArray(new IUnlistedProperty[6]);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return AgriProperties.POWERED.applyToBlockState(this.getDefaultState(), meta != 0);
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
        AgriSideMetaMatrix connection = new AgriSideMetaMatrix();
        for (EnumFacing facing : EnumFacing.HORIZONTALS) {
            final IBlockState stateAt = world.getBlockState(pos.offset(facing));
            final byte value = (byte)(stateAt.getBlock() == state.getBlock() ? 1 : 0);
            connection.set(facing, value);
        }
        return connection.writeToBlockState(state);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return AgriProperties.POWERED.getValue(state) ? 0 : 1;
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return Blocks.DIRT.getDrops(world, pos, Blocks.DIRT.getDefaultState(), fortune);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return WATER_PAD_BOUNDS;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return FluidUtil.interactWithFluidHandler(player, hand, new FluidHandlerBlockWrapper(this, world, pos));
    }

    @Override
    public IFluidTankProperties[] getTankProperties(World world, BlockPos pos, IBlockState state) {
        return new IFluidTankProperties[]{};
    }

    @Override
    public int fill(World world, BlockPos pos, IBlockState state, FluidStack fluid, boolean doFill) {
        if (!AgriProperties.POWERED.getValue(state) && (fluid != null) && (fluid.amount == 1000) && (fluid.getFluid().equals(FluidRegistry.WATER))) {
            if (doFill) {
                world.setBlockState(pos, AgriProperties.POWERED.applyToBlockState(state, true));
            }
            return 1000;
        } else {
            return 0;
        }
    }

    @Override
    public FluidStack drain(World world, BlockPos pos, IBlockState state, FluidStack fluid, boolean doDrain) {
        if ((AgriProperties.POWERED.getValue(state)) && (fluid != null) && (fluid.amount >= 1000) && (fluid.getFluid().equals(FluidRegistry.WATER))) {
            if (doDrain) {
                world.setBlockState(pos, AgriProperties.POWERED.applyToBlockState(state, false));
            }
            return new FluidStack(FluidRegistry.WATER, 1000);
        } else {
            return null;
        }
    }

    @Override
    public FluidStack drain(World world, BlockPos pos, IBlockState state, int amount, boolean doDrain) {
        if ((AgriProperties.POWERED.getValue(state)) && (amount >= 1000)) {
            if (doDrain) {
                world.setBlockState(pos, AgriProperties.POWERED.applyToBlockState(state, false));
            }
            return new FluidStack(FluidRegistry.WATER, 1000);
        } else {
            return null;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public RenderWaterPad getRenderer() {
        return new RenderWaterPad(this);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

}
