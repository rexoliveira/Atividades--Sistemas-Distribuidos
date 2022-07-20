
package carregadorvetor;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarregadorVetor {

    
    public static void main(String[] args) {
       //Vetor vetor=new Vetor();
                Vector  vetor = new Vector();
         
       for (int i=1;i<=10;i++)
       {
           Carregador c = new Carregador(vetor);
           Thread t = new Thread(c,"#"+i);
           t.start();
       }
       
       while (Thread.activeCount()>1)
       {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CarregadorVetor.class.getName()).log(Level.SEVERE, null, ex);
                    }
       }
       
       
       for (int i=0;i<vetor.size();i++)
       {
           System.out.println("["+i+"]= "+vetor.get(i));       
       }
       
       
    }
    
}
