package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;
import net.minecraft.world.EnumSkyBlock;

public class MethodGetBrightness extends MethodBaseCrop {

    public MethodGetBrightness() {
        super("getBrightness");
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) {
        return new Object[]{Math.max(crop.getWorld().getLightFor(EnumSkyBlock.SKY, crop.getPos()), crop.getWorld().getLightFor(EnumSkyBlock.BLOCK, crop.getPos()))};
    }
}
