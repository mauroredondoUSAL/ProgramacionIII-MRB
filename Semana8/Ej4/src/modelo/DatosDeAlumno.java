package modelo;

public class DatosDeAlumno {
    private DatosPersonales datos;
    private Direccion direccion;

    public DatosDeAlumno(DatosPersonales datos, Direccion direccion) {
        this.datos = datos;
        this.direccion = direccion;
    }

    public DatosPersonales getDatos(){
        return datos;
    }
    public Direccion getDireccion(){
        return direccion;
    }

    // --- FACTORY METHOD GLOBAL ---
    public static DatosDeAlumno crearAlumnoAleatorio() {
        return new DatosDeAlumno(
            DatosPersonales.crearDatosAleatorios(),
            Direccion.crearDireccionAleatoria()
        );
    }
}