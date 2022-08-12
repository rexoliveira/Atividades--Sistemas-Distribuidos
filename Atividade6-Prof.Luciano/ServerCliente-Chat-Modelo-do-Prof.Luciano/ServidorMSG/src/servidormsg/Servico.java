package servidormsg;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

public class Servico extends JInternalFrame implements Runnable {

    private JFrame frame;
    private JTextArea area;
    private Socket socket;
    private boolean rodando = false;
    private Scanner entrada;

    public Servico(JFrame frame, Socket socket) {
        try {
            this.frame = frame;
            this.socket = socket;
            this.setTitle("Cliente");
            this.setSize(400, 400);
            area = new JTextArea(10, 100);
            this.add(area);
            frame.add(this);
            this.setVisible(true);
            entrada = new Scanner(this.socket.getInputStream());
            rodando = true;

            new Thread(this).start();
        } catch (IOException ex) {
            rodando = false;
        }
    }

    @Override
    public void run() {
        try {
            area.append("Cliente Conectado");
            while (rodando) {
                while (entrada.hasNext())
                {
                    
                    area.append(entrada.nextLine()+"\n");
                }
            }
            
            entrada.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
