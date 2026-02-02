package controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import modelo.Factura;

public class PersistenciaFacturas {

    public static List<Factura> cargarFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();

        // 1. CONSTRUCCIÓN DE LA RUTA (Igual que antes, con el espacio corregido)
        String userHome = System.getProperty("user.home");
        //Paths.get() une las carpetas automáticamente, es más limpio que File.separator
        Path rutaFichero = Paths.get(userHome,
                "Library", "Mobile Documents", "com~apple~CloudDocs",
                "4to carrera",
                "Programación III",
                "Práctica",
                "Semana8",
                "facturas.tsv");

        System.out.println("Leyendo fichero en: " + rutaFichero.toAbsolutePath());

        // 2.
        // Verificamos si existe usando la clase Files
        if (Files.exists(rutaFichero)) {
            try {
                // MAGIA AQUÍ: Files.readAllLines lee todo el fichero de golpe y devuelve una Lista de Strings
                List<String> lineasDelFichero = Files.readAllLines(rutaFichero);

                // Recorremos la lista de líneas (ya no hace falta un while)
                for (String linea : lineasDelFichero) {
                    
                    // Saltamos líneas vacías
                    if (linea.trim().isEmpty()) continue;

                    // Separamos por tabuladores (TSV)
                    String[] datos = linea.split("\t");

                    // Verificamos que tenga las 8 columnas necesarias
                    if (datos.length >= 8) {
                        try {
                            // Convertimos y creamos la Factura
                            String concepto = datos[0];
                            double descuento = Double.parseDouble(datos[1]);
                            String fecha = datos[2];
                            double importe = Double.parseDouble(datos[3]);
                            String nif = datos[4];
                            String cliente = datos[5];
                            String direccion = datos[6];
                            double iva = Double.parseDouble(datos[7]);

                            // Añadimos a la lista final
                            listaFacturas.add(new Factura(concepto, descuento, fecha, importe, nif, cliente, direccion, iva));

                        } catch (NumberFormatException e) {
                            System.out.println(" > Error de formato numérico en línea: " + linea);
                        }
                    }
                }
                
                System.out.println("Se han cargado " + listaFacturas.size() + " facturas correctamente.");

            } catch (IOException e) {
                // Files.readAllLines lanza IOException si hay problemas de lectura
                System.out.println("Error de Entrada/Salida: " + e.getMessage());
            }
        } else {
            System.out.println("El fichero no existe en la ruta especificada.");
        }

        return listaFacturas;
    }

    // MÉTODOS NUEVOS PARA EXPORTAR

    public static boolean guardarCSV(List<Factura> facturas, String nombreFichero) {
        // Aseguramos que acabe en .csv
        if (!nombreFichero.endsWith(".csv")) {
            nombreFichero += ".csv";
        }
        
        Path ruta = Paths.get(nombreFichero); // Se guardará en la raíz del proyecto
        List<String> lineas = new ArrayList<>();

        // 1. Cabecera del CSV
        lineas.add("Concepto;Fecha;Base;IVA;Total;Cliente");

        // 2. Datos de cada factura
        for (Factura f : facturas) {
            // Creamos una cadena separada por punto y coma
            String linea = String.format("%s;%s;%.2f;%.2f;%.2f;%s",
                    f.getConcepto(),
                    f.getFecha(),
                    f.getImporteBase(),
                    f.getIva(),
                    f.getImporteTotal(),
                    f.getNombreCliente());
            lineas.add(linea);
        }

        try {
            // Escribimos todo de golpe
            Files.write(ruta, lineas);
            return true; // Ha ido bien
        } catch (IOException e) {
            System.err.println("Error escribiendo CSV: " + e.getMessage());
            return false; // Ha fallado
        }
    }

    public static boolean guardarHTML(List<Factura> facturas, String nombreFichero) {
        if (!nombreFichero.endsWith(".html")) {
            nombreFichero += ".html";
        }

        Path ruta = Paths.get(nombreFichero);
        List<String> html = new ArrayList<>();

        // 1. Construimos el esqueleto HTML
        html.add("<!DOCTYPE html>");
        html.add("<html><head><title>Listado de Facturas</title>");
        // Un poco de estilo CSS básico para que se vea bonito
        html.add("<style>table { border-collapse: collapse; width: 100%; } " +
                "th, td { border: 1px solid black; padding: 8px; text-align: left; } " +
                "th { background-color: #f2f2f2; }</style>");
        html.add("</head><body>");
        html.add("<h1>Listado de Facturas Exportadas</h1>");
        html.add("<table>");
        html.add("<tr><th>Fecha</th><th>Cliente</th><th>Concepto</th><th>Total</th></tr>");

        // 2. Filas de la tabla
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
            Files.write(ruta, html);
            return true;
        } catch (IOException e) {
            System.err.println("Error escribiendo HTML: " + e.getMessage());
            return false;
        }
    }
}