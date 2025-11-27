import modelo.Videoteca;
import vista.Vista;
import controlador.Controlador;

public class App {
    public static void main(String[] args) {
        Videoteca modelo = new Videoteca();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);

        vista.setControlador(controlador);

        controlador.init();
    }
}
