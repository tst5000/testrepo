package com.tst5000.agricrafttfctngintegration.proxy;

import com.tst5000.agricrafttfctngintegration.handler.PlayerConnectToServerHandler;
import com.infinityraider.infinitylib.proxy.base.IServerProxyBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
@SuppressWarnings("unused")
public class ServerProxy implements IServerProxyBase, IProxy {

    @Override
    public void registerEventHandlers() {
        IProxy.super.registerEventHandlers();
        registerEventHandler(new PlayerConnectToServerHandler());
    }
}
