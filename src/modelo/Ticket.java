package modelo;

import java.util.UUID;
import estructuras.ListaNotas;

public class Ticket {

    private String id;
    private String nombreEstudiante;
    private EstadoTicket estado;
    private ListaNotas notas;


    public Ticket(String nombreEstudiante) {
        this.id = UUID.randomUUID().toString();
        this.nombreEstudiante = nombreEstudiante;
        this.estado = EstadoTicket.EN_COLA;
        this.notas = new ListaNotas(); // inicializa lista vacía
    }

    // Metodos requeridos

    public void agregarNota(String texto) {
        notas.insertarNotaInicio(texto);
    }

    public void eliminarNota(String texto) {
        notas.eliminarPrimeraCoincidencia(texto);
    }

    public void cambiarEstado(String nuevoEstado) {
        try {
            EstadoTicket estadoValido = EstadoTicket.valueOf(nuevoEstado.toUpperCase());
            this.estado = estadoValido;
            System.out.println("Estado cambiado a: " + estadoValido);
        } catch (IllegalArgumentException e) {
            System.out.println("Estado no válido: " + nuevoEstado + ". No se realizo el cambio.");
        }
    }

    public void mostrarHistorial() {
        System.out.println("Historial del Ticket");
        System.out.println("ID: " + id);
        System.out.println("Estudiante: " + nombreEstudiante);
        System.out.println("Estado actual: " + estado);
        notas.mostrarNotas();
    }

    public String getId() { return id; }
    public String getNombreEstudiante() { return nombreEstudiante; }
    public EstadoTicket getEstado() { return estado; }
    public ListaNotas getNotas() { return notas; }
}
