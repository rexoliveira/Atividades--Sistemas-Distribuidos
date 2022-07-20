package leescreve;

public class Professor implements Runnable {

    private Caderno caderno;

    public Professor(Caderno caderno) {
        this.caderno = caderno;
    }

    @Override
    public void run() {
            caderno.Atualiza();
    }

}
