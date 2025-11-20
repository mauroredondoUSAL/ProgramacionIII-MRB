package paquete;
import java.io.Console;

public class App {
    public static void main(String[] args) throws Exception {
       
        Console console = System.console();

       String nacimientoString=console.readLine("Indica tu año de nacimiento: ");
       String actualString=console.readLine("Indica ahora el año actual: ");
       int nacimiento=Integer.parseInt(nacimientoString);
       int actual=Integer.parseInt(actualString);
       int edad=actual-nacimiento;
       console.printf("Tu edad es: %d", edad);



    }
}
