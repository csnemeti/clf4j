package org.slf4j.impl;

import com.pfaalliance.clf4j.core.Clf4jLoggerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * Created by Nemeti on 4/6/2017.
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static final ILoggerFactory LOGGER_FACTORY = new Clf4jLoggerFactory();

    @Override
    public ILoggerFactory getLoggerFactory() {
        return LOGGER_FACTORY;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return LOGGER_FACTORY.getClass().getName();
    }
}
