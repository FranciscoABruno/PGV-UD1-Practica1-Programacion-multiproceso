package net.salesianos.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LineProcessor {
    public static void main(String[] args) {

        String line = args[0];
        String wordToFind = args[1];
        String outputFileName = args[2];

        try {
            processLine(line, wordToFind, outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processLine(String line, String wordToFind, String outputFileName) throws IOException {
        if (line.contains(wordToFind)) {
            String modifiedLine = line.replaceAll(wordToFind, wordToFind.toUpperCase());
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(outputFileName, StandardCharsets.UTF_8, true))) {

                writer.write(modifiedLine);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La palabra no se encontró en la línea.");
        }
    }
}