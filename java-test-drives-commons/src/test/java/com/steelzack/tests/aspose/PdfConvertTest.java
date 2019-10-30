package com.steelzack.tests.aspose;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

/**
 * Created by joaofilipesabinoesperancinha on 21-05-16.
 */
public class PdfConvertTest {
    @Test
    public void convertPdfToDocx() throws Exception {

        final InputStream inputFile = getClass().getResourceAsStream("/input.pdf");

        final File result = PdfConvert.convertPdfToDocx(inputFile, "/tmp/output.docx");

        assertTrue(result.exists());

    }

}