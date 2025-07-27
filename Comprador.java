public class Comprador {
    private String nombre;
    private String email;
    private int cantidadTickets;
    private float presupuesto;

    public Comprador(String nombre, String email, int cantidadTickets, float presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadTickets = cantidadTickets;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidadTickets() {
        return cantidadTickets;
    }

    public float getPresupuesto() {
        return presupuesto;
    }
}
