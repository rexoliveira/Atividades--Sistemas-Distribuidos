package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class ConsumidorMilho implements Runnable {
    
    JProgressBar milho;

    public ConsumidorMilho(JProgressBar milho) {
        this.milho = milho;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (milho) {
                try {
                    if (milho.getValue() <= 10) {
                        milho.notifyAll();
                        milho.wait();
                    }
                    milho.setValue(milho.getValue() - 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConsumidorArroz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
