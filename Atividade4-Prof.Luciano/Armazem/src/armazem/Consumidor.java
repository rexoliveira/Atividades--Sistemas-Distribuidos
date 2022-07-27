package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class Consumidor implements Runnable {
    
    JProgressBar barra;

    public Consumidor(JProgressBar barra) {
        this.barra = barra;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (barra) {
                try {
                    if (barra.getValue() <= 30) {
                        barra.notifyAll();
                        barra.wait();
                    }
                    barra.setValue(barra.getValue() - 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
