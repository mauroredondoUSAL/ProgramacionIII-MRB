package EjercicioCRUDCoches;

import static com.coti.tools.Esdia.*;
import java.util.HashSet;

/**
 *
 * 
 * Ejercicio CRUD Collections. (Con la colección HashSet)
 * 
 * Este ejemplo muestra como hacer en un CRUD en un HashSet con sus
 * peculiaridades.
 * 
 * Al decir que no existan dos objetos iguales, es necesario abordar
 * el tema referente a como definir cuando dos objetos son iguales.
 * 
 * 
 * No se sigue ningún patrón arquitectónico en este ejercicio.
 * 
 * Se realiza todo en la misma clase para mayor claridad, sin embargo
 * esto se aplica a las colecciones que residan en cualquier otro objeto del programa.
 * 
 * 
 * @author Loza
 */
public class HashSetCoches {
    
    private static HashSet<Coche> coches = new HashSet<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Listar coches");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1: agregarCoche(); break;
                case 2: eliminarCoche(); break;
                case 3: modificarCoche(); break;
                case 4: listarCoches(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarCoche() {
        String marca = readString_ne("Ingrese la marca del coche: ");
        int caballos = readInt("Ingrese los caballos del coche: ");
        String matricula = readString_ne("Ingrese la matricula del coche (ej. 1.75): ");

        Coche nuevoCoche = new Coche(marca, caballos, matricula);
        // Add devuelve false si la coche añadida ya está en el Set
        // Para que la coche sea igual a otra es necesario implementar equals y hash
        // Consulta la clase Coche y los métodos implementados al final de esta.
        if (!coches.add(nuevoCoche)) {
            System.out.println("Coche con esa marca ya existe.");
        }
    }

    public static void eliminarCoche() {
        String matricula = readString_ne("Ingrese la matricula del coche a eliminar: ");
        Coche cocheAEliminar = new Coche(matricula, 0, 0); // Valores temporales solo para comparación
        // Equals y HashCode se han implementado solo teniendo en cuenta el marca
        if (!coches.remove(cocheAEliminar)) {
            System.out.println("Coche no encontrado.");
        } else {
            System.out.println("Coche eliminado.");
        }
    }

    public static void modificarCoche() {
        String marca = readString_ne("Ingrese la marca del coche a modificar: ");

        Coche cocheAModificar = new Coche(marca, 0, 0); // Valores temporales solo para comparación
        // Aquí sucede lo mismo.
        if (!coches.contains(cocheAModificar)) {
            System.out.println("Coche no encontrada.");
            return;
        }

        // Continuación de la lógica para modificar los datos
        String nuevomarca = readString_ne("Ingrese el nuevo marca: ");
        int nuevaEdad = readInt("Ingrese la nueva caballos: ");
        System.out.print("Ingrese la nueva matricula (ej. 1.75): ");
        String nuevaAltura = readString("Ingrese la nueva matricula (ej. 1.75): ");

        // Solo es necesario el marca para que dos coches sean iguales
        coches.remove(cocheAModificar);
        coches.add(new Coche(nuevomarca, nuevaEdad, nuevaAltura));
    }

    public static void listarCoches() {

        // Si está vacío, no se puede recorrer
        if (coches.isEmpty()) {
            System.out.println("No hay coches para mostrar.");
            return;
        }

        for (Coche coche : coches) {
            System.out.println(String.format("HashCode:%10d - %s",coche.hashCode(), coche.getEstadoComoString()));
        }
    }
    
}
