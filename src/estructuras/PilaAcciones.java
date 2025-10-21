package estructuras;

import java.util.Stack;

public class PilaAcciones<T> {
    private Stack<T> pilaDeshacer;
    private Stack<T> pilaRehacer;

    public PilaAcciones() {
        pilaDeshacer = new Stack<>();
        pilaRehacer = new Stack<>();
    }

    public void registrarAccion(T accion) {
        pilaDeshacer.push(accion);
        pilaRehacer.clear();
    }

    public T deshacer() {
        if (pilaDeshacer.isEmpty()) return null;
        T ultima = pilaDeshacer.pop();
        pilaRehacer.push(ultima);
        return ultima;
    }

    public T rehacer() {
        if (pilaRehacer.isEmpty()) return null;
        T accion = pilaRehacer.pop();
        pilaDeshacer.push(accion);
        return accion;
    }

    public boolean hayAccionesDeshacer() {
        return !pilaDeshacer.isEmpty();
    }

    public boolean hayAccionesRehacer() {
        return !pilaRehacer.isEmpty();
    }
}