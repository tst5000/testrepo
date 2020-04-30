package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;

public class MethodIsMature extends MethodBaseCrop {

    public MethodIsMature() {
        super("isMature");
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) {
        return new Object[]{crop.isMature()};
    }

}
