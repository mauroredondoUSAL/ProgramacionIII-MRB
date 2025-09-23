import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número:");
        int num1=scanner.nextInt();

        System.out.println("Ingresa otro número:");
        int num2=scanner.nextInt();

        int opcion;
        do{
        System.out.println("=====Menú=====");
        System.out.println("1 Suma");
        System.out.println("2 Resta");
        System.out.println("3 Multiplcar");
        System.out.println("4 Dividir");
        System.out.println("5 Raíz cuadrada dl primer número");
        System.out.println("6 Salir");
        System.out.println("Elige una opción");

        opcion=scanner.nextInt();

        switch(opcion){
            case 1:
            System.out.println("Resultado: "+(num1+num2)+"\n");
            break;

            case 2:
            System.out.println("Resultado: "+(num1-num2)+"\n");
            break;

            case 3:
            System.out.println("Resultado: "+(num1*num2)+"\n");
            break;

            case 4:
            if(num2==0){
                System.err.println("No se puede dividir por 0");
            }else{
                System.out.println("Resultado: "+((double)num1/num2)+"\n");
            }
            break;

            case 5:
            if(num1<0){
                System.out.println("No se puede sacar la raíz cuadrada de un número negativo");
            }else{
                System.out.println("Resultado: "+Math.sqrt(num1)+"\n");
            }
            break;

            case 6:
            System.out.println("Adiós");
            break;

            default:
            break;
        }
    }while(opcion!=6);
    
    scanner.close();
    }
}
