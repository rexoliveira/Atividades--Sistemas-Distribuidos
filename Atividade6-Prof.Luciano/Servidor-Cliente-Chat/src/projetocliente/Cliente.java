package projetocliente;

import java.awt.TextArea;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Cliente  extends JFrame implements Runnable {

    private Socket socket;
    private PrintStream saida;
    public String palavra;
    public String porta;
    public boolean rodando;
    
    

    public Cliente() {
        new Thread(new Cliente()).start();
        try {
            socket = new Socket("localhost", Integer.parseInt("12345"));

            saida = new PrintStream(socket.getOutputStream());

            rodando = true;

        } catch (IOException ex) {
            Mensagem("Erro tentando conectar ao servidor.");

        }
    }

    public void enviar(String palavra, String porta) {
        this.palavra = palavra;
        this.porta = porta;
        
    }

    @Override
    public void run() {
        try {

            while (rodando) {

                if (palavra.length() > 0) {

                    saida.println(palavra);
                    Thread.sleep(1000);
                    palavra = "";
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Mensagem(String msg) {
        System.out.println(Thread.currentThread().getName() + "-" + msg);
    }

}
