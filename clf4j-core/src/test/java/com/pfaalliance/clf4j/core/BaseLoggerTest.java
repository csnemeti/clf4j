package com.pfaalliance.clf4j.core;

import org.junit.Test;
import org.slf4j.Marker;
import org.slf4j.event.Level;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nemeti on 4/10/2017.
 */
public class BaseLoggerTest {

    @Test
    public void testName() {
        BaseLogger logger = new BaseLoggerMock("aName");
        assertEquals("Names are different", "aName", logger.getName());
    }

    private static class BaseLoggerMock extends BaseLogger {

        public BaseLoggerMock(String name) {
            super(name);
        }

        @Override
        protected boolean isEnabled(Level level) {
            return false;
        }

        @Override
        protected boolean isEnabled(Level level, Marker marker) {
            return false;
        }

        @Override
        protected void doLog(Level level, String format, Object[] arguments) {

        }

        @Override
        protected void doLog(Level level, Marker marker, String format, Object[] arguments) {

        }
    }
}
