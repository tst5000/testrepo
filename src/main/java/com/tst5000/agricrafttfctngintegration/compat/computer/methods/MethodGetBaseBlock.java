package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.api.v1.plant.IAgriPlant;
import com.tst5000.agricrafttfctngintegration.api.v1.requirement.BlockCondition;
import com.tst5000.agricrafttfctngintegration.api.v1.util.FuzzyStack;

import java.util.Optional;

public class MethodGetBaseBlock extends MethodBaseGrowthReq {

    public MethodGetBaseBlock() {
        super("getBaseBlock");
    }

    @Override
    protected Object[] onMethodCalled(Optional<IAgriPlant> plant) {
        if (plant.isPresent()) {
            Optional<FuzzyStack> block = plant.get().getGrowthRequirement().getConditions().stream()
                    .filter(c -> c instanceof BlockCondition)
                    .map(c -> ((BlockCondition) c).getStack())
                    .findFirst();
            String msg = block.map(b -> b.toStack().getDisplayName()).orElse("null");
            return new Object[]{msg};
        } else {
            return null;
        }
    }
}
