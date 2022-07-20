
package leescreve;


public class EstudanteLe implements Runnable{
    private Caderno caderno;

    public EstudanteLe(Caderno caderno) {
        this.caderno = caderno;
    }
     
    @Override
    public void run() {       
        caderno.Ler();
    }  
}
