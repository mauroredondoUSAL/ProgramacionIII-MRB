package vista;
import controlador.Controlador;
import com.coti.tools.Esdia;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu(){
        String opcion="";
        do{
            //Imprimir menu
            System.out.println("---Calculadora---");
            System.out.println("1. Leer números");
            System.out.println("2. Realizar suma");
            System.out.println("3. Mostrar resultado");
            System.out.println("q. salir");
            //Leer opcion
            opcion=Esdia.readString_ne("Introduce la opcion");


            switch (opcion) {
                case "1":
                //pedir numeros
                pedirNumeros();
                break;
                case"2":
                realizarSuma();
                //Realizar suma
                break;
                case"3":
                //imprimir suma
                imprimirSuma();
                break;

                default:
                break;
            }
        }while(!opcion.equals("q"));

    }
    
    private void pedirNumeros(){
        float num1=Esdia.readFloat("Dame el primer número");
        float num2=Esdia.readFloat("Dame el segundo número");
        controlador.asignarNum1Num2(num1,num2);
    }

    private void realizarSuma(){
        controlador.realizarSuma();
    }

    private void imprimirSuma(){
        float suma = controlador.getSuma();
        System.out.println("La suma es: "+suma);
    }


}

