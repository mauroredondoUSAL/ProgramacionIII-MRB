import controlador.ControladorPersonas;
import modelo.ModeloPersonas;
import vista.VistaPersonas;

public class App {
    public static void main(String[] args) {
        // 1. Instanciar componentes
        VistaPersonas vista = new VistaPersonas();
        ModeloPersonas modelo = new ModeloPersonas();

        // 2. Inyectar dependencias (Constructor)
        ControladorPersonas controlador = new ControladorPersonas(vista, modelo);

        // 3. Setter cruzado
        vista.setControlador(controlador);

        // 4. Arrancar
        controlador.init();
    }
}