
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class C_Payments extends javax.swing.JFrame {

        DefaultTableModel model;
       Customer_Data cData;
    
       
       public C_Payments() {
        initComponents();
         cData = new Customer_Data();
        model = (DefaultTableModel) tb1Data.getModel();
        model.setRowCount(0);
        cData.DisplayListOfPayments(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1Data = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cnicSearch = new javax.swing.JTextField();
        searchBTN = new javax.swing.JButton();
        receivedBTN = new javax.swing.JButton();
        sendMail = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setLocation(new java.awt.Point(400, 65));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 605));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/payment_1.png"))); // NOI18N
        jLabel1.setText("Customers Payments");

        tb1Data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNIC No.", "Name", "Address", "Mobile No.", "Email", "Amount", "Fee Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb1Data.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tb1DataComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(tb1Data);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("CNIC No.");

        cnicSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cnicSearch.setForeground(new java.awt.Color(255, 0, 0));
        cnicSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cnicSearchFocusGained(evt);
            }
        });
        cnicSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnicSearchActionPerformed(evt);
            }
        });
        cnicSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnicSearchKeyReleased(evt);
            }
        });

        searchBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        searchBTN.setText("Search");
        searchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformed(evt);
            }
        });

        receivedBTN.setForeground(new java.awt.Color(51, 51, 51));
        receivedBTN.setText("Recieved");
        receivedBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedBTNActionPerformed(evt);
            }
        });

        sendMail.setForeground(new java.awt.Color(51, 51, 51));
        sendMail.setText("Send Mail");
        sendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMailActionPerformed(evt);
            }
        });

        jButton1.setText("Mail Message");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sendMail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(receivedBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(cnicSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBTN)
                    .addComponent(cnicSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(receivedBTN)
                        .addGap(18, 18, 18)
                        .addComponent(sendMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(90, 90, 90))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb1DataComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tb1DataComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tb1DataComponentAdded

    private void cnicSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnicSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnicSearchActionPerformed

    private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        cData.DisplayListOfPaymentsSearchingCNIC(model, cnicSearch.getText());
    }//GEN-LAST:event_searchBTNActionPerformed

    private void receivedBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedBTNActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = tb1Data.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tb1Data.getModel();
            
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);

            
            
            String cCNIC = (String) model.getValueAt(selectedRow, 0);
            String Name = (String) model.getValueAt(selectedRow, 1);
            String Payment = (String) model.getValueAt(selectedRow, 5);
            
            cData.ReceivedAmount(cCNIC);
            cData.paymentRecieved(cCNIC, Name, Payment, formattedDate);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        new C_Payments().setVisible(true);
  
    }//GEN-LAST:event_receivedBTNActionPerformed

    private void cnicSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cnicSearchFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_cnicSearchFocusGained

    private void sendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMailActionPerformed
        // TODO add your handling code here:
        int row = tb1Data.getSelectedRow();
       if(!(row == -1)){
          if (!(MailMessage.message==null))
        {
            
            try {
            DefaultTableModel dtm = (DefaultTableModel) tb1Data.getModel();
            String mailRecepient = (String) dtm.getValueAt(row, 4);
          //  System.out.println("error payment");
                SendMail.sendMail(mailRecepient);
                JOptionPane.showMessageDialog(null, "Email Sent");
            } catch (MessagingException ex) {
                Logger.getLogger(C_Payments.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }else
        {
            JOptionPane.showMessageDialog(null, "Please Write the message!");
        }
       }else{
            JOptionPane.showMessageDialog(null, "Please select the customer");
       }
           
    }//GEN-LAST:event_sendMailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new MailMessage().show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cnicSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnicSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tb1Data.getModel();
        TableRowSorter<DefaultTableModel> dtm1 = new TableRowSorter<>(dtm);
        tb1Data.setRowSorter(dtm1);
        dtm1.setRowFilter(RowFilter.regexFilter(cnicSearch.getText()));
    }//GEN-LAST:event_cnicSearchKeyReleased

    
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
            java.util.logging.Logger.getLogger(C_Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_Payments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cnicSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton receivedBTN;
    private javax.swing.JButton searchBTN;
    private javax.swing.JButton sendMail;
    private javax.swing.JTable tb1Data;
    // End of variables declaration//GEN-END:variables
}
