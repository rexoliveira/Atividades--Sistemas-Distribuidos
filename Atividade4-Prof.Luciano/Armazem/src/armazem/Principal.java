package armazem;


public class Principal extends javax.swing.JFrame { 
    
    private int contadorArroz = 0;
    private int contadorFeijao = 0;
    private int contadorMilho = 0;
    
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Arroz = new javax.swing.JProgressBar();
        btnProdArroz = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Feijao = new javax.swing.JProgressBar();
        Milho = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnProdFeijao = new javax.swing.JButton();
        btnProdMilho = new javax.swing.JButton();
        lblArroz = new javax.swing.JLabel();
        lblFeijao = new javax.swing.JLabel();
        lblMilho = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Arroz.setBackground(new java.awt.Color(51, 51, 51));
        Arroz.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Arroz.setForeground(new java.awt.Color(255, 255, 255));
        Arroz.setOrientation(1);
        Arroz.setToolTipText("Arroz");
        Arroz.setValue(30);
        Arroz.setFocusCycleRoot(true);
        Arroz.setStringPainted(true);

        btnProdArroz.setText("+PRODUTOR/-CONSUMIDOR");
        btnProdArroz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdArrozActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Arroz");

        Feijao.setBackground(new java.awt.Color(204, 204, 204));
        Feijao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Feijao.setForeground(new java.awt.Color(67, 56, 47));
        Feijao.setOrientation(1);
        Feijao.setToolTipText("Feijão");
        Feijao.setValue(20);
        Feijao.setStringPainted(true);

        Milho.setBackground(new java.awt.Color(204, 204, 204));
        Milho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Milho.setForeground(new java.awt.Color(255, 255, 0));
        Milho.setOrientation(1);
        Milho.setToolTipText("Milho");
        Milho.setValue(10);
        Milho.setBorderPainted(false);
        Milho.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Milho.setStringPainted(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Milho");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Feijão");

        btnProdFeijao.setText("+PRODUTOR/-CONSUMIDOR");
        btnProdFeijao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdFeijaoActionPerformed(evt);
            }
        });

        btnProdMilho.setText("+PRODUTOR/-CONSUMIDOR");
        btnProdMilho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdMilhoActionPerformed(evt);
            }
        });

        lblArroz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArroz.setText("0");

        lblFeijao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFeijao.setText("0");

        lblMilho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMilho.setText("0");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Clique uma vez para PRODUZIR  e uma para CONSUMO automático.");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Consumidor e número de Threads ativas, print no terminal.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Arroz, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(Feijao, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Milho, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblArroz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnProdArroz, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnProdFeijao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFeijao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnProdMilho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMilho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Arroz, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(Feijao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Milho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArroz)
                    .addComponent(lblMilho)
                    .addComponent(lblFeijao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProdArroz)
                    .addComponent(btnProdFeijao)
                    .addComponent(btnProdMilho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdArrozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdArrozActionPerformed
        
        new Thread(new ProdutorArroz(Arroz),"Teste1").start();
        
        contadorArroz++;
        lblArroz.setText(Integer.toString(contadorArroz)+"+Produtores e -Consumidores");
        
    }//GEN-LAST:event_btnProdArrozActionPerformed

    private void btnProdFeijaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdFeijaoActionPerformed
        new Thread(new ProdutorFeijao(Feijao)).start();
        contadorFeijao++;
        lblFeijao.setText(Integer.toString(contadorFeijao)+"+Produtores e -Consumidores");
    }//GEN-LAST:event_btnProdFeijaoActionPerformed

    private void btnProdMilhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdMilhoActionPerformed
        new Thread(new ProdutorMilho(Milho)).start();
        contadorMilho++;
        lblMilho.setText(Integer.toString(contadorMilho)+"+Produtores e -Consumidores");
        
    }//GEN-LAST:event_btnProdMilhoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Arroz;
    private javax.swing.JProgressBar Feijao;
    private javax.swing.JProgressBar Milho;
    private javax.swing.JButton btnProdArroz;
    private javax.swing.JButton btnProdFeijao;
    private javax.swing.JButton btnProdMilho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblArroz;
    private javax.swing.JLabel lblFeijao;
    private javax.swing.JLabel lblMilho;
    // End of variables declaration//GEN-END:variables
}
