package modelo;

public class Modelo {

    private int[][] ventas;   // 5 almacenes × 2 productos
    private float[] precios;  // precio de cada producto

    private float ingresosTotales;

    public Modelo() {
        ventas = new int[5][2];     // inicializado a 0
        precios = new float[2];      // inicializado a 0
        ingresosTotales = 0;
    }

    public void setVentas(int[][] ventas) {
        this.ventas = ventas;
    }

    public void setPrecios(float p1, float p2) {
        precios[0] = p1;
        precios[1] = p2;
    }

    public void calcularIngresos() {
        float total = 0;
        for (int i = 0; i < 5; i++) {
            total += ventas[i][0] * precios[0];
            total += ventas[i][1] * precios[1];
        }
        ingresosTotales = total;
    }

    public int[][] getVentas() {
        return ventas;
    }

    public float[] getPrecios() {
        return precios;
    }

    public float getIngresosTotales() {
        return ingresosTotales;
    }
}
