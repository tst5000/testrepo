package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.api.v1.plant.IAgriPlant;

import java.util.Optional;

public class MethodNeedsBaseBlock extends MethodBaseGrowthReq {

    public MethodNeedsBaseBlock() {
        super("needsBaseBlock");
    }

    @Override
    protected Object[] onMethodCalled(Optional<IAgriPlant> plant) throws InvocationException {
        return new Object[]{plant.flatMap(p -> p.getGrowthRequirement().getConditionStack()).isPresent()};
    }

}
