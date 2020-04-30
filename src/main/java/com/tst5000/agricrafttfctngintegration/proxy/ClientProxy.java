package com.tst5000.agricrafttfctngintegration.proxy;

import com.tst5000.agricrafttfctngintegration.handler.ItemToolTipHandler;
import com.tst5000.agricrafttfctngintegration.utility.CustomWoodTypeRegistry;
import com.tst5000.agricrafttfctngintegration.utility.ModelErrorSuppressor;
import com.infinityraider.infinitylib.proxy.base.IClientProxyBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@SuppressWarnings("unused")
public class ClientProxy implements IClientProxyBase, IProxy {

    @Override
    public void registerEventHandlers() {
        IProxy.super.registerEventHandlers();
        registerEventHandler(ItemToolTipHandler.getInstance());
    }

    @Override
    public void initConfiguration(FMLPreInitializationEvent event) {
        registerEventHandler(new ModelErrorSuppressor());
    }

    @Override
    public void initCustomWoodTypes() {
        CustomWoodTypeRegistry.initClient();
    }

    @Override
    public String translateToLocal(String string) {
        return I18n.format(string);
    }

    @Override
    public String getLocale() {
        return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
    }

}
