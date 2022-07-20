
package carregadorvetor;


public class Vetor {
    private String[] vetor=new String[1000];
    private int quantidade=0;
    
    public synchronized void add(String valor)
    {
        vetor[quantidade]=valor;
        quantidade++;
    }
    
    public String get(int indice)
    {
        return vetor[indice];
    }
    
    
}
