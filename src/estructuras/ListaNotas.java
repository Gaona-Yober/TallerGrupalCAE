package estructuras;

public class ListaNotas {
    private Nota cabeza; // primer nodo de la lista

    public ListaNotas() {
        this.cabeza = null;
    }

    //insertar al inicio
    public void insertarNotaInicio(String texto) {
        Nota nuevaNota = new Nota(texto);
        nuevaNota.setSiguiente(cabeza);
        cabeza = nuevaNota;
        System.out.println("Nota insertada al inicio: " + texto);
    }

    //eliminar primera coincidencia
    public void eliminarPrimeraCoincidencia(String texto) {


        //si no hay notas
        if (cabeza == null) {
            System.out.println("La lista está vacía. No se puede eliminar.");
            return;
        }


        //si la nota a eliminar es la cabeza
        if (cabeza.getTexto().equalsIgnoreCase(texto)) {
            cabeza = cabeza.getSiguiente();
            System.out.println("Nota eliminada: " + texto);
            return;
        }


        //buscar mas coincidencias
        Nota actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getTexto().equalsIgnoreCase(texto)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                System.out.println("Nota eliminada: " + texto);
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("Nota no encontrada: " + texto);
    }


    //mostrar toddas las notas
    public void mostrarNotas() {
        if (cabeza == null) {
            System.out.println("No hay notas para mostrar.");
            return;
        }

        System.out.println("Notas en la lista:");
        Nota actual = cabeza;
        while (actual != null) {
            System.out.println("- " + actual.getTexto());
            actual = actual.getSiguiente();
        }
    }
}
