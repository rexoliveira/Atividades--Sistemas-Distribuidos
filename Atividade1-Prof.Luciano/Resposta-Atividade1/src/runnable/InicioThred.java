package runnable;

public class InicioThred {

    /* Crédito/Ajuda: Parte1:https://youtu.be/v5l30QMKv6c - Parte2:https://youtu.be/oWoU0uTEaA0*/
    
    /* Esse programa se torna um processo */
    public static void main(String[] args) {

        /* Primeira Tarefa */
        @SuppressWarnings("unused")/* Retira o aviso de variable não usada */
        MinhaThredRunnable thread1 = new MinhaThredRunnable(0, 10, "#1");

        /* Está dentro do contrutor classe MinhaThreaRunnable */
        /* Thread t1 = new Thread(thread1);
        t1.start(); */

        /* Segunda Tarefa */
        @SuppressWarnings("unused")
        MinhaThredRunnable thread2 = new MinhaThredRunnable(0, 10, "#2");

        /* Terceira tarefa */
        @SuppressWarnings("unused")
        MinhaThredRunnable thread3 = new MinhaThredRunnable(0, 10, "#3");
    }
}