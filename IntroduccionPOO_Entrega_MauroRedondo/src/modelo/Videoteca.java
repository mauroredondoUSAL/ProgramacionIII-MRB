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
        if (peliculas == null) {
            System.out.println("No hay videoteca creada.");
            return;
        }
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                System.out.printf("%d) %s%n", i + 1, peliculas[i].infoPelicula());
            }
        }
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