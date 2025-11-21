import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Introducción de precios diarios sin IVA
        System.out.print("Precio/kg sin IVA de las manzanas: ");
        double precioManzana = sc.nextDouble();

        System.out.print("Precio/kg sin IVA de las peras: ");
        double precioPera = sc.nextDouble();

        // Creamos array de productos
        Producto[] productos = new Producto[2];
        productos[0] = new Producto("Manzanas", precioManzana);
        productos[1] = new Producto("Peras", precioPera);

        int cliente = 1;

        while (true) {

            System.out.println("\n--- Cliente " + cliente + " ---");

            // almacenar cantidades
            double[] cantidades = new double[2];

            // pedir kg
            for (int i = 0; i < productos.length; i++) {
                System.out.print("Kg de " + productos[i].getNombre() + ": ");
                cantidades[i] = sc.nextDouble();
            }

            // generar factura
            double totalFactura = 0;

            System.out.println("\n|----------------------------------------------------------|");
            System.out.printf("| %-56s |\n", "Cliente " + cliente);
            System.out.println("|----------------------------------------------------------|");

            for (int i = 0; i < productos.length; i++) {

                double subtotal = cantidades[i] * productos[i].getPrecioConIVA();
                totalFactura += subtotal;

                System.out.printf("| %-10s | %4.1f kg | precio Kg con IVA %5.2f | %5.2f € |\n",
                                productos[i].getNombre(),
                                cantidades[i],
                                productos[i].getPrecioConIVA(),
                                subtotal);
            }

            System.out.println("|----------------------------------------------------------|");
            System.out.printf("| %-56s |\n", "Total con IVA " + String.format("%.2f €", totalFactura));
            System.out.println("|----------------------------------------------------------|\n");

            // preguntar si continuar
            System.out.print("¿Desea atender otro cliente? (s/n): ");
            char seguir = sc.next().toLowerCase().charAt(0);

            if (seguir == 'n') {
                break;
            }

            cliente++;
        }

        sc.close();
    }
}
