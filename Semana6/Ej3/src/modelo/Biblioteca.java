package modelo;

import java.util.HashMap;

public class Biblioteca {

    private HashMap<String, Libro> libros;

    public Biblioteca() {
        this.libros = new HashMap<>();
    }

    public boolean existeLibro(String isbn) {
        return libros.containsKey(isbn);
    }

    //Opciones CRUD:
    
    public boolean agregarLibro(Libro libro) {
        if (libros.containsKey(libro.getIsbn())) {
            return false;
        }
        libros.put(libro.getIsbn(), libro);
        return true;
    }

    
    public Libro buscarLibro(String isbn) {
        return libros.get(isbn);
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        System.out.println("LIBROS EN LA BIBLIOTECA:");
        System.out.println("---------------------------------------------------------------");

        libros.values().forEach(lib -> {
            System.out.printf("ISBN: %s | %s | %s | %d páginas | Valoración: %.2f%n",
                    lib.getIsbn(),
                    lib.getTitulo(),
                    lib.getAutor().infoAutor(),
                    lib.getNumPaginas(),
                    lib.getValoracion()
            );
        });

        System.out.println("---------------------------------------------------------------");
    }

    
    public boolean actualizarLibro(String isbn, Libro nuevo) {
        if (!libros.containsKey(isbn)) return false;
        libros.put(isbn, nuevo);
        return true;
    }

    
    public boolean eliminarLibro(String isbn) {
        return libros.remove(isbn) != null;
    }

    public int totalLibros() {
        return libros.size();
    }
}
