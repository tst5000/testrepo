package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.api.v1.plant.IAgriPlant;
import com.tst5000.agricrafttfctngintegration.tiles.TileEntityPeripheral;
import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;

import java.util.ArrayList;
import java.util.Optional;

public abstract class MethodBaseGrowthReq extends MethodBase {

    public MethodBaseGrowthReq(String name) {
        super(name, true, true, true);
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) throws InvocationException {
        return onMethodCalled(MethodUtilities.getCropPlant(crop));
    }

    @Override
    protected Object[] onMethodCalled(TileEntityPeripheral peripheral) throws InvocationException {
        return onMethodCalled(MethodUtilities.getCropPlant(peripheral.getSpecimen()));
    }

    protected abstract Object[] onMethodCalled(Optional<IAgriPlant> plant) throws InvocationException;

    @Override
    protected ArrayList<MethodParameter> getParameters() {
        ArrayList<MethodParameter> pars = new ArrayList<>();
        pars.add(MethodParameter.DIRECTION_OPTIONAL);
        return pars;
    }
}
