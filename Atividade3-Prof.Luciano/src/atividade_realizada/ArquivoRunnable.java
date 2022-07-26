package atividade_realizada;

public class ArquivoRunnable implements Runnable {

  private String nome;
  private String escolha;
  private int contador;
  /* Por ser static essa classe vai compartilhar a mesma instância  de ParImpar */
  private static ParImpar parImpar = new ParImpar();

  /* Construtor */
  public ArquivoRunnable(String nome, String escolha) {
    this.nome = nome;
    this.escolha = escolha;
    /* Simplificado */
    new Thread(this, nome).start();
    /* Instancia a Thread no construtor */
    /* Thread t = new Thread(this, nome); */
    /* Inícia a Thread */
    /* t.start(); */
  }

  @Override
  public void run() {
    contador = 0;
    System.out.println(this.nome+" iniciado");
    for (int i = 0; i < 10; i++) {
        contador ++;
      System.out.println(contador+parImpar.escolha(escolha) + " da Thread("+nome+")");
    }
    System.out.println(this.nome+" terminado");
  }
}
/* Crédito da ajuda: Curso de Java 71: 
Threads: métodos e blocos sincronizados (synchronized)
 - Loiane Groner(Canal do Youtube) 
 -Link: https://www.youtube.com/watch?v=uR0zWNqJ5a8&list=PLGxZ4Rq3BOBoqYyFWOV_YbfBW80YGAGEI&index=20&ab_channel=LoianeGroner*/
