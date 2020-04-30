package com.tst5000.agricrafttfctngintegration.compat.computer.methods;

import com.agricrafttfctngintegration.agritfccore.core.AgriCore;

public class MethodParameter {

    public static final MethodParameter DIRECTION = new MethodParameter("direction");
    public static final MethodParameter DIRECTION_OPTIONAL = new MethodParameter("direction.optional");

    private String name;

    private MethodParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return AgriCore.getTranslator().translate("agricraft_arg." + name);
    }

    public String getDescription() {
        return AgriCore.getTranslator().translate("agricraft_description.parameter." + name);
    }
}
