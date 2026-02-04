package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloFilmoteca {

    private List<Pelicula> listaPeliculas;

    public ModeloFilmoteca() {
        this.listaPeliculas = new ArrayList<>();
    }

    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public void agregarPelicula(Pelicula p) {
        this.listaPeliculas.add(p);
    }

    // --- NUEVOS MÉTODOS ---

    public void eliminarPelicula(int indice) {
        if (indice >= 0 && indice < listaPeliculas.size()) {
            listaPeliculas.remove(indice);
        }
    }

    public void modificarPelicula(int indice, Pelicula nuevaPelicula) {
        if (indice >= 0 && indice < listaPeliculas.size()) {
            listaPeliculas.set(indice, nuevaPelicula);
        }
    }

    public Pelicula getPelicula(int indice) {
        if (indice >= 0 && indice < listaPeliculas.size()) {
            return listaPeliculas.get(indice);
        }
        return null;
    }
}