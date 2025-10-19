package modelo;
public class Ticket {
    private String id;
    private String estudiante;
    private EstadoTicket estado;

    public Ticket(String id, String estudiante) {
        this.id = id;
        this.estudiante = estudiante;
        this.estado = EstadoTicket.EN_COLA; // Por defecto
    }

    public void setEstado(EstadoTicket estado) {
        this.estado = estado;
    }

    public EstadoTicket getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "[" + id + " - " + estudiante + "] (" + estado + ")";
    }
}