import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        Comprador comprador = null;

        int opcion = 0;

        do {
            System.out.println("\n----- MENÚ -----");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Cantidad de boletos: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Presupuesto: ");
                    float presupuesto = sc.nextFloat();
                    comprador = new Comprador(nombre, email, cantidad, presupuesto);
                    break;
                case 2:
                    if (comprador == null) {
                        System.out.println("Primero crea un comprador.");
                    } else {
                        sistema.solicitarBoletos(comprador);
                    }
                    break;
                case 3:
                    sistema.mostrarDisponibilidad();
                    break;
                case 4:
                    System.out.println("Selecciona localidad (0, 1 o 2): ");
                    int index = sc.nextInt();
                    sistema.mostrarDisponibilidadIndividual(index);
                    break;
                case 5:
                    System.out.println("Total generado: $" + sistema.reporteCaja());
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
