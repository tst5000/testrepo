package com.tst5000.agricrafttfctngintegration.proxy;

import com.agricrafttfctngintegration.agritfccore.core.AgriCore;
import com.tst5000.agricrafttfctngintegration.AgriCraftTFCTNGIntegration;
import com.tst5000.agricrafttfctngintegration.impl.v1.PluginHandler;
import com.tst5000.agricrafttfctngintegration.core.CoreHandler;
import com.tst5000.agricrafttfctngintegration.handler.GuiHandler;
import com.tst5000.agricrafttfctngintegration.init.AgriOreDict;
import com.tst5000.agricrafttfctngintegration.utility.CustomWoodTypeRegistry;
import com.infinityraider.infinitylib.proxy.base.IProxyBase;
import com.infinityraider.infinitylib.utility.ReflectionHelper;
import net.minecraft.command.ICommand;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public interface IProxy extends IProxyBase {

    @Override
    default void preInitStart(FMLPreInitializationEvent event) {
        CoreHandler.preInit(event);
        registerEventHandler(AgriCraftTFCTNGIntegration.instance);
        PluginHandler.preInit(event);
    }

    @Override
    default void initStart(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(AgriCraftTFCTNGIntegration.instance, new GuiHandler());
        PluginHandler.init();
        initCustomWoodTypes();
    }

    @Override
    default void initEnd(FMLInitializationEvent event) {
        CoreHandler.init();
    }

    @Override
    default void postInitStart(FMLPostInitializationEvent event) {
        PluginHandler.postInit();
        AgriOreDict.upgradeOreDict();
    }

    default void registerVillagerSkin(int id, String resource) {
    }

    default void initCustomWoodTypes() {
        CustomWoodTypeRegistry.init();
    }

    @Override
    default void registerCapabilities() {
    }

    @Override
    default void registerEventHandlers() {
    }

    @Override
    default void activateRequiredModules() {
    }

    @Override
    default void initConfiguration(FMLPreInitializationEvent event) {
    }

    // Since apparently translation is now client-side only.
    // This is why we can't have nice things.
    default String translateToLocal(String string) {
        // The {**} is a hack to get TOP integration to work.
        return "{*" + string + "*}";
    }

    default String getLocale() {
        // Whatever...
        return "en_US";
    }
    
    @Override
    default void onServerStarting(FMLServerStartingEvent event) {
        // This is to be moved to infinity lib in a future version, I would expect.
        AgriCore.getLogger("agricraft").info("Registering AgriCraftTFCTNGIntegration Commands.");
        ReflectionHelper.forEachValueIn(AgriCraftTFCTNGIntegration.instance.getModCommandRegistry(), ICommand.class, event::registerServerCommand);
    }
    
}
