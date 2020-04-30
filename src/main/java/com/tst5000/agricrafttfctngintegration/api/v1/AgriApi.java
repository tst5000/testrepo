/*
 */
package com.tst5000.agricrafttfctngintegration.api.v1;

import com.tst5000.agricrafttfctngintegration.api.v1.adapter.IAgriAdapterizer;
import com.tst5000.agricrafttfctngintegration.api.v1.fertilizer.IAgriFertilizer;
import com.tst5000.agricrafttfctngintegration.api.v1.misc.IAgriPeripheralMethod;
import com.tst5000.agricrafttfctngintegration.api.v1.misc.IAgriRegistry;
import com.tst5000.agricrafttfctngintegration.api.v1.mutation.IAgriMutationEngine;
import com.tst5000.agricrafttfctngintegration.api.v1.mutation.IAgriMutationRegistry;
import com.tst5000.agricrafttfctngintegration.api.v1.plant.IAgriPlant;
import com.tst5000.agricrafttfctngintegration.api.v1.seed.AgriSeed;
import com.tst5000.agricrafttfctngintegration.api.v1.soil.IAgriSoilRegistry;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStat;
import com.tst5000.agricrafttfctngintegration.api.v1.stat.IAgriStatCalculator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nonnull;
import javax.naming.OperationNotSupportedException;

import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

/**
 * The AgriCraftTFCTNGIntegration APIv1.
 *
 * @since 2.0.0
 */
public final class AgriApi {

    public static final String MOD_ID = "agricraft";

    public static final String API_ID = "agricraft-api-v1";

    private static final IAgriApiConnector CONNECTOR = connect();

