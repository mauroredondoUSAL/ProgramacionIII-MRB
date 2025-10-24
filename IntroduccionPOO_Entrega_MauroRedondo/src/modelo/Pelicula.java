package modelo;
public class Pelicula {
    private Director director;
    private String titulo;
    private int anoEstreno;
    private int duracionMin;
    private double valoracion;

    public Pelicula(Director director, String titulo, int anoEstreno, int duracionMin, double valoracion) {
        this.director = director;
        this.titulo = titulo;
        this.anoEstreno = anoEstreno;
        this.duracionMin = duracionMin;
        this.valoracion = valoracion;
    }


    //Getters y Setters
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public int getAnoEstreno(){
        return anoEstreno;
    }
    public void setAnoEstreno(int anoEstreno){
        this.anoEstreno = anoEstreno;
    }


    public int getDuracionMin(){
        return duracionMin;
    }
    public void setDuracionMin(int duracionMin){
        this.duracionMin = duracionMin;
    }


    public double getValoracion(){
        return valoracion;
    }
    public void setValoracion(double valoracion){
        this.valoracion = valoracion;
    }


    public String infoPelicula(){
        return titulo + " (" + anoEstreno + ") - " + duracionMin + " min - valoración: " + valoracion;
    }
}


