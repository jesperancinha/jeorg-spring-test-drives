package com.steelzack.tests.logs;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class LoggerInfoTest {
    private final OutputStream logCapturingStream = new ByteArrayOutputStream();
    private final StreamHandler customLogHandler;
    private String logString;
    private boolean flushed = false;

    public LoggerInfoTest(Class... classes) {
        customLogHandler = new StreamHandler(logCapturingStream, Logger.getLogger(classes[0].getName()).getParent().getHandlers()[0].getFormatter());
        for (Class classje : classes) {
            Logger.getLogger(classje.getName()).addHandler(customLogHandler);
        }
    }

    private void flushLogs() {
        if (!flushed) {
            customLogHandler.flush();
            this.flushed = true;
            this.logString = logCapturingStream.toString();
        }
    }

    protected void assertLogOrder(String... testLogStrings) {
        flushLogs();

        String currentSegment= logString.replace("\n", "");
        boolean started = false;
        for (String testLogString : testLogStrings) {
            if(started) {
                assertThat(currentSegment, containsString(testLogString));
            }
            if(currentSegment.endsWith(testLogString))
            {
                break;
            }
            currentSegment = currentSegment.split(testLogString)[1];
            started = true;
        }
    }

    protected void assertNotLogged(String ... testLogStrings){
        flushLogs();

        for(String testLogString : testLogStrings) {
            assertThat(this.logString, not(containsString(testLogString)));
        }
    }
}
