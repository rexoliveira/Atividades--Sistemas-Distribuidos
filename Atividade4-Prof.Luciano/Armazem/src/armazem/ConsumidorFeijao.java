package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class ConsumidorFeijao implements Runnable {
    
    JProgressBar feijao;

    public ConsumidorFeijao(JProgressBar feijao) {
        this.feijao = feijao;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (feijao) {
                try {
                    if (feijao.getValue() <= 20) {
                        feijao.notifyAll();
                        feijao.wait();
                    }
                    feijao.setValue(feijao.getValue() - 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConsumidorArroz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
