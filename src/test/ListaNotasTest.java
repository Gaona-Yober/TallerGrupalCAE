package test;

import estructuras.ListaNotas;

public class ListaNotasTest {
    public static void main(String[] args) {
        ListaNotas notas = new ListaNotas();


        notas.insertarNotaInicio("Caso estudiante 4452 en proceso");
        notas.insertarNotaInicio("Caso estudiante 1534 resuelto");
        notas.insertarNotaInicio("Caso estudiante 9821 no existe");
        notas.insertarNotaInicio("Caso estudiante 7389 en espera");

        notas.mostrarNotas();

        notas.eliminarPrimeraCoincidencia("Caso estudiante 1534 resuelto");

        notas.mostrarNotas();

        notas.eliminarPrimeraCoincidencia("Caso estudiante 9999 en espera");



    }
}
