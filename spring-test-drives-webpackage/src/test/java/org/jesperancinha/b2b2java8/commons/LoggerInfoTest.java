package org.jesperancinha.b2b2java8.commons;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import static org.assertj.core.api.Assertions.assertThat;

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

        String currentSegment = logString.replace("\n", "");
        boolean started = false;
        for (String testLogString : testLogStrings) {
            if (started) {
                assertThat(currentSegment).contains(testLogString);
            }
            if (currentSegment.endsWith(testLogString)) {
                break;
            }
            String[] splitSegment = currentSegment.split(testLogString);
            if (splitSegment.length == 2) {
                currentSegment = splitSegment[1];
            } else {
                currentSegment = splitSegment[0];
            }
            started = true;
        }
    }

    protected void assertNotLogged(String... testLogStrings) {
        flushLogs();

        for (String testLogString : testLogStrings) {
            assertThat(this.logString).doesNotContain(testLogString);
        }
    }
}
