package modelo;
public class ColaTickets {
    private NodoTicket frente;
    private NodoTicket fin;

    // Clase interna NodoTicket
    private static class NodoTicket {
        Ticket ticket;
        NodoTicket siguiente;

        NodoTicket(Ticket ticket) {
            this.ticket = ticket;
            this.siguiente = null;
        }
    }

    // Método: enqueue(Ticket nuevo)
    public void enqueue(Ticket nuevo) {
        NodoTicket nuevoNodo = new NodoTicket(nuevo);
        if (fin == null) {
            // Cola vacía
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
        // Actualizar estado del ticket a EN_COLA
        nuevo.setEstado(EstadoTicket.EN_COLA);
    }

    // Método: dequeue()
    public Ticket dequeue() {
        if (frente == null) {
            return null; // Cola vacía
        }
        Ticket ticketAtendido = frente.ticket;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null; // La cola quedó vacía
        }
        // Cambiar estado del ticket a EN_ATENCION
        ticketAtendido.setEstado(EstadoTicket.EN_ATENCION);
        return ticketAtendido;
    }

    // Método: isEmpty()
    public boolean isEmpty() {
        return frente == null;
    }

    // Método: peek()
    public Ticket peek() {
        if (frente == null) {
            return null;
        }
        return frente.ticket;
    }

    // Método auxiliar para mostrar la cola (opcional, útil para pruebas)
    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("-Cola vacía");
            return;
        }
        NodoTicket actual = frente;
        System.out.println("=== Cola de Tickets ===");
        while (actual != null) {
            System.out.println(actual.ticket); // Usa el toString() de Ticket
            actual = actual.siguiente;
        }
    }
}
