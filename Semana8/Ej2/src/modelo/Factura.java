package modelo;

public class Factura {

    // Atributos
    private String concepto;
    private double descuento; // Ejemplo: 0.05 para 5%
    private String fecha;
    private double importeBase;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva; // Ejemplo: 0.21 para 21%

    // Constructor
    public Factura(String concepto, double descuento, String fecha, double importeBase,
                String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importeBase = importeBase;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    // --- LÓGICA DE NEGOCIO ---
    
    public double getImporteTotal() {
        return importeBase * (1 - descuento) * (1 + iva);
    }

    // getters y setters
    
    public String getConcepto(){
        return concepto;
    }
    public double getDescuento(){
        return descuento;
    }
    public String getFecha(){
        return fecha;
    }
    public double getImporteBase(){
        return importeBase;
    }
    public String getNif(){
        return nif;
    }
    public String getNombreCliente(){
        return nombreCliente;
    }
    public String getDireccion(){
        return direccion;
    }
    public double getIva(){
        return iva;
    }
    
    // Método toString para depuración rápida
    @Override
    public String toString() {
        return String.format("Cliente: %s | Total: %.2f€", nombreCliente, getImporteTotal());
    }
}