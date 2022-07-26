package leescreve;

public class EstudanteEscreve implements Runnable {

    private Caderno caderno;

    public EstudanteEscreve(Caderno caderno) {
        this.caderno = caderno;
    }

    @Override
    public void run() {
            caderno.Escrever();  
    }

}
