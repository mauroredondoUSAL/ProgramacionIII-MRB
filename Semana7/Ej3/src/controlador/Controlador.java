package controlador;

import modelo.Director;
import modelo.Videoteca;
import modelo.Pelicula;
import vista.Vista;
import java.util.ArrayList;

public class Controlador {

    private Videoteca modelo;
    private Vista vista;

    public Controlador(Videoteca modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void init() {
        boolean salir = false;

        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.pedirOpcionMenu();

            switch (opcion) {
                case 1 -> vista.crearNuevaVideoteca();
                case 2 -> vista.configurarVelocidad();
                case 3 -> vista.anadirPelicula();
                case 4 -> vista.mostrarInformacion();
                case 5 -> vista.editarPelicula();
                case 6 -> vista.eliminarPelicula();
                case 7 -> salir = vista.confirmarSalir();
            }
        }

        System.out.println("Programa finalizado.");
    }

    // ------ MÉTODOS ACCESIBLES DESDE LA VISTA ------

    public void crearVideoteca() {
        modelo.crearNuevaVideoteca();
    }

    public boolean estaInicializada() {
        return modelo.estaInicializada();
    }

    public void setVelocidad(double v) {
        modelo.setVelocidad(v);
    }

    public void anadirPelicula(Pelicula p) {
        modelo.anadirPelicula(p);
    }

    public boolean hayPeliculas() {
        return modelo.numPeliculas() > 0;
    }

    public int numPeliculas() {
        return modelo.numPeliculas();
    }

    public void mostrarPeliculas() {
        ArrayList<Pelicula> lista = modelo.getPeliculas();

        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay películas.");
            return;
        }

        System.out.println("--- LISTA DE PELÍCULAS ---");
        for (int i = 0; i < lista.size(); i++) {
            Pelicula p = lista.get(i);
            System.out.printf("%d) %s (%d) - %d min - %.1f/10 - Director: %s %s%n",
                i, p.getTitulo(), p.getAnoEstreno(), p.getDuracionMin(),
                p.getValoracion(), p.getDirector().getNombre(), 
                p.getDirector().getApellidos());
        }
    }

    public void editarPelicula(int index) {
        Pelicula actual = modelo.getPelicula(index);
        if (actual == null) return;

        // Este método podría delegarse a Vista para pedir campos,
        // pero por simplicidad lo dejo aquí en modo texto.
        System.out.println("Editar película NO implementado completamente (puedo hacerlo si quieres).");
    }

    public boolean eliminarPelicula(int idx) {
        return modelo.eliminarPelicula(idx);
    }
}
