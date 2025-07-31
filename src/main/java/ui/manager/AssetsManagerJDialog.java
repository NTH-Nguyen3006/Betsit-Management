/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui.manager;

import dao.AssetsDAO;
import dao.RoomDAO;
import entity.Assets;
import entity.Room;
import impl.AssetsDAOImpl;
import impl.RoomDAOImpl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ui.controller.AssetsController;
import utils.XDialog;
import utils.XIcon;

/**
 *
 * @code by VinhKhanh
 */
public class AssetsManagerJDialog extends javax.swing.JDialog implements AssetsController{

    /**
     * Creates new form AssetsManagerJDialog
     */
    public AssetsManagerJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        lblImage = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAssets = new javax.swing.JTable();
        btnDeleteCheckedItems = new javax.swing.JButton();
        btnUncheckAll = new javax.swing.JButton();
        btnCheckAll = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRooms = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtAssetName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtRoomId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtCondition = new javax.swing.JTextField();
        btnNewInput = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnMoveFirst = new javax.swing.JButton();
        btnMovePrevious = new javax.swing.JButton();
        btnMoveNext = new javax.swing.JButton();
        btnMoveLast = new javax.swing.JButton();
        imageJPanel = new ui.component.ImageJPanel();

        lblImage.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblAssets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài sản", "Tên tài sản", "Số lượng", "Trạng thái", "Ngày thêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAssets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAssetsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAssets);

        btnDeleteCheckedItems.setText("xóa mục đã chọn");
        btnDeleteCheckedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCheckedItemsActionPerformed(evt);
            }
        });

        btnUncheckAll.setText("Bỏ chọn tất cả");
        btnUncheckAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUncheckAllActionPerformed(evt);
            }
        });

        btnCheckAll.setText("Chọn tất cả");
        btnCheckAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckAllActionPerformed(evt);
            }
        });

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRooms);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addComponent(btnCheckAll)
                .addGap(31, 31, 31)
                .addComponent(btnUncheckAll)
                .addGap(27, 27, 27)
                .addComponent(btnDeleteCheckedItems)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheckAll)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUncheckAll)
                        .addComponent(btnDeleteCheckedItems)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Danh Sách", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã tài sản");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên tài sản");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Phòng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Số lượng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Chất lượng");

        btnNewInput.setText("Nhập mới");
        btnNewInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewInputActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCreate.setText("Tạo mới");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnMoveFirst.setText("|<");
        btnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveFirstActionPerformed(evt);
            }
        });

        btnMovePrevious.setText("<<");
        btnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovePreviousActionPerformed(evt);
            }
        });

        btnMoveNext.setText(">>");
        btnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveNextActionPerformed(evt);
            }
        });

        btnMoveLast.setText(">|");
        btnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(imageJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(txtAssetName)
                                .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(txtCondition))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtQuantity)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnMoveFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnMovePrevious)
                .addGap(2, 2, 2)
                .addComponent(btnMoveNext)
                .addGap(2, 2, 2)
                .addComponent(btnMoveLast, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewInput)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, 0)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAssetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, 0)
                                .addComponent(txtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel5)))
                        .addGap(1, 1, 1)
                        .addComponent(txtCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete)
                        .addComponent(btnNewInput))
                    .addComponent(btnMoveFirst)
                    .addComponent(btnMovePrevious)
                    .addComponent(btnMoveNext)
                    .addComponent(btnMoveLast))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        tabs.addTab("Biểu Mẫu", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAssetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAssetsMouseClicked
        if (evt.getClickCount() == 2) {
            this.edit();
        }
    }//GEN-LAST:event_tblAssetsMouseClicked

    private void btnDeleteCheckedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCheckedItemsActionPerformed
        this.deleteCheckedItems();
    }//GEN-LAST:event_btnDeleteCheckedItemsActionPerformed

    private void btnUncheckAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUncheckAllActionPerformed
        this.uncheckAll();
    }//GEN-LAST:event_btnUncheckAllActionPerformed

    private void btnCheckAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckAllActionPerformed
        this.checkAll();
    }//GEN-LAST:event_btnCheckAllActionPerformed

    private void tblRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomsMouseClicked
        this.fillToTable();
        }//GEN-LAST:event_tblRoomsMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.open();
    }//GEN-LAST:event_formWindowOpened

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void btnNewInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewInputActionPerformed
        this.clear();
    }//GEN-LAST:event_btnNewInputActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        this.delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.create();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveFirstActionPerformed
        // TODO add your handling code here:
        this.moveFirst();
    }//GEN-LAST:event_btnMoveFirstActionPerformed

    private void btnMovePreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovePreviousActionPerformed
        // TODO add your handling code here:
        this.movePrevious();
    }//GEN-LAST:event_btnMovePreviousActionPerformed

    private void btnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveNextActionPerformed
        // TODO add your handling code here:
        this.moveNext();
    }//GEN-LAST:event_btnMoveNextActionPerformed

    private void btnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveLastActionPerformed
        // TODO add your handling code here:
        this.moveLast();
    }//GEN-LAST:event_btnMoveLastActionPerformed

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
            java.util.logging.Logger.getLogger(AssetsManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssetsManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssetsManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssetsManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AssetsManagerJDialog dialog = new AssetsManagerJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckAll;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteCheckedItems;
    private javax.swing.JButton btnMoveFirst;
    private javax.swing.JButton btnMoveLast;
    private javax.swing.JButton btnMoveNext;
    private javax.swing.JButton btnMovePrevious;
    private javax.swing.JButton btnNewInput;
    private javax.swing.JButton btnUncheckAll;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JFileChooser fileChooser;
    private ui.component.ImageJPanel imageJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblAssets;
    private javax.swing.JTable tblRooms;
    private javax.swing.JTextField txtAssetName;
    private javax.swing.JTextField txtCondition;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtRoomId;
    // End of variables declaration//GEN-END:variables
    List<Room> rooms = List.of();
    List<Assets> items = List.of();
    AssetsDAO dao = new AssetsDAOImpl();   
    private List<Room> listRooms;
    AssetsDAO assetsDAO = new AssetsDAOImpl(); // Khởi tạo AssetsDAO
    RoomDAO roomDAO = new RoomDAOImpl();       // Khởi tạo RoomDAO
    int row = -1;
   
    
    @Override
    public void open() {
        setLocationRelativeTo(null);
        fillroom();
        fillToTable();
//        fillCondition();
    }
    
    @Override
    public void fillroom() {
        DefaultTableModel tblModel = (DefaultTableModel) tblRooms.getModel();
        tblModel.setRowCount(0);

        RoomDAO rdao = new RoomDAOImpl();
        rooms = rdao.findAll();

        rooms.forEach(category -> {
            tblModel.addRow(new Object[]{category.getRoomId()});
        });

        tblRooms.setRowSelectionInterval(0, 0);
    }
    
    @Override
    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblAssets.getModel();
        model.setRowCount(0);

        Room room = rooms.get(tblRooms.getSelectedRow());
        items = dao.findByRoomId(String.valueOf(room.getRoomId()));
        items.forEach(item -> {
            Object[] rowData = {
                item.getId(),
                item.getAssetName(),
                item.getQuantity(),
                item.getCondition(),
//                item.getCreate_at(),
                
                false
            };
            model.addRow(rowData);
        });
        this.clear();
    }
   
        @Override
    public void edit() {
        Assets entity = items.get(tblAssets.getSelectedRow());
        this.setForm(entity);
        this.setEditable(true);
        tabs.setSelectedIndex(1);
    }

    @Override
    public void checkAll() {
        setCheckedAll(true);
    }

    @Override
    public void uncheckAll() {
        setCheckedAll(false);
    }
    
    private void setCheckedAll(boolean checked) {
        for (int i = 0; i < tblAssets.getRowCount(); i++) {
            tblAssets.setValueAt(checked, i, 5);
        }
    }
    
        @Override
    public void deleteCheckedItems() {
        if (XDialog.confirm("Bạn thực sự muốn xóa các mục chọn?")) {
            for (int i = 0; i < tblAssets.getRowCount(); i++) {
                if ((Boolean) tblAssets.getValueAt(i, 5)) {
                    dao.deleteById(String.valueOf(items.get(i).getId()));
                }
            }
            this.fillToTable();
        }
    }
    @Override
    public void setForm(Assets entity) {
        txtId.setText(String.valueOf(entity.getId()));
        txtAssetName.setText(entity.getAssetName());
        txtQuantity.setText(String.valueOf(entity.getQuantity()));
        txtCondition.setText(entity.getCondition());
        txtRoomId.setText(String.valueOf(entity.getRoomId()));    
    }

    @Override
    public Assets getForm() {
        Assets asset = new Assets();
        asset.setId(Integer.parseInt(txtId.getText()));
        asset.setAssetName(txtAssetName.getText());
        asset.setQuantity(Integer.parseInt(txtQuantity.getText()));
        asset.setCondition(txtCondition.getText());
        asset.setRoomId(Integer.parseInt(txtRoomId.getText()));
       
        return asset;    
    }


    
    @Override
    public void create() {
        try {
            Assets entity = this.getForm();
            dao.create(entity);
            this.fillToTable();
            this.clear();
        } catch (Exception e) {
            XDialog.alert("Thêm mới thất bại! " + e.getMessage());
       
        }    
    }

    @Override
    public void update() {
        try {
            Assets entity = this.getForm();
            dao.update(entity);
            this.fillToTable();           
        } catch (Exception e) {
            XDialog.alert("Cập nhật thất bại! " + e.getMessage());
        }    
    }

    @Override
    public void delete() {
        if (XDialog.confirm("Bạn có chắc chắn muốn xóa tài sản này?")) {
            String assetId = txtId.getText();
            try {
                assetsDAO.deleteById(assetId);
                XDialog.alert("Xóa thành công!");
                this.fillToTable();// Sau khi xóa, tải lại bảng tài sản cho phòng hiện tại
                this.clear(); 
            } catch (Exception e) {
                XDialog.alert("Xóa thất bại! " + e.getMessage());               
            }
        }
    }

    @Override
    public void clear() {
        this.setForm(new Assets());
        this.setEditable(false);
    }

    @Override
    public void setEditable(boolean editable) {
        txtId.setEnabled(!editable);
        btnCreate.setEnabled(!editable);
        btnUpdate.setEnabled(editable);
        btnDelete.setEnabled(editable);

        int rowCount = tblAssets.getRowCount();
        btnMoveFirst.setEnabled(editable && rowCount > 0);
        btnMovePrevious.setEnabled(editable && rowCount > 0);
        btnMoveNext.setEnabled(editable && rowCount > 0);
        btnMoveLast.setEnabled(editable && rowCount > 0);
    }


     @Override
    public void moveFirst() {
        this.moveTo(0);
    }

    @Override
    public void movePrevious() {
        this.moveTo(tblAssets.getSelectedRow() - 1);
    }

    @Override
    public void moveNext() {
        this.moveTo(tblAssets.getSelectedRow() + 1);
    }

    @Override
    public void moveLast() {
        this.moveTo(tblAssets.getRowCount() - 1);
    }

    @Override
    public void moveTo(int index) {
        if (index < 0) {
            this.moveLast();
        } else if (index >= tblAssets.getRowCount()) {
            this.moveFirst();
        } else {
            tblAssets.clearSelection();
            tblAssets.setRowSelectionInterval(index, index);
            this.edit();
        }
    }
    private void chooseFile() {
        
        String[] fileTypeAllow = {"png", "jpg", "jpeg"};
        fileChooser.setFileFilter(new FileNameExtensionFilter("Chọn ảnh image/*", fileTypeAllow));
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            File file = XIcon.copyTo(selectedFile, "images");
            lblImage.setToolTipText(file.getName());
            XIcon.setIcon(lblImage, file);
        }
    }
}
