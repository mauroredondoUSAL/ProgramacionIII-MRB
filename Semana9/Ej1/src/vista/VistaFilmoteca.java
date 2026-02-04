package vista;

import com.coti.tools.Esdia;
import controlador.ControladorFilmoteca;
import java.util.List;
import modelo.Pelicula;

public class VistaFilmoteca {

    private ControladorFilmoteca controlador;

    public void setControlador(ControladorFilmoteca controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        boolean salir = false;
        do {
            System.out.println("\n--- 🎬 FILMOTECA PRO (JSON / XML / CSV) ---");
            System.out.println("1. Nueva película");
            System.out.println("2. Ver listado");
            System.out.println("3. Modificar película");
            System.out.println("4. Eliminar película");
            System.out.println("-------------------------");
            System.out.println("5. Exportar (JSON, XML, CSV)");
            System.out.println("6. Importar (JSON, XML, CSV)");
            System.out.println("q. Salir");

            String opcion = Esdia.readString("Elige una opción: ");

            switch (opcion.toLowerCase()) {
                case "1": pedirDatosPelicula(); break;
                case "2": mostrarListado(); break;
                case "3": modificarPelicula(); break;
                case "4": eliminarPelicula(); break;
                case "5": menuExportar(); break;
                case "6": menuImportar(); break;
                case "q": salir = true; break;
                default: System.out.println("Opción no válida.");
            }
        } while (!salir);
    }

    // --- SUBMENÚS DE EXPORTACIÓN/IMPORTACIÓN ---

    private void menuExportar() {
        String tipo = Esdia.readString("Formato (json, xml, csv): ").toLowerCase();
        String nombre = Esdia.readString("Nombre del archivo: ");
        
        switch (tipo) {
            case "json": controlador.exportarJSON(nombre); break;
            case "xml":  controlador.exportarXML(nombre); break;
            case "csv":  controlador.exportarCSV(nombre); break;
            default: System.out.println("Formato desconocido.");
        }
    }

    private void menuImportar() {
        String tipo = Esdia.readString("Formato (json, xml, csv): ").toLowerCase();
        String nombre = Esdia.readString("Nombre del archivo a leer: ");
        
        switch (tipo) {
            case "json": controlador.importarJSON(nombre); break;
            case "xml":  controlador.importarXML(nombre); break;
            case "csv":  controlador.importarCSV(nombre); break;
            default: System.out.println("Formato desconocido.");
        }
        System.out.println("🔄 Operación de importación terminada.");
    }

    // --- ACCIONES DE GESTIÓN ---

    private void mostrarListado() {
        List<Pelicula> lista = controlador.getPeliculas();
        if (lista.isEmpty()) {
            System.out.println("📭 Filmoteca vacía.");
            return;
        }
        System.out.println("\n" + "-".repeat(100));
        System.out.printf("| %-3s | %-20s | %-15s | %4s |%n", "ID", "TÍTULO", "DIRECTOR", "AÑO");
        System.out.println("-".repeat(100));
        
        for (int i = 0; i < lista.size(); i++) {
            Pelicula p = lista.get(i);
            // Mostramos el índice 'i' para que el usuario sepa cuál borrar/editar
            System.out.printf("| %-3d | %-20s | %-15s | %4d |%n", i, p.getTitulo(), p.getDirector(), p.getAnio());
        }
        System.out.println("-".repeat(100));
    }

    private void eliminarPelicula() {
        mostrarListado();
        if (controlador.getPeliculas().isEmpty()) return;

        int index = Esdia.readInt("Introduce el ID de la película a borrar: ");
        controlador.borrarPelicula(index);
        System.out.println("🗑️ Película eliminada.");
    }

    private void modificarPelicula() {
        mostrarListado();
        if (controlador.getPeliculas().isEmpty()) return;

        int index = Esdia.readInt("Introduce el ID de la película a modificar: ");
        
        if (index < 0 || index >= controlador.getPeliculas().size()) {
            System.out.println("ID incorrecto.");
            return;
        }

        System.out.println("--- Introduce los NUEVOS datos ---");
        String titulo = Esdia.readString("Título: ");
        String director = Esdia.readString("Director: ");
        int anio = Esdia.readInt("Año: ");
        int duracion = Esdia.readInt("Duración: ");
        String descripcion = Esdia.readString("Descripción: ");

        controlador.editarPelicula(index, titulo, director, anio, duracion, descripcion);
        System.out.println("✏️ Película modificada.");
    }

    private void pedirDatosPelicula() {
        String titulo = Esdia.readString("Título: ");
        String director = Esdia.readString("Director: ");
        int anio = Esdia.readInt("Año: ");
        int duracion = Esdia.readInt("Duración: ");
        String descripcion = Esdia.readString("Descripción: ");
        controlador.crearPelicula(titulo, director, anio, duracion, descripcion);
    }
}