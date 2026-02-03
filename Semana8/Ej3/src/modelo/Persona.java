package modelo;

public class Persona {

    private String nombre;
    private String telefono;
    private int peso; // En el txt son enteros (70, 65...)

    public Persona(String nombre, String telefono, int peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    // Getters y Setters
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public int getPeso(){
        return peso;
    }
    public void setPeso(int peso){
        this.peso = peso;
    }

    // --- MÉTODOS DE AYUDA PARA LA VISTA ---
    
    // Método estático para devolver el título de las columnas ya formateado
    public static String getCabeceraFormateada() {
        return String.format("| %-20s | %-15s | %5s |", "NOMBRE", "TELÉFONO", "PESO");
    }

    // Método para que la persona se devuelva a sí misma como una fila de tabla
    public String getFilaFormateada() {
        return String.format("| %-20s | %-15s | %5d |",
                            this.nombre,
                            this.telefono,
                            this.peso);
    }
}