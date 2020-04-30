/*
 */
package com.tst5000.agricrafttfctngintegration.core;

import com.agricrafttfctngintegration.agritfccore.util.AgriConverter;
import com.agricrafttfctngintegration.agritfccore.util.TypeHelper;
import com.tst5000.agricrafttfctngintegration.api.v1.util.FuzzyStack;
import com.tst5000.agricrafttfctngintegration.utility.OreDictUtil;

import java.util.List;
import java.util.Optional;
/**
 *
 *
 */
public class ModConverter implements AgriConverter {

    @Override
    public <T> Optional<T> toStack(Class<T> token, String element, int meta, int amount, String tags, boolean ignoreMeta, boolean useOreDict, List<String> ignoreTags) {
        return Optional.ofNullable(token)
                .filter(type -> TypeHelper.isType(FuzzyStack.class, type))
                .flatMap(type -> OreDictUtil.makeItemStack(element, meta, amount, tags))
                .map(stack -> (T) new FuzzyStack(stack, ignoreMeta, useOreDict, ignoreTags));
    }
    
}
