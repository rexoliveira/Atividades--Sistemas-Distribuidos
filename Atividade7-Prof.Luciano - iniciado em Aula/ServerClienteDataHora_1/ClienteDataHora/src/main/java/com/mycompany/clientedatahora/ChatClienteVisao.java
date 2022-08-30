package com.mycompany.clientedatahora;

import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;
//Fonte:https://acervolima.com/estabelecendo-a-comunicacao-bidirecional-entre-servidor-e-cliente-em-java/#:~:text=Java%20%2C%20que%20primeiro%20se%20conecta,do%20cliente%2C%20o%20programa%20termina.
public class ChatClienteVisao extends javax.swing.JFrame {

    ChatCliente chatCliente;
    
    public ChatClienteVisao() {
        
        initComponents();
         new Thread(chatCliente = new ChatCliente()).start();
         inserirNome();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpApp = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaSaida = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jpApp.setBackground(new java.awt.Color(51, 153, 255));
        jpApp.setMinimumSize(new java.awt.Dimension(230, 350));
        jpApp.setPreferredSize(new java.awt.Dimension(230, 350));

        lblCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Cliente");

        txaSaida.setColumns(5);
        txaSaida.setLineWrap(true);
        txaSaida.setRows(3);
        txaSaida.setTabSize(0);
        txaSaida.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txaSaida);

        btnEnviar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(0, 153, 51));
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAppLayout = new javax.swing.GroupLayout(jpApp);
        jpApp.setLayout(jpAppLayout);
        jpAppLayout.setHorizontalGroup(
            jpAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAppLayout.createSequentialGroup()
                .addGroup(jpAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpAppLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCliente)
                        .addGap(0, 171, Short.MAX_VALUE))
                    .addGroup(jpAppLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpAppLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAppLayout.setVerticalGroup(
            jpAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAppLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpApp, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        chatCliente.saida(lblCliente.getText().toUpperCase()+": "+ txaSaida.getText());
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
            java.util.logging.Logger.getLogger(ChatClienteVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClienteVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClienteVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClienteVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClienteVisao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpApp;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JTextArea txaSaida;
    // End of variables declaration//GEN-END:variables

    private void inserirNome() {
       String nome = JOptionPane.showInputDialog("Informe um nome");
       Random rand = new Random();
       int cor1 = rand.nextInt((255 - 100) + 1) + 100;
       int cor2 = rand.nextInt((255 - 0) + 1) + 0;
        System.out.println(nome);
        if (nome==null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog( null, "Inserir um nome para identificação");
            System.exit( 0 );
        }else{
            lblCliente.setForeground(new Color(cor2,cor1,255));
            jpApp.setBackground(new Color(cor1,cor2,cor2));
            lblCliente.setText(nome);
        }    
    }
}
