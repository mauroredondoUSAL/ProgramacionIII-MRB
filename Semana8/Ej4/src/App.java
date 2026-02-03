import controlador.ControladorAlumnos;
import modelo.ModeloAlumnos;
import vista.VistaAlumnos;

public class App {
    public static void main(String[] args) {
        // 1. Instanciar
        VistaAlumnos vista = new VistaAlumnos();
        ModeloAlumnos modelo = new ModeloAlumnos(); // Aquí se crean los 20 alumnos solos

        // 2. Controlar
        ControladorAlumnos controlador = new ControladorAlumnos(vista, modelo);

        // 3. Conectar
        vista.setControlador(controlador);

        // 4. Ejecutar
        controlador.init();
    }
}