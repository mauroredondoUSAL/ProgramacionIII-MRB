package modelo;

import java.io.Serializable;

// Implementamos Serializable por buena práctica, aunque Gson/Jackson no lo exigen
public class Pelicula implements Serializable {

    private String titulo;
    private String director;
    private int anio;
    private int duracionMinutos;
    private String descripcion;

    // CONSTRUCTOR VACÍO (OBLIGATORIO para Gson y Jackson)
    // Sin esto, al intentar leer el fichero, el programa explotará.
    public Pelicula() {
    }

    // CONSTRUCTOR CON DATOS
    public Pelicula(String titulo, String director, int anio, int duracionMinutos, String descripcion) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.duracionMinutos = duracionMinutos;
        this.descripcion = descripcion;
    }

    // GETTERS Y SETTERS
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }

    public int getAnio(){
        return anio;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }

    public int getDuracionMinutos(){
        return duracionMinutos;
    }
    public void setDuracionMinutos(int duracionMinutos){
        this.duracionMinutos = duracionMinutos;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    // MÉTODOS DE AYUDA PARA LA VISTA
    
    // Para imprimir una fila bonita en la tabla
    public String getFilaFormateada() {
        // Cortamos la descripción si es muy larga para que no rompa la tabla
        String descCorta = (descripcion != null && descripcion.length() > 25)
                        ? descripcion.substring(0, 22) + "..."
                        : descripcion;
                        
                        return String.format("| %-20s | %-15s | %4d | %3d min | %-25s |",
                cortar(titulo, 20),
                cortar(director, 15),
                anio,
                duracionMinutos,
                descCorta);
    }

    // Auxiliar para cortar strings
    private String cortar(String texto, int largo) {
        if (texto == null) return "";
        if (texto.length() > largo) return texto.substring(0, largo - 3) + "...";
        return texto;
    }
}