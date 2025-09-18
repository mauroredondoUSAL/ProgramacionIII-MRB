
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int num1;
        int num2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dame el primer numero");
        num1=scanner.nextInt();

        System.out.println("Dame el segundo numero");
        num2=scanner.nextInt();
        int suma =num1+num2;

        System.out.println("La suma de: "+ num1 + " con: " + num2 +" es: "+suma);
    }
}
