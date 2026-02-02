package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloFacturas {
    // Atributo principal: La lista de datos
    private List<Factura> listaFacturas;

    public ModeloFacturas() {
        // Inicializamos la lista vacía
        this.listaFacturas = new ArrayList<>();
    }

    // Setter para cargar la lista entera (lo usará el controlador al leer el fichero)
    public void setListaFacturas(List<Factura> lista) {
        this.listaFacturas = lista;
    }

    // Getter para obtener la lista
    public List<Factura> getListaFacturas() {
        return this.listaFacturas;
    }
}