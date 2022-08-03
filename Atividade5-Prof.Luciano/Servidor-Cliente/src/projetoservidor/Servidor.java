
package projetoservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Servidor implements Runnable{
        private ServerSocket servidor;
        private boolean conectado=false;
        private Scanner entrada;
        
                
        public Servidor()
        {
            try {
                servidor=new ServerSocket(12345);
                conectado=true;                
                Mensagem("Servidor conectado.");
            } catch (IOException ex) {

            }
        }
        
        @Override
        public void run()
        {
            
            while (conectado)
            {
                try {
                    Socket socket=servidor.accept();
                    new Thread(new Servico(socket)).start();                                
                } catch (IOException ex) {
 
                }
            
            }
            
        }
        
        private void Mensagem(String msg)
        {
            System.out.println(Thread.currentThread().getName()+"-"+msg);
        }
    
}
