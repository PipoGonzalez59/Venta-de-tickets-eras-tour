public class Localidad {
    private String nombre;
    private float precio;
    private int aforo;
    private int vendidos;

    public Localidad(String nombre, float precio, int aforo) {
        this.nombre = nombre;
        this.precio = precio;
        this.aforo = aforo;
        this.vendidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getDisponible() {
        return aforo - vendidos;
    }

    public boolean getEspacio(int cantidad) {
        return (vendidos + cantidad) <= aforo;
    }

    public boolean xPagar(float presupuesto, int cantidad) {
        return (precio * cantidad) <= presupuesto;
    }

    public int venderBoletos(int cantidad) {
        int disponibles = getDisponible();
        int aVender = Math.min(disponibles, cantidad);
        vendidos += aVender;
        return aVender;
    }

    public int getVendidos() {
        return vendidos;
    }
}