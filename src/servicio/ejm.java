import estructuras.ColaTickets;
import estructuras.ListaNotas;
import estructuras.PilaAcciones;
import modelo.Ticket;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaTickets cola = new ColaTickets();
        PilaAcciones<String> acciones = new PilaAcciones<>();
        ListaNotas notas = new ListaNotas();

        int opcion;
        do {
            System.out.println("\n=== Sistema CAE - Consola Principal ===");
            System.out.println("1. Registrar nuevo caso");
            System.out.println("2. Atender caso");
            System.out.println("3. Añadir / eliminar nota");
            System.out.println("4. Deshacer / rehacer");
            System.out.println("5. Finalizar atención");
            System.out.println("6. Consultar historial");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese descripción del caso: ");
                    String desc = sc.nextLine();
                    Ticket nuevo = new Ticket(desc);
                    cola.agregarTicket(nuevo);
                    acciones.registrarAccion("Registrar caso: " + desc);
                    System.out.println("✅ Caso registrado con éxito.");
                    break;

                case 2:
                    if (!cola.estaVacia()) {
                        Ticket atendido = cola.atenderTicket();
                        acciones.registrarAccion("Atender caso: " + atendido.getDescripcion());
                        System.out.println("🩺 Atendiendo caso: " + atendido.getDescripcion());
                    } else {
                        System.out.println("⚠️ No hay casos por atender.");
                    }
                    break;

                case 3:
                    System.out.println("1. Añadir nota");
                    System.out.println("2. Eliminar nota");
                    System.out.print("Seleccione: ");
                    int sub = sc.nextInt();
                    sc.nextLine();

                    if (sub == 1) {
                        System.out.print("Ingrese texto de la nota: ");
                        String texto = sc.nextLine();
                        notas.agregarNota(texto);
                        acciones.registrarAccion("Añadir nota: " + texto);
                        System.out.println("📝 Nota añadida.");
                    } else if (sub == 2) {
                        notas.eliminarUltimaNota();
                        acciones.registrarAccion("Eliminar última nota");
                        System.out.println("🗑️ Nota eliminada.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 4:
                    System.out.println("1. Deshacer");
                    System.out.println("2. Rehacer");
                    System.out.print("Seleccione: ");
                    int sub2 = sc.nextInt();
                    sc.nextLine();

                    if (sub2 == 1) {
                        String acc = acciones.deshacer();
                        if (acc != null) System.out.println("↩️ Deshecho: " + acc);
                        else System.out.println("Nada que deshacer.");
                    } else if (sub2 == 2) {
                        String acc = acciones.rehacer();
                        if (acc != null) System.out.println("↪️ Rehecho: " + acc);
                        else System.out.println("Nada que rehacer.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 5:
                    System.out.println("✅ Atención finalizada. Guardando cambios...");
                    acciones.registrarAccion("Finalizar atención");
                    break;

                case 6:
                    System.out.println("📜 === Historial de notas ===");
                    notas.mostrarNotas();
                    break;

                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
