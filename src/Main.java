import estructuras.PilasAcciones.GestorAcc;

public class Main {

    public static void main(String[] args) {
        GestorAcc gestor = new GestorAcc();

        System.out.println("Registrando acciones...");

        gestor.registrarAccion(new estructuras.PilasAcciones.Accion(estructuras.PilasAcciones.Accion.TipoAccion.AGREGAR, null, "Verificar documentos"));
        gestor.registrarAccion(new estructuras.PilasAcciones.Accion(estructuras.PilasAcciones.Accion.TipoAccion.MODIFICAR, "Verificar documentos", "Revisar documentos actualizados"));

        gestor.deshacer();
        gestor.deshacer();

        gestor.rehacer();
    }
}