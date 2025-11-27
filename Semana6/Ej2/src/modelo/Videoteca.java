package modelo;

import java.util.ArrayList;

public class Videoteca {

    private ArrayList<Pelicula> peliculas;
    private double velocidad;

    public Videoteca() {
        this.peliculas = null; // indicamos que aún no está creada
        this.velocidad = 1.0;
    }

    //Crear
    public void crearNuevaVideoteca(int tamanyoIgnorado) {
        this.peliculas = new ArrayList<>();
        System.out.println("Nueva videoteca creada (sin límite de capacidad).");
    }

    public boolean estaInicializada() {
        return peliculas != null;
    }

    public int numPeliculas() {
        return peliculas == null ? 0 : peliculas.size();
    }

    public int capacidad() {
        //devolvemos -1 para indicar "ilimitado"
        return peliculas == null ? 0 : -1;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        if (velocidad <= 0) {
            throw new IllegalArgumentException("La velocidad debe ser mayor que 0.");
        }
        this.velocidad = velocidad;
    }

    //Añadir película
    public boolean anadirPelicula(Pelicula p) {
        if (peliculas == null) {
            System.out.println("Primero debes crear una videoteca (opción 1).");
            return false;
        }
        peliculas.add(p);
        return true;
    }

    //Mostrar
    public void mostrarPeliculas() {
        if (peliculas == null || peliculas.isEmpty()) {
            System.out.println("No hay películas en la videoteca.");
            return;
        }

        String separador = "|-----------------------------------------------------------------------------------------------------------------------------------------------|";
        System.out.println(separador);
        System.out.printf("|  %-140s |\n","PELÍCULAS EN LA VIDEOTECA" );
        System.out.println(separador);
        System.out.printf("| %-30s | %-12s | %-20s | %-13s | %-15s | %-23s | %-10s |\n",
                "Título", "Año Estreno", "Director", "Oscar ganado", "Duración (min)", "Tiempo visionado (min)", "Valoración");
        System.out.println(separador);

        double sumaValoracion = 0;
        double sumaVisionado = 0;

        for (Pelicula p : peliculas) {

            String director = p.getDirector().getNombre() + " " + p.getDirector().getApellidos();
            String oscar = p.getDirector().esOscarGanado() ? "Sí" : "No";
            double tiempoVisionado = p.getDuracionMin() / this.velocidad;

            sumaVisionado += tiempoVisionado;
            sumaValoracion += p.getValoracion();

            System.out.printf("| %-30s | %-12d | %-20s | %-13s | %-15d | %-23.2f | %-10.2f |\n",
                    p.getTitulo(), p.getAnoEstreno(), director, oscar,
                    p.getDuracionMin(), tiempoVisionado, p.getValoracion());
        }

        System.out.println(separador);
        System.out.printf("| Tiempo de visionado total de la videoteca: %-8.2f min %-85s |\n", sumaVisionado, "");
        System.out.printf("| Valoración promedio: %-8.2f %-98s |\n",
                (peliculas.size() > 0 ? sumaValoracion / peliculas.size() : 0), "");
        System.out.println(separador);
    }

    // Modificar película
    public Pelicula getPelicula(int index) {
        if (peliculas == null || index < 0 || index >= peliculas.size()) return null;
        return peliculas.get(index);
    }

    public boolean actualizarPelicula(int index, Pelicula nueva) {
        if (peliculas == null || index < 0 || index >= peliculas.size()) return false;
        peliculas.set(index, nueva);
        return true;
    }

    // Eliminar película
    public boolean eliminarPelicula(int index) {
        if (peliculas == null || index < 0 || index >= peliculas.size()) return false;
        peliculas.remove(index);
        return true;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
}
