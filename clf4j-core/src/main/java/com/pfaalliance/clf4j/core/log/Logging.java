package com.pfaalliance.clf4j.core.log;

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
}
