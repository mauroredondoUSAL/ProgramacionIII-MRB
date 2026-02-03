package modelo;

import java.util.Random;

public class Direccion {
    private String calle;
    private int numero;
    private int piso;
    private String letra;

    // Constructor
    public Direccion(String calle, int numero, int piso, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    // Getters
    public String getCalle(){
        return calle;
    }
    public int getNumero(){
        return numero;
    }
    public int getPiso(){
        return piso;
    }
    public String getLetra(){
        return letra;
    }

    // Formato para CSV (Opción 4 del menú)
    public String toCSV(){
        return String.format("%s;%d;%d;%s", calle, numero, piso, letra);
    }

    // Formato bonito para la tabla
    @Override
    public String toString() {
        return String.format("C/ %s, %d, %dº %s", calle, numero, piso, letra);
    }

    // --- FACTORY METHOD (Generador Aleatorio) ---
    private static final String[] CALLES = {"Mayor", "Alcalá", "Gran Vía", "Castellana", "Princesa", "Goya", "Serrano"};
    private static final String[] LETRAS = {"A", "B", "C", "D", "Izda", "Dcha"};
    private static final Random r = new Random();

    public static Direccion crearDireccionAleatoria() {
        String calle = CALLES[r.nextInt(CALLES.length)];
        int numero = r.nextInt(100) + 1; // 1 a 100
        int piso = r.nextInt(8) + 1;     // 1 a 8
        String letra = LETRAS[r.nextInt(LETRAS.length)];

        return new Direccion(calle, numero, piso, letra);
    }
}