package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;

import java.util.Optional;

public class MethodGetPlant extends MethodBaseCrop {

    public MethodGetPlant() {
        super("getPlant");
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) {
        return new Object[]{Optional.ofNullable(crop.getSeed()).map(s -> s.getPlant().getSeedName()).orElse("None")};
    }
}
