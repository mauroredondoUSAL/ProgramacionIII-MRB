package vista;
import com.coti.tools.Esdia;

import modelo.Partido;
import modelo.Quiniela;


public class Vista {

        
/*// Método para pedir un solo partido completo (Para la V1)
    public static Partido pedirPartido(int numeroPartido) {
        System.out.println("\n--- DATOS DEL PARTIDO " + numeroPartido + " ---");
        
        String local = Esdia.readString("Introduce el equipo local: ");
        String visitante = Esdia.readString("Introduce el equipo visitante: ");
        int golesL = Esdia.readInt("Goles de " + local + ": ");
        int golesV = Esdia.readInt("Goles de " + visitante + ": ");
        
        // La vista crea el objeto con los datos que recogió y lo devuelve
        return new Partido(local, visitante, golesL, golesV);
    }*/
    // Método para la V2: Ya conocemos los equipos, solo pedimos goles
    public static void pedirGoles(Partido p) {
        System.out.println("\n--- PARTIDO: " + p.getEquipoLocal() + " vs " + p.getEquipoVisitante() + " ---");
        
        // Pedimos solo los números
        int golesL = Esdia.readInt("Goles " + p.getEquipoLocal() + ": ");
        int golesV = Esdia.readInt("Goles " + p.getEquipoVisitante() + ": ");
        
        // Actualizamos el objeto que nos han pasado
        p.setGolesLocal(golesL);
        p.setGolesVisitante(golesV);
    }

    // Método para mostrar la quiniela final
    public static void mostrarQuiniela(Quiniela quiniela) {
        System.out.println("\nResultados de la Quiniela:");
        // La vista pide al modelo el String de la tabla y lo imprime
        System.out.println(quiniela.obtenerTablaQuiniela());
    }



}
