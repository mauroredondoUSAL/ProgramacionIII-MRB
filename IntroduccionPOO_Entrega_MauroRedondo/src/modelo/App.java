package modelo;

import static com.coti.tools.Esdia.*;

//Lo que aparece en pantalla y que manipula el cliente
public class App {

    private static Videoteca videoteca = new Videoteca();

    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            int opcion = readInt("Seleccione una opción: ", 1, 5);

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
                    opcionSalir(); 
                    salir = true;
                    break;
            }
        }

        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("+--------------------------------------+");
        System.out.println("|           MI VIDEOTECA               |");
        System.out.println("+--------------------------------------+");
        System.out.println("1) Nueva videoteca de películas");
        System.out.println("2) Configurar velocidad de reproducción");
        System.out.println("3) Añadir una nueva película a la videoteca");
        System.out.println("4) Mostrar información actual de películas");
        System.out.println("5) Salir (se borrará toda la información)");
    }

    //Opción 1, 
    private static void opcionCrearNuevaVideoteca() {
        System.out.println("Creando nueva videoteca...");

        int tamanyo = readInt("Introduce el tamaño de la nueva videoteca: ", 1, Integer.MAX_VALUE);

        videoteca.crearNuevaVideoteca(tamanyo);
    if (videoteca.capacidad() > 0) {
        System.out.printf("Videoteca creada con capacidad para %d películas.%n", videoteca.capacidad());
    } else {
        System.err.println("Error al crear la videoteca: El tamaño debe ser mayor que 0.");
    }
    }

    // OPCIÓN 2
    private static void opcionConfigurarVelocidad() {
        System.out.println("Configurando velocidad de reproducción...");

        double nuevaVelocidad = readDouble(
                "Introduce la nueva velocidad de reproducción (por ejemplo, 1.0 = normal, 1.5 = rápido, 0.5 = lento): ",
                0.1, 5.0);

        videoteca.setVelocidad(nuevaVelocidad);
        System.out.printf("Velocidad de reproducción establecida a %.2fx%n", videoteca.getVelocidad());
    }

    // OPCIÓN 3
    private static void opcionAnadirPelicula() {
        System.out.println("Añadiendo nueva película...");

        if (!videoteca.estaInicializada()) {
            System.out.println("Primero debes crear una videoteca (opción 1).");
            return;
        }

        String titulo = readString_ne("Título de la película: ");
        String nombre = readString_ne("Nombre del director: ");
        String apellidos = readString_ne("Apellidos del director: ");
        boolean oscarGanado = siOno("¿Ha ganado un Oscar? (s/n): ");
        Director director = new Director(nombre, apellidos, oscarGanado);
        int duracionMin = readInt("Duración (en minutos, >0): ", 1, 1000);
        int anoEstreno = readInt("Año de estreno (1900 - 2100): ", 1900, 2100);
        double valoracion = readDouble("Valoración (0.0 - 10.0): ", 0.0, 10.0);

        Pelicula p = new Pelicula(director, titulo, anoEstreno, duracionMin, valoracion);

        boolean añadida = videoteca.anadirPelicula(p);

        if (añadida) {
            System.out.println("Película añadida correctamente.");
        } else {
            System.out.println("No se pudo añadir la película (la videoteca está llena).");
        }
    }

    // OPCIÓN 4
    private static void opcionMostrarInformacion() {
        if (!videoteca.estaInicializada()) {
            System.out.println("Primero debes crear una videoteca (opción 1).");
            return;
        }

        System.out.println("\n=== INFORMACIÓN ACTUAL ===");
        System.out.printf("Velocidad de reproducción actual: %.2fx%n", videoteca.getVelocidad());
        System.out.printf("Capacidad total: %d%n", videoteca.capacidad());
        System.out.printf("Películas almacenadas: %d%n%n", videoteca.numPeliculas());

        videoteca.mostrarPeliculas();
    }

    // OPCIÓN 5
    private static void opcionSalir() {
        System.out.println("¿Seguro que deseas salir y borrar toda la información?");
        boolean confirmar = siOno("Confirma (s/n): ");
        if (confirmar) {
            videoteca = new Videoteca();
            System.out.println("Datos borrados. ¡Hasta pronto!");
        } else {
            System.out.println("Cancelado. Volviendo al menú principal...");
        }
    }
}
