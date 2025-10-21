package estructuras;

import modelo.Ticket;
import java.util.LinkedList;
import java.util.Queue;

public class ColaTickets {
    private Queue<Ticket> cola;

    public ColaTickets() {
        cola = new LinkedList<>();
    }

    public void agregarTicket(Ticket ticket) {
        cola.offer(ticket);
    }

    public Ticket atenderTicket() {
        return cola.poll();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public Ticket verSiguiente() {
        return cola.peek();
    }

    public void mostrarCola() {
        if (cola.isEmpty()) {
            System.out.println("No hay casos en espera.");
            return;
        }
        System.out.println("Casos pendientes:");
        for (Ticket t : cola) {
            System.out.println("- " + t);
        }
    }
}