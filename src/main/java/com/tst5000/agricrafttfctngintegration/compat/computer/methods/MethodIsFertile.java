package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;

public class MethodIsFertile extends MethodBaseCrop {

    public MethodIsFertile() {
        super("isFertile");
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) {
        return new Object[]{crop.isFertile()};
    }

}
