
package servidormsg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Servidor implements Runnable{
    private boolean rodando=false;
    private ServerSocket servidor;
    private JFrame frame;
    private JTextArea area;
    
    public Servidor(JFrame frame,JTextArea area)
    {
        try {
            servidor= new ServerSocket(12345);
            rodando=true;
            this.frame=frame;
            this.area=area;
            new Thread(this).start();
        } catch (IOException ex) {
            System.out.println("Erro de conexao:");
            rodando=false;
        }
    }
    
    
    @Override
    public void run() {
        try {
            while (rodando)
            {
                try {
                    area.append("SERVIDOR CONECTADO\n");
                    Socket cliente = servidor.accept();
                    new Servico(frame, cliente);
                } catch (IOException ex) {
                    System.out.println("Erro ao conectar cliente");
                }
            }
            
            servidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
    }
    
}
