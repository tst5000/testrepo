package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;

public class MethodHasPlant extends MethodBaseCrop {

    public MethodHasPlant() {
        super("hasPlant");
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) {
        return new Object[]{crop.hasSeed()};
    }
}
