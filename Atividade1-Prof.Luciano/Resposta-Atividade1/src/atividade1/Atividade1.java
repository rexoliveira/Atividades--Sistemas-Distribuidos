package atividade1;
/*
 * Tranforme o código abaixo em uma soma de matriz usando
 * processamento paralelo usando a interface Runnable.
 */


public class Atividade1 {

    public static void main(String[] args) {
        int soma = 0;
        int cont = 1;
        int[][] M = new int[10][10];
        long tempo=System.currentTimeMillis();
        

        
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                M[linha][coluna] = cont;
                cont++;
            }
        }

        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                soma = soma + M[linha][coluna];

            }
        }

        
        System.out.println("SOMA:"+soma);
        System.out.println("TEMPO:"+(System.currentTimeMillis()-tempo));
    }

}
