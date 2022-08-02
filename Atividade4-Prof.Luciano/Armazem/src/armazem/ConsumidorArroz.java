package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class ConsumidorArroz implements Runnable {
    
    JProgressBar arroz;

    public ConsumidorArroz(JProgressBar arroz) {
        this.arroz = arroz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (arroz) {
                try {
                    if (arroz.getValue() <= 30) {
                        arroz.notifyAll();
                        arroz.wait();
                    }
                    arroz.setValue(arroz.getValue() - 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConsumidorArroz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
