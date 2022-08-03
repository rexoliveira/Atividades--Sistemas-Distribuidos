
package projetoservidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servico implements Runnable{
    private Socket socket;
    private Scanner entrada;
    
    public Servico(Socket socket)
    {
        this.socket=socket;
    }
    
    
    @Override
    public void run() {
        try {
            entrada=new Scanner(socket.getInputStream());
            System.out.println("Cliente "+socket+" conectou.");           
            while (entrada.hasNextLine())
            {
                System.out.println(socket);
                System.out.println(entrada.nextLine());       
            }
        } catch (IOException ex) {
            Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
