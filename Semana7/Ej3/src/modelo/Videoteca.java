package modelo;

import java.util.ArrayList;

public class Videoteca {

    private ArrayList<Pelicula> peliculas;
    private double velocidad;

    public Videoteca() {
        this.peliculas = null;
        this.velocidad = 1.0;
    }

    // Crear
    public void crearNuevaVideoteca() {
        this.peliculas = new ArrayList<>();
    }

    public boolean estaInicializada() {
        return peliculas != null;
    }

    public int numPeliculas() {
        return peliculas == null ? 0 : peliculas.size();
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        if (velocidad <= 0) {
            throw new IllegalArgumentException("La velocidad debe ser mayor que 0.");
        }
        this.velocidad = velocidad;
    }

    public boolean anadirPelicula(Pelicula p) {
        if (peliculas == null) return false;
        peliculas.add(p);
        return true;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public Pelicula getPelicula(int index) {
        if (peliculas == null || index < 0 || index >= peliculas.size()) return null;
        return peliculas.get(index);
    }

    public boolean actualizarPelicula(int index, Pelicula nueva) {
        if (peliculas == null || index < 0 || index >= peliculas.size()) return false;
        peliculas.set(index, nueva);
        return true;
    }

    public boolean eliminarPelicula(int index) {
        if (peliculas == null || index < 0 || index >= peliculas.size()) return false;
        peliculas.remove(index);
        return true;
    }
}
