import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {

        int N;
        // Pedir N hasta que sea válido
        while (N <= 0) {

            N = Esdia.readInt("Introduce un número entero mayor que 0: ");
            
            if (N <= 0) {
                System.err.println("Error: el número debe ser mayor que 0.");
            }
        }


        double suma = 0;

        // Pedir N números de coma flotante
        for (int i = 1; i <= N; i++) {
            double x = Esdia.readDouble("Número " + i + ": ");
            suma += x;
        }

        double media = suma / N;
        System.out.println("La media aritmética es: " + media);
    }
}

