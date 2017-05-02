package com.pfaalliance.clf4j.core;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Nemeti on 4/10/2017.
 */
public class Clf4jLoggerFactory implements ILoggerFactory {
    private final Map<String, Logger> loggers = new HashMap<>();

    @Override
    public Logger getLogger(final String name) {
        Objects.requireNonNull(name, "Logger name must not be null");
        String trimmedName = name.trim();
        if (trimmedName.equals("") || trimmedName.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME)) {
            trimmedName = Logger.ROOT_LOGGER_NAME;
        }
        return getOrCreateLogger(trimmedName);
    }

    /**
     * Gets the logger from cache or creates a new one and put it into cache.
     *
     * @param trimmedName the logged name
     * @return the coresponding logger for the given name
     */
    private Logger getOrCreateLogger(final String trimmedName) {
        Logger result = null;
        synchronized (loggers) {
            result = loggers.get(trimmedName);
            if (result == null) {
                result = new Clf4jLogger(trimmedName);
                loggers.put(trimmedName, result);
            }
        }
        return result;
    }
}
