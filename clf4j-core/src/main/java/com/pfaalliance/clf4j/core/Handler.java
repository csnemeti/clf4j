package com.pfaalliance.clf4j.core;

import com.pfaalliance.clf4j.core.config.Configuration;
import com.pfaalliance.clf4j.core.log.Logging;

/**
 * Created by Nemeti on 5/5/2017.
 */
public final class Handler {
    /**
     * The Configuration instance we have.
     */
    private static Configuration configuration;
    /**
     * The logging implementation.
     */
    private static Logging logging;

    /**
     * Gets the {@link Configuration}
     *
     * @return the Configuration instance
     */
    public static Configuration getConfiguration() {
        initConfiguration();
        return configuration;
    }

    /**
     * Lazy init the DEFAULT configuration instance if necessary.
     */
    private static void initConfiguration() {
        if (configuration != null) {

        }
    }

    /**
     * Sets the configuration
     *
     * @param configuration the new value for configuration
     */
    static void setConfiguration(Configuration configuration) {
        Handler.configuration = configuration;
    }

    /**
     * Gets the {@link Logging} instance.
     *
     * @return the logging instance
     */
    public static Logging getLogging() {
        return logging;
    }

    /**
     * Lasy init the DEFAULT logging if necessary.
     */
    private static void initLogging() {
        if (logging != null) {

        }
    }

    /**
     * Sets a logging to use.
     *
     * @param logging the new logging instance
     */
    static void setLogging(Logging logging) {
        Handler.logging = logging;
    }
}
