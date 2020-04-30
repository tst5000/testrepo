package com.tst5000.agricrafttfctngintegration.init;

import com.tst5000.agricrafttfctngintegration.blocks.BlockCrop;
import com.tst5000.agricrafttfctngintegration.blocks.BlockGrate;
import com.tst5000.agricrafttfctngintegration.blocks.BlockSeedAnalyzer;
import com.tst5000.agricrafttfctngintegration.blocks.BlockPeripheral;
import com.tst5000.agricrafttfctngintegration.blocks.BlockWaterPad;
import com.tst5000.agricrafttfctngintegration.blocks.irrigation.BlockSprinkler;
import com.tst5000.agricrafttfctngintegration.blocks.irrigation.BlockWaterChannel;
import com.tst5000.agricrafttfctngintegration.blocks.irrigation.BlockWaterChannelFull;
import com.tst5000.agricrafttfctngintegration.blocks.irrigation.BlockWaterChannelValve;
import com.tst5000.agricrafttfctngintegration.blocks.irrigation.BlockWaterTank;
import com.infinityraider.infinitylib.block.BlockBase;

import javax.annotation.Nonnull;

public class AgriBlocks {

    private static final AgriBlocks INSTANCE = new AgriBlocks();

    public static AgriBlocks getInstance() {
        return INSTANCE;
    }

    private AgriBlocks() {
        CROP = new BlockCrop();
        SEED_ANALYZER = new BlockSeedAnalyzer();
        PERIPHERAL = new BlockPeripheral();
        WATER_PAD = new BlockWaterPad();
        TANK = new BlockWaterTank();
        CHANNEL = new BlockWaterChannel();
        CHANNEL_FULL = new BlockWaterChannelFull();
        CHANNEL_VALVE = new BlockWaterChannelValve();
        SPRINKLER = new BlockSprinkler();
        //SEED_STORAGE = new BlockSeedStorage();
        GRATE = new BlockGrate();
    }

    // Crops
    @Nonnull
    public final BlockBase CROP;

    // Analyzers
    @Nonnull
    public final BlockBase SEED_ANALYZER;
    
    // Peripherals
    @Nonnull
    public final BlockBase PERIPHERAL;

    // Water Pads
    @Nonnull
    public final BlockBase WATER_PAD;

    // Irrigation
    @Nonnull
    public final BlockBase TANK;
    @Nonnull
    public final BlockBase CHANNEL;
    @Nonnull
    public final BlockBase CHANNEL_FULL;
    @Nonnull
    public final BlockBase CHANNEL_VALVE;
    @Nonnull
    public final BlockBase SPRINKLER;

    // Seed Storage
    //public final BlockBase SEED_STORAGE;
    //public static final BlockBase SEED_STORAGE_CONTROLLER = new BlockSeedStorageController();
    // Decoration
    @Nonnull
    public final BlockBase GRATE;

}
