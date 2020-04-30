package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.tst5000.agricrafttfctngintegration.tiles.TileEntityPeripheral;
import com.tst5000.agricrafttfctngintegration.container.ContainerSeedAnalyzer;
import net.minecraft.item.ItemStack;

public class MethodGetSpecimen extends MethodBasePeripheral {

    public MethodGetSpecimen() {
        super("getSpecimen");
    }

    @Override
    protected Object[] onMethodCalled(TileEntityPeripheral peripheral) throws InvocationException {
        ItemStack stack = peripheral.getStackInSlot(ContainerSeedAnalyzer.SEED_SLOT_ID);
        return new Object[]{stack == null ? null : stack.getDisplayName()};
    }
}
