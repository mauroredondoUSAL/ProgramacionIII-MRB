package controlador;

import java.util.List;
import modelo.ModeloPersonas;
import modelo.Persona;
import vista.VistaPersonas;

public class ControladorPersonas {

    private VistaPersonas vista;
    private ModeloPersonas modelo;

    public ControladorPersonas(VistaPersonas vista, ModeloPersonas modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void init() {
        // Intentamos cargar "datos.txt" por defecto
        List<Persona> datosIniciales = PersistenciaPersonas.cargarDatos("datos.txt");
        
        if (!datosIniciales.isEmpty()) {
            modelo.setListaPersonas(datosIniciales);
            System.out.println("Se han cargado datos iniciales automáticamente.");
        } else {
            System.out.println("No se encontró 'datos.txt', iniciamos vacío.");
        }

        
        vista.mostrarMenu();
    }

    // --- MÉTODOS QUE LLAMARÁ LA VISTA ---

    public List<Persona> getPersonas() {
        return modelo.getListaPersonas();
    }

    // Para la opción de "Importar otro fichero"
    public void importarDatos(String nombreFichero) {
        List<Persona> nuevosDatos = PersistenciaPersonas.cargarDatos(nombreFichero);
        if (!nuevosDatos.isEmpty()) {
            modelo.setListaPersonas(nuevosDatos);
        }
    }
}