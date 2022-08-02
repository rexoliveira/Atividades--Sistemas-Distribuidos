package armazem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class ProdutorFeijao implements Runnable {

    JProgressBar feijao;
    private int contador = 0;

    public ProdutorFeijao(JProgressBar feijao) {
        this.feijao = feijao;
    }

    @Override
    public void run() {
        
        while (true) {
            synchronized (feijao) {

                try {

                    if (feijao.getValue() >= 70) {
                        feijao.notifyAll();
                        feijao.wait();
                        new Thread(new ConsumidorFeijao(feijao)).start();
                        contador++;
                        System.out.println(Integer.toString(contador) + " ConsumoFeijao");
                        System.out.println(Thread.activeCount() + " Threads ativas[FEIJAO]...");
                        System.out.println("===========================");
                    }

                    feijao.setValue(feijao.getValue() + 1);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProdutorArroz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
