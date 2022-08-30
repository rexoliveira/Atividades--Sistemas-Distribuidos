package com.mycompany.clientenovo;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class CliThread extends Thread {

    static DataOutputStream ostream = null;
    DataInputStream istream = null;
    static String host = "";
    static int port = 9090;//porta para comunicacao. Deve ser a mesma do servidor.
    Socket socket = null;
    String MRcv= "";
    static String MSnd= "";


    CliThread(){
        try {
            socket = new Socket("localhost", port);//conecta com o servidor.
            System.out.println("Conectado....");
            this.start();//comeca uma nova thread. O metodo run é executado.
            ostream = new DataOutputStream(socket.getOutputStream());
            istream = new DataInputStream(socket.getInputStream());
            Scanner console = new Scanner(System.in);

            while(true){
                System.out.println("Mensagem: ");
                String MSnd = console.nextLine();//le mensagem do console.
                ostream.writeUTF(MSnd);//manda mensagem para o servidor.
                ostream.flush();
            }
        } catch(Exception e) {System.out.println(e);}
  }

  public void run(){
      while (true) {
          try {        
              MRcv = istream.readUTF();//le mensagem do servidor.
              System.out.println("Remoto: " + MRcv);
          } catch(Exception e) {}
      }
  }


  public static void main(String args[]){
      new CliThread(); 
  }
}   