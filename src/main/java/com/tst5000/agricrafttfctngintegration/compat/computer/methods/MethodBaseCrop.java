package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityPeripheral;

import java.util.ArrayList;

public abstract class MethodBaseCrop extends MethodBase {

    public MethodBaseCrop(String name) {
        super(name, false, false, true);
    }

    @Override
    protected Object[] onMethodCalled(TileEntityPeripheral peripheral) throws InvocationException {
        return new Object[0];
    }

    @Override
    protected ArrayList<MethodParameter> getParameters() {
        ArrayList<MethodParameter> pars = new ArrayList<>();
        pars.add(MethodParameter.DIRECTION);
        return pars;
    }

}
