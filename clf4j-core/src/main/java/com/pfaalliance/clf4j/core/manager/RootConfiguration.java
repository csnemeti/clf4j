package com.pfaalliance.clf4j.core.manager;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/**
 * Created by Nemeti on 5/16/2017.
 */
class RootConfiguration implements Configuration {
    /**
     * Default level in case no level is specified.
     */
    private static final Level DEFAULT_LEVEL = Level.INFO;
    private Level rootLevel;

    /**
     * Create root configuration with default INFO level.
     */
    public RootConfiguration() {
        this(null);
    }

    /**
     * Create root configuration with a given root level.
     *
     * @param rootLevel the specific level,
     */
    public RootConfiguration(Level rootLevel) {
        setLevel(Logger.ROOT_LOGGER_NAME, rootLevel, null);
    }

    @Override
    public boolean isEnabled(String name, Level level, Marker marker) {
        return level.compareTo(rootLevel) >= 0;
    }

    public Level getRootLevel() {
        return rootLevel;
    }

    @Override
    public void setLevel(String name, Level level, Marker marker) {
        if (marker == null && (name.equals("") || name.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME))) {
            rootLevel = (level == null) ? DEFAULT_LEVEL : level;
        }
    }

    @Override
    public void remove(String name, Marker marker) {
        // nothing to do here
    }
}
