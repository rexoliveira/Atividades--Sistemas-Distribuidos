package atividade_realizada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArquivoRunnable implements Runnable {

    Scanner arquivo;
    String nome ;
    String nome_arquivo;


    public ArquivoRunnable(String nome, String nome_arquivo){
        this.nome =  nome;
        this.nome_arquivo = nome_arquivo;

        /* Instancia a Thread no construtor */
        Thread t = new Thread(this);
        /* Inícia a Thread */
        t.start();
    }

    @Override
    public void run() {
        try {
            arquivo = new Scanner(new File(nome_arquivo));
            int numero_linha = 1;
            while (arquivo.hasNextLine()) {
                String linha = arquivo.nextLine();
                if (linha.contains(nome)) {
                    System.out.println(nome_arquivo + "-" + linha + "-" + numero_linha);
                }
                numero_linha++;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("ERRO de arquivo");
        }

    }

}
