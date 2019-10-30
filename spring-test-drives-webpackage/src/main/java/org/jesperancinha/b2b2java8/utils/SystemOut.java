package org.jesperancinha.b2b2java8.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

/**
 * Created by joaofilipesabinoesperancinha on 10-05-16.
 */
public class SystemOut {

    public ByteArrayOutputStream testSystemOut() {
        final StringWriter stringWriter = new StringWriter();
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        return byteArrayOutputStream;
    }
}
