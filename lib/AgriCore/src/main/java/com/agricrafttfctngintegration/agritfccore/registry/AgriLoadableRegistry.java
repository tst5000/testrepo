/*
 */
package com.agricrafttfctngintegration.agritfccore.registry;

/**
 *
 * @author RlonRyan
 */
public interface AgriLoadableRegistry<T> {

    boolean acceptsElement(String filename);

    Class<T> getElementClass();

    void registerElement(T element);

    void clearElements();

}
