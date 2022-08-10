package projetocliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    private Socket socket;
    private boolean conectado = false;
    private PrintStream saida;
    public String palavra ;

    public Cliente(String palavra, String porta) {
        this.palavra = palavra;

        try {
            socket = new Socket("localhost", Integer.parseInt(porta));

            saida = new PrintStream(socket.getOutputStream());

        } catch (IOException ex) {
            Mensagem("Erro tentando conectar ao servidor.");

        }
    }

    @Override
    public void run() {
        try {

            if (palavra.equals("sair")) {
                conectado = false;
            } else {
                saida.println(palavra);
            }

            saida.close();

            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Mensagem(String msg) {
        System.out.println(Thread.currentThread().getName() + "-" + msg);
    }

}
