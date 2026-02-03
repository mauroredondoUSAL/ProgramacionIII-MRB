package vista;

import com.coti.tools.Esdia;
import controlador.ControladorPersonas;
import java.util.List;
import modelo.Persona;

public class VistaPersonas {

    private ControladorPersonas controlador;

    public void setControlador(ControladorPersonas controlador){
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        boolean salir = false;
        do {
            System.out.println("\n--- GESTIÓN DE PERSONAS ---");
            System.out.println("1. Importar datos (fichero TSV)");
            System.out.println("2. Mostrar tabla de personas");
            System.out.println("q. Salir");

            String opcion = Esdia.readString("Elige una opción: ");

            switch (opcion.toLowerCase()) {
                case "1":
                    importar();
                    break;
                case "2":
                    mostrarTabla();
                    break;
                case "q":
                    // Confirmar salida
                    String confirmacion = Esdia.readString("¿Seguro que quieres salir? (s/n): ");
                    if (confirmacion.equalsIgnoreCase("s")) {
                        salir = true;
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);
        System.out.println("Fin del programa.");
    }

    // --- MÉTODOS PRIVADOS ---

    private void importar() {
        String nombre = Esdia.readString("Introduce el nombre del fichero (ej: otros_datos.txt): ");
        controlador.importarDatos(nombre);
    }

    private void mostrarTabla() {
        List<Persona> lista = controlador.getPersonas();

        if (lista.isEmpty()) {
            System.out.println("No hay personas en la lista.");
            return;
        }

        // Usamos los métodos estáticos que creamos en la clase Persona (Requisito PDF)
        System.out.println("-".repeat(50));
        System.out.println(Persona.getCabeceraFormateada());
        System.out.println("-".repeat(50));

        for (Persona p : lista) {
            System.out.println(p.getFilaFormateada());
        }
        System.out.println("-".repeat(50));
    }
}