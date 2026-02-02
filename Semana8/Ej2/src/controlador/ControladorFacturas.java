package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Factura;
import modelo.ModeloFacturas;
import vista.VistaFacturas;

public class ControladorFacturas {
    
    private ModeloFacturas modelo;
    private VistaFacturas vista;

    // Constructor: recibe Vista y Modelo
    public ControladorFacturas(VistaFacturas vista, ModeloFacturas modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    // Método init: Carga datos y lanza el menú
    public void init() {
        // 1. Cargamos datos del fichero usando tu clase de Persistencia
        List<Factura> datosCargados = PersistenciaFacturas.cargarFacturas();
        
        // 2. Guardamos los datos en el Modelo
        modelo.setListaFacturas(datosCargados);

        // 3. Le decimos a la vista que empiece
        vista.mostrarMenu();
    }

    // --- MÉTODOS QUE LLAMARÁ LA VISTA ---

    public List<Factura> getTodasLasFacturas() {
        return modelo.getListaFacturas();
    }

    // Lógica para filtrar
    public List<Factura> getFacturasFiltradas(double importeMinimo) {
        List<Factura> todas = modelo.getListaFacturas();
        List<Factura> filtradas = new ArrayList<>();

        for (Factura f : todas) {
            if (f.getImporteTotal() > importeMinimo) {
                filtradas.add(f);
            }
        }
        return filtradas;
    }

    // --- MÉTODOS PARA EXPORTAR ---

    public boolean exportarA_CSV(String nombreArchivo) {
        // 1. Obtenemos los datos del modelo
        List<Factura> lista = modelo.getListaFacturas();
        
        // 2. Llamamos a persistencia y devolvemos el resultado (true/false)
        return PersistenciaFacturas.guardarCSV(lista, nombreArchivo);
    }

    public boolean exportarA_HTML(String nombreArchivo) {
        List<Factura> lista = modelo.getListaFacturas();
        return PersistenciaFacturas.guardarHTML(lista, nombreArchivo);
    }
}