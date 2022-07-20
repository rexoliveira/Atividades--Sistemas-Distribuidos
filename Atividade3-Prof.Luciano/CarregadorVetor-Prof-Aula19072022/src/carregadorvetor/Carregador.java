
package carregadorvetor;


import java.util.Vector;


public class Carregador implements Runnable {
      //private  Vetor vetor;
      private Vector vetor;
      
    public Carregador( Vector vetor) {
        this.vetor=vetor;
    }

    @Override
    public void run() {
       for (int i=0;i<100;i++)
       {
           String valor=Thread.currentThread().getName()+" - "+i;
           System.out.println(valor);
           vetor.add(valor);
       }
              
    }
    
}
