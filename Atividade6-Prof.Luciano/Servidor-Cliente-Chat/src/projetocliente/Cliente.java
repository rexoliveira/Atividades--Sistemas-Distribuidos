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
    public String palavra = "";
    public String porta;

    public Cliente() {

        try {
            socket = new Socket("localhost", Integer.parseInt("12345"));

           
            saida = new PrintStream(socket.getOutputStream());

            //Não Aagar Escreve pelo terminal-Minha Implementação
//            Scanner teclado = new Scanner(System.in);
//            while (teclado.hasNextLine()) {
//                saida.println(teclado.nextLine());
//            }
            conectado = true;

        } catch (IOException ex) {
            Mensagem("Erro tentando conectar ao servidor.");

        }
    }

    public void saida(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public void run() {

        while (conectado) {
            //Como está muito rápido se não colodar um dalay antes o if, não é impresso
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (palavra.length() > 0) {
                saida.println(this.palavra);
                palavra = "";

            }

        }
    }

    private void Mensagem(String msg) {
        System.out.println(Thread.currentThread().getName() + "-" + msg);
    }

}