    /**
     * Determines the current state of the AgriCraftTFCTNGIntegration API.
     * <p>
     * Notice, unlike the other API methods, this one is always safe to use, and will not throw an
     * exception when AgriCraftTFCTNGIntegration is not installed, opting instead to return
     * {@link AgriApiState#INVALID}.
     *
     * @return the current state of the AgriCraftTFCTNGIntegration API.
     */
    @Nonnull
    AgriApiState getState() {
        return AgriApi.CONNECTOR.getState();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration Plant Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Plant Registry.
     */
    @Nonnull
    public static IAgriRegistry<IAgriPlant> getPlantRegistry() {
        return AgriApi.CONNECTOR.connectPlantRegistry();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration Mutation Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Mutation Registry.
     */
    @Nonnull
    public static IAgriMutationRegistry getMutationRegistry() {
        return AgriApi.CONNECTOR.connectMutationRegistry();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration Soil Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Soil Registry.
     */
    @Nonnull
    public static IAgriSoilRegistry getSoilRegistry() {
        return AgriApi.CONNECTOR.connectSoilRegistry();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration Stat Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Stat Registry.
     */
    @Nonnull
    public static IAgriAdapterizer<IAgriStat> getStatRegistry() {
        return AgriApi.CONNECTOR.connectStatRegistry();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration StatCalculator Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration StatCalculator Registry.
     */
    @Nonnull
    public static IAgriAdapterizer<IAgriStatCalculator> getStatCalculatorRegistry() {
        return AgriApi.CONNECTOR.connectStatCalculatorRegistry();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration Mutation Engine.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Mutation Engine.
     */
    @Nonnull
    public static IAgriMutationEngine getMutationEngine() {
        return AgriApi.CONNECTOR.connectMutationEngine();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration Seed Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Seed Registry.
     */
    @Nonnull
    public static IAgriAdapterizer<AgriSeed> getSeedRegistry() {
        return AgriApi.CONNECTOR.connectSeedRegistry();
    }

    /**
     * Fetches the AgriCraftTFCTNGIntegration Fertilizer Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Fertilizer Registry.
     */
    @Nonnull
    public static IAgriAdapterizer<IAgriFertilizer> getFertilizerRegistry() {
        return AgriApi.CONNECTOR.connectFertilizerRegistry();
    }
    
    /**
     * Fetches the AgriCraftTFCTNGIntegration Peripheral Method Registry.
     * <p>
     * Notice: This method will throw an {@link OperationNotSupportedException} if the corresponding
     * version of AgriCraftTFCTNGIntegration is not currently installed.
     *
     * @return the AgriCraftTFCTNGIntegration Plant Registry.
     */
    @Nonnull
    public static IAgriRegistry<IAgriPeripheralMethod> getPeripheralMethodRegistry() {
        return AgriApi.CONNECTOR.connectPeripheralMethodRegistry();
    }

    /**
     * Establishes a connection to AgriCraftTFCTNGIntegration, if it is present, or returns a fake connection to
     * nothing.
     *
     * @return a connection to AgriCraftTFCTNGIntegration, or a connection to nothing.
     */
    @Nonnull
    private static IAgriApiConnector connect() {
        // Step I. Setup Variables.
        final Class<? extends IAgriApiConnector> clazz;
        final Constructor<? extends IAgriApiConnector> constructor;
        final IAgriApiConnector instance;

        // Step II. Attempt To Find Class
        try {
            clazz = Class.forName("com.tst5000.agricrafttfctngintegration.impl.v1.AgriApiConnector").asSubclass(IAgriApiConnector.class);
        } catch (ClassNotFoundException exception) {
            FMLLog.log(API_ID, Level.INFO, "The AgriCraftTFCTNGIntegration APIv1 was unable find AgriCraftTFCTNGIntegration! Is AgriCraftTFCTNGIntegration missing from your modpack?");
            return IAgriApiConnector.FAKE;
        } catch (ClassCastException exception) {
            throw new RuntimeException("The AgriCraftTFCTNGIntegration APIv1 attempted to connect to AgriCraftTFCTNGIntegration, but instead found an invalid class! This is a serious error that should never happen! Report this error immediately!", exception);
        }

        // Step III. Attempt To Find Constructor
        try {
            constructor = clazz.getConstructor();
        } catch (NoSuchMethodException exception) {
            throw new RuntimeException("The AgriCraftTFCTNGIntegration APIv1 attempted to connect to AgriCraftTFCTNGIntegration, found a connection class, but couldn't find a valid no-args constructor! This is a serious error that should never happen! Report this error immediately!", exception);
        } catch (SecurityException exception) {
            throw new RuntimeException("The AgriCraftTFCTNGIntegration APIv1 attempted to connect to AgriCraftTFCTNGIntegration, but instead ran into a security exception! This is a very unusual error that should not have happened! Report this error immediately!", exception);
        }

        // Step IV. Attempt To Instantiate Constructor
        try {
            instance = constructor.newInstance();
        } catch (IllegalAccessException exception) {
            throw new RuntimeException("The AgriCraftTFCTNGIntegration APIv1 attempted to connect to AgriCraftTFCTNGIntegration, but instead was prevented from accessing the constructor required to create a connection! This is a very unusual error that should not have happened! Report this error immediately!", exception);
        } catch (IllegalArgumentException exception) {
            throw new RuntimeException("The AgriCraftTFCTNGIntegration APIv1 attempted to connect to AgriCraftTFCTNGIntegration, but instead discovered something is wrong with the JVM! This error should never occur! Report this error immediately to Oracle!", exception);
        } catch (InstantiationException exception) {
            throw new RuntimeException("The AgriCraftTFCTNGIntegration APIv1 attempted to connect to AgriCraftTFCTNGIntegration, found a connection class, but it was abstract! This is a serious error that should never happen! Report this error immediately!", exception);
        } catch (InvocationTargetException exception) {
            throw new RuntimeException("The AgriCraftTFCTNGIntegration APIv1 attempted to connect to AgriCraftTFCTNGIntegration, found a valid connection class, started instantiation, but then the AgriApi.connector threw an error! This is a serious error that should never happen! Report this error immediately!", exception);
        }

        // Step V. Celebrate Connection Success
        FMLLog.log(API_ID, Level.INFO, "The AgriCraftTFCTNGIntegration APIv1 successfully connected to AgriCraftTFCTNGIntegration! Thank you for including AgriCraftTFCTNGIntegration in your modpack!");

        // Step VI. Return The Connector
        return instance;
    }

    /**
     * A private constructor to prevent instantiation of this class.
     */
    private AgriApi() {
    }

}
