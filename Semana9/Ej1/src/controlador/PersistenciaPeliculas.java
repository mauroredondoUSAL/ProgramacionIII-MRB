package controlador;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Importaciones GSON y JACKSON (se mantienen igual)
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import modelo.Pelicula;

public class PersistenciaPeliculas {

    // --- CSV  ---

    public static void exportarCSV(List<Pelicula> lista, String nombreArchivo) {
        if (!nombreArchivo.endsWith(".csv")) nombreArchivo += ".csv";
        Path ruta = Paths.get(nombreArchivo);
        List<String> lineas = new ArrayList<>();

        // Cabecera
        lineas.add("Titulo;Director;Anio;Duracion;Descripcion");

        for (Pelicula p : lista) {
            // Reemplazamos ; por , en la descripción para no romper el CSV
            String descSegura = p.getDescripcion().replace(";", ",");
            String linea = String.format("%s;%s;%d;%d;%s",
                    p.getTitulo(), p.getDirector(), p.getAnio(), p.getDuracionMinutos(), descSegura);
            lineas.add(linea);
        }

        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            System.out.println("Exportado a CSV: " + ruta.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error exportando CSV: " + e.getMessage());
        }
    }

    public static List<Pelicula> importarCSV(String nombreArchivo) {
        if (!nombreArchivo.endsWith(".csv")) nombreArchivo += ".csv";
        Path ruta = Paths.get(nombreArchivo);
        List<Pelicula> lista = new ArrayList<>();

        if (!Files.exists(ruta)) return lista;

        try {
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            boolean esCabecera = true;

            for (String linea : lineas) {
                if (esCabecera) { esCabecera = false; continue; } // Saltar primera línea
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(";");
                if (partes.length >= 5) {
                    try {
                        Pelicula p = new Pelicula(
                            partes[0], // Título
                            partes[1], // Director
                            Integer.parseInt(partes[2]), // Año
                            Integer.parseInt(partes[3]), // Duración
                            partes[4]  // Descripción
                        );
                        lista.add(p);
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato en línea CSV: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error importando CSV: " + e.getMessage());
        }
        return lista;
    }

    // --- JSON ---

    public static void exportarJSON(List<Pelicula> lista, String nombreArchivo) {
        if (!nombreArchivo.endsWith(".json")) nombreArchivo += ".json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            String jsonTexto = gson.toJson(lista);
            Files.write(Paths.get(nombreArchivo), jsonTexto.getBytes(StandardCharsets.UTF_8));
            System.out.println("Exportado a JSON.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static List<Pelicula> importarJSON(String nombreArchivo) {
        if (!nombreArchivo.endsWith(".json")) nombreArchivo += ".json";
        Path ruta = Paths.get(nombreArchivo);
        if (!Files.exists(ruta)) return new ArrayList<>();

        Gson gson = new Gson();
        try {
            byte[] bytes = Files.readAllBytes(ruta);
            String json = new String(bytes, StandardCharsets.UTF_8);
            return gson.fromJson(json, new TypeToken<List<Pelicula>>(){}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // --- XML ---

    public static void exportarXML(List<Pelicula> lista, String nombreArchivo) {
        if (!nombreArchivo.endsWith(".xml")) nombreArchivo += ".xml";
        XmlMapper mapper = new XmlMapper();
        try {
            mapper.writeValue(new File(nombreArchivo), lista);
            System.out.println("Exportado a XML.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static List<Pelicula> importarXML(String nombreArchivo) {
        if (!nombreArchivo.endsWith(".xml")) nombreArchivo += ".xml";
        File file = new File(nombreArchivo);
        if (!file.exists()) return new ArrayList<>();
        
        XmlMapper mapper = new XmlMapper();
        try {
            return mapper.readValue(file, new TypeReference<List<Pelicula>>(){});
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}