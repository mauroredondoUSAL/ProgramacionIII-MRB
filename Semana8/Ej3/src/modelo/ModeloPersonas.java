package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloPersonas {
    
    // Aquí guardaremos la lista de gente cargada
    private List<Persona> listaPersonas;

    public ModeloPersonas() {
        this.listaPersonas = new ArrayList<>();
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}