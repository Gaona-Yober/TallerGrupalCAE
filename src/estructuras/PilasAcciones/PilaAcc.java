package estructuras.PilasAcciones;

public class PilaAcc {
    private NodoAcc cima;

    private class NodoAcc {
        Accion accion;
        NodoAcc siguiente;

        NodoAcc(Accion accion) {
            this.accion = accion;
            this.siguiente = null;
        }
    }

    public PilaAcc() {
        this.cima = null;
    }

    public void push(Accion accion) {
        NodoAcc nuevoNodo = new NodoAcc(accion);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public Accion pop() {
        if (isEmpty()) {
            return null;
        }
        Accion accion = cima.accion;
        cima = cima.siguiente;
        return accion;
    }

    public Accion peek() {
        if (isEmpty()) {
            return null;
        }
        return cima.accion;
    }

    public boolean isEmpty() {
        return cima == null;
    }
}
