public class Main {
    public static void main(String[] args) {
        //Recurso compartido - capacidad para 5 cafés
        Deposito deposito = new Deposito(5);

        //Creo los hilos (Extends Thread)
        Cafetera cafetera = new Cafetera(deposito, 20);

        //Reparto los 20 cafés entre los profesores
        Profesor ana = new Profesor("Ana", deposito, 7);
        Profesor luis = new Profesor("Luis", deposito, 6);
        Profesor marta = new Profesor("Marta", deposito, 7);

        //Inicio los hilos
        cafetera.start();
        ana.start();
        luis.start();
        marta.start();

        try {
            cafetera.join();
            ana.join();
            luis.join();
            marta.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nFin del programa - Joanne Zamorano");
    }
}
