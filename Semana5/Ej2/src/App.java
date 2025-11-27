import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lista = new String[5];

        System.out.println("Introduce 5 palabras, pulsando enter con cada una:");

        for (int i = 0; i < lista.length; i++) { //Esto rellena el array
            lista[i] = scanner.nextLine();
        }

        Arrays.sort(lista, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println("Aquí tienes tus palabras ordenadas alfabéticamente: ");

        // Esto muestra el array
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}
