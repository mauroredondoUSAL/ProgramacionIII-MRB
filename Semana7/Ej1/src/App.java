import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;


public class App {
    public static void main(String[] args) throws Exception {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();

        Controlador controlador = new Controlador(vista,modelo);
        vista.setControlador(controlador);
        controlador.init();
    }

    

}
