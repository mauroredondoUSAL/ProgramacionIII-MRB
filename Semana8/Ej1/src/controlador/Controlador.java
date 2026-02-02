package controlador;

import java.util.List;

import modelo.Partido;
import modelo.Quiniela;
import vista.Vista;// Asegúrate de que tu clase Vista se llame así

public class Controlador {

   /*  // Método principal que dirige la aplicación de la V1
    public void iniciar() {
        // 1. Instanciamos el Modelo (La Quiniela vacía)
        Quiniela quiniela = new Quiniela();
        
        // Obtenemos la referencia al array de partidos para llenarlo
        Partido[] partidos = quiniela.getPartidos();

        // 2. El Bucle: Lógica de Control
        // Aquí sustituimos el código "sucio" de Exercise5 por llamadas limpias a la Vista
        for (int i = 0; i < partidos.length; i++) {
            
            // LLAMADA A LA VISTA: "Oye Vista, pide los datos del partido X"
            // La vista se encarga de usar Esdia y nos devuelve un objeto Partido listo.
            Partido nuevoPartido = Vista.pedirPartido(i + 1);

            // ACTUALIZACIÓN DEL MODELO: Guardamos el partido en la quiniela
            partidos[i] = nuevoPartido;
        }

        // 3. Finalización: Decimos a la vista que muestre el resultado
        Vista.mostrarQuiniela(quiniela);
    }
}*/


    public void iniciar() {
        // 1. PERSISTENCIA: Cargamos los partidos del fichero
        System.out.println("Cargando partidos desde fichero...");
        List<Partido> listaPartidos = Persistencia.cargarPartidosDesdeFichero();

        // Validación simple
        if (listaPartidos.isEmpty()) {
            System.out.println("No se han cargado partidos. Revisa el fichero.");
            return;
        }

        // Convertimos la Lista a Array (porque tu clase Quiniela usa Array)
        Partido[] arrayPartidos = listaPartidos.toArray(new Partido[0]);
        
        // 2. MODELO: Creamos la quiniela con los partidos YA cargados
        Quiniela quiniela = new Quiniela();
        quiniela.setPartidos(arrayPartidos);

        // 3. BUCLE (CONTROLADOR): Recorremos para pedir resultados
        for (Partido p : arrayPartidos) {
            // Validamos que el partido no sea nulo (por si acaso el array tiene huecos)
            if (p != null) {
                // LLAMADA A VISTA: Pedimos solo los goles
                Vista.pedirGoles(p);
            }
        }

        // 4. MOSTRAR RESULTADO
        Vista.mostrarQuiniela(quiniela);
    }





}
