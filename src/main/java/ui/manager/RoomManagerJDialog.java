package ui.manager;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import dao.RoomDAO;
import entity.Room;
import entity.Room.eStatus;
import impl.RoomDAOImpl;
import ui.controller.RoomController;
import utils.XDialog;

public class RoomManagerJDialog extends javax.swing.JDialog implements RoomController {

    public RoomManagerJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusBtnGroup = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRooms = new javax.swing.JTable();
        txtSearchRoomId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnNewRooom = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRentPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdopanel = new javax.swing.JPanel();
        rdoAvailable = new javax.swing.JRadioButton();
        rdoRented = new javax.swing.JRadioButton();
        rdoRepair = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cboRoomType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnMoveFirst = new javax.swing.JButton();
        btnMovePrevious = new javax.swing.JButton();
        btnMoveNext = new javax.swing.JButton();
        btnMoveLast = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btnCheckAll = new javax.swing.JButton();
        btnUncheckAll = new javax.swing.JButton();
        btnDeleteCheckedItems = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản Lí Phòng");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Loại phòng", "Diện tích", "Giá Thuê", "Trạng thái", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane1.setViewportView(tblRooms);

        txtSearchRoomId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchRoomIdActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã phòng");

        btnNewRooom.setText("Nhập mới");
        btnNewRooom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRooomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearchRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewRooom)
                .addContainerGap(275, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel7)
                    .addComponent(btnNewRooom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Mã Phòng");

        txtId.setEditable(false);
        txtId.setAutoscrolls(false);
        txtId.setFocusable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Diện Tích");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setText("Giá Thuê");

        txtRentPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRentPriceActionPerformed(evt);
            }
        });

        jLabel6.setText("Trạng thái");

        statusBtnGroup.add(rdoAvailable);
        rdoAvailable.setText("Chưa Thuê");
        rdoAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAvailableActionPerformed(evt);
            }
        });

        statusBtnGroup.add(rdoRented);
        rdoRented.setText("Đã Thuê");

        statusBtnGroup.add(rdoRepair);
        rdoRepair.setText("Đang Sửa Chửa");

        jLabel4.setText("Kiểu Phòng");

        cboRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRoomTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rdopanelLayout = new javax.swing.GroupLayout(rdopanel);
        rdopanel.setLayout(rdopanelLayout);
        rdopanelLayout.setHorizontalGroup(
            rdopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rdopanelLayout.createSequentialGroup()
                .addComponent(rdoAvailable)
                .addGap(68, 68, 68)
                .addComponent(rdoRented)
                .addGap(75, 75, 75)
                .addComponent(rdoRepair)
                .addGap(0, 476, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
            .addComponent(cboRoomType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rdopanelLayout.setVerticalGroup(
            rdopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rdopanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(rdopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAvailable)
                    .addComponent(rdoRented)
                    .addComponent(rdoRepair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setText("Ghi Chú");

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        jScrollPane2.setViewportView(txtNotes);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(txtArea, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(txtRentPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(rdopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(66, 66, 66))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(rdopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel7.setLayout(new java.awt.GridLayout(1, 0, 2, 2));

        btnCreate.setText("Tạo mới");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel7.add(btnCreate);

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel7.add(btnUpdate);

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel7.add(btnDelete);

        btnClear.setText("Nhập mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel7.add(btnClear);

        jPanel4.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 2, 2));

        btnMoveFirst.setText("|<");
        btnMoveFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveFirstActionPerformed(evt);
            }
        });
        jPanel8.add(btnMoveFirst);

        btnMovePrevious.setText("<<");
        btnMovePrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovePreviousActionPerformed(evt);
            }
        });
        jPanel8.add(btnMovePrevious);

        btnMoveNext.setText(">>");
        btnMoveNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveNextActionPerformed(evt);
            }
        });
        jPanel8.add(btnMoveNext);

        btnMoveLast.setText(">|");
        btnMoveLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveLastActionPerformed(evt);
            }
        });
        jPanel8.add(btnMoveLast);

        jPanel4.add(jPanel8, java.awt.BorderLayout.LINE_END);
        jPanel4.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        tabs.addTab("BIỂU MẪU", jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 2, 2));

        btnCheckAll.setText("Chọn tất cả");
        btnCheckAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckAllActionPerformed(evt);
            }
        });
        jPanel3.add(btnCheckAll);

        btnUncheckAll.setText("Bỏ chọn tất cả");
        btnUncheckAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUncheckAllActionPerformed(evt);
            }
        });
        jPanel3.add(btnUncheckAll);

        btnDeleteCheckedItems.setText("Xóa các mục chọn");
        btnDeleteCheckedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCheckedItemsActionPerformed(evt);
            }
        });
        jPanel3.add(btnDeleteCheckedItems);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchRoomIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchRoomIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchRoomIdActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.SearchByRoomId();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewRooomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRooomActionPerformed
        this.newRoom();
    }//GEN-LAST:event_btnNewRooomActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIdActionPerformed

    }// GEN-LAST:event_txtIdActionPerformed

    private void rdoAvailableActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdoAvailableActionPerformed

    }// GEN-LAST:event_rdoAvailableActionPerformed

    private void tblRoomsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblRoomsMouseClicked
        if (evt.getClickCount() == 2) {
            this.edit();
        }
    }// GEN-LAST:event_tblRoomsMouseClicked

    private void btnCheckAllActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCheckAllActionPerformed

        this.checkAll();
    }// GEN-LAST:event_btnCheckAllActionPerformed

    private void btnUncheckAllActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUncheckAllActionPerformed

        this.uncheckAll();
    }// GEN-LAST:event_btnUncheckAllActionPerformed

    private void btnDeleteCheckedItemsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteCheckedItemsActionPerformed

        this.deleteCheckedItems();
    }// GEN-LAST:event_btnDeleteCheckedItemsActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCreateActionPerformed

        this.create();
    }// GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed

        this.update();
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed

        this.delete();
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearActionPerformed

        this.clear();
    }// GEN-LAST:event_btnClearActionPerformed

    private void btnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoveFirstActionPerformed

        this.moveFirst();
    }// GEN-LAST:event_btnMoveFirstActionPerformed

    private void btnMovePreviousActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMovePreviousActionPerformed

        this.movePrevious();
    }// GEN-LAST:event_btnMovePreviousActionPerformed

    private void btnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoveNextActionPerformed

        this.moveNext();
    }// GEN-LAST:event_btnMoveNextActionPerformed

    private void btnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoveLastActionPerformed

        this.moveLast();
    }// GEN-LAST:event_btnMoveLastActionPerformed

    private void cboRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboRoomTypeActionPerformed

    }// GEN-LAST:event_cboRoomTypeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        // TODO: xử lý gì đó khi mở cửa sổ
        System.out.println("Window opened");
        this.open();
    }

    public void txtNotesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public void txtRentPriceActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public void abtnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoomManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomManagerJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RoomManagerJDialog dialog = new RoomManagerJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteCheckedItems;
    private javax.swing.JButton btnMoveFirst;
    private javax.swing.JButton btnMoveLast;
    private javax.swing.JButton btnMoveNext;
    private javax.swing.JButton btnMovePrevious;
    private javax.swing.JButton btnNewRooom;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUncheckAll;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboRoomType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoAvailable;
    private javax.swing.JRadioButton rdoRented;
    private javax.swing.JRadioButton rdoRepair;
    private javax.swing.JPanel rdopanel;
    private javax.swing.ButtonGroup statusBtnGroup;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblRooms;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextField txtRentPrice;
    private javax.swing.JTextField txtSearchRoomId;
    // End of variables declaration//GEN-END:variables
    RoomDAO dao = new RoomDAOImpl();
    List<Room> items = List.of();
    List<String> room = List.of();
    // private int index = 0;

    @Override
    public void open() {
        setLocationRelativeTo(null);
        this.fillToTable(); // Đổ dữ liệu lên bảng
        this.fillRoomType(); // đổ dữ liệu vào cbo
    }

    List<String> roomtype = List.of("Phòng Deluxe", "Phòng Đôi", "Phòng Đơn", "Phòng Gia Đình", "Phòng Mini",
            "Phòng Studio", "Khác");

    @Override
    public void fillRoomType() {
        DefaultComboBoxModel<String> cboModel = (DefaultComboBoxModel<String>) cboRoomType.getModel();
        cboModel.removeAllElements(); // Xóa tất cả các mục hiện có trong ComboBox

        roomtype.forEach(roomType -> {
            cboModel.addElement(roomType);
        });

        if (cboModel.getSize() > 0) {
            cboRoomType.setSelectedIndex(0);
        }
    }

    @Override
    public void fillToTable() {
        String[] statusVN = { "Đang thuê", "Chưa thuê", "Sửa chữa" };
        DefaultTableModel tblModel = (DefaultTableModel) tblRooms.getModel();
        tblModel.setRowCount(0);

        items = dao.findAll();

        if (items != null) {
            for (Room room : items) {
                int statusIndex = room.getStatus();
                String statusName = (statusIndex >= 0 && statusIndex < statusVN.length)
                        ? statusVN[statusIndex]
                        : "Không xác định";
                tblModel.addRow(new Object[] {
                        room.getRoomId(),
                        room.getRoomType(),
                        room.getArea(),
                        room.getRentPrice(),
                        // room.getStatus(),
                        statusName,
                        room.getNotes()
                });
            }
        }
    }

    @Override
    public void edit() {
        Room entity = items.get(tblRooms.getSelectedRow());
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
        if (tblRooms.getSelectedRowCount() == 0) {
            XDialog.alert("Bạn đang không chọn bất kì dòng nào", "Thông báo chọn");
        }
        tblRooms.clearSelection();
        this.setEditable(false);
    }

    private void setCheckedAll(boolean checked) {
        tblRooms.selectAll();
    }

    @Override
    public void setForm(Room entity) {
        txtId.setText(String.valueOf(entity.getRoomId()));
        txtArea.setText(String.valueOf(entity.getArea()));
        txtRentPrice.setText(String.valueOf(entity.getRentPrice()));
        // txtStatus.setText(String.valueOf(entity.getStatus()));
        eStatus status = eStatus.values()[entity.getStatus()];
        if (status == eStatus.Available) {
            rdoAvailable.setSelected(true);
        } else if (status == eStatus.Rented) {
            rdoRented.setSelected(true);
        } else if (status == eStatus.Repair) {
            rdoRepair.setSelected(true);
        }

        cboRoomType.setSelectedIndex(roomtype.size() - 1);
        for (int i = 0; i < roomtype.size(); i++) {
            if (roomtype.get(i).equals(entity.getRoomType())) {
                cboRoomType.setSelectedIndex(i);
            }
        }

        txtNotes.setText(entity.getNotes());

    }

    @Override
    public Room getForm() {
        System.out.println("getform ............");
        Room entity = new Room();

        if (txtArea.getText().isEmpty() && txtNotes.getText().isEmpty() && txtRentPrice.getText().isEmpty()) {
            XDialog.alert("bạn chưa nhập bất kì mục nào", "Thông báo nhập");
            return null;
        } else {
            if (txtArea.getText().isEmpty()) {
                XDialog.alert("Không được để trống mã phòng", "Thông báo nhập");
                return null;
            } else if (txtRentPrice.getText().isEmpty()) {
                XDialog.alert("Không được để trống Giá thuê", "Thông báo nhập");
                return null;
            } else if (cboRoomType.getSelectedIndex() == -1 || cboRoomType.getSelectedItem() == null) {
                XDialog.alert("Vui lòng chọn loại phòng", "Thông báo nhập");
                return null;
            } else if (!rdoAvailable.isSelected() && !rdoRented.isSelected() && !rdoRepair.isSelected()) {
                XDialog.alert("Vui lòng chọn trạng thái phòng", "Thông báo nhập");
                return null;
            }
        }

        // entity.setRoomId(Integer.parseInt(txtId.getText()));
        entity.setArea(Double.parseDouble(txtArea.getText()));
        entity.setRentPrice(new BigDecimal(txtRentPrice.getText()));
        eStatus status = eStatus.values()[entity.getStatus()];
        if (rdoAvailable.isSelected()) {
            status = eStatus.Available;

        } else if (rdoRented.isSelected()) {
            status = eStatus.Rented;

        } else if (rdoRepair.isSelected()) {
            status = eStatus.Repair;
        }
        entity.setStatus(status.ordinal());
        String SelectedItem = cboRoomType.getSelectedItem().toString();
        entity.setRoomType(SelectedItem);
        entity.setNotes(txtNotes.getText());

        return entity;
    }

    @Override
    public void create() {
        Room room = getForm();
        if (room != null) {
            try {
                dao.create(room);
                XDialog.alert("Thêm mới phòng thành công!");
                this.fillToTable();
                this.clear(); // Xóa trắng form sau khi thêm mới
            } catch (Exception e) {
                XDialog.alert("Thêm mới phòng thất bại: " + e.getMessage());
            }
        }
    }

    @Override
    public void update() {
        System.out.println("cập nhật");
        Room room = getForm();
        if (room != null) {
            try {
                dao.update(room);
                XDialog.alert("Cập nhật phòng thành công!");
                this.fillToTable();
                this.clear();
                // Không cần clear() ở đây để người dùng có thể thấy thông tin vừa cập nhật
            } catch (Exception e) {
                XDialog.alert("Cập nhật phòng thất bại");
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void delete() {
        if (XDialog.confirm("Bạn có chắc chắn muốn xóa phòng này không?")) {
            try {
                String roomId = txtId.getText();
                dao.deleteById(roomId);
                XDialog.alert("Xóa phòng thành công!");
                this.fillToTable();
                this.clear(); // Xóa trắng form sau khi xóa
            } catch (Exception e) {
                XDialog.alert("Xóa phòng thất bại: " + e.getMessage());
            }
        }

    }

    @Override
    public void clear() {
        txtArea.setText("");
        txtId.setText("");
        txtNotes.setText("");
        txtRentPrice.setText("");
        rdoAvailable.setSelected(false);
        rdoRented.setSelected(false);
        rdoRepair.setSelected(false);
        this.setEditable(false);
    }

    @Override
    public void setEditable(boolean editable) {
        btnCreate.setEnabled(!editable);
        btnUpdate.setEnabled(editable);
        btnDelete.setEnabled(editable);

        int rowCount = tblRooms.getRowCount();
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
        this.moveTo(tblRooms.getSelectedRow() - 1);
    }

    @Override
    public void moveNext() {
        this.moveTo(tblRooms.getSelectedRow() + 1);
    }

    @Override
    public void moveLast() {
        this.moveTo(tblRooms.getRowCount() - 1);
    }

    @Override
    public void moveTo(int index) {
        if (index < 0) {
            this.moveLast();
        } else if (index >= tblRooms.getRowCount()) {
            this.moveFirst();
        } else {
            tblRooms.clearSelection();
            tblRooms.setRowSelectionInterval(index, index);
            this.edit();
        }
    }

    @Override
    public void chooseFile() {

    }

    @Override
    public void deleteCheckedItems() {
        int[] selectedRows = tblRooms.getSelectedRows();
        if (selectedRows.length == 0) {
            XDialog.alert("Đang không chọn bất kì dòng nào để xóa", "Vui lòng chọn");
        }
        if (XDialog.confirm("Bạn chắc chắn muốn xóa mục này chứ?", "Cảnh báo xóa")) {
            try {
                if (selectedRows.length > 0) {
                    // Iterate in reverse to avoid issues with index changes after deletion
                    for (int i = selectedRows.length - 1; i >= 0; i--) {
                        String roomId = String.valueOf(tblRooms.getValueAt(selectedRows[i], 0));
                        dao.deleteById(roomId);
                    }
                    this.fillToTable();
                    this.clear();
                }
            } catch (Exception e) {
                XDialog.alert("Xóa tài sản không thành công");
                System.out.println(e.getMessage());
            }
        }
    }
    public void SearchByRoomId(){
        String RoomId = txtSearchRoomId.getText().trim();
        if (RoomId.isEmpty()) {
            XDialog.alert("Vui lòng nhập mã phòng");
            return;
        }
        Room entity = dao.findById(RoomId);
        if (entity == null) {
            XDialog.alert("Không tìm thấy phòng");
            return;
        }
        this.setForm(entity);
        this.setEditable(true);
        tabs.setSelectedIndex(1);
    }
    public void newRoom(){
        txtSearchRoomId.setText("");
    }
}
