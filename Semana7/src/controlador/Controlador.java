package controlador;
import vista.Vista;
import modelo.Modelo;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Vista vista, Modelo modelo){
        this.modelo = modelo;
        this.vista = vista;
    } 

    public void init(){
        vista.mostrarMenu();

    }

    public void asignarNum1Num2(float num1, float num2){
        modelo.setNum1Num2(num1,num2);

    }

    public void realizarSuma(){
        modelo.realizarSuma();
    }

    public float getSuma(){
        return modelo.getSuma();
    }
    
}
