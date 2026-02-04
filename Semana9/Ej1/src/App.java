import controlador.ControladorFilmoteca;
import modelo.ModeloFilmoteca;
import vista.VistaFilmoteca;

public class App {
    public static void main(String[] args) {
        // 1. Instanciar los tres pilares
        VistaFilmoteca vista = new VistaFilmoteca();
        ModeloFilmoteca modelo = new ModeloFilmoteca();
        
        // 2. Crear el controlador (el puente)
        ControladorFilmoteca controlador = new ControladorFilmoteca(vista, modelo);
        
        // 3. Darle el mando a la vista
        vista.setControlador(controlador);

        // 4. ¡Acción!
        controlador.init();
    }
}