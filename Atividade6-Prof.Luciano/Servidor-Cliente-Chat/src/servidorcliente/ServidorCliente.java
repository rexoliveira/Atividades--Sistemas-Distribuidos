package servidorcliente;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author rooli
 */
public class ServidorCliente extends javax.swing.JFrame {

    public ServidorCliente() {
        initComponents();
        new Thread(new Servidor()).start();
    }

//    Criar novo server após start do primeiro
    public ServidorCliente(String porta) throws IOException {
        initComponents();
        new Thread(new Servidor(porta)).start();
    }

    public class Servico implements Runnable {

        private Socket socket;
        private Scanner entrada;

        public Servico(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                entrada = new Scanner(socket.getInputStream());
                txaServer.append("Cliente " + socket.getPort() + " conectou." + "\n");
                while (entrada.hasNextLine()) {

                    txaServer.append(entrada.nextLine() + "\n");
                }
                
                txaServer.append("==============================================" + "\n");
                txaServer.append("Cliente " + socket.getPort() + " saiu." + "\n");
            } catch (IOException ex) {
                Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public class Servidor implements Runnable {

        private ServerSocket servidor;
        private boolean conectado = false;
        private String porta = "";

        public Servidor() {
            try {
                servidor = new ServerSocket(Integer.parseInt(txfPortServer.getText()));
                conectado = true;
                Mensagem("Servidor conectado.");
                txaServer.append(("Servidor conectado.\n").toUpperCase());

                txaServer.append("#####################################################" + "\n");

                txaServer.append(("Porta Servidor = " + servidor.getLocalPort() + ".\n").toUpperCase());

                txaServer.append("#####################################################" + "\n");

            } catch (IOException ex) {

            }
        }

        //Criar Novo servidor
        public Servidor(String porta) throws IOException {
            servidor = new ServerSocket(Integer.parseInt(porta));
            conectado = true;
            Mensagem("Servidor conectado.");
            txaServer.append(("Servidor conectado.\n").toUpperCase());
            txaServer.append("#####################################################" + "\n");
            txaServer.append(("Porta Servidor = " + servidor.getLocalPort() + ".\n").toUpperCase());
            txaServer.append("#####################################################" + "\n");
        }

        @Override
        public void run() {

            while (conectado) {
                try {
                    Socket socket = servidor.accept();
                    new Thread(new Servico(socket)).start();
                } catch (IOException ex) {

                }

            }

        }

        private void Mensagem(String msg) {

            System.out.println(msg);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaServer = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfPortServer = new javax.swing.JTextField();
        btnStartServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jScrollPane1.setBackground(new java.awt.Color(102, 255, 51));
        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));

        txaServer.setEditable(false);
        txaServer.setBackground(new java.awt.Color(51, 51, 51));
        txaServer.setColumns(20);
        txaServer.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txaServer.setForeground(new java.awt.Color(153, 255, 102));
        txaServer.setLineWrap(true);
        txaServer.setRows(5);
        txaServer.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txaServer);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Saída Servidor");

        jLabel2.setText("Porta:");

        txfPortServer.setBackground(new java.awt.Color(0, 0, 0));
        txfPortServer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txfPortServer.setForeground(new java.awt.Color(102, 255, 51));
        txfPortServer.setText("12345");
        txfPortServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPortServerActionPerformed(evt);
            }
        });

        btnStartServer.setText("Start Novo Servidor");
        btnStartServer.setToolTipText("Antes de dar Start em um Novo Servidor troque a PORTA!");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPortServer, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfPortServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnStartServer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfPortServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPortServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPortServerActionPerformed

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        if (txfPortServer.getText().equals("12345")) {

            JDialog dialog = new JOptionPane("Altere a porta para um valor diferente " + txfPortServer.getText() + ".",
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION).createDialog("Trocar Porta");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

            txfPortServer.requestFocus(true);
            Border border;
            
            
            int delay = 10000;   // tempo de espera antes da 1ª execução da tarefa.
            int interval = 10000;  // intervalo no qual a tarefa será executada.
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    
                    txfPortServer.setBorder(new LineBorder(Color.GREEN));
                }
            }, delay, interval);
            txfPortServer.setBorder(new LineBorder(Color.RED));
        } else {

            try {
                ServidorCliente servidorCliente = new ServidorCliente(txfPortServer.getText());

//        centro da tela
                servidorCliente.setLocationRelativeTo(null);

                servidorCliente.setVisible(true);
//            Define a porta do atual servidor
                servidorCliente.txfPortServer.setText(txfPortServer.getText());
                servidorCliente.btnStartServer.setVisible(false);
                servidorCliente.txfPortServer.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(ServidorCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Volta para PORTA padrão
            txfPortServer.setText("12345");
        }
    }//GEN-LAST:event_btnStartServerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServidorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaServer;
    private javax.swing.JTextField txfPortServer;
    // End of variables declaration//GEN-END:variables
}
