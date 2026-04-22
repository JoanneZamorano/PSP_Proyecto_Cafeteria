public class Cafetera extends Thread {
    private final Deposito deposito;
    private final int totalAProducir; //limite de café diario

    public Cafetera(Deposito deposito, int total) {
        this.deposito = deposito;
        this.totalAProducir = total;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < totalAProducir; i++) {
                Thread.sleep(500); //tiempo de preparación
                deposito.dejarCafe();
            }
            System.out.println("\n------- Limite de cafés diarios ------- \n");
        } catch (InterruptedException e) {
            System.err.println("**** Cafetera interrumpida ****");
        }
    }
}

