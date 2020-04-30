package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;

public class MethodIsCrossCrop extends MethodBaseCrop {

    public MethodIsCrossCrop() {
        super("isCrossCrop");
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) {
        return new Object[]{crop.isCrossCrop()};
    }

}
