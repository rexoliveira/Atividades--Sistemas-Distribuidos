package visaochatcliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ChatCliente implements Runnable {

    private Socket socket;
    private PrintStream saida;
    public String mensagemSaida = "";
    public boolean ativo = false;
    private int contador = 0;

    public int getContador() {

        return contador;
    }

    public ChatCliente() {
        this.mensagemSaida = mensagemSaida;

        try {
            socket = new Socket("localhost", Integer.parseInt("12345"));
            ativo = true;
            saida = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            Mensagem("Erro tentando conectar ao servidor.");

        }
    }

    public void saida(String mensagemSaida) {
        this.mensagemSaida = mensagemSaida;
    }

    @Override
    public void run() {
        try {
            while (ativo) {
                /*Colocar p sleep dentro do while reduzir processamento e 
                    sair a mensagem */
                Thread.sleep(1000);
                                
                if (mensagemSaida.length() > 0 ) {
                    saida.println(mensagemSaida);
                    mensagemSaida = "";
                }

            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            saida.close();
            ativo = false;
        }

    }

    private void Mensagem(String msg) {
        System.out.println(Thread.currentThread().getName() + "-" + msg);
    }

}
