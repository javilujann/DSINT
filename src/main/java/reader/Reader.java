package reader;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import componentes.*;  // Para acceder a Onda, OndaTipo, Ciclo, etc.
import elem.Ciclo;

public class Reader {

    // Regex: tipo (P,Q,R,S,T), start, end, peak (con signo y decimal opcional)
    private static final Pattern PATRON_ONDA =
            Pattern.compile("([PQRST])\\((\\d+),(\\d+),(-?\\d*\\.?\\d+)\\)");

    public static List<Ciclo> leerFichero(String ruta) throws IOException {
    	int cont = 0;
        List<Ciclo> ciclos = new ArrayList<>();
        Ciclo cicloActual = new Ciclo(cont);

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
                    OndaTipo tipo = OndaTipo.valueOf(matcher.group(1)); // usa enum
                    float start = Float.parseFloat(matcher.group(2));
                    float end = Float.parseFloat(matcher.group(3));
                    float peak = Float.parseFloat(matcher.group(4));

                    // Crear la onda
                    Onda onda = new Onda(peak, start, end, tipo);
                    cicloActual.getOndas().add(onda);

                    // Si llega una onda T, se cierra el ciclo
                    if (tipo == OndaTipo.T) {
                    	cont ++;
                        ciclos.add(cicloActual);
                        cicloActual = new Ciclo(cont);
                    }
                }
            }

            // Si queda un ciclo incompleto, se añade igualmente
            if (!cicloActual.getOndas().isEmpty()) {
                ciclos.add(cicloActual);
            }
        }

        return ciclos;
    }
    
    // Método para probar que funciona el Lector
    public static void main(String[] args) {
        // Asegurar que la consola use UTF-8
        System.setProperty("file.encoding", "UTF-8");

        String ruta = "bradicardia2.ecg"; // Cambia por tu ruta si es necesario
        System.out.println("Leyendo archivo: " + ruta);
        System.out.println("Directorio actual: " + new java.io.File(".").getAbsolutePath());

        try {
            List<Ciclo> ciclos = Reader.leerFichero(ruta);

            System.out.println();
            System.out.println("Ciclos leidos: " + ciclos.size());
            System.out.println("--------------------------------------------");

            for (int i = 0; i < ciclos.size(); i++) {
                Ciclo ciclo = ciclos.get(i);
                System.out.println("Ciclo " + ciclo.getNciclo() + ": contiene " + ciclo.getOndas().size() + " ondas");

                for (Componente comp : ciclo.getOndas()) {
                    if (comp instanceof Onda) {
                        Onda o = (Onda) comp;
                        System.out.printf("   %s -> start=%.0f, end=%.0f, peak=%.16f%n",
                                o.getTipo(), o.getInicio(), o.getFin(), o.getAmplitud());
                    }
                }

                System.out.println("--------------------------------------------");
            }

        } catch (FileNotFoundException e) {
            System.err.println("No se encontro el archivo: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}


