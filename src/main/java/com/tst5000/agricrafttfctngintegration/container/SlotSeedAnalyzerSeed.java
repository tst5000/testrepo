package com.tst5000.agricrafttfctngintegration.container;

import com.tst5000.agricrafttfctngintegration.tiles.analyzer.TileEntitySeedAnalyzer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSeedAnalyzerSeed extends Slot {

    public SlotSeedAnalyzerSeed(IInventory inventory, int id, int x, int y) {
        super(inventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return TileEntitySeedAnalyzer.isValid(stack);
    }
}
