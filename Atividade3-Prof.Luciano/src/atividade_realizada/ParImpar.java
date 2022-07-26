package atividade_realizada;

public class ParImpar {

  private String escolhas;

  /* synchronized - sincronizar as Threads */
  public synchronized String escolha(String escolha) {
    escolhas = "Escolha foi: " + escolha;

    System.out.println("Fazendo a escolha " + Thread.currentThread().getName());

    /* Dar tempo para as Threads serem sincromizadas, poderia ser 100 millis */
    try {
        
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return escolhas;
  }
}
/* Crédito da ajuda: Curso de Java 71: 
Threads: métodos e blocos sincronizados (synchronized)
 - Loiane Groner(Canal do Youtube) 
 -Link: https://www.youtube.com/watch?v=uR0zWNqJ5a8&list=PLGxZ4Rq3BOBoqYyFWOV_YbfBW80YGAGEI&index=20&ab_channel=LoianeGroner*/
