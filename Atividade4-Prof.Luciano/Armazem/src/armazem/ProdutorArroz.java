package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class ProdutorArroz implements Runnable {

    JProgressBar arroz;
    private int contador = 0;

    public ProdutorArroz(JProgressBar arroz) {
        this.arroz = arroz;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (arroz) {

                try {

                    if (arroz.getValue() >= 60) {
                        arroz.notifyAll();
                        arroz.wait();
                        new Thread(new ConsumidorArroz(arroz)).start();
                        contador++;
                        System.out.println(Integer.toString(contador) + " ConsumoArroz");
                        System.out.println(Thread.activeCount() + " Threads ativas[ARROZ]...");
                        System.out.println("===========================");
                    }

                    arroz.setValue(arroz.getValue() + 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProdutorArroz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
