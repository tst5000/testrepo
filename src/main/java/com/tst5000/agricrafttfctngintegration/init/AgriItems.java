package com.tst5000.agricrafttfctngintegration.init;

import com.tst5000.agricrafttfctngintegration.items.ItemAgriSeed;
import com.tst5000.agricrafttfctngintegration.items.ItemClipper;
import com.tst5000.agricrafttfctngintegration.items.ItemClipping;
import com.tst5000.agricrafttfctngintegration.items.ItemCrop;
import com.tst5000.agricrafttfctngintegration.items.ItemDebugger;
import com.tst5000.agricrafttfctngintegration.items.ItemJournal;
import com.tst5000.agricrafttfctngintegration.items.ItemMagnifyingGlass;
import com.tst5000.agricrafttfctngintegration.items.ItemNugget;
import com.tst5000.agricrafttfctngintegration.items.ItemRake;
import com.tst5000.agricrafttfctngintegration.items.ItemTrowel;
import com.infinityraider.infinitylib.item.ItemBase;

import javax.annotation.Nonnull;

public class AgriItems {

    private static final AgriItems INSTANCE = new AgriItems();

    public static AgriItems getInstance() {
        return INSTANCE;
    }

    private AgriItems() {
        CROPS = new ItemCrop();
        JOURNAL = new ItemJournal();
        TROWEL = new ItemTrowel();
        DEBUGGER = new ItemDebugger();
        HAND_RAKE = new ItemRake();
        CLIPPER = new ItemClipper();
        AGRI_CLIPPING = new ItemClipping();
        AGRI_SEED = new ItemAgriSeed();
        AGRI_NUGGET = new ItemNugget();
        MAGNIFYING_GLASS = new ItemMagnifyingGlass();
    }

    @Nonnull
    public final ItemBase CROPS;
    @Nonnull
    public final ItemBase JOURNAL;
    @Nonnull
    public final ItemBase TROWEL;
    @Nonnull
    public final ItemBase DEBUGGER;
    @Nonnull
    public final ItemBase HAND_RAKE;
    @Nonnull
    public final ItemBase CLIPPER;
    @Nonnull
    public final ItemBase AGRI_CLIPPING;
    @Nonnull
    public final ItemBase AGRI_SEED;
    @Nonnull
    public final ItemBase AGRI_NUGGET;
    @Nonnull
    public final ItemBase MAGNIFYING_GLASS;

}
