/*
 */
package com.tst5000.agricrafttfctngintegration.compat.computer;

import com.tst5000.agricrafttfctngintegration.api.v1.plugin.AgriPlugin;
import com.tst5000.agricrafttfctngintegration.api.v1.plugin.IAgriPlugin;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodAnalyze;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetBaseBlock;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetBrightness;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetBrightnessRange;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetCurrentSoil;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetGrowthStage;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetNeededSoil;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetPlant;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetSpecimen;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodGetStats;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodHasJournal;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodHasPlant;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodIsAnalyzed;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodIsCrossCrop;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodIsFertile;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodIsMature;
import com.tst5000.agricrafttfctngintegration.compat.computer.methods.MethodNeedsBaseBlock;
import com.tst5000.agricrafttfctngintegration.api.v1.misc.IAgriPeripheralMethod;
import com.tst5000.agricrafttfctngintegration.api.v1.misc.IAgriRegistry;
import javax.annotation.Nonnull;

/**
 *
 *
 */
@AgriPlugin
public class ComputerPlugin implements IAgriPlugin {

    @Nonnull
    private static final IAgriPeripheralMethod[] METHODS = new IAgriPeripheralMethod[]{
        new MethodAnalyze(),
        new MethodGetBaseBlock(),
        new MethodGetBrightness(),
        new MethodGetBrightnessRange(),
        new MethodGetCurrentSoil(),
        new MethodGetGrowthStage(),
        new MethodGetNeededSoil(),
        new MethodGetPlant(),
        new MethodGetSpecimen(),
        new MethodGetStats(),
        new MethodHasJournal(),
        new MethodHasPlant(),
        new MethodIsAnalyzed(),
        new MethodIsCrossCrop(),
        new MethodIsFertile(),
        new MethodIsMature(),
        new MethodNeedsBaseBlock()
    };

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getId() {
        return "computer";
    }

    @Override
    public String getName() {
        return "Computer Integration";
    }

    @Override
    public void registerPeripheralMethods(IAgriRegistry<IAgriPeripheralMethod> methodRegistry) {
        // Register all the default methods.
        for (IAgriPeripheralMethod m : METHODS) {
            methodRegistry.add(m);
        }
    }

}
