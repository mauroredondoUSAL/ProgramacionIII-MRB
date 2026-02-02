package controlador;

import java.io.IOException;
import java.nio.charset.StandardCharsets; // 1. IMPORTANTE: Importamos esto
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import modelo.Factura;

public class PersistenciaFacturas {

    // --- MÉTODOS DE LECTURA ---
    public static List<Factura> cargarFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();
        String userHome = System.getProperty("user.home");
        Path rutaFichero = Paths.get(userHome,
                "Library", "Mobile Documents", "com~apple~CloudDocs",
                "4to carrera",
                "Programación III",
                "Práctica",
                "Semana8",
                "facturas.tsv");

        if (Files.exists(rutaFichero)) {
            try {
                // Leemos usando UTF-8 explícitamente también al cargar
                List<String> lineasDelFichero = Files.readAllLines(rutaFichero, StandardCharsets.UTF_8);

                for (String linea : lineasDelFichero) {
                    if (linea.trim().isEmpty()) continue;
                    String[] datos = linea.split("\t");

                    if (datos.length >= 8) {
                        try {
                            String concepto = datos[0];
                            double descuento = Double.parseDouble(datos[1]);
                            String fecha = datos[2];
                            double importe = Double.parseDouble(datos[3]);
                            String nif = datos[4];
                            String cliente = datos[5];
                            String direccion = datos[6];
                            double iva = Double.parseDouble(datos[7]);

                            listaFacturas.add(new Factura(concepto, descuento, fecha, importe, nif, cliente, direccion, iva));

                        } catch (NumberFormatException e) {
                            System.out.println(" > Error de formato numérico en línea: " + linea);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error de Entrada/Salida: " + e.getMessage());
            }
        } else {
            System.out.println("El fichero no existe en la ruta especificada.");
        }
        return listaFacturas;
    }

    // --- MÉTODOS DE ESCRITURA ---

    public static boolean guardarCSV(List<Factura> facturas, String nombreFichero) {
        if (!nombreFichero.endsWith(".csv")) {
            nombreFichero += ".csv";
        }
        Path ruta = Paths.get(nombreFichero);
        List<String> lineas = new ArrayList<>();

        lineas.add("Concepto;Fecha;Base;IVA;Total;Cliente");

        for (Factura f : facturas) {
            String linea = String.format("%s;%s;%.2f;%.2f;%.2f;%s",
                    f.getConcepto(), f.getFecha(), f.getImporteBase(),
                    f.getIva(), f.getImporteTotal(), f.getNombreCliente());
            lineas.add(linea);
        }

        try {
            // CAMBIO AQUÍ: Forzamos UTF-8
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            System.err.println("Error escribiendo CSV: " + e.getMessage());
            return false;
        }
    }

    public static boolean guardarHTML(List<Factura> facturas, String nombreFichero) {
        if (!nombreFichero.endsWith(".html")) {
            nombreFichero += ".html";
        }
        Path ruta = Paths.get(nombreFichero);
        List<String> html = new ArrayList<>();

        html.add("<!DOCTYPE html>");
        html.add("<html><head>");
        
        // 2. CAMBIO CLAVE: Avisamos al navegador que es UTF-8
        html.add("<meta charset=\"UTF-8\">");
        
        html.add("<title>Listado de Facturas</title>");
        html.add("<style>table { border-collapse: collapse; width: 100%; font-family: Arial, sans-serif; } " +
                "th, td { border: 1px solid #ddd; padding: 8px; text-align: left; } " +
                "th { background-color: #f2f2f2; color: #333; } tr:nth-child(even){background-color: #f9f9f9;}</style>");
        html.add("</head><body>");
        html.add("<h1>Listado de Facturas Exportadas</h1>");
        html.add("<table>");
        html.add("<tr><th>Fecha</th><th>Cliente</th><th>Concepto</th><th>Total</th></tr>");

        for (Factura f : facturas) {
            String fila = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%.2f €</td></tr>",
                    f.getFecha(),
                    f.getNombreCliente(),
                    f.getConcepto(),
                    f.getImporteTotal());
            html.add(fila);
        }

        html.add("</table></body></html>");

        try {
            // 3. CAMBIO CLAVE: Escribimos el fichero en formato UTF-8
            Files.write(ruta, html, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            System.err.println("Error escribiendo HTML: " + e.getMessage());
            return false;
        }
    }
}