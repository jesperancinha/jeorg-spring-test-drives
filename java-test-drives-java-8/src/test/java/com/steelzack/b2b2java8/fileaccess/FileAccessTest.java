package com.steelzack.b2b2java8.fileaccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jesperancinha on 11-5-16.
 */
public class FileAccessTest {

    private static final String TEST_FILE_ACCESS_TXT = "/testFileAccess.txt";
    private static final String TEST_ABSOLUTE_PATH_FILE_ACCESS = "/tmp" + TEST_FILE_ACCESS_TXT;

    @Before
    public void setUp() throws IOException {
        final InputStream inputStream = getClass().getResourceAsStream(TEST_FILE_ACCESS_TXT);
        final OutputStream outputStream = new FileOutputStream(TEST_ABSOLUTE_PATH_FILE_ACCESS);

        try (final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
             final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String test;
            while ((test = bufferedReader.readLine()) != null) {
                bufferedWriter.write(test);
            }
        }

        final File f = new File(TEST_ABSOLUTE_PATH_FILE_ACCESS);
        f.deleteOnExit();
    }

    @Test
    public void readFile_JustRun() throws Exception {
        final FileAccess fileAccess = new FileAccess();

        fileAccess.checkIfLastAccessChangesForVariable(TEST_ABSOLUTE_PATH_FILE_ACCESS);
    }
}
