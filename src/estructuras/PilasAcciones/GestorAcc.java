package estructuras.PilasAcciones;

public class GestorAcc {
    private PilaAcc pilaUndo = new PilaAcc();
    private PilaAcc pilaRedo = new PilaAcc(); 

    public void registrarAccion(Accion accion) {
        pilaUndo.push(accion);
        pilaRedo = new PilaAcc(); // Limpiar la pila de redo al registrar una nueva acción
    }

    public Accion deshacer() {
        if (pilaUndo.isEmpty()) {
            return null; // No hay acciones para deshacer
        }
        Accion accion = pilaUndo.pop();
        pilaRedo.push(accion);
        revertirAccion(accion);

        return accion;
    }

    public Accion rehacer() {
        if (pilaRedo.isEmpty()) {
            return null; // No hay acciones para rehacer
        }
        Accion accion = pilaRedo.pop();
        pilaUndo.push(accion);
        aplicarAccion(accion);
        return accion;
    }

    private void revertirAccion(Accion accion) {
        switch (accion.getTipo()) {
            case AGREGAR:
                System.out.println("Deshacer: eliminar nota '" + accion.getDatoNuevo() + "'");
                break;
            case ELIMINAR:
                System.out.println("Deshacer: agregar nota '" + accion.getDatoAnterior() + "'");
                break;
            case MODIFICAR:
                System.out.println("Deshacer: restaurar nota de '" + accion.getDatoNuevo() + "' a '" + accion.getDatoAnterior() + "'");
                break;
        }
    }
    
    private void aplicarAccion(Accion accion) {
        switch (accion.getTipo()) {
            case AGREGAR:
                System.out.println("Rehacer: agregar nota '" + accion.getDatoNuevo() + "'");
                break;
            case ELIMINAR:
                System.out.println("Rehacer: eliminar nota '" + accion.getDatoAnterior() + "'");
                break;
            case MODIFICAR:
                System.out.println("Rehacer: cambiar nota de '" + accion.getDatoAnterior() + "' a '" + accion.getDatoNuevo() + "'");
                break;
        }
    }

}

