
package com.mycompany.servidorchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ServidorChat implements Runnable {

    //é usado para armazenar o BufferedWriter de cada cliente conectado
    private static ArrayList<BufferedWriter> usuarios;
    /*é usado para a criação do servidor, que teoricamente deve ser feita apenas
    uma vez*/
    private static ServerSocket servidor;
    private String nomeUsuario;
    private Socket conexao;
    private InputStream entrada;
    private InputStreamReader entradaLeitura;
    //é chamado, ele lê os dados do buffer de memória
    private BufferedReader bufferLeitura;
   
    /*método construtor, que recebe um objeto socket como 
    parâmetro e cria um objeto do tipo BufferedReader, que aponta para o stream 
    do cliente socket.*/
    public ServidorChat(Socket conexao)  {
        this.conexao = conexao;
        try {
            entrada = conexao.getInputStream();
            entradaLeitura = new InputStreamReader(entrada);
            bufferLeitura = new BufferedReader(entradaLeitura);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*toda vez que um cliente novo chega ao servidor, esse método é acionado e
    alocado numa Thread e também fica verificando se existe alguma mensagem 
    nova. Caso exista, esta será lida e o evento “sentToAll” será acionado para
    enviar a mensagem para os demais usuários conectados no chat.*/
    @Override
    public void run() {
        try {
            String mensagem;
            OutputStream saida = this.conexao.getOutputStream();
            Writer saidaEscrita = new OutputStreamWriter(saida);
            BufferedWriter bufferEscrita = new BufferedWriter(saidaEscrita);
            usuarios.add(bufferEscrita);
            nomeUsuario =  mensagem = bufferLeitura.readLine();

            /* equalsIgnoreCase-Verifica se duas strings são iguais. A comparação, 
        nesse caso, não é case-sensitive*/
            while (!"Sair".equalsIgnoreCase(mensagem) && mensagem != null) {
                mensagem = bufferLeitura.readLine();
                sendToAll(bufferEscrita, mensagem);
                //Avisos(nomeUsuario+": "+ mensagem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*Usuario envia uma mensagem, o servidor recebe e manda esta para 
    todos os outros usuarios conectados. 
    É necessário percorrer a lista de usuarios e mandar uma 
    cópia da mensagem para cada um.*/
    private void sendToAll(BufferedWriter bufferEscrita, String mensagem) throws IOException {
        BufferedWriter bufferEnvio;
        
        for (BufferedWriter bw : usuarios) {
            
            bufferEnvio = (BufferedWriter) bw;
            
            if (!(bufferEscrita == bufferEnvio)) {
                
                bw.write( nomeUsuario + ": " + mensagem + "\r\n");
                /*limpar o console e forçar qualquer saída armazenada em buffer
                a ser escrita imediatamente.*/
                bw.flush();
            }
        }
    }

//    private void Avisos(String aviso) {
//        System.out.println(aviso);
//    }
    
    /*[main] iniciará o servidor, fará a configuração do servidor socket/porta.
    -Cria uma janela para informar a porta e depois entra no “while(true)”;
    -Na linha “server.accept()” o sistema fica bloqueado até que um cliente 
    socket se conecte: se ele fizer isso é criada uma nova Thread do tipo 
    servidor;
    -Classe ServidorChat é um tipo Runnable, multiplos Threads e é iniciada na 
    instrução “t.start()”;
    -O controle do fluxo retorna para a linha “server.accept()” e aguarda outro
    cliente se conectar. */
    public static void main(String[] args) {

        try {
            //Cria os objetos necessário para instânciar o servidor
            JLabel lblMensagem = new JLabel("Porta do Servidor:");
            JTextField txfPorta = new JTextField("12345");
            Object[] info = {lblMensagem, txfPorta};
            //Mostra uma mensagem de alerta na tela para escolha de porta
            JOptionPane.showMessageDialog(null, info);
            //Cria o socket do servidor com a porta escolhida
            servidor = new ServerSocket(Integer.parseInt(txfPorta.getText()));
            //Gera um array para entrada de usuarios
            usuarios = new ArrayList<BufferedWriter>();
            //Mostra a porta escolhida e avisa que o servidor foi inciado
            JOptionPane.showMessageDialog(null, "Servidor iniciado na porta: " +
                    txfPorta.getText());
            
            while(true){
                System.out.println("Aguardando conexão...");
                Socket conexao = servidor.accept();
                //System.out.println("Conexão: "+conexao);
                System.out.println("Usuario conectado...");
                new Thread(new ServidorChat(conexao)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
