package com.pfaalliance.clf4j.core.manager;

import org.slf4j.Marker;
import org.slf4j.event.Level;

/**
 * Created by Nemeti on 5/11/2017.
 */
public interface Logging {
    /**
     * Perform the logging.
     *
     * @param name      the logger name
     * @param level     the log level
     * @param marker    the marker (could be null)
     * @param format    the message format
     * @param arguments the arguments containing format parameters and / or {@link Throwable} as last parameter
     */
    void doLog(String name, Level level, Marker marker, String format, Object[] arguments);

    /**
     * Gets the target names for a given (generic) logger name and marker.
     *
     * @param name   the name of the logger
     * @param marker the Marker (null if no Marker)
     * @return the array of targets
     */
    String[] getTargets(String name, Marker marker);

    /**
     * Sets the target names for the given (generic) logger name and marker.
     *
     * @param name    the name of the logger
     * @param marker  the Marker (null if no Marker)
     * @param targets the target names, if no target it will not be set any target
     */
    void setTargets(String name, Marker marker, String... targets);
}
