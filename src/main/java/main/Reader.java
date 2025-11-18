package main;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import componentes.*;  // Para acceder a Onda, OndaTipo, Ciclo, etc.

public enum Reader {
	
	INSTANCIA;

    // Regex: tipo (P,Q,R,S,T), start, end, peak (con signo y decimal opcional)
    private final Pattern PATRON_ONDA =
            Pattern.compile("([PQRST])\\((\\d+),(\\d+),(-?\\d*\\.?\\d+)\\)");
    
    private int contador = 0;

    public List<Onda> leerFichero(String ruta) throws IOException {
        List<Onda> ondas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                // Ignorar líneas vacías o de cabecera
                if (linea.isEmpty() || linea.startsWith("#")) {
                    continue;
                }

                Matcher matcher = PATRON_ONDA.matcher(linea);
                if (matcher.matches()) {
                	
                	
                    // Extraer datos
                    float start = Float.parseFloat(matcher.group(2));
                    float end = Float.parseFloat(matcher.group(3));
                    float peak = Float.parseFloat(matcher.group(4));

                    // Crear la onda
                    Onda onda = null;
                    switch (contador % 5) {
                    	case 0: onda = new OndaP(peak, start, end); break;
                    	case 1: onda = new OndaQ(peak, start, end); break;
                    	case 2: onda = new OndaR(peak, start, end); break;
                    	case 3: onda = new OndaS(peak, start, end); break;
                    	case 4: onda = new OndaT(peak, start, end); break;
                    }
                    contador++;
                    
                    ondas.add(onda);
                }
            }
        }

        return ondas;
    }
    
    // Método para probar que funciona el Lector
    public static void main(String[] args) {
        // Asegurar que la consola use UTF-8
        System.setProperty("file.encoding", "UTF-8");

        String ruta = "./entrada/bradicardia2.ecg"; // Cambia por tu ruta si es necesario
        System.out.println("Leyendo archivo: " + ruta);
        System.out.println("Directorio actual: " + new java.io.File(".").getAbsolutePath());

        try {
            List<Onda> ondas = Reader.INSTANCIA.leerFichero(ruta);

            System.out.println();
            System.out.println("Ondas leidos: " + ondas.size());
            System.out.println("--------------------------------------------");

            for (int i = 0; i < ondas.size(); i++) {
            	Onda onda = ondas.get(i); 
                System.out.printf("   %s -> start=%.0f, end=%.0f, peak=%.16f%n",onda.getClass(), onda.getInicio(), onda.getFin(), onda.getAmplitud());
                }

                System.out.println("--------------------------------------------");

        } catch (FileNotFoundException e) {
            System.err.println("No se encontro el archivo: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}


