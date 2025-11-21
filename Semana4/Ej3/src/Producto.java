public class Producto {

    private String nombre;
    private double precioSinIVA;
    private double precioConIVA;

    private final double IVA = 0.21;  // 21%

    // Constructor
    public Producto(String nombre, double precioSinIVA) {
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
        this.precioConIVA = precioSinIVA * (1 + IVA);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    public double getPrecioConIVA() {
        return precioConIVA;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioSinIVA(double precioSinIVA) {
        this.precioSinIVA = precioSinIVA;
        this.precioConIVA = precioSinIVA * (1 + IVA);
    }
}
