package modelo;
public class Director {
    private String nombre;
    private String apellidos;
    private boolean oscarGanado;

    public Director(String nombre, String apellidos, boolean oscarGanado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.oscarGanado = oscarGanado;
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean esOscarGanado(){
        return oscarGanado;
    }

    public void setOscarGanado(boolean oscarGanado){
        this.oscarGanado = oscarGanado;
    }

    public String infoDirector(){
        return nombre + ", con apellidos " + apellidos + (oscarGanado ? ", ha ganado un Oscar." : ", no ha ganado un Oscar.");
    }
}
