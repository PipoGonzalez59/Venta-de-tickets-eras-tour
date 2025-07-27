import java.util.ArrayList;
import java.util.Random;

public class Sistema {
    private ArrayList<Localidad> localidades;
    private Random random;

    public Sistema() {
        localidades = new ArrayList<>();
        localidades.add(new Localidad("Localidad 1", 100, 20));
        localidades.add(new Localidad("Localidad 5", 500, 20));
        localidades.add(new Localidad("Localidad 10", 1000, 20));
        random = new Random();
    }

    public void mostrarDisponibilidad() {
        for (Localidad l : localidades) {
            System.out.println(l.getNombre() + ": " + l.getDisponible() + " disponibles");
        }
    }

    public void mostrarDisponibilidadIndividual(int index) {
        if (index >= 0 && index < localidades.size()) {
            Localidad l = localidades.get(index);
            System.out.println(l.getNombre() + ": " + l.getDisponible() + " disponibles");
        }
    }

    public float reporteCaja() {
        float total = 0;
        for (Localidad l : localidades) {
            total += l.getVendidos() * l.getPrecio();
        }
        return total;
    }

    public void solicitarBoletos(Comprador comprador) {
        Ticket ticket = new Ticket();
        System.out.println("Tu número de ticket es: " + ticket.getNumero());

        if (!ticket.esApto()) {
            System.out.println("Lo sentimos, tu ticket no fue apto.");
            return;
        }

        Localidad localidad = localidades.get(random.nextInt(localidades.size()));
        System.out.println("Te tocó: " + localidad.getNombre());

        if (localidad.getDisponible() == 0) {
            System.out.println("Ya no hay espacio en esa localidad.");
            return;
        }

        int cantidad = comprador.getCantidadTickets();
        if (!localidad.getEspacio(cantidad)) {
            System.out.println("No hay suficientes espacios. Se venderán los que queden.");
        }

        if (!localidad.xPagar(comprador.getPresupuesto(), cantidad)) {
            System.out.println("No alcanza tu presupuesto.");
            return;
        }

        int vendidos = localidad.venderBoletos(cantidad);
        System.out.println("Se vendieron " + vendidos + " boletos.");
    }
}

