package launch;

import java.io.*;
import java.util.List;

import controlador.Controlador;
import diagnosticos.Diagnostico;
import elem.Ciclo;
import reader.Reader;

public class Launcher {

    public static void main(String[] args) {
        // Directorios por defecto
        String inputDir = "entrada"; 
        String outputDir = "salida";

        // Procesar argumentos
        if (args.length >= 1) {
            inputDir = args[0];
        }
        if (args.length >= 2) {
            outputDir = args[1];
        }

        // Crear directorio de salida si no existe
        File outDir = new File(outputDir);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        // Archivo de salida general
        File globalOutput = new File(outDir, "todo.salida.txt");

        try (BufferedWriter globalWriter = new BufferedWriter(new FileWriter(globalOutput))) {

            // Listar archivos del directorio de entrada
            File dir = new File(inputDir);
            File[] files = dir.listFiles(File::isFile);

            if (files == null || files.length == 0) {
                System.out.println("No se encontraron archivos en el directorio de entrada: " + inputDir);
                return;
            }

            // Procesar cada archivo
            for (File file : files) {
                
                List<Ciclo> lista = Reader.INSTANCIA.leerFichero(file.getAbsolutePath());
                List<Diagnostico> diagnosticos = Controlador.INSTANCE.generarDiagnostico(lista);

                // Crear fichero de salida individual
                File outFile = new File(outDir, file.getName().replace(".txt", ".salida.txt"));
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {

                    if (diagnosticos.isEmpty()) {
                        writer.write("El paciente no tiene ning�n diagn�stico.\n");
                        globalWriter.write(file.getName() + ": sin diagn�sticos.\n");
                    } else {
                        writer.write("Diagn�sticos del paciente:\n");
                        for (Diagnostico d : diagnosticos) {
                            writer.write("- " + d.getTipo() + "\n");
                            globalWriter.write(file.getName() + ": " + d.getTipo() + "\n");
                        }
                    }

                    writer.flush();
                    globalWriter.flush(); // tambi�n escribir al archivo global al mismo tiempo
                }
            }

            System.out.println("Procesamiento completado. Resultados en: " + outputDir);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n===== CONTENIDO DE todo.salida.txt =====");
        try (BufferedReader reader = new BufferedReader(new FileReader(globalOutput))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo 'todo.salida.txt': " + e.getMessage());
        }
    }
}

