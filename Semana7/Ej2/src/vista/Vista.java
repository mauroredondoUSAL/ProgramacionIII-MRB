package vista;

import controlador.Controlador;
import com.coti.tools.Esdia;

public class Vista {

    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu(){
        String opcion = "";

        do{
            System.out.println("\n--- MENÚ CRUD VENTAS ---");
            System.out.println("1. Leer tabla de ventas");
            System.out.println("2. Leer tabla de precios");
            System.out.println("3. Calcular ingresos totales");
            System.out.println("4. Mostrar resultados");
            System.out.println("q. Salir");

            opcion = Esdia.readString_ne("Introduce la opción (No se podrá opción 3 si no están rellenas las tablas, y no se podrá opción 4 si no están calculados los ingresosos totales)");

            switch(opcion){
                case "1":
                    leerTablaVentas();
                    break;
                case "2":
                    leerTablaPrecios();
                    break;
                case "3":
                    controlador.calcularIngresos();
                    System.out.println("Ingresos calculados.");
                    break;
                case "4":
                    mostrarResultados();
                    break;
                default:
                    break;
            }

        } while(!opcion.equals("q"));
    }

    private void leerTablaVentas() {
        int[][] ventas = new int[5][2];

        System.out.println("\nIntroduce las ventas por almacén y por producto:");
        for(int i = 0; i < 5; i++) {
            System.out.println("Almacén " + (i+1));
            ventas[i][0] = Esdia.readInt("Unidades producto 1: ");
            ventas[i][1] = Esdia.readInt("Unidades producto 2: ");
        }

        controlador.setVentas(ventas);
    }

    private void leerTablaPrecios() {
        float precio1 = Esdia.readFloat("Precio del producto 1: ");
        float precio2 = Esdia.readFloat("Precio del producto 2: ");

        controlador.setPrecios(precio1, precio2);
    }

    private void mostrarResultados() {
        int[][] ventas = controlador.getVentas();
        float[] precios = controlador.getPrecios();
        float ingresos = controlador.getIngresosTotales();

        System.out.println("\n--- RESULTADOS ---");

        System.out.println("\nVentas por almacén:");
        for(int i = 0; i < 5; i++) {
            System.out.printf("Almacén %d -> P1: %d unidades | P2: %d unidades%n",
                            (i+1), ventas[i][0], ventas[i][1]);
        }

        System.out.println("\nPrecios:");
        System.out.println("Producto 1: " + precios[0]);
        System.out.println("Producto 2: " + precios[1]);

        System.out.println("\nIngresos totales: " + ingresos + " €");
    }
}
