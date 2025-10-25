package modelo;

public class Videoteca {
    private Pelicula[] peliculas;
    private int numPeliculas;
    private double velocidad;


    public Videoteca() {
        this.peliculas = null;
        this.numPeliculas = 0;
        this.velocidad = 1.0;
    }

    
    public void crearNuevaVideoteca(int tamanyo) {
        if (tamanyo <= 0) {
            System.err.println("El tamaño debe ser mayor que 0.");
        return;
        }
        this.peliculas = new Pelicula[tamanyo]; 
        this.numPeliculas = 0;
        
    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public int getNumPeliculas() {
        return numPeliculas;
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

    
    public int capacidad() {
        return peliculas == null ? 0 : peliculas.length;
    }

    
    public boolean estaInicializada() {
        return peliculas != null;
    }

    
    public int numPeliculas() {
        return numPeliculas;
    }

    
    public void mostrarPeliculas() {
        if (peliculas == null || numPeliculas == 0) {
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
        int peliculasContadas = 0;
        for (int i = 0; i < peliculas.length; i++) {
            Pelicula p = peliculas[i];
            if (p != null) {
                String director = "";
                String oscar = "";
                try {
                    director = p.getDirector().getNombre() + " " + p.getDirector().getApellidos();
                    oscar = p.getDirector().esOscarGanado() ? "Sí" : "No";
                } catch (Exception e) {
                    director = "-";
                    oscar = "-";
                }
                double tiempoVisionado = 0;
                try {
                    tiempoVisionado = p.getDuracionMin() / this.velocidad;
                } catch (Exception e) {
                    tiempoVisionado = 0;
                }
                sumaVisionado += tiempoVisionado;
                sumaValoracion += p.getValoracion();
                peliculasContadas++;

                System.out.printf("| %-30s | %-12d | %-20s | %-13s | %-15d | %-23.2f | %-10.2f |\n",
                        p.getTitulo(), p.getAnoEstreno(), director, oscar, p.getDuracionMin(), tiempoVisionado, p.getValoracion());
            }
        }
    System.out.println(separador);
    System.out.printf("| Tiempo de visionado total de la videoteca: %-8.2f min %-85s |\n", sumaVisionado, "");
    System.out.printf("| Valoración total de la videoteca: %-8.2f %-98s |\n", (peliculasContadas > 0 ? sumaValoracion / peliculasContadas : 0), "");
    System.out.println(separador);
    }

    
    public boolean anadirPelicula(Pelicula p) {
        if (peliculas == null) {
            System.out.println("Primero crea una videoteca (opción 1).");
            return false;
        }
        if (numPeliculas >= peliculas.length) {
            System.out.println("La videoteca está llena.");
            return false;
        }
        // Inserción en la primera posición null (ejemplo sencillo)
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] == null) {
                peliculas[i] = p;
                numPeliculas++;
                return true;
            }
        }
        return false;
    }
}