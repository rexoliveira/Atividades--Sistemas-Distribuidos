package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class ProdutorMilho implements Runnable {

    JProgressBar milho;
    private int contador = 0;

    public ProdutorMilho(JProgressBar milho) {
        this.milho = milho;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (milho) {

                try {

                    if (milho.getValue() >= 50) {
                        milho.notifyAll();
                        milho.wait();
                        new Thread(new ConsumidorMilho(milho)).start();
                        contador++;
                        System.out.println(Integer.toString(contador) + " ConsumoMilho");
                        System.out.println(Thread.activeCount() + " Threads ativas[MILHO]...");
                        System.out.println("===========================");
                    }

                    milho.setValue(milho.getValue() + 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProdutorArroz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
