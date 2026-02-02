package vista;

import java.util.List;
import com.coti.tools.Esdia;
import controlador.ControladorFacturas;
import modelo.Factura;

public class VistaFacturas {
    
    private ControladorFacturas controlador;

    // Necesario para la referencia cruzada
    public void setControlador(ControladorFacturas controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        String opcion = "";
        do {
            System.out.println("\n--- GESTIÓN DE FACTURAS ---");
            System.out.println("1. Filtrar por importe mínimo");
            System.out.println("2. Ver todas");
            System.out.println("3. Exportar HTML");
            System.out.println("4. Exportar CSV");
            System.out.println("q. Salir");
            
            opcion = Esdia.readString("Introduce la opción: ");

            switch (opcion.toLowerCase()) {
                case "1":
                    filtrarFacturas(); // Método privado de la vista
                    break;
                case "2":
                    mostrarTodas();    // Método privado de la vista
                    break;
                case "3":
                    exportarHTML();
                    break;
                case "4":
                    exportarCSV();
                    break;
                case "q":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        } while (!opcion.equals("q"));
    }

    // --- MÉTODOS PRIVADOS QUE MANEJAN LA LÓGICA DE VISUALIZACIÓN ---

    private void mostrarTodas() {
        List<Factura> lista = controlador.getTodasLasFacturas();
        imprimirTabla(lista);
    }

    private void filtrarFacturas() {
        // 1. La Vista pide el dato al usuario
        double min = Esdia.readDouble("Introduce importe mínimo: ");
        // 2. La Vista pide al Controlador que procese
        List<Factura> resultado = controlador.getFacturasFiltradas(min);
        // 3. La Vista pinta el resultado
        System.out.println("--- FACTURAS > " + min + "€ ---");
        imprimirTabla(resultado);
    }

    // Método auxiliar para no repetir código de impresión
    private void imprimirTabla(List<Factura> facturas) {
        if (facturas.isEmpty()) {
            System.out.println("No hay datos.");
            return;
        }
        System.out.println("-".repeat(80));
        System.out.printf("| %-20s | %-12s | %10s |%n", "CLIENTE", "FECHA", "TOTAL");
        System.out.println("-".repeat(80));
        for (Factura f : facturas) {
            System.out.printf("| %-20s | %-12s | %10.2f |%n",
                truncate(f.getNombreCliente(), 20),
                f.getFecha(),
                f.getImporteTotal());
        }
        System.out.println("-".repeat(80));
    }
    
    private String truncate(String str, int width) {
        if (str.length() > width) return str.substring(0, width - 3) + "...";
        return str;
    }

    private void exportarHTML() {
        // 1. Pedir nombre
        String nombre = Esdia.readString("Introduce el nombre para el archivo HTML (ej: salida): ");
        
        // 2. Llamar al controlador
        boolean exito = controlador.exportarA_HTML(nombre);
        
        // 3. Feedback al usuario
        if (exito) {
            System.out.println("¡Exportación HTML correcta! Revisa la carpeta del proyecto.");
        } else {
            System.out.println("Hubo un error al crear el archivo HTML.");
        }
    }

    private void exportarCSV() {
        String nombre = Esdia.readString("Introduce el nombre para el archivo CSV (ej: datos): ");
        boolean exito = controlador.exportarA_CSV(nombre);
        
        if (exito) {
            System.out.println("¡Exportación CSV correcta! Revisa la carpeta del proyecto.");
        } else {
            System.out.println("Hubo un error al crear el archivo CSV.");
        }
    }
}