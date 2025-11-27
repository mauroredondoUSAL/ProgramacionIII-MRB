import static com.coti.tools.Esdia.*;

import modelo.Director;
import modelo.Pelicula;
import modelo.Videoteca;

public class App {

    private static Videoteca videoteca = new Videoteca();

    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            int opcion = readInt("Seleccione una opción: ", 1, 7);

            switch (opcion) {
                case 1:
                    opcionCrearNuevaVideoteca();
                    break;
                case 2:
                    opcionConfigurarVelocidad();
                    break;
                case 3:
                    opcionAnadirPelicula();
                    break;
                case 4:
                    opcionMostrarInformacion();
                    break;
                case 5:
                    opcionEditarPelicula();
                    break;
                case 6:
                    opcionEliminarPelicula();
                    break;
                case 7:{
                    opcionSalir();
                    salir = true;
                }
            }
        }

        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("|---------------------------------------------|");
        System.out.println("|                 MI VIDEOTECA                |");
        System.out.println("|---------------------------------------------|");
        System.out.println("| 1) Nueva videoteca de películas             |");
        System.out.println("| 2) Configurar velocidad de reproducción     |");
        System.out.println("| 3) Añadir una nueva película                |");
        System.out.println("| 4) Mostrar información actual de películas  |");
        System.out.println("| 5) Editar una película                      |");
        System.out.println("| 6) Eliminar una película                    |");
        System.out.println("| 7) Salir                                     |");
        System.out.println("|---------------------------------------------|");
    }

    // OPCIÓN 1
    private static void opcionCrearNuevaVideoteca() {
        System.out.println("Creando nueva videoteca...");
        videoteca.crearNuevaVideoteca(0);
    }

    // OPCIÓN 2
    private static void opcionConfigurarVelocidad() {
        if (!videoteca.estaInicializada()) {
            System.out.println("Primero debes crear una videoteca.");
            return;
        }

        double nuevaVelocidad = readDouble(
                "Introduce la nueva velocidad de reproducción (0.1–5.0): ",
                0.1, 5.0);

        videoteca.setVelocidad(nuevaVelocidad);
        System.out.printf("Velocidad establecida a %.2fx%n", videoteca.getVelocidad());
    }

    // OPCIÓN 3
    private static void opcionAnadirPelicula() {
        if (!videoteca.estaInicializada()) {
            System.out.println("Primero debes crear una videoteca.");
            return;
        }

        System.out.println("Añadiendo nueva película...");

        String titulo = readString_ne("Título: ");
        String nombre = readString_ne("Nombre del director: ");
        String apellidos = readString_ne("Apellidos del director: ");
        boolean oscar = siOno("¿Ha ganado un Oscar? (s/n): ");

        Director dir = new Director(nombre, apellidos, oscar);

        int duracionMin = readInt("Duración (min): ", 1, 1000);
        int ano = readInt("Año de estreno (1900-2100): ", 1900, 2100);
        double valoracion = readDouble("Valoración (0-10): ", 0.0, 10.0);

        Pelicula p = new Pelicula(dir, titulo, ano, duracionMin, valoracion);

        videoteca.anadirPelicula(p);

        System.out.println("Película añadida correctamente.");
    }

    // OPCIÓN 4
    private static void opcionMostrarInformacion() {
        if (!videoteca.estaInicializada()) {
            System.out.println("Primero debes crear una videoteca.");
            return;
        }
        videoteca.mostrarPeliculas();
    }

    // OPCIÓN 5
    private static void opcionEditarPelicula() {
        if (!videoteca.estaInicializada() || videoteca.numPeliculas() == 0) {
            System.out.println("No hay películas que editar.");
            return;
        }

        videoteca.mostrarPeliculas();

        int index = readInt("Número de la película a editar (0 - "
                + (videoteca.numPeliculas() - 1) + "): ", 0, videoteca.numPeliculas() - 1);

        Pelicula actual = videoteca.getPelicula(index);
        if (actual == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        System.out.println("Editando: " + actual.getTitulo());

        String nuevoTitulo = readString("Nuevo título (ENTER para mantener): ");
        if (!nuevoTitulo.isBlank()) actual.setTitulo(nuevoTitulo);

        int nuevoAno = readInt("Nuevo año (-1 para mantener): ", -1, 2100);
        if (nuevoAno != -1) actual.setAnoEstreno(nuevoAno);

        int nuevaDur = readInt("Nueva duración (-1 para mantener): ", -1, 1000);
        if (nuevaDur != -1) actual.setDuracionMin(nuevaDur);

        double nuevaVal = readDouble("Nueva valoración (-1 para mantener): ", -1, 10);
        if (nuevaVal != -1) actual.setValoracion(nuevaVal);

        System.out.println("Película actualizada.");
    }

    // OPCIÓN 6
    private static void opcionEliminarPelicula() {
        if (!videoteca.estaInicializada() || videoteca.numPeliculas() == 0) {
            System.out.println("No hay películas que eliminar.");
            return;
        }

        videoteca.mostrarPeliculas();

        int index = readInt("Número de la película a eliminar (0 - "
                + (videoteca.numPeliculas() - 1) + "): ", 0, videoteca.numPeliculas() - 1);

        boolean ok = videoteca.eliminarPelicula(index);

        if (ok) System.out.println("Película eliminada correctamente.");
        else System.out.println("No se pudo eliminar.");
    }

    // OPCIÓN 7
    private static void opcionSalir() {
        boolean confirmar = siOno("¿Seguro que deseas salir? (s/n): ");
        if (confirmar) {
            System.out.println("¡Hasta pronto!");
        }
    }
}
