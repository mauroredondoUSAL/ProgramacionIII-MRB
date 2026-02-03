import controlador.ControladorPersonas;
import modelo.ModeloPersonas;
import vista.VistaPersonas;

public class App {
    public static void main(String[] args) {
        VistaPersonas vista = new VistaPersonas();
        ModeloPersonas modelo = new ModeloPersonas();

        ControladorPersonas controlador = new ControladorPersonas(vista, modelo);
        vista.setControlador(controlador);
        
        controlador.init();
    }
}