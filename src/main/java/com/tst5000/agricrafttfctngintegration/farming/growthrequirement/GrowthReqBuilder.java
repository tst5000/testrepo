/*
 */
package com.tst5000.agricrafttfctngintegration.farming.growthrequirement;

import com.agricrafttfctngintegration.agritfccore.util.MathHelper;
import com.tst5000.agricrafttfctngintegration.api.v1.requirement.ICondition;
import com.tst5000.agricrafttfctngintegration.api.v1.requirement.IGrowthReqBuilder;
import com.tst5000.agricrafttfctngintegration.api.v1.requirement.IGrowthRequirement;
import com.tst5000.agricrafttfctngintegration.api.v1.soil.IAgriSoil;

import java.util.ArrayList;
import java.util.List;

public class GrowthReqBuilder implements IGrowthReqBuilder {

    private final List<IAgriSoil> soils;
    private final List<ICondition> conditions;
    private int minLight = 0;
    private int maxLight = 16;

    public GrowthReqBuilder() {
        this.soils = new ArrayList<>();
        this.conditions = new ArrayList<>();
    }

    @Override
    public GrowthReqBuilder addSoil(IAgriSoil soil) {
        this.soils.add(soil);
        return this;
    }

    @Override
    public IGrowthReqBuilder addCondition(ICondition condition) {
        this.conditions.add(condition);
        return this;
    }

    @Override
    public IGrowthReqBuilder setMinLight(int minLight) {
        this.minLight = MathHelper.inRange(minLight, 0, 16);
        return this;
    }

    @Override
    public IGrowthReqBuilder setMaxLight(int maxLight) {
        this.maxLight = MathHelper.inRange(maxLight, 0, 16);
        return this;
    }

    @Override
    public IGrowthRequirement build() {
        return new GrowthRequirement(soils, conditions, minLight, maxLight);
    }

}
