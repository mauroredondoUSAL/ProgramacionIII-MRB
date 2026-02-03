package controlador;

import java.util.List;
import modelo.DatosDeAlumno;
import modelo.ModeloAlumnos;
import vista.VistaAlumnos;

public class ControladorAlumnos {

    private VistaAlumnos vista;
    private ModeloAlumnos modelo;

    public ControladorAlumnos(VistaAlumnos vista, ModeloAlumnos modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void init() {
        // Al arrancar, el modelo ya generó los 20 alumnos en su constructor.
        // Solo lanzamos el menú.
        vista.mostrarMenu();
    }

    // --- MÉTODOS PARA LA VISTA ---

    public List<DatosDeAlumno> getListaAlumnos() {
        return modelo.getListaAlumnos();
    }

    // Opción 1: Regenerar lista
    public void regenerarLista() {
        modelo.generarListaNueva();
    }

    // Opción 3: Exportar Personales
    public boolean exportarPersonales(String nombreArchivo) {
        return PersistenciaAlumnos.guardarDatosPersonalesCSV(modelo.getListaAlumnos(), nombreArchivo);
    }

    // Opción 4: Exportar Direcciones
    public boolean exportarDirecciones(String nombreArchivo) {
        return PersistenciaAlumnos.guardarDireccionesCSV(modelo.getListaAlumnos(), nombreArchivo);
    }
}