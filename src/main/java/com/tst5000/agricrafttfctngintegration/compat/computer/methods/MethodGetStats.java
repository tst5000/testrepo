package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.api.v1.AgriApi;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStat;
import com.tst5000.agricrafttfctngintegration.tiles.TileEntityPeripheral;
import com.tst5000.agricrafttfctngintegration.tiles.TileEntityCrop;
import com.tst5000.agricrafttfctngintegration.utility.StackHelper;

import java.util.ArrayList;
import java.util.Optional;

public class MethodGetStats extends MethodBase {

    public MethodGetStats() {
        super("getSpecimenStats", false, true, true);
    }

    @Override
    protected Object[] onMethodCalled(TileEntityCrop crop) throws InvocationException {
        return Optional.ofNullable(crop.getSeed())
                .map(s -> s.getStat())
                .filter(IAgriStat::isAnalyzed)
                .map(s -> new Object[]{s.getGrowth(), s.getGain(), s.getStrength()})
                .orElse(null);
    }

    @Override
    protected Object[] onMethodCalled(TileEntityPeripheral peripheral) throws InvocationException {
        IAgriStat stats = AgriApi.getStatRegistry().valueOf(StackHelper.getTag(peripheral.getSpecimen())).orElse(null);
        return stats == null ? null : new Object[]{stats.getGrowth(), stats.getGain(), stats.getStrength()};
    }

    @Override
    protected ArrayList<MethodParameter> getParameters() {
        ArrayList<MethodParameter> pars = new ArrayList<>();
        pars.add(MethodParameter.DIRECTION_OPTIONAL);
        return pars;
    }

}
