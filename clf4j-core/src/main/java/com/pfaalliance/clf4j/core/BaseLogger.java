package com.pfaalliance.clf4j.core;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/**
 * Created by Nemeti on 4/10/2017.
 */
abstract class BaseLogger implements Logger {
    /**
     * The name of the logger.
     */
    private final String name;
    /**
     * Internal object used for reusability.
     */
    private final static Object[] NO_ARG = new Object[0];

    public BaseLogger(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Method indicating if logging on a level is enabled or not.
     *
     * @param level the logging level
     * @return true if the level is enabled, flase otherwise
     */
    protected abstract boolean isEnabled(Level level);

    /**
     * Method indicating if logging on a level is enabled or not.
     *
     * @param level  the logging level
     * @param marker the marker to check
     * @return true if the level is enabled, false otherwise
     */
    protected abstract boolean isEnabled(Level level, Marker marker);

    /**
     * Logs a message.
     *
     * @param level     the message level
     * @param format    the text to log
     * @param arguments the arguments for the log
     */
    protected abstract void doLog(Level level, String format, Object[] arguments);

    /**
     * Logs a message.
     *
     * @param level     the message level
     * @param marker    the main marker
     * @param format    the text to log
     * @param arguments the arguments for the log
     */
    protected abstract void doLog(Level level, Marker marker, String format, Object[] arguments);

    /**
     * Logs a message.
     *
     * @param level     the message level
     * @param format    the text to log
     * @param arguments the arguments for the log
     */
    protected void log(Level level, String format, Object[] arguments) {
        if (isEnabled(level)) {
            doLog(level, format, arguments);
        }
    }

    /**
     * Logs a message.
     *
     * @param level     the message level
     * @param marker    the main marker
     * @param format    the text to log
     * @param arguments the arguments for the log
     */
    protected void log(Level level, Marker marker, String format, Object[] arguments) {
        if (isEnabled(level, marker)) {
            doLog(level, marker, format, arguments);
        }
    }

    @Override
    public boolean isTraceEnabled() {
        return isEnabled(Level.TRACE);
    }

    @Override
    public void trace(String msg) {
        log(Level.TRACE, msg, NO_ARG);
    }

    @Override
    public void trace(String format, Object arg) {
        log(Level.TRACE, format, new Object[]{arg});
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        log(Level.TRACE, format, new Object[]{arg1, arg2});
    }

    @Override
    public void trace(String format, Object... arguments) {
        log(Level.TRACE, format, arguments);
    }

    @Override
    public void trace(String msg, Throwable t) {
        log(Level.TRACE, msg, new Object[]{t});
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return isEnabled(Level.TRACE, marker);
    }

    @Override
    public void trace(Marker marker, String msg) {
        log(Level.TRACE, marker, msg, NO_ARG);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        log(Level.TRACE, marker, format, new Object[]{arg});
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.TRACE, marker, format, new Object[]{arg1, arg2});
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        log(Level.TRACE, marker, format, argArray);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        log(Level.TRACE, marker, msg, new Object[]{t});
    }

    @Override
    public boolean isDebugEnabled() {
        return isEnabled(Level.DEBUG);
    }

    @Override
    public void debug(String msg) {
        log(Level.DEBUG, msg, NO_ARG);
    }

    @Override
    public void debug(String format, Object arg) {
        log(Level.DEBUG, format, new Object[]{arg});
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        log(Level.DEBUG, format, new Object[]{arg1, arg2});
    }

    @Override
    public void debug(String format, Object... arguments) {
        log(Level.DEBUG, format, arguments);
    }

    @Override
    public void debug(String msg, Throwable t) {
        log(Level.DEBUG, msg, new Object[]{t});
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return isEnabled(Level.DEBUG, marker);
    }

    @Override
    public void debug(Marker marker, String msg) {
        log(Level.DEBUG, marker, msg, NO_ARG);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        log(Level.DEBUG, marker, format, new Object[]{arg});
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.DEBUG, marker, format, new Object[]{arg1, arg2});
    }

    @Override
    public void debug(Marker marker, String format, Object... argArray) {
        log(Level.DEBUG, marker, format, argArray);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        log(Level.DEBUG, marker, msg, new Object[]{t});
    }

    @Override
    public boolean isInfoEnabled() {
        return isEnabled(Level.INFO);
    }

    @Override
    public void info(String msg) {
        log(Level.INFO, msg, NO_ARG);
    }

    @Override
    public void info(String format, Object arg) {
        log(Level.INFO, format, new Object[]{arg});
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        log(Level.INFO, format, new Object[]{arg1, arg2});
    }

    @Override
    public void info(String format, Object... arguments) {
        log(Level.INFO, format, arguments);
    }

    @Override
    public void info(String msg, Throwable t) {
        log(Level.INFO, msg, new Object[]{t});
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return isEnabled(Level.DEBUG, marker);
    }

    @Override
    public void info(Marker marker, String msg) {
        log(Level.INFO, marker, msg, NO_ARG);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        log(Level.INFO, marker, format, new Object[]{arg});
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.INFO, marker, format, new Object[]{arg1, arg2});
    }

    @Override
    public void info(Marker marker, String format, Object... argArray) {
        log(Level.INFO, marker, format, argArray);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        log(Level.INFO, marker, msg, new Object[]{t});
    }

    @Override
    public boolean isWarnEnabled() {
        return isEnabled(Level.WARN);
    }

    @Override
    public void warn(String msg) {
        log(Level.WARN, msg, NO_ARG);
    }

    @Override
    public void warn(String format, Object arg) {
        log(Level.WARN, format, new Object[]{arg});
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        log(Level.WARN, format, new Object[]{arg1, arg2});
    }

    @Override
    public void warn(String format, Object... arguments) {
        log(Level.WARN, format, arguments);
    }

    @Override
    public void warn(String msg, Throwable t) {
        log(Level.WARN, msg, new Object[]{t});
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return isEnabled(Level.WARN, marker);
    }

    @Override
    public void warn(Marker marker, String msg) {
        log(Level.WARN, marker, msg, NO_ARG);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        log(Level.WARN, marker, format, new Object[]{arg});
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.WARN, marker, format, new Object[]{arg1, arg2});
    }

    @Override
    public void warn(Marker marker, String format, Object... argArray) {
        log(Level.WARN, marker, format, argArray);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        log(Level.WARN, marker, msg, new Object[]{t});
    }

    @Override
    public boolean isErrorEnabled() {
        return isEnabled(Level.ERROR);
    }

    @Override
    public void error(String msg) {
        log(Level.ERROR, msg, NO_ARG);
    }

    @Override
    public void error(String format, Object arg) {
        log(Level.ERROR, format, new Object[]{arg});
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        log(Level.ERROR, format, new Object[]{arg1, arg2});
    }

    @Override
    public void error(String format, Object... arguments) {
        log(Level.ERROR, format, arguments);
    }

    @Override
    public void error(String msg, Throwable t) {
        log(Level.ERROR, msg, new Object[]{t});
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return isEnabled(Level.ERROR, marker);
    }

    @Override
    public void error(Marker marker, String msg) {
        log(Level.ERROR, marker, msg, NO_ARG);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        log(Level.ERROR, marker, format, new Object[]{arg});
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.ERROR, marker, format, new Object[]{arg1, arg2});
    }

    @Override
    public void error(Marker marker, String format, Object... argArray) {
        log(Level.ERROR, marker, format, argArray);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        log(Level.ERROR, marker, msg, new Object[]{t});
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "(" + getName() + ")";
    }
}
