package com.pfaalliance.clf4j.core;

import com.pfaalliance.clf4j.core.manager.Handler;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/**
 * Created by Nemeti on 4/11/2017.
 */
public class Clf4jLogger extends BaseLogger {
    public Clf4jLogger(String name) {
        super(name);
    }

    @Override
    protected boolean isEnabled(Level level) {
        return Handler.getConfiguration().isEnabled(getName(), level, null);
    }

    @Override
    protected boolean isEnabled(Level level, Marker marker) {
        return Handler.getConfiguration().isEnabled(getName(), level, marker);
    }

    @Override
    protected void doLog(Level level, String format, Object[] arguments) {
        Handler.getLogging().doLog(getName(), level, null, format, arguments);
    }

    @Override
    protected void doLog(Level level, Marker marker, String format, Object[] arguments) {
        Handler.getLogging().doLog(getName(), level, marker, format, arguments);
    }
}
