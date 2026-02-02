import controlador.ControladorFacturas;
import modelo.ModeloFacturas;
import vista.VistaFacturas;

public class App {
    public static void main(String[] args) {
        // 1. Instanciar los 3 componentes
        VistaFacturas vista = new VistaFacturas();
        ModeloFacturas modelo = new ModeloFacturas();
        
        // 2. Crear el controlador pasando vista y modelo
        ControladorFacturas controlador = new ControladorFacturas(vista, modelo);
        
        // 3. IMPORTANTE: Darle el controlador a la vista (setter)
        vista.setControlador(controlador);

        // 4. Arrancar
        controlador.init();
    }
}