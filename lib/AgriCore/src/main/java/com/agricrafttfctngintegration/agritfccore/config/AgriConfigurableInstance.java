/*
 */
package com.agricrafttfctngintegration.agritfccore.config;

/**
 * Interface for AgriConfigurable instances that need name resolution based on
 * the instance.
 *
 * @author RlonRyan
 */
public interface AgriConfigurableInstance {

    String resolve(String input);

}
