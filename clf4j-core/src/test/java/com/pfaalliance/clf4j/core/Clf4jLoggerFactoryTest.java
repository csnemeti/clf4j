package com.pfaalliance.clf4j.core;

import org.junit.Test;
import org.slf4j.Logger;

import static org.junit.Assert.*;

/**
 * Created by Nemeti on 5/2/2017.
 */
public class Clf4jLoggerFactoryTest {
    @Test(expected = NullPointerException.class)
    public void test_getLogger_withNull() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();
        factory.getLogger(null);
    }

    @Test
    public void test_getLogger_withEmptyString() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();
        Logger logger = factory.getLogger("");
        assertNotNull("Logger should not be null", logger);
        assertEquals("name issue", Logger.ROOT_LOGGER_NAME, logger.getName());
    }

    @Test
    public void test_getLogger_withBlankString() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();
        Logger logger = factory.getLogger(" ");
        assertNotNull("Logger should not be null", logger);
        assertEquals("name issue", Logger.ROOT_LOGGER_NAME, logger.getName());
    }

    @Test
    public void test_getLogger_withRootString1() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();
        Logger logger = factory.getLogger("root");
        assertNotNull("Logger should not be null", logger);
        assertEquals("name issue", Logger.ROOT_LOGGER_NAME, logger.getName());
    }

    @Test
    public void test_getLogger_withRootString2() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();
        Logger logger = factory.getLogger(Logger.ROOT_LOGGER_NAME);
        assertNotNull("Logger should not be null", logger);
        assertEquals("name issue", Logger.ROOT_LOGGER_NAME, logger.getName());
    }

    @Test
    public void test_getLogger_withRootString3() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();
        Logger logger = factory.getLogger(" Root ");
        assertNotNull("Logger should not be null", logger);
        assertEquals("name issue", Logger.ROOT_LOGGER_NAME, logger.getName());
    }

    @Test
    public void test_getLogger_forAbc() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();
        Logger logger = factory.getLogger(" Abc ");
        assertNotNull("Logger should not be null", logger);
        assertEquals("name issue", "Abc", logger.getName());
    }

    @Test
    public void test_getLogger_fromCache() {
        Clf4jLoggerFactory factory = new Clf4jLoggerFactory();

        Logger logger1 = factory.getLogger(" Abc ");
        assertNotNull("Logger should not be null", logger1);
        assertEquals("name issue", "Abc", logger1.getName());

        Logger logger2 = factory.getLogger(" Abc");
        assertNotNull("Logger should not be null", logger2);
        assertEquals("name issue", "Abc", logger2.getName());

        assertSame("Instance issues", logger1, logger2);
    }

}
