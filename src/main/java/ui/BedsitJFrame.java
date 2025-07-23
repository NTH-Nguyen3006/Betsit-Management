/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import ui.controller.BedsitController;
import utils.XAuth;
import utils.XIcon;

/**
 *
 * @author DELL
 */
public final class BedsitJFrame extends javax.swing.JFrame implements BedsitController {

    public BedsitJFrame() {
        initComponents();
        this.init();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlLeft = new javax.swing.JPanel();
        pnlLeftCenter = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        pnlLeftBottom = new javax.swing.JPanel();
        btnTenants = new javax.swing.JButton();
        btnInvoice = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnServices = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlManager = new javax.swing.JPanel();
        pnlCenterBottom = new javax.swing.JPanel();
        btnUser = new javax.swing.JButton();
        btnReport01 = new javax.swing.JButton();
        btnInvoices = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pnlBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Poly Cafe");
        setBackground(new java.awt.Color(255, 51, 51));

        pnlLeft.setBackground(new java.awt.Color(255, 153, 102));
        pnlLeft.setLayout(new java.awt.BorderLayout(1, 1));

        pnlLeftCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeftCenter.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);

        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Thiết kế chưa có tên.jpg"))); // NOI18N
        lblPhoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 1, true));

        lblFullname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblFullname.setForeground(new java.awt.Color(255, 51, 0));
        lblFullname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFullname.setText("Hồng Tỷ");

        pnlLeftBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeftBottom.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlLeftBottom.setPreferredSize(new java.awt.Dimension(310, 150));
        pnlLeftBottom.setLayout(new java.awt.GridLayout(0, 2, 5, 5));

        btnTenants.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnTenants.setText("QUẢN LÍ KHÁCH THUÊ");
        btnTenants.setPreferredSize(new java.awt.Dimension(90, 60));
        btnTenants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTenantsActionPerformed(evt);
            }
        });
        pnlLeftBottom.add(btnTenants);

        btnInvoice.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnInvoice.setText("QUẢN LÍ HỢP ĐỒNG");
        btnInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoiceActionPerformed(evt);
            }
        });
        pnlLeftBottom.add(btnInvoice);

        btnPayment.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnPayment.setText("THANH TOÁN");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        pnlLeftBottom.add(btnPayment);

        btnServices.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnServices.setText("QUẢN LÍ DỊCH VỤ");
        btnServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicesActionPerformed(evt);
            }
        });
        pnlLeftBottom.add(btnServices);

        btnExit1.setText("Kết Thúc");
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });

        btnChangePassword.setText("Đổi Mật Khẩu");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlLeftBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChangePassword))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFullname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnExit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnChangePassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLeftBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlLeftCenter.add(jPanel1, java.awt.BorderLayout.CENTER);

        pnlLeft.add(pnlLeftCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlLeft, java.awt.BorderLayout.LINE_START);

        pnlCenter.setLayout(new javax.swing.OverlayLayout(pnlCenter));

        pnlManager.setOpaque(false);
        pnlManager.setLayout(new java.awt.BorderLayout());

        pnlCenterBottom.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlCenterBottom.setOpaque(false);
        pnlCenterBottom.setPreferredSize(new java.awt.Dimension(693, 150));
        pnlCenterBottom.setLayout(new java.awt.GridLayout(0, 2, 5, 5));

        btnUser.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnUser.setText("QUẢN LÍ NGƯỜI DÙNG");
        btnUser.setPreferredSize(new java.awt.Dimension(200, 60));
        btnUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        pnlCenterBottom.add(btnUser);

        btnReport01.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnReport01.setText("BÁO CÁO - THỐNG KÊ");
        btnReport01.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReport01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport01ActionPerformed(evt);
            }
        });
        pnlCenterBottom.add(btnReport01);

        btnInvoices.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnInvoices.setText("QUẢN LÍ HÓA ĐƠN");
        btnInvoices.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoicesActionPerformed(evt);
            }
        });
        pnlCenterBottom.add(btnInvoices);

        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnExit.setText("KẾT THÚC");
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlCenterBottom.add(btnExit);

        pnlManager.add(pnlCenterBottom, java.awt.BorderLayout.PAGE_END);

        pnlCenter.add(pnlManager);

        pnlBackground.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bgBedsitJFrame.jpg"))); // NOI18N
        pnlBackground.add(jLabel1);

        pnlCenter.add(pnlBackground);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiceActionPerformed
        
//        this.showReportJDialog(this);
    }//GEN-LAST:event_btnInvoiceActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
//        this.showInvoiceManagerJDialog(this);
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnTenantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTenantsActionPerformed
//        this.showUserManagerJDialog(this);
    }//GEN-LAST:event_btnTenantsActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
//        this.showTenantManagerJDialog(this);
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnReport01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport01ActionPerformed
//        this.showCategoryManagerJDialog(this);
    }//GEN-LAST:event_btnReport01ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
//        this.showBillManagerJDialog(this);
    this.exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoicesActionPerformed
//        this.showUserManagerJDialog(this);
    }//GEN-LAST:event_btnInvoicesActionPerformed

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnServicesActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        // TODO add your handling code here:
        this.exit();
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        // TODO add your handling code here:
        this.showChangePasswordJDialog(this);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

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
            java.util.logging.Logger.getLogger(BedsitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BedsitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BedsitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BedsitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new BedsitJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnInvoices;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnReport01;
    private javax.swing.JButton btnServices;
    private javax.swing.JButton btnTenants;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlCenterBottom;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlLeftBottom;
    private javax.swing.JPanel pnlLeftCenter;
    private javax.swing.JPanel pnlManager;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        this.setLocationRelativeTo(null);
        this.showWelcomeJDialog(this);
        this.showLoginJDialog(this);
        lblFullname.setText(XAuth.user.getFullname());
        int role = XAuth.user.getRoleId();
        if(!(role == 1 || role ==2)){
            pnlCenter.remove(pnlManager);
            btnExit1.setVisible(true);
        }else{
            btnExit1.setVisible(false);
        }

    }
}