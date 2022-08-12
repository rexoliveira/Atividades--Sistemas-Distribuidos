package visaochatservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServidorVisao extends javax.swing.JFrame {

    public ChatServidorVisao() {
        initComponents();
        new Thread(new Servidor()).start();
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
                txaServer.append("==============================================" + "\n");
                txaServer.append("Cliente " + socket.getPort() + " conectou." + "\n");
                while (entrada.hasNextLine()) {
                    txaServer.append(entrada.nextLine() + "\n");
                }
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
                servidor = new ServerSocket(Integer.parseInt("12345"));
                conectado = true;
                Mensagem("Servidor conectado.");
                txaServer.append(("Servidor conectado.\n").toUpperCase());

                txaServer.append("#####################################################" + "\n");

                txaServer.append(("Porta Servidor = " + servidor.getLocalPort() + ".\n").toUpperCase());

                txaServer.append("#####################################################" + "\n");

            } catch (IOException ex) {

            }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(0, 0));
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
        setLocationRelativeTo(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Saída Servidor");

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
                        .addGap(57, 233, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ChatServidorVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatServidorVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatServidorVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatServidorVisao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ChatServidorVisao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaServer;
    // End of variables declaration//GEN-END:variables
}
