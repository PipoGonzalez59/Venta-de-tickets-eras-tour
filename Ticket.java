import java.util.Random;

public class Ticket {
    private int numero;

    public Ticket() {
        Random rand = new Random();
        this.numero = rand.nextInt(15000) + 1;
    }

    public int getNumero() {
        return numero;
    }

    public boolean esApto() {
        Random rand = new Random();
        int a = rand.nextInt(15000) + 1;
        int b = rand.nextInt(15000) + 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return numero >= min && numero <= max;
    }
}