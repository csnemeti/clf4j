package com.pfaalliance.clf4j.core;

import org.junit.Test;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.event.Level;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Nemeti on 4/10/2017.
 */
public class BaseLoggerTest {

    @Test
    public void testName() {
        BaseLogger logger = new BaseLoggerMock("aName", false, null);
        assertEquals("Names are different", "aName", logger.getName());
    }

    @Test
    public void test_toString() {
        BaseLogger logger = new BaseLoggerMock("aName", false, null);
        assertNotNull(logger.toString());
    }

    // trace
    @Test
    public void test_isTraceEnabled_noParams() {
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.TRACE)).thenReturn(true);
        when(logger.isTraceEnabled()).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isTraceEnabled());

        verify(logger, times(1)).isTraceEnabled();
        verify(logger, times(1)).isEnabled(Level.TRACE);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_isTraceEnabled_withParams() {
        Marker marker = mock(Marker.class);
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.TRACE, marker)).thenReturn(true);
        when(logger.isTraceEnabled(any(Marker.class))).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isTraceEnabled(marker));

        verify(logger, times(1)).isTraceEnabled(marker);
        verify(logger, times(1)).isEnabled(Level.TRACE, marker);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_trace_noLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace("Trace format");

        logger.validateNoCall();
    }

    @Test
    public void test_trace_withLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace("Trace format");

        logger.validateLogCall(Level.TRACE, null, "Trace format", new Object[0]);
    }

    @Test
    public void test_trace1Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace("Trace format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_trace1Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace("Trace format {}", arg1);

        logger.validateLogCall(Level.TRACE, null, "Trace format {}", new Object[]{arg1});
    }

    @Test
    public void test_trace2Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace("Trace format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_trace2Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace("Trace format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.TRACE, null, "Trace format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_trace3Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace("Trace format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_trace3Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace("Trace format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.TRACE, null, "Trace format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_traceM_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace(marker, "Trace format");

        logger.validateNoCall();
    }

    @Test
    public void test_traceM_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace(marker, "Trace format");

        logger.validateLogCall(Level.TRACE, marker, "Trace format", new Object[0]);
    }

    @Test
    public void test_traceM1Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace(marker, "Trace format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_traceM1Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace(marker, "Trace format {}", arg1);

        logger.validateLogCall(Level.TRACE, marker, "Trace format {}", new Object[]{arg1});
    }

    @Test
    public void test_traceM2Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace(marker, "Trace format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_traceM2Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace(marker, "Trace format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.TRACE, marker, "Trace format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_traceM3Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace(marker, "Trace format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_traceM3Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace(marker, "Trace format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.TRACE, marker, "Trace format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_trace_throwable_noLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace("Trace format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_trace_throwable_withLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace("Trace format", arg1);

        logger.validateLogCall(Level.TRACE, marker, "Trace format", new Object[]{arg1});
    }

    @Test
    public void test_traceM_throwable_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.trace(marker, "Trace format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_traceM_throwable_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.trace(marker, "Trace format", arg1);

        logger.validateLogCall(Level.TRACE, marker, "Trace format", new Object[]{arg1});
    }

    // debug
    @Test
    public void test_isDebugEnabled_noParams() {
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.DEBUG)).thenReturn(true);
        when(logger.isDebugEnabled()).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isDebugEnabled());

        verify(logger, times(1)).isDebugEnabled();
        verify(logger, times(1)).isEnabled(Level.DEBUG);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_isDebugEnabled_withParams() {
        Marker marker = mock(Marker.class);
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.DEBUG, marker)).thenReturn(true);
        when(logger.isDebugEnabled(any(Marker.class))).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isDebugEnabled(marker));

        verify(logger, times(1)).isDebugEnabled(marker);
        verify(logger, times(1)).isEnabled(Level.DEBUG, marker);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_debug_noLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug("Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_debug_withLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug("Message format");

        logger.validateLogCall(Level.DEBUG, null, "Message format", new Object[0]);
    }

    @Test
    public void test_debug1Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug("Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_debug1Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug("Message format {}", arg1);

        logger.validateLogCall(Level.DEBUG, null, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_debug2Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug("Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_debug2Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug("Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.DEBUG, null, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_debug3Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_debug3Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.DEBUG, null, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_debugM_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug(marker, "Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_debugM_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug(marker, "Message format");

        logger.validateLogCall(Level.DEBUG, marker, "Message format", new Object[0]);
    }

    @Test
    public void test_debugM1Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug(marker, "Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_debugM1Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug(marker, "Message format {}", arg1);

        logger.validateLogCall(Level.DEBUG, marker, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_debugM2Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug(marker, "Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_debugM2Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug(marker, "Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.DEBUG, marker, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_debugM3Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_debugM3Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.DEBUG, marker, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_debug_throwable_noLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug("Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_debug_throwable_withLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug("Message format", arg1);

        logger.validateLogCall(Level.DEBUG, marker, "Message format", new Object[]{arg1});
    }

    @Test
    public void test_debugM_throwable_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.debug(marker, "Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_debugM_throwable_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.debug(marker, "Message format", arg1);

        logger.validateLogCall(Level.DEBUG, marker, "Message format", new Object[]{arg1});
    }

    // info
    @Test
    public void test_isInfoEnabled_noParams() {
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.INFO)).thenReturn(true);
        when(logger.isInfoEnabled()).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isInfoEnabled());

        verify(logger, times(1)).isInfoEnabled();
        verify(logger, times(1)).isEnabled(Level.INFO);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_isInfoEnabled_withParams() {
        Marker marker = mock(Marker.class);
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.INFO, marker)).thenReturn(true);
        when(logger.isInfoEnabled(any(Marker.class))).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isInfoEnabled(marker));

        verify(logger, times(1)).isInfoEnabled(marker);
        verify(logger, times(1)).isEnabled(Level.INFO, marker);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_info_noLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info("Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_info_withLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info("Message format");

        logger.validateLogCall(Level.INFO, null, "Message format", new Object[0]);
    }

    @Test
    public void test_info1Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info("Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_info1Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info("Message format {}", arg1);

        logger.validateLogCall(Level.INFO, null, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_info2Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info("Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_info2Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info("Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.INFO, null, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_info3Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_info3Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.INFO, null, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_infoM_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info(marker, "Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_infoM_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info(marker, "Message format");

        logger.validateLogCall(Level.INFO, marker, "Message format", new Object[0]);
    }

    @Test
    public void test_infoM1Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info(marker, "Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_infoM1Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info(marker, "Message format {}", arg1);

        logger.validateLogCall(Level.INFO, marker, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_infoM2Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info(marker, "Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_infoM2Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info(marker, "Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.INFO, marker, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_infoM3Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_infoM3Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.INFO, marker, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_info_throwable_noLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info("Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_info_throwable_withLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info("Message format", arg1);

        logger.validateLogCall(Level.INFO, marker, "Message format", new Object[]{arg1});
    }

    @Test
    public void test_infoM_throwable_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.info(marker, "Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_infoM_throwable_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.info(marker, "Message format", arg1);

        logger.validateLogCall(Level.INFO, marker, "Message format", new Object[]{arg1});
    }


    // warn
    @Test
    public void test_isWarnEnabled_noParams() {
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.WARN)).thenReturn(true);
        when(logger.isWarnEnabled()).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isWarnEnabled());

        verify(logger, times(1)).isWarnEnabled();
        verify(logger, times(1)).isEnabled(Level.WARN);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_isWarnEnabled_withParams() {
        Marker marker = mock(Marker.class);
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.WARN, marker)).thenReturn(true);
        when(logger.isWarnEnabled(any(Marker.class))).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isWarnEnabled(marker));

        verify(logger, times(1)).isWarnEnabled(marker);
        verify(logger, times(1)).isEnabled(Level.WARN, marker);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_warn_noLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn("Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_warn_withLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn("Message format");

        logger.validateLogCall(Level.WARN, null, "Message format", new Object[0]);
    }

    @Test
    public void test_warn1Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn("Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_warn1Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn("Message format {}", arg1);

        logger.validateLogCall(Level.WARN, null, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_warn2Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn("Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_warn2Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn("Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.WARN, null, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_warn3Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_warn3Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.WARN, null, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_warnM_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn(marker, "Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_warnM_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn(marker, "Message format");

        logger.validateLogCall(Level.WARN, marker, "Message format", new Object[0]);
    }

    @Test
    public void test_warnM1Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn(marker, "Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_warnM1Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn(marker, "Message format {}", arg1);

        logger.validateLogCall(Level.WARN, marker, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_warnM2Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn(marker, "Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_warnM2Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn(marker, "Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.WARN, marker, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_warnM3Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_warnM3Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.WARN, marker, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_warn_throwable_noLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn("Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_warn_throwable_withLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn("Message format", arg1);

        logger.validateLogCall(Level.WARN, marker, "Message format", new Object[]{arg1});
    }

    @Test
    public void test_warnM_throwable_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.warn(marker, "Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_warnM_throwable_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.warn(marker, "Message format", arg1);

        logger.validateLogCall(Level.WARN, marker, "Message format", new Object[]{arg1});
    }


    // error
    @Test
    public void test_isErrorEnabled_noParams() {
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.ERROR)).thenReturn(true);
        when(logger.isErrorEnabled()).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isErrorEnabled());

        verify(logger, times(1)).isErrorEnabled();
        verify(logger, times(1)).isEnabled(Level.ERROR);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_isErrorEnabled_withParams() {
        Marker marker = mock(Marker.class);
        BaseLogger logger = mock(BaseLogger.class);
        when(logger.isEnabled(Level.ERROR, marker)).thenReturn(true);
        when(logger.isErrorEnabled(any(Marker.class))).thenCallRealMethod();

        assertTrue("IsEnabled should return true", logger.isErrorEnabled(marker));

        verify(logger, times(1)).isErrorEnabled(marker);
        verify(logger, times(1)).isEnabled(Level.ERROR, marker);
        verifyNoMoreInteractions(logger);
    }

    @Test
    public void test_error_noLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error("Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_error_withLog() {
        Marker marker = null;
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error("Message format");

        logger.validateLogCall(Level.ERROR, null, "Message format", new Object[0]);
    }

    @Test
    public void test_error1Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error("Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_error1Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error("Message format {}", arg1);

        logger.validateLogCall(Level.ERROR, null, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_error2Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error("Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_error2Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error("Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.ERROR, null, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_error3Arg_noLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_error3Arg_withLog() {
        Marker marker = null;
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error("Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.ERROR, null, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_errorM_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error(marker, "Message format");

        logger.validateNoCall();
    }

    @Test
    public void test_errorM_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error(marker, "Message format");

        logger.validateLogCall(Level.ERROR, marker, "Message format", new Object[0]);
    }

    @Test
    public void test_errorM1Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error(marker, "Message format {}", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_errorM1Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error(marker, "Message format {}", arg1);

        logger.validateLogCall(Level.ERROR, marker, "Message format {}", new Object[]{arg1});
    }

    @Test
    public void test_errorM2Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error(marker, "Message format {}, {}", arg1, arg2);

        logger.validateNoCall();
    }

    @Test
    public void test_errorM2Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error(marker, "Message format {}, {}", arg1, arg2);

        logger.validateLogCall(Level.ERROR, marker, "Message format {}, {}", new Object[]{arg1, arg2});
    }

    @Test
    public void test_errorM3Arg_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateNoCall();
    }

    @Test
    public void test_errorM3Arg_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Object arg1 = "arg1";
        Object arg2 = "arg2";
        Object arg3 = "arg3";
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error(marker, "Message format {}, {} and {}", arg1, arg2, arg3);

        logger.validateLogCall(Level.ERROR, marker, "Message format {}, {} and {}", new Object[]{arg1, arg2, arg3});
    }

    @Test
    public void test_error_throwable_noLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error("Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_error_throwable_withLog() {
        Marker marker = null;
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error("Message format", arg1);

        logger.validateLogCall(Level.ERROR, marker, "Message format", new Object[]{arg1});
    }

    @Test
    public void test_errorM_throwable_noLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", false, marker);

        logger.error(marker, "Message format", arg1);

        logger.validateNoCall();
    }

    @Test
    public void test_errorM_throwable_withLog() {
        Marker marker = MarkerFactory.getMarker("marker");
        Throwable arg1 = new Exception("4 testing");
        BaseLoggerMock logger = new BaseLoggerMock("test", true, marker);

        logger.error(marker, "Message format", arg1);

        logger.validateLogCall(Level.ERROR, marker, "Message format", new Object[]{arg1});
    }


    /**
     * Inner class used for mock a {@link BaseLogger}.
     */
    private static class BaseLoggerMock extends BaseLogger {

        private final boolean enabled;
        private final Marker marker;

        private Level logLevel = null;
        private String logFormat = null;
        private Object[] logArguments = null;
        private Marker logMarker = null;

        public BaseLoggerMock(final String name, final boolean enabled, final Marker marker) {
            super(name);
            this.enabled = enabled;
            this.marker = marker;
        }

        @Override
        protected boolean isEnabled(Level level) {
            if (this.marker != null) {
                throw new IllegalStateException("this method should not be called");
            }
            return enabled;
        }

        @Override
        protected boolean isEnabled(Level level, Marker marker) {
            if (this.marker == null) {
                throw new IllegalStateException("this method should not be called");
            }
            if (this.marker != marker) {
                throw new IllegalArgumentException("different marker was provided");
            }
            return enabled;
        }

        @Override
        protected void doLog(Level level, String format, Object[] arguments) {
            if (logLevel != null) {
                throw new IllegalStateException("Method called twice");
            }
            this.logLevel = level;
            this.logFormat = format;
            this.logArguments = arguments;
        }

        @Override
        protected void doLog(Level level, Marker marker, String format, Object[] arguments) {
            if (logLevel != null) {
                throw new IllegalStateException("Method called twice");
            }
            this.logLevel = level;
            this.logMarker = marker;
            this.logFormat = format;
            this.logArguments = arguments;
        }

        public void validateLogCall(Level level, Marker marker, String format, Object... arguments) {
            assertEquals("Log level issues", level, logLevel);
            assertEquals("Marker issues", marker, logMarker);
            assertEquals("Format issues", format, logFormat);
            assertEquals("Arguments size issue", arguments.length, logArguments.length);
            for (int i = 0; i < arguments.length; i++) {
                assertEquals("argument[" + i + "] issue", logArguments[i], arguments[i]);
            }
        }

        public void validateNoCall() {
            if (logLevel != null) {
                fail("Log was called with level = " + logLevel + ", marker = " + marker + ", format = " + logFormat);
            }
        }
    }
}
