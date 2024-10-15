package net.salesianos.utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {

    public static Process initLineProcessor(String line, String wordToFind, String outputFileName) throws IOException {

        ProcessBuilder builder = new ProcessBuilder(
                "java",
                "./src/net/salesianos/utils/LineProcessor.java",
                line,
                wordToFind,
                outputFileName);

        builder.redirectOutput(new File("./output/ProcessOutput.txt"));
        builder.redirectError(new File("./output/LineProcessorErrors.txt"));

        return builder.start();
    }
}
