/*
 */
package com.tst5000.agricrafttfctngintegration.core;

import com.agricrafttfctngintegration.agritfccore.lang.AgriTranslationAdapter;
import com.tst5000.agricrafttfctngintegration.AgriCraftTFCTNGIntegration;

/**
 *
 *
 */
public class ModTranslator implements AgriTranslationAdapter {

    @Override
    public String translateKey(String key) {
        return AgriCraftTFCTNGIntegration.proxy.translateToLocal(key);
    }

    @Override
    public String getLocale() {
        return AgriCraftTFCTNGIntegration.proxy.getLocale();
    }

}
