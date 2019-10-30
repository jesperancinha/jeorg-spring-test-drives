package com.steelzack.b2b2java8.fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.log4j.Logger;

/**
 * Created by jesperancinha on 11-5-16.
 */
class FileAccess {
    private static final Logger logger = Logger.getLogger(FileAccess.class);

    boolean checkIfLastAccessChangesForVariable(String filePath) throws IOException, InterruptedException {
        final long firstTimeStamp = fileInfo(filePath);
        final File file = new File(filePath);
        logger.info(firstTimeStamp);
        Thread.sleep(1000);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                logger.info(line);
            }
            long nextTimeStamp = fileInfo(file.getAbsolutePath());
            logger.info(nextTimeStamp);
            return firstTimeStamp != nextTimeStamp;
        }
    }

    private long fileInfo(String path) throws IOException {
        final Path file = Paths.get(path);
        final BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
        return attrs.lastAccessTime().toMillis();
    }
}
