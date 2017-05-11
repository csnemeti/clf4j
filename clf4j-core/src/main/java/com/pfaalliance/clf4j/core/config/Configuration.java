package com.pfaalliance.clf4j.core.config;

import org.slf4j.Marker;
import org.slf4j.event.Level;

/**
 * Created by Nemeti on 5/5/2017.
 */
public interface Configuration {
    /**
     * Method indicating if logging on a level is enabled or not.
     *
     * @param name   the name of the logger (cannot be null).
     * @param level  the logging level
     * @param marker the marker to check
     * @return true if the level is enabled, false otherwise
     */
    boolean isEnabled(String name, Level level, Marker marker);

    /**
     * Set a minimum loggin level for the given logger name and marker. In case there is a mapping for the given name and marker that will be overwritten.
     *
     * @param name   the name of the logger (cannot be null).
     * @param level  the minimum log level
     * @param marker the marker or marker chain or null if marker is not present
     */
    void setEnabled(String name, Level level, Marker marker);

    /**
     * Removes any mapping (present) for the given loggr name and marker.
     *
     * @param name   the name of the logger (cannot be null).
     * @param marker the marker or marker chain or null if marker is not present
     */
    void remove(String name, Marker marker);
}
