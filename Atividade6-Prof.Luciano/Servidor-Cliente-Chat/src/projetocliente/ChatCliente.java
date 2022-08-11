package projetocliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorcliente.ServidorCliente;

public class ChatCliente extends javax.swing.JFrame {

    Cliente cliente;
    private Socket socket;
    private Scanner entrada;

    public ChatCliente() {
    }

    ;
    public ChatCliente(Socket socket) {

        initComponents();

        new Thread(cliente = new Cliente()).start();
        this.socket = socket;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCliente1 = new javax.swing.JPanel();
        btnEnviar = new javax.swing.JButton();
        txfPort = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaEntrada = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaSaida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jpCliente1.setBackground(new java.awt.Color(51, 153, 255));
        jpCliente1.setMinimumSize(new java.awt.Dimension(230, 350));
        jpCliente1.setPreferredSize(new java.awt.Dimension(230, 350));

        btnEnviar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(0, 153, 51));
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txfPort.setBackground(new java.awt.Color(0, 0, 0));
        txfPort.setForeground(new java.awt.Color(51, 204, 0));
        txfPort.setText("12345");

        jLabel6.setText("Porta:");

        txaEntrada.setEditable(false);
        txaEntrada.setBackground(new java.awt.Color(51, 51, 51));
        txaEntrada.setColumns(10);
        txaEntrada.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txaEntrada.setForeground(new java.awt.Color(102, 255, 51));
        txaEntrada.setLineWrap(true);
        txaEntrada.setRows(5);
        txaEntrada.setTabSize(0);
        txaEntrada.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txaEntrada);

        txaSaida.setColumns(5);
        txaSaida.setLineWrap(true);
        txaSaida.setRows(3);
        txaSaida.setTabSize(0);
        txaSaida.setToolTipText("Escreva aqui!");
        txaSaida.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txaSaida);

        javax.swing.GroupLayout jpCliente1Layout = new javax.swing.GroupLayout(jpCliente1);
        jpCliente1.setLayout(jpCliente1Layout);
        jpCliente1Layout.setHorizontalGroup(
            jpCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCliente1Layout.createSequentialGroup()
                .addGroup(jpCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpCliente1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCliente1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCliente1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnEnviar)
                        .addGap(0, 73, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpCliente1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jpCliente1Layout.setVerticalGroup(
            jpCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCliente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnEnviar)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jpCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCliente1Layout.createSequentialGroup()
                    .addContainerGap(251, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        cliente.saida(txaSaida.getText());
        //Apaga campo mensagem
        txaSaida.setText("");

    }//GEN-LAST:event_btnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatCliente().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpCliente1;
    private javax.swing.JTextArea txaEntrada;
    private javax.swing.JTextArea txaSaida;
    private javax.swing.JTextField txfPort;
    // End of variables declaration//GEN-END:variables
    public class ServicoChat implements Runnable {

            public void run() {
                System.out.println("TESTE");
                try {
                    entrada = new Scanner(socket.getInputStream());
                    txaEntrada.append("==============================================" + "\n");
                    txaEntrada.append("Cliente " + socket.getPort() + " conectou!" + "\n");
                    while (entrada.hasNextLine()) {

                        txaEntrada.append("Cliente [" + socket.getPort() + "]: " + entrada.nextLine() + "\n");

                    }

                    txaEntrada.append("Cliente " + socket.getPort() + " saiu!" + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(ServidorCliente.Servico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
