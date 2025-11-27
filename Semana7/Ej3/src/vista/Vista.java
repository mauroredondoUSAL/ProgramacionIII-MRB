package vista;

import controlador.Controlador;
import com.coti.tools.Esdia;

import modelo.Pelicula;
import modelo.Director;

public class Vista {

    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        System.out.println("|---------------------------------------------|");
        System.out.println("|                 MI VIDEOTECA                |");
        System.out.println("|---------------------------------------------|");
        System.out.println("| 1) Nueva videoteca de películas             |");
        System.out.println("| 2) Configurar velocidad de reproducción     |");
        System.out.println("| 3) Añadir película                          |");
        System.out.println("| 4) Mostrar información                      |");
        System.out.println("| 5) Editar película                          |");
        System.out.println("| 6) Eliminar película                        |");
        System.out.println("| 7) Salir                                    |");
        System.out.println("|---------------------------------------------|");
    }

    public int pedirOpcionMenu() {
        return Esdia.readInt("Seleccione una opción: ", 1, 7);
    }


    // ---- OPCIÓN 1 ----
    public void crearNuevaVideoteca() {
        controlador.crearVideoteca();
        System.out.println("Nueva videoteca creada.");
    }

    // ---- OPCIÓN 2 ----
    public void configurarVelocidad() {
        if (!controlador.estaInicializada()) {
            System.out.println("Primero debes crear una videoteca.");
            return;
        }

        double speed = Esdia.readDouble("Nueva velocidad (0.1 - 5): ", 0.1, 5.0);
        controlador.setVelocidad(speed);

        System.out.printf("Velocidad establecida a %.2fx%n", speed);
    }

    // ---- OPCIÓN 3 ----
    public void anadirPelicula() {
        if (!controlador.estaInicializada()) {
            System.out.println("Primero debes crear una videoteca.");
            return;
        }

        System.out.println("Añadiendo nueva película...");

        String titulo = Esdia.readString_ne("Título: ");
        String nombre = Esdia.readString_ne("Nombre del director: ");
        String apellidos = Esdia.readString_ne("Apellidos del director: ");
        boolean oscar = Esdia.siOno("¿Ha ganado un Oscar? (s/n): ");

        Director d = new Director(nombre, apellidos, oscar);

        int dur = Esdia.readInt("Duración (min): ", 1, 1000);
        int ano = Esdia.readInt("Año (1900-2100): ", 1900, 2100);
        double val = Esdia.readDouble("Valoración (0-10): ", 0, 10);

        Pelicula p = new Pelicula(d, titulo, ano, dur, val);

        controlador.anadirPelicula(p);

        System.out.println("Película añadida correctamente.");
    }

    // ---- OPCIÓN 4 ----
    public void mostrarInformacion() {
        controlador.mostrarPeliculas();
    }

    // ---- OPCIÓN 5 ----
    public void editarPelicula() {
        if (!controlador.hayPeliculas()) {
            System.out.println("No hay películas que editar.");
            return;
        }

        controlador.mostrarPeliculas();

        int index = Esdia.readInt("Número de la película: ",
                                0, controlador.numPeliculas()-1);

        controlador.editarPelicula(index);
    }

    // ---- OPCIÓN 6 ----
    public void eliminarPelicula() {
        if (!controlador.hayPeliculas()) {
            System.out.println("No hay películas que eliminar.");
            return;
        }

        controlador.mostrarPeliculas();
        int index = Esdia.readInt("Número de la película: ",
                                0, controlador.numPeliculas() - 1);

        if (controlador.eliminarPelicula(index))
            System.out.println("Película eliminada.");
        else
            System.out.println("No se pudo eliminar.");
    }

    // ---- OPCIÓN 7 ----
    public boolean confirmarSalir() {
        return Esdia.siOno("¿Seguro que deseas salir? (s/n): ");
    }
}
