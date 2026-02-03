package vista;

import com.coti.tools.Esdia;
import controlador.ControladorAlumnos;
import java.util.List;
import modelo.DatosDeAlumno;

public class VistaAlumnos {

    private ControladorAlumnos controlador;

    public void setControlador(ControladorAlumnos controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        boolean salir = false;
        do {
            System.out.println("\n--- GESTIÓN DE CLASE (20 ALUMNOS) ---");
            System.out.println("1. Volver a crear la lista (aleatoria)");
            System.out.println("2. Mostrar tabla de alumnos");
            System.out.println("3. Exportar datos personales (CSV)");
            System.out.println("4. Exportar direcciones (CSV)");
            System.out.println("q. Salir");

            String opcion = Esdia.readString("Elige una opción: ");

            switch (opcion.toLowerCase()) {
                case "1":
                    controlador.regenerarLista();
                    System.out.println("Lista regenerada con nuevos alumnos aleatorios.");
                    break;
                case "2":
                    mostrarTablaCompleta();
                    break;
                case "3":
                    exportarPersonales();
                    break;
                case "4":
                    exportarDirecciones();
                    break;
                case "q":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);
        System.out.println("Adiós.");
    }

    // Opción 2: Mostrar TODO
    private void mostrarTablaCompleta() {
        List<DatosDeAlumno> lista = controlador.getListaAlumnos();
        
        System.out.println("-".repeat(110));
        // Cabecera ancha para que quepa todo
        System.out.printf("| %-20s | %-12s | %-3s | %-50s |%n",
                "NOMBRE", "NIF", "EDAD", "DIRECCIÓN COMPLETA");
        System.out.println("-".repeat(110));

        for (DatosDeAlumno a : lista) {
            System.out.printf("| %-20s | %-12s | %3d | %-50s |%n",
                    a.getDatos().getNombre() + " " + a.getDatos().getApellidos(), // Juntamos nombre y apellidos
                    a.getDatos().getNif(),
                    a.getDatos().getEdad(),
                    a.getDireccion().toString()); // Usamos el toString de dirección
        }
        System.out.println("-".repeat(110));
    }

    private void exportarPersonales() {
        String nombre = Esdia.readString("Nombre del archivo para Datos Personales: ");
        if (controlador.exportarPersonales(nombre)) {
            System.out.println("Exportado correctamente.");
        } else {
            System.out.println("Error al exportar.");
        }
    }

    private void exportarDirecciones() {
        String nombre = Esdia.readString("Nombre del archivo para Direcciones: ");
        if (controlador.exportarDirecciones(nombre)) {
            System.out.println("Exportado correctamente.");
        } else {
            System.out.println("Error al exportar.");
        }
    }
}