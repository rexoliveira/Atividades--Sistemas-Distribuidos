package atividade_realizada_2;

public class InicioThred {

    public static void main(String[] args) {

        /* Primeira Tarefa */
        ArquivoRunnable thread1 = new ArquivoRunnable("Dr", "nomes1.txt");
        Thread t1 = new Thread(thread1, "#TH1");
        t1.start();

        /* Segunda Tarefa */
        ArquivoRunnable thread2 = new ArquivoRunnable("Ana", "nomes2.txt");
        Thread t2 = new Thread(thread2,"#TH2");
        t2.start();

        /* Terceira Tarefa */
        ArquivoRunnable thread3 = new ArquivoRunnable("Sr", "nomes3.txt");
        Thread t3 = new Thread(thread3,"#TH3");
        t3.start();

    }

}
