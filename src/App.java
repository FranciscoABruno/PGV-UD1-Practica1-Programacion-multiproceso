import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.salesianos.utils.ProcessLauncher;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la palabra que desea buscar:");
        String wordToFind = scanner.nextLine();
        String inputFile = "./input/contenido.txt";
        String outputFile = "output\\contenido_modificado.txt";

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Process> processes = new ArrayList<>();
        for (String currentLine : lines) {
            try {
                Process process = ProcessLauncher.initLineProcessor(currentLine, wordToFind, outputFile);
                processes.add(process);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Process process : processes) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Proceso completado. Verifica el archivo: ./output/" + outputFile);
        scanner.close();
    }
}