package atividade_realizada;

public class InicioThread {


    public static void main(String[] args) {
       
        /* Primeira Tarefa */
        /* Retira o aviso de variable não usada */
       @SuppressWarnings("unused")
       ArquivoRunnable thread1  = new ArquivoRunnable("#1","PAR  ");

        /* Segunda Tarefa */
        @SuppressWarnings("unused")
        ArquivoRunnable threadd2  = new ArquivoRunnable("#2","ÍMPAR");

       
    }
    
}
/* Crédito da ajuda: Curso de Java 71: 
Threads: métodos e blocos sincronizados (synchronized)
 - Loiane Groner(Canal do Youtube) 
 -Link: https://www.youtube.com/watch?v=uR0zWNqJ5a8&list=PLGxZ4Rq3BOBoqYyFWOV_YbfBW80YGAGEI&index=20&ab_channel=LoianeGroner*/
