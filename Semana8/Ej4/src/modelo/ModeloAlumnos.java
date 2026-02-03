package modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloAlumnos {
    
    private List<DatosDeAlumno> listaAlumnos;

    public ModeloAlumnos() {
        this.listaAlumnos = new ArrayList<>();
        // Al crear el modelo, generamos los 20 primeros automáticamente (Requisito PDF)
        generarListaNueva();
    }

    public List<DatosDeAlumno> getListaAlumnos() {
        return listaAlumnos;
    }

    // Lógica para vaciar y llenar con 20 nuevos (Opción 1 del menú)
    public void generarListaNueva() {
        listaAlumnos.clear();
        for (int i = 0; i < 20; i++) {
            // Usamos el Factory Method que creamos antes
            listaAlumnos.add(DatosDeAlumno.crearAlumnoAleatorio());
        }
    }
}