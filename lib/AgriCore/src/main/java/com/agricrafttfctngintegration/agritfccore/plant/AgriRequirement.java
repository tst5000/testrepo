/*
 */
package com.agricrafttfctngintegration.agritfccore.plant;

import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.agricrafttfctngintegration.agritfccore.util.TypeHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author RlonRyan
 */
public class AgriRequirement {

    private final int min_light;
    private final int max_light;

    private final float tempMinAlive, tempMinGrow, tempMaxGrow, tempMaxAlive;
    private final float rainMinAlive, rainMinGrow, rainMaxGrow, rainMaxAlive;

    private final List<String> soils;
    private final List<AgriCondition> conditions;

    public AgriRequirement() {
        this.min_light = 10;
        this.max_light = 16;
        this.tempMinAlive = 0f;
        this.tempMinGrow = 4f;
        this.tempMaxGrow = 35f;
        this.tempMaxAlive = 40f;
        this.rainMinAlive = 50f;
        this.rainMinGrow = 100f;
        this.rainMaxGrow = 400f;
        this.rainMaxAlive = 450f;
        this.soils = new ArrayList<>();
        this.conditions = new ArrayList<>();
    }

    public AgriRequirement(List<String> soils, List<AgriCondition> conditions, int min_light, int max_light, float tempMinAlive, float tempMinGrow, float tempMaxGrow, float tempMaxAlive, float rainMinAlive, float rainMinGrow, float rainMaxGrow, float rainMaxAlive) {
        this.soils = new ArrayList<>(soils);
        this.conditions = conditions;
        this.min_light = min_light;
        this.max_light = max_light;
        this.tempMinAlive = tempMinAlive;
        this.tempMinGrow = tempMinGrow;
        this.tempMaxGrow = tempMaxGrow;
        this.tempMaxAlive = tempMaxAlive;
        this.rainMinAlive = rainMinAlive;
        this.rainMinGrow = rainMinGrow;
        this.rainMaxGrow = rainMaxGrow;
        this.rainMaxAlive = rainMaxAlive;
    }

    public int getMinLight() {
        return min_light;
    }

    public int getMaxLight() {
        return max_light;
    }

    public List<AgriSoil> getSoils() {
        return this.soils.stream()
                .map(AgriCore.getSoils()::getSoil)
                .filter(TypeHelper::isNonNull)
                .collect(Collectors.toList());
    }

    public List<AgriCondition> getConditions() {
        return new ArrayList<>(this.conditions);
    }

    public boolean validate() {
        this.soils.removeIf(soil -> {
            if (!AgriCore.getSoils().hasSoil(soil)) {
                AgriCore.getCoreLogger().info("Invalid Requirement: Invalid Soil: {0}! Removing!", soil);
                return true;
            } else {
                return false;
            }
        });
        for (AgriCondition condition : conditions) {
            if (!condition.validate()) {
                AgriCore.getCoreLogger().info("Invalid Requirement: Invalid Condition!", condition);
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nRequirement:");
        sb.append("\n\t- Light:");
        sb.append("\n\t\t- Min: ").append(min_light);
        sb.append("\n\t\t- Max: ").append(max_light);
        sb.append("\n\t- Soil:");
        this.soils.forEach((e) -> {
            sb.append("\n\t\t- AgriSoil: ").append(e);
        });
        sb.append("\n\t- Conditions:");
        this.conditions.forEach((e) -> {
            sb.append("\n\t\t- ").append(e.toString().replaceAll("\n", "\n\t\t").trim());
        });
        return sb.toString();
    }

}
