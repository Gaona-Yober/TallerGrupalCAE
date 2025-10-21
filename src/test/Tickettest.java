package test;

import modelo.Ticket;

public class Tickettest {
    public static void main(String[] args) {
        Ticket t = new Ticket("Mateo Silva");
        t.agregarNota("Primera observación");
        t.agregarNota("Documentos recibidos");
        t.mostrarHistorial();
        t.cambiarEstado("EN_PROCESO");
        t.eliminarNota("Primera observación");
        t.mostrarHistorial();
    }
}
