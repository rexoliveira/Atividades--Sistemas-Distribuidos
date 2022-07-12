package runnable;

public class MinhaThredRunnable implements Runnable {

    private int mult = 0;
    private int cont = 1;
    private int[][] M = new int[10][10];
    private int[][] N = new int[10][10];
    private long tempo = System.currentTimeMillis();
    private int inicio;
    private int fim;
    private String nome;

    public MinhaThredRunnable(int inicio, int fim, String nome) {
        this.inicio = inicio;
        this.fim = fim;
        /* Nome da Thread */
        this.nome = nome;
        /* Instancia a Thread no construtor */
        Thread t = new Thread(this);
        /* Inícia a Thread */
        t.start();
    }

    @Override
    public void run() {

        for (int linha = inicio; linha < fim; linha++) {
            for (int coluna = inicio; coluna < fim; coluna++) {
                M[linha][coluna] = cont;
                N[linha][coluna] = cont;
                cont++;
            }
            System.out.println("#Arrays - nome da thread: "+nome+"-Cont: "+cont+"-Linha: "+linha);
        }

        /* Crédito/Ajuda: https://pt.stackoverflow.com/questions/249732/multiplica%C3%A7%C3%A3o-de-matriz-em-java */
        for (int linha = inicio; linha < fim; linha++) {
            for (int coluna = inicio; coluna < fim; coluna++) {
                mult +=  M[linha][coluna] * N[linha][coluna];

            }
            System.out.println("#MULT dos Arrays - nome da thread: "+nome+", Mult: "+mult);
        }
        System.out.println("Thread"+nome +" terminou a execução");

        System.out.println("MULT-FINAL:" + mult);
        System.out.println("TEMPO:" + (System.currentTimeMillis() - tempo));

    }

}