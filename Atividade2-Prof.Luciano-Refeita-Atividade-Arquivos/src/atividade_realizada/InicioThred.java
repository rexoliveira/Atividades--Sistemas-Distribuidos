package atividade_realizada;

public class InicioThred {


    public static void main(String[] args) {
       
        /* Está no contrutor do arquivo Runnable */
        /* Instancia a Thread no construtor */
        /* Thread t = new Thread(this); */
        /* Inícia a Thread */
        /* t.start(); */

        /* Primeira Tarefa */
        /* Retira o aviso de variable não usada */
       @SuppressWarnings("unused")
       ArquivoRunnable thraed1  = new ArquivoRunnable("Dr","nomes1.txt");

        /* Segunda Tarefa */
        /* Retira o aviso de variable não usada */
        @SuppressWarnings("unused")
        ArquivoRunnable thraed2  = new ArquivoRunnable("Ana","nomes2.txt");

        /* Terceira Tarefa */
        /* Retira o aviso de variable não usada */
        @SuppressWarnings("unused")
        ArquivoRunnable thraed3  = new ArquivoRunnable("Sr","nomes3.txt");
       
    }
    
}
