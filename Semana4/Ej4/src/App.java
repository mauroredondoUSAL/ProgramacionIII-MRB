import com.coti.tools.Esdia;

public class App {

    public static void main(String[] args) {

        int numAlumnos = Esdia.readInt("Indica el número de alumnos que tiene la clase: ");

        Alumno[] alumnos = new Alumno[numAlumnos];

        // Entrada de datos
        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("\n--- Alumno " + (i + 1) + " ---");

            String nombre = Esdia.readString("Introduce el nombre del alumno: ");
            double parcial1 = Esdia.readDouble("Introduce la nota del primer parcial: ");
            double parcial2 = Esdia.readDouble("Introduce la nota del segundo parcial: ");
            double examenfinal = Esdia.readDouble("Introduce la nota del examen final: ");

            alumnos[i] = new Alumno(nombre, parcial1, parcial2, examenfinal);
        }

        // Mostrar tabla
        System.out.println("\n==========================================================");
        System.out.println("                     LISTADO ALUMNOS                      ");
        System.out.println("==========================================================");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s\n",
                "Nombre", "Nota 1", "Nota 2", "Nota 3", "Media");
        System.out.println("----------------------------------------------------------");

        for (Alumno a : alumnos) {
            System.out.printf("%-15s %-10.2f %-10.2f %-10.2f %-10.2f\n",
                    a.getNombre(),
                    a.getParcial1(),
                    a.getParcial2(),
                    a.getExamenFinal(),
                    a.calcularNotaFinal());
        }

    }
}
