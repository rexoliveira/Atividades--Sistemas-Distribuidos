package com.mycompany.servidornovo;

import java.net.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class SrvThread extends Thread {
    ServerSocket serverSocket = null;
    Socket socket = null;
    static DataOutputStream ostream = null;
    static int port = 9090;//porta para comunicacao.
    DataInputStream istream  = null;
    String MRcv= "";
    static String MSnd= "";

    SrvThread(){
    try {
        serverSocket = new ServerSocket(port);
        System.out.println("Aguardando conexão...");
        socket = serverSocket.accept();//aguarda conexao com o cliente.
        System.out.println("Conexão Estabelecida.");
        ostream = new DataOutputStream(socket.getOutputStream());
        istream = new DataInputStream(socket.getInputStream());

        this.start();//inicia uma nova thread. O metodo run é executado.

        Scanner console = new Scanner(System.in);
        while(true){
            System.out.println("Mensagem: ");
            String MSnd = console.nextLine(); //le string do console
            ostream.writeUTF(MSnd);//envia string para o cliente.
            ostream.flush();
       }
    } catch(Exception e){
          System.out.println(e);
      }
  }

  public void run(){
      try {
          while(true){
              MRcv = istream.readUTF();//le as strings do cliente
              System.out.println("Remoto: "+MRcv);
          }
      } catch(Exception e) {
          System.out.println(e);
      }
  }

  public static void main(String args[]){
    new SrvThread();
  }
}
