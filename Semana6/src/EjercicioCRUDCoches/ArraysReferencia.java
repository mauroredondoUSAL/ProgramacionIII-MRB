package EjercicioCRUDCoches;

import static com.coti.tools.Esdia.*;

/**
 *
 * 
 * Ejercicio CRUD Arrays. (Con tipos de Referencia, en este caso clase Coche)
 * 
 * Ejercicio para ejemplificar altas, bajas, modificaciones y listados
 * empleando Arrays y la clase utilidad Arrays.
 * 
 * Se podrá comprobar que rápidamente la gestión de un simple CRUD se complica
 * demasiado frente al mismo ejercicio realizado con Colecciones como ArrayList
 * 
 * Por lo general se emplearán colecciones para este propósito.
 * 
 * No se sigue ningún patrón arquitectónico en este ejercicio.
 * 
 * Se realiza todo en la misma clase para mayor claridad, sin embargo
 * esto se aplica a los Arrays que residan en cualquier otro objeto del programa.
 * 
 * 
 * @author Loza
 */
public class ArraysReferencia {
    
    private static final int MAX_SIZE = 5;
    private static Coche[] coches = new Coche[MAX_SIZE];
    private static int cocheCount = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Listar coches");
            System.out.println("5. Salir");1
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
        if (cocheCount < MAX_SIZE) {
            String marca = readString_ne("Ingrese la marca del coche: ");
            int caballos = readInt("Ingrese los caballos del coche: ");
            String matricula = readString_ne("Ingrese la matricula del coche: ");
            coches[cocheCount++] = new Coche(marca, caballos, matricula);
            System.out.println("Coche añadido correctamente.");
        } else {
            System.out.println("Array de coches está lleno.");
        }
    }

    public static void eliminarCoche() {
        String matricula = readString_ne("Ingrese la matricula del coche a eliminar: ");
        boolean encontrado = false;
        for (int i = 0; i < cocheCount; i++) {
            // Para comparar cadenas empleamos equals
            if (coches[i].getMatricula().equals(matricula)) {
                encontrado = true;
                for (int j = i; j < cocheCount - 1; j++) {
                    coches[j] = coches[j + 1];
                }
                cocheCount--;

                System.out.println("Coche eliminado correctamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Coche no encontrada.");
        }
    }

    public static void modificarCoche() {

        String matricula = readString_ne("Ingrese la matricula del coche a modificar: ");
        boolean encontrado = false;
        for (int i = 0; i < cocheCount; i++) {
            if (coches[i].getMatricula().equals(matricula)) {
                String nuevaMarca = readString_ne("Ingrese la nueva marca: ");
                int nuevosCaballos = readInt("Ingrese los nuevos caballos: ");
                String nuevaMatricula = readString_ne("Ingrese la nueva matrícula: ");

                coches[i].setMarca(nuevaMarca);
                coches[i].setCaballos(nuevosCaballos);
                coches[i].setMatricula(nuevaMatricula);

                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void listarCoches() {

        if (cocheCount == 0) {
            System.out.println("No hay coches en el array.");
            return;
        }

        for (int i = 0; i < cocheCount; i++) {
            System.out.println(coches[i].getEstadoComoString());
        }
    }
    
}
