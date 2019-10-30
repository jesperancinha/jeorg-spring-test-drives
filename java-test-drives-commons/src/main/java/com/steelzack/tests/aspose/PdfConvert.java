package com.steelzack.tests.aspose;

/**
 * Created by joaofilipesabinoesperancinha on 21-05-16.
 */

import com.aspose.pdf.DocSaveOptions;

import java.io.File;
import java.io.InputStream;

public class PdfConvert {

    public static File convertPdfToDocx(InputStream inputFile, String outputFileName) throws Exception {
        com.aspose.pdf.Document doc = new com.aspose.pdf.Document(inputFile);
        DocSaveOptions saveOptions = new DocSaveOptions();
        saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
        doc.save(outputFileName, saveOptions);
        return new File(outputFileName);

    }
}
