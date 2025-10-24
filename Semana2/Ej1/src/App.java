import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    

    System.out.print("Indica tu año de nacimiento");
    int nacimiento=scanner.nextInt();
    System.out.print("Indica ahora el año actual ");
    int actual=scanner.nextInt();
    int edad=actual-nacimiento;
    System.out.print("Tu edad es "+edad);


    }
}
