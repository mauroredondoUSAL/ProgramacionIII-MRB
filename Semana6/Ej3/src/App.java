import static com.coti.tools.Esdia.*;

import modelo.Autor;
import modelo.Libro;
import modelo.Biblioteca;

public class App {

    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            int opcion = readInt("Seleccione una opción: ", 1, 6);

            switch (opcion) {
                case 1:
                    opcionAgregarLibro();
                    break;
                case 2:
                    opcionBuscarLibro();
                    break;
                case 3:
                    opcionMostrarLibros();
                    break;
                case 4:
                    opcionEditarLibro();
                    break;
                case 5:
                    opcionEliminarLibro();
                    break;
                case 6:{
                    opcionSalir();
                    salir = true;
                }
            }
        }

        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("|----------------------------------------------|");
        System.out.println("|                 MI BIBLIOTECA                |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1) Agregar un libro                          |");
        System.out.println("| 2) Buscar un libro por ISBN                  |");
        System.out.println("| 3) Mostrar todos los libros                  |");
        System.out.println("| 4) Editar un libro                           |");
        System.out.println("| 5) Eliminar un libro                         |");
        System.out.println("| 6) Salir                                     |");
        System.out.println("|----------------------------------------------|");
    }

    // OPCIÓN 1
    private static void opcionAgregarLibro() {

        String isbn = readString_ne("ISBN del libro: ");

        if (biblioteca.existeLibro(isbn)) {
            System.out.println("Ya existe un libro con ese ISBN.");
            return;
        }

        String titulo = readString_ne("Título: ");
        String nombre = readString_ne("Nombre del autor: ");
        String apellidos = readString_ne("Apellidos del autor: ");

        Autor autor = new Autor(nombre, apellidos);

        int ano = readInt("Año de publicación: ", 1000, 2100);
        int paginas = readInt("Número de páginas: ", 1, 5000);
        double valoracion = readDouble("Valoración (0-10): ", 0, 10);

        Libro libro = new Libro(isbn, titulo, autor, ano, paginas, valoracion);

        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado correctamente.");
    }

    // OPCIÓN 2
    private static void opcionBuscarLibro() {

        String isbn = readString_ne("Introduce el ISBN: ");

        Libro lib = biblioteca.buscarLibro(isbn);

        if (lib == null) {
            System.out.println("No existe un libro con ese ISBN.");
        } else {
            System.out.println("Libro encontrado:");
            System.out.println(lib.infoLibro());
        }
    }

    // OPCIÓN 3
    private static void opcionMostrarLibros() {
        biblioteca.mostrarLibros();
    }

    // OPCIÓN 4
    private static void opcionEditarLibro() {
        String isbn = readString_ne("ISBN del libro a editar: ");

        Libro libro = biblioteca.buscarLibro(isbn);

        if (libro == null) {
            System.out.println("No existe un libro con ese ISBN.");
            return;
        }

        System.out.println("Editando libro: " + libro.getTitulo());

        String nuevoTitulo = readString("Nuevo título (ENTER para mantener): ");
        if (!nuevoTitulo.isBlank()) libro.setTitulo(nuevoTitulo);

        int nuevoAno = readInt("Nuevo año (-1 para mantener): ", -1, 2100);
        if (nuevoAno != -1) libro.setAnoPublicacion(nuevoAno);

        int nuevasPaginas = readInt("Nuevas páginas (-1 para mantener): ", -1, 5000);
        if (nuevasPaginas != -1) libro.setNumPaginas(nuevasPaginas);

        double nuevaValoracion = readDouble("Nueva valoración (-1 para mantener): ", -1, 10);
        if (nuevaValoracion != -1) libro.setValoracion(nuevaValoracion);

        System.out.println("Libro actualizado correctamente.");
    }

    // OPCIÓN 5
    private static void opcionEliminarLibro() {
        String isbn = readString_ne("ISBN del libro a eliminar: ");

        if (biblioteca.eliminarLibro(isbn)) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("No existe un libro con ese ISBN.");
        }
    }
    
    //OPCIÓN 6
    private static void opcionSalir() {
        boolean confirmar = siOno("¿Seguro que deseas salir? (s/n): ");
        if (confirmar) {
            System.out.println("¡Hasta pronto!");
        }
    }
}

