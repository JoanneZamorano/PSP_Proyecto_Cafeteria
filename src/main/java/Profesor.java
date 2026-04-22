public class Profesor extends Thread {
    private final String nombre;
    private final Deposito deposito;
    private final int cafesABeber;

    public Profesor(String nombre, Deposito deposito, int cantidad) {
        this.nombre = nombre;
        this.deposito = deposito;
        this.cafesABeber = cantidad;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < cafesABeber; i++) {
                deposito.retirarCafe(nombre);
                Thread.sleep((long) (Math.random() * 10000)); //tiempo simulado para beber el café
                //Tiene que ser mayor que el tiempo de preparado del café porque si no no me salen cafés en depósito
            }
            System.out.println("\n>> " + nombre + " ya ha tomado todos sus cafés\n");
        } catch (InterruptedException e) {
            System.err.println("*** " + nombre + " interrumpido ***");
        }
    }
}

