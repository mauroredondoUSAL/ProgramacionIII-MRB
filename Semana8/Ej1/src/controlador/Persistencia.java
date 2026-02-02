package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Partido;

public class Persistencia {

    public static List<Partido> cargarPartidosDesdeFichero() {
        List<Partido> partidos = new ArrayList<>();
        
        // 1. Ruta base del usuario (/Users/TuUsuario)
        String userHome = System.getProperty("user.home");
        
        // 2. Ruta base de iCloud Drive (Oculta en Library)
        String rutaICloud = userHome + File.separator + "Library" + File.separator +
                            "Mobile Documents" + File.separator + "com~apple~CloudDocs";

        // 3. Ruta específica de las carpetas
        String rutaCompleta = rutaICloud + File.separator +
                            "4to carrera" + File.separator +
                            "Programación III" + File.separator +
                            "Práctica" + File.separator +
                            "Semana8" + File.separator +
                            "equipos.txt";

        File fichero = new File(rutaCompleta);

        // Imprimimos la ruta para estar seguros
        System.out.println("Intentando leer fichero en: " + fichero.getAbsolutePath());

        if (fichero.exists()) {
            try (Scanner lector = new Scanner(fichero)) {
                
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    
                    // Saltamos líneas vacías si las hubiera
                    if (linea.trim().isEmpty()) continue;

                    // Separamos por el guion: "Local-Visitante"
                    String[] equipos = linea.split("-");
                    
                    if (equipos.length == 2) {
                        // Creamos el partido y lo añadimos a la lista
                        // Usamos trim() por si hay espacios extra alrededor de los nombres
                        partidos.add(new Partido(equipos[0].trim(), equipos[1].trim()));
                    }
                }
                System.out.println("¡Partidos cargados correctamente!");

            } catch (FileNotFoundException e) {
                System.out.println("Error: No se puede abrir el archivo. " + e.getMessage());
            }
        } else {
            System.out.println("ERROR: El fichero sigue sin aparecer.");
        }

        return partidos;
    }
}