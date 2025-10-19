package estructuras.PilasAcciones;

public class Accion {
    public enum TipoAccion {
        AGREGAR,
        ELIMINAR,
        MODIFICAR
    }

    private TipoAccion tipo;
    private Object datoAnterior;
    private Object datoNuevo;

    public Accion(TipoAccion tipo, Object datoAnterior, Object datoNuevo) {
        this.tipo = tipo;
        this.datoAnterior = datoAnterior;
        this.datoNuevo = datoNuevo;
    }

    public TipoAccion getTipo() {
        return tipo;
    }

    public Object getDatoAnterior() {
        return datoAnterior;
    }

    public Object getDatoNuevo() {
        return datoNuevo;
    }
}