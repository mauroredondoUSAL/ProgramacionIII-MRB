package modelo;

public class Libro {
    private String isbn;
    private String titulo;
    private Autor autor;
    private int anoPublicacion;
    private int numPaginas;
    private double valoracion;

    public Libro(String isbn, String titulo, Autor autor, int anoPublicacion, int numPaginas, double valoracion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.numPaginas = numPaginas;
        this.valoracion = valoracion;
    }

    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }
    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public double getValoracion() {
        return valoracion;
    }
    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public String infoLibro() {
        return titulo + " (" + anoPublicacion + ") - " + numPaginas + " páginas - valoración: " + valoracion;
    }
}
