package controlador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import modelo.DatosDeAlumno;

public class PersistenciaAlumnos {

    // Opción 3: Exportar Datos Personales
    public static boolean guardarDatosPersonalesCSV(List<DatosDeAlumno> alumnos, String nombreArchivo) {
        if (!nombreArchivo.endsWith(".csv")) nombreArchivo += ".csv";
        Path ruta = Paths.get(nombreArchivo); // Se guarda en raíz del proyecto
        
        List<String> lineas = new ArrayList<>();
        // Cabecera
        lineas.add("Nombre;Apellidos;Edad;NIF");

        for (DatosDeAlumno alumno : alumnos) {
            // Llamamos al método toCSV() de la clase DatosPersonales
            lineas.add(alumno.getDatos().toCSV());
        }

        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            System.err.println("Error guardando personales: " + e.getMessage());
            return false;
        }
    }

    // Opción 4: Exportar Direcciones
    public static boolean guardarDireccionesCSV(List<DatosDeAlumno> alumnos, String nombreArchivo) {
        if (!nombreArchivo.endsWith(".csv")) nombreArchivo += ".csv";
        Path ruta = Paths.get(nombreArchivo);
        
        List<String> lineas = new ArrayList<>();
        // Cabecera
        lineas.add("Calle;Numero;Piso;Letra");

        for (DatosDeAlumno alumno : alumnos) {
            // Llamamos al método toCSV() de la clase Direccion
            lineas.add(alumno.getDireccion().toCSV());
        }

        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            System.err.println("Error guardando direcciones: " + e.getMessage());
            return false;
        }
    }
}