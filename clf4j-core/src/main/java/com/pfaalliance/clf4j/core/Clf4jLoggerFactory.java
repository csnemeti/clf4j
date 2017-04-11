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
    private final Logger rootLogger = null;

    @Override
    public Logger getLogger(String name) {
        Objects.requireNonNull(name, "Logger name must not be null");
        String trimmedName = name.trim();
        Logger result;
        if (trimmedName.equals("")) {
            result = rootLogger;
        } else {
            result = getOrCreateLogger(trimmedName);
        }
        return result;
    }

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
