/*
 */
package com.agricrafttfctngintegration.agritfccore.util;

/**
 *
 * @author RlonRyan
 */
public interface AgriValidator {

    boolean isValidBlock(final String block);

    boolean isValidItem(final String item);

    boolean isValidTexture(final String texture);
    
    boolean isValidMod(final String modid);

}
