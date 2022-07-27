package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class Produtor implements Runnable {

    JProgressBar barra;

    public Produtor(JProgressBar barra) {
        this.barra = barra;
    }

    @Override
    public void run() {
        while (true) {
            
            synchronized (barra) {
                try {
                    if (barra.getValue() >= 50) {
                        barra.notifyAll();
                    }
                    
                    if (barra.getValue() >= 80) {
                        barra.notifyAll();
                        barra.wait();
                    }
                    
                    barra.setValue(barra.getValue() + 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
