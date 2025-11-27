package controlador;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
    
    private Modelo modelo;
    private Vista vista;

    public Controlador(Vista vista, Modelo modelo){
        this.vista = vista;
        this.modelo = modelo;
    }

    public void init() {
        vista.mostrarMenu();
    }

    public void setVentas(int[][] ventas){
        modelo.setVentas(ventas);
    }

    public void setPrecios(float p1, float p2){
        modelo.setPrecios(p1, p2);
    }

    public void calcularIngresos(){
        modelo.calcularIngresos();
    }

    public int[][] getVentas(){
        return modelo.getVentas();
    }

    public float[] getPrecios(){
        return modelo.getPrecios();
    }

    public float getIngresosTotales(){
        return modelo.getIngresosTotales();
    }
}
