public class Deposito {
    private final int capacidadMaxima; //Final -> para que no se pueda modificar
    private int cafeActuales = 0;
    private int idCafeActual = 1; //para llevar la cuenta de qué café se entrega

    public Deposito(int capacidad) {
        this.capacidadMaxima = capacidad;
    }

    // Método para la cafetera (Productor)
    public synchronized void dejarCafe() {
        while (cafeActuales == capacidadMaxima) {
            System.out.println("\t--- DEPOSITO LLENO --- La cafetera espera...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cafeActuales++;
        System.out.println("Cafetera prepara y deposita Cafe-" + idCafeActual + " | En depósito: " + cafeActuales);
        idCafeActual++;

        notifyAll(); // Avisa a los profesores de que ya hay café
    }

    // Método para el profesor (Consumidor)
    public synchronized int retirarCafe(String nombreProfesor){
        while (cafeActuales == 0) {
            System.out.println("\t... " + nombreProfesor + " espera café | DEPOSITO VACIO");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int idEntregado = idCafeActual - cafeActuales;
        cafeActuales--;
        System.out.println(">> Profesor " + nombreProfesor + " retira Cafe-" + idEntregado + " | En depósito: " + cafeActuales);

        notifyAll(); // Avisa a la cafetera de que hay espacio libre
        return idEntregado;
    }
}