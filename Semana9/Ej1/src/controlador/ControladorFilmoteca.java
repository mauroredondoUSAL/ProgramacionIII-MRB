package controlador;

import java.util.List;
import modelo.ModeloFilmoteca;
import modelo.Pelicula;
import vista.VistaFilmoteca;

public class ControladorFilmoteca {

    private VistaFilmoteca vista;
    private ModeloFilmoteca modelo;

    public ControladorFilmoteca(VistaFilmoteca vista, ModeloFilmoteca modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void init() {
        vista.mostrarMenu();
    }

    public List<Pelicula> getPeliculas() {
        return modelo.getListaPeliculas();
    }

    public void crearPelicula(String titulo, String director, int anio, int duracion, String descripcion) {
        modelo.agregarPelicula(new Pelicula(titulo, director, anio, duracion, descripcion));
    }

    // --- NUEVAS ACCIONES ---

    public void borrarPelicula(int indice) {
        modelo.eliminarPelicula(indice);
    }

    public void editarPelicula(int indice, String titulo, String director, int anio, int duracion, String descripcion) {
        Pelicula p = new Pelicula(titulo, director, anio, duracion, descripcion);
        modelo.modificarPelicula(indice, p);
    }

    // --- EXPORTAR / IMPORTAR (RENOMBRADOS Y CSV AÑADIDO) ---

    public void exportarJSON(String archivo) { PersistenciaPeliculas.exportarJSON(modelo.getListaPeliculas(), archivo); }
    public void importarJSON(String archivo) { cargarEnModelo(PersistenciaPeliculas.importarJSON(archivo)); }

    public void exportarXML(String archivo) { PersistenciaPeliculas.exportarXML(modelo.getListaPeliculas(), archivo); }
    public void importarXML(String archivo) { cargarEnModelo(PersistenciaPeliculas.importarXML(archivo)); }

    public void exportarCSV(String archivo) { PersistenciaPeliculas.exportarCSV(modelo.getListaPeliculas(), archivo); }
    public void importarCSV(String archivo) { cargarEnModelo(PersistenciaPeliculas.importarCSV(archivo)); }

    // Auxiliar para no repetir código
    private void cargarEnModelo(List<Pelicula> lista) {
        if (!lista.isEmpty()) modelo.setListaPeliculas(lista);
    }
}