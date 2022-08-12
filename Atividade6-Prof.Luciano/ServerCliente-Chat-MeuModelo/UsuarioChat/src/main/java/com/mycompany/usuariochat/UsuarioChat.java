package com.mycompany.usuariochat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*classe UsuarioChat cria a tela para o usuário informar alguns parâmetros como
o IP do servidor, a PORTA e o nomeUsuario que será visto para os demais usuários
no chat. No código está definido como padrão o IP 127.0.0.1[LOCALHOST], 
porta 12345 e nome usuario.*/
public class UsuarioChat extends JFrame implements ActionListener, KeyListener, Runnable {

    private static final long serialVersionUID = 1L;
    private JTextArea txaTexto;
    private JTextField txfMensagem;
    private JButton btnEnviar;
    private JButton btnSair;
    private JLabel lblHistorico;
    private JLabel lblMensagem;
    private JPanel pnlConteudo;
    private Socket socket;
    private OutputStream saida;
    private Writer saidaEscrita;
    private BufferedWriter bufferEscrita;
    private JTextField txfIp;
    private JTextField txfPorta;
    private JTextField txfNomeUsuario;

    public UsuarioChat() throws IOException {
        JLabel lblVerifica = new JLabel("Verificar!");
        txfIp = new JTextField("127.0.0.1");
        txfPorta = new JTextField("12345");
        txfNomeUsuario = new JTextField("Nome Usuario");
        //Cria o array de objetos
        Object[] informacoes = {lblVerifica, txfIp, txfPorta, txfNomeUsuario};
        //Mostra um alerta com as informações desses objetos
        JOptionPane.showConfirmDialog(null, informacoes);
        //Cria um PAINEL
        pnlConteudo = new JPanel();
        //Abaixo define as propriedas do painel
        txaTexto = new JTextArea(13, 25);
        txaTexto.setEditable(false);
        txaTexto.setBackground(new Color(94, 94, 94));
        txaTexto.setForeground(new Color(249, 212, 25));
        txfMensagem = new JTextField(25);
        lblHistorico = new JLabel("Histórico");
        lblHistorico.setForeground(new Color(0, 198, 46));
        lblMensagem = new JLabel("Mensagem");
        lblMensagem.setForeground(new Color(0, 198, 46));
        btnEnviar = new JButton("Enviar");
        btnEnviar.setForeground(new Color(0, 255, 0));
        btnEnviar.setToolTipText("Enviar Mensagem");
        btnSair = new JButton("Sair");
        btnSair.setForeground(new Color(255, 0, 0));
        btnSair.setToolTipText("Sair do Chat");
        btnEnviar.addActionListener(this);
        btnSair.addActionListener(this);
        btnEnviar.addKeyListener(this);
        txfMensagem.addKeyListener(this);
        JScrollPane scroll = new JScrollPane(txaTexto);
        txaTexto.setLineWrap(true);
        pnlConteudo.add(lblHistorico);
        pnlConteudo.add(scroll);
        pnlConteudo.add(lblMensagem);
        pnlConteudo.add(txfMensagem);
        pnlConteudo.add(btnSair);
        pnlConteudo.add(btnEnviar);
        pnlConteudo.setBackground(new Color(65, 64, 64));
        //txa.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
        //txfMensagem.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
        txfMensagem.setBackground(new Color(94, 94, 94));
        txfMensagem.setForeground(new Color(249, 212, 25));
        setTitle(txfNomeUsuario.getText().toUpperCase());
        setContentPane(pnlConteudo);
        //Vai inciar no centro da tela
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(300, 370);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //EU-Sempre visivel
        setAlwaysOnTop(true);
    }

    /*
        *  Método usado para conectar no server socket, retorna IO Exception
            caso dê algum erro.
        * @throws IOException
     
    public void conectar() throws IOException {

        socket = new Socket(txtIP.getText(), Integer.parseInt(txtPorta.getText()));
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
        bfw.write(txtNome.getText() + "\r\n");
        bfw.flush();
    }

     */
 /*  é usado para conectar o cliente com o servidor socket;
        é possível visualizar a criação do socket cliente e 
        dos streams de comunicação.*/
    @Override
    public void run() {

        try {
            socket = new Socket(txfIp.getText(), Integer.parseInt(txfPorta.getText()));
            saida = socket.getOutputStream();
            saidaEscrita = new OutputStreamWriter(saida);
            bufferEscrita = new BufferedWriter(saidaEscrita);
            bufferEscrita.write(txfNomeUsuario.getText() + "\r\n");
            bufferEscrita.flush();

            escutar();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioChat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*  usado para enviar mensagens do usuario para o servidor socket;
        ao escrever uma mensagem e apertar o botão “Enter”,
        esta será enviada para o servido*/
    public void enviarMensagem(String mensagem) throws IOException {

        if (mensagem.equals("Sair")) {
            bufferEscrita.write("Desconectado \r\n");
            txaTexto.append("Desconectado \r\n");
        } else {
            bufferEscrita.write(mensagem + "\r\n");
            txaTexto.append(txfNomeUsuario.getText().toUpperCase() + " [Eu]: "
                    + txfMensagem.getText() + "\r\n");
        }
        bufferEscrita.flush();
        txfMensagem.setText("");
    }

    /*  usado para escutar mensagens RECEBIDAS do servidor;
        toda vez que alguém enviar uma, o método será processado pelo servidor
        e envia para todos os usuarios conectados*/
    public void escutar() throws IOException {

        InputStream entrada = socket.getInputStream();
        InputStreamReader entradaLeitura = new InputStreamReader(entrada);
        BufferedReader bufferLeitura = new BufferedReader(entradaLeitura);

        String mensagem = "";
        while (!"Sair".equalsIgnoreCase(mensagem)) {
            if (bufferLeitura.ready()) {
                mensagem = bufferLeitura.readLine();

                if (mensagem.equals("Sair")) {
                    txaTexto.append("Servidor desconectado! \r\n");
                } else {
                    txaTexto.append(mensagem + "\r\n");
                }
            }
        }
    }

    /*  usado para desconectar do server socket;
        o sistema fecha os streams de comunicação.*/
    public void sair() throws IOException {
        enviarMensagem("Sair");
        bufferEscrita.close();
        saidaEscrita.close();
        saida.close();
        socket.close();
//        EU
        lblMensagem.setVisible(false);
        txfMensagem.setVisible(false);
        btnEnviar.setVisible(false);
        btnSair.setVisible(false);
        setSize(300, 300);
        txaTexto.setBackground(new Color(243, 113, 113));
    }

    /*  usado para receber as ações dos botões dos usuários;
        é feito um chaveamento: se o usuário pressionar o botão “Enviar” 
        então será enviada uma mensagem, senão será encerrado o chat.*/
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals(btnEnviar.getActionCommand())) {
                enviarMensagem(txfMensagem.getText());
            } else {
                if (e.getActionCommand().equals(btnSair.getActionCommand())) {
                    sair();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /*acionado quando o usuário pressiona “Enter”, verificando se o 
        key code é o Enter. Caso seja, a mensagem é enviada para o servidor.*/
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                enviarMensagem(txfMensagem.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //Declaração do método main
    public static void main(String[] args) throws IOException {

        new Thread(new UsuarioChat()).start();
    }
}
