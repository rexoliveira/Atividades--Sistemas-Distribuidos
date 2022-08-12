package clientemsg;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    private Socket cliente;
    private boolean rodando = false;
    private String msg = "";
    private PrintStream saida;

    public Cliente() {
        try {
            cliente = new Socket("localhost", 12345);
            saida = new PrintStream(cliente.getOutputStream());
            rodando = true;
            new Thread(this).start();
        } catch (IOException ex) {
            rodando = false;
        }

    }

    public void Enviar(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("RODANDO FORA");
        while (rodando) {
           
                if (msg.length() > 0) {
                    saida.print(msg + "\n");
                    msg = "";
                }
                 try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        try {
            saida.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
