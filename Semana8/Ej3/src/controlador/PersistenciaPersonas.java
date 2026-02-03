package controlador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

public class PersistenciaPersonas {

    public static List<Persona> cargarDatos(String nombreArchivo) {
        List<Persona> lista = new ArrayList<>();
        
        // Ruta a Semana8 de Icloud Drive
        String userHome = System.getProperty("user.home");
        Path ruta = Paths.get(userHome,
                "Library", "Mobile Documents", "com~apple~CloudDocs",
                "4to carrera",
                "Programación III",
                "Práctica",
                "Semana8",
                nombreArchivo);      // "datos.txt"

        System.out.println("Buscando fichero en: " + ruta.toAbsolutePath());

        // LECTURA DEL FICHERO
        if (Files.exists(ruta)) {
            try {
                // Leemos usando UTF-8 para evitar problemas con tildes
                List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);

                for (String linea : lineas) {
                    // Saltamos líneas vacías
                    if (linea.trim().isEmpty()) continue;
                    String[] partes = linea.split("\t");
                    
                    if (partes.length >= 3) {
                        try {
                            String nombre = partes[0].trim();
                            String telefono = partes[1].trim();
                            // El peso es un entero (int)
                            int peso = Integer.parseInt(partes[2].trim());

                            lista.add(new Persona(nombre, telefono, peso));

                        } catch (NumberFormatException e) {
                            System.out.println("Error al leer número en línea: " + linea);
                        }
                    }
                }
                System.out.println("Cargadas " + lista.size() + " personas correctamente.");

            } catch (IOException e) {
                System.out.println("Error de lectura (IO): " + e.getMessage());
            }
        } else {
            System.out.println("NO SE ENCUENTRA EL FICHERO en:");
            System.out.println(ruta.toString());
            System.out.println("Asegúrate de que 'datos.txt' está en la carpeta Semana8.");
        }

        return lista;
    }
}