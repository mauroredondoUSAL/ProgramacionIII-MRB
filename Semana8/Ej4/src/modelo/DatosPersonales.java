package modelo;

import java.util.Random;

public class DatosPersonales {
    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;

    public DatosPersonales(String nombre, String apellidos, int edad, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nif = nif;
    }

    // Getters
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public int getEdad(){
        return edad;
    }
    public String getNif(){
        return nif;
    }

    // Formato para CSV (Opción 3 del menú)
    public String toCSV(){
        return String.format("%s;%s;%d;%s", nombre, apellidos, edad, nif);
    }

    // --- FACTORY METHOD ---
    private static final String[] NOMBRES = {"Juan", "Ana", "Luis", "María", "Pedro", "Lucía", "Carlos", "Sofía"};
    private static final String[] APELLIDOS = {"Pérez", "García", "López", "Sánchez", "Martín", "Ruiz", "Gómez"};
    private static final Random r = new Random();

    public static DatosPersonales crearDatosAleatorios() {
        String nombre = NOMBRES[r.nextInt(NOMBRES.length)];
        String apellido1 = APELLIDOS[r.nextInt(APELLIDOS.length)];
        String apellido2 = APELLIDOS[r.nextInt(APELLIDOS.length)];
        int edad = 18 + r.nextInt(10); // Entre 18 y 27 años
        
        // Generar NIF aleatorio (8 números + 1 letra)
        int numNif = 10000000 + r.nextInt(89999999);
        char letraNif = (char) ('A' + r.nextInt(26));
        String nif = numNif + "-" + letraNif;

        return new DatosPersonales(nombre, apellido1 + " " + apellido2, edad, nif);
    }
}