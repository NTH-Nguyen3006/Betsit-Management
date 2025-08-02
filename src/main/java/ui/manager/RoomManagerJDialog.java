package ui.manager;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import dao.RoomDAO;
import entity.Room;
import impl.RoomDAOImpl;
import ui.controller.RoomController;
import utils.XDialog;
import utils.XOther;

public class RoomManagerJDialog extends javax.swing.JDialog implements RoomController {

    public RoomManagerJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusBtnGroup = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCheckAll = new javax.swing.JButton();
        btnUncheckAll = new javax.swing.JButton();
        btnDeleteCheckedItems = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRooms = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRentPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        rdoAvailable = new javax.swing.JRadioButton();
        rdoRented = new javax.swing.JRadioButton();
        rdoRepair = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cboRoomType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNotes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout(15, 15));

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

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Mã Phòng", "Loại phòng", "Diện tích", "Giá thuê", "Trạng thái", "Ghi chú"
                }));
        tblRooms.setRowHeight(25);
        tblRooms.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tblRooms.setSelectionForeground(new java.awt.Color(255, 0, 0));
        tblRooms.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRooms.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRooms.setShowGrid(true);
        tblRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRooms);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabs.addTab("DANH SÁCH", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

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

        jPanel6.setLayout(new java.awt.GridLayout(12, 1, 10, 10));

        jLabel1.setText("Mã Phòng");
        jPanel6.add(jLabel1);

        txtId.setEditable(false);
        txtId.setAutoscrolls(false);
        txtId.setFocusable(false);
        jPanel6.add(txtId);

        jLabel2.setText("Diện Tích");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel6.add(jLabel2);
        jPanel6.add(txtArea);

        jLabel3.setText("Giá Thuê");
        jPanel6.add(jLabel3);

        txtRentPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRentPriceActionPerformed(evt);
            }
        });
        jPanel6.add(txtRentPrice);

        jLabel6.setText("Trạng thái");
        jPanel6.add(jLabel6);

        statusBtnGroup.add(rdoAvailable);
        rdoAvailable.setText("Chưa Thuê");

        statusBtnGroup.add(rdoRented);
        rdoRented.setText("Đã Thuê");

        statusBtnGroup.add(rdoRepair);
        rdoRepair.setText("Đang Sửa Chửa");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(rdoAvailable)
                                .addGap(68, 68, 68)
                                .addComponent(rdoRented)
                                .addGap(75, 75, 75)
                                .addComponent(rdoRepair)
                                .addGap(0, 452, Short.MAX_VALUE)));
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdoAvailable)
                                        .addComponent(rdoRented)
                                        .addComponent(rdoRepair))));

        jPanel6.add(jPanel9);

        jLabel4.setText("Kiểu Phòng");
        jPanel6.add(jLabel4);

        cboRoomType.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRoomTypeActionPerformed(evt);
            }
        });
        jPanel6.add(cboRoomType);

        jLabel5.setText("Ghi Chú");
        jPanel6.add(jLabel5);

        txtNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotesActionPerformed(evt);
            }
        });
        jPanel6.add(txtNotes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        tabs.addTab("BIỂU MẪU", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabs)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 443,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRentPriceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtRentPriceActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtRentPriceActionPerformed

    private void btnMoveLastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoveLastActionPerformed
        // TODO add your handling code here:
        this.moveLast();
    }// GEN-LAST:event_btnMoveLastActionPerformed

    private void btnMoveNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoveNextActionPerformed
        // TODO add your handling code here:
        this.moveNext();
    }// GEN-LAST:event_btnMoveNextActionPerformed

    private void btnMovePreviousActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMovePreviousActionPerformed
        // TODO add your handling code here:
        this.movePrevious();
    }// GEN-LAST:event_btnMovePreviousActionPerformed

    private void btnMoveFirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoveFirstActionPerformed
        // TODO add your handling code here:
        this.moveFirst();
    }// GEN-LAST:event_btnMoveFirstActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.clear();
    }// GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        this.delete();
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        this.update();
    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        this.create();
    }// GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteCheckedItemsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteCheckedItemsActionPerformed
        // TODO add your handling code here:
        this.deleteCheckedItems();
    }// GEN-LAST:event_btnDeleteCheckedItemsActionPerformed

    private void btnUncheckAllActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUncheckAllActionPerformed
        // TODO add your handling code here:
        this.uncheckAll();
    }// GEN-LAST:event_btnUncheckAllActionPerformed

    private void btnCheckAllActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCheckAllActionPerformed
        // TODO add your handling code here:
        this.checkAll();
    }// GEN-LAST:event_btnCheckAllActionPerformed

    private void tblRoomsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblRoomsMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.edit();
        }
    }// GEN-LAST:event_tblRoomsMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.open();
    }// GEN-LAST:event_formWindowOpened

    private void cboRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboRoomTypeActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cboRoomTypeActionPerformed

    private void txtNotesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNotesActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNotesActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JButton btnUncheckAll;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboRoomType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoAvailable;
    private javax.swing.JRadioButton rdoRented;
    private javax.swing.JRadioButton rdoRepair;
    private javax.swing.ButtonGroup statusBtnGroup;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblRooms;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNotes;
    private javax.swing.JTextField txtRentPrice;
    // End of variables declaration//GEN-END:variables
    RoomDAO dao = new RoomDAOImpl();
    List<Room> items = List.of();
    private int index = -1;
    private List<Room> listRooms;

    @Override
    public void chooseFile() {

    }

    @Override
    public void open() {
        this.clear(); // xóa form
        this.index = -1; // ặt lại chỉ số chọn
        this.setEditable(true); // Bật chỉnh sửa cho form
        this.fillToTable(); // Đổ dữ liệu lên bảng
        this.fillRoomTypes(); // Đổ dữ liệu cho combobox loại phòng
    }

    @Override
    public void setForm(Room entity) {
        txtArea.setText(String.valueOf(entity.getArea()));
        txtRentPrice.setText(String.valueOf(entity.getRentPrice()));
        // txtStatus.setText(String.valueOf(entity.getStatus()));

        cboRoomType.setSelectedItem(entity.getRoomType());
        txtNotes.setText(entity.getNotes());

    }

    @Override
    public Room getForm() {
        Room room = new Room();
        // Kiểm tra dữ liệu đầu vào cơ bản

        boolean hasEmpty = XOther.hasTextFieldEmpty(txtArea, txtRentPrice, txtNotes);
        if (hasEmpty)
            XDialog.alert("Vui lòng điền đủ thông tin");

        // if (txtArea.getText().isEmpty()) {
        // XDialog.alert("Diện tích không được để trống!");
        // return null;
        // }
        // if (txtRentPrice.getText().isEmpty()) {
        // XDialog.alert("Giá thuê không được để trống!");
        // return null;
        // }

        try {
            int _status = 0; // Avaliable
            if (rdoRented.isSelected())
                _status = Room.eStatus.Rented.ordinal();
            else
                _status = Room.eStatus.Repair.ordinal();

            Room.builder().area(Float.parseFloat(txtArea.getText()))
                    .rentPrice(new BigDecimal(txtRentPrice.getText()))
                    .status(_status).roomType((String) cboRoomType.getSelectedItem())
                    .notes(txtNotes.getText());

            // room.setArea(Float.parseFloat(txtArea.getText()));
            // room.setRentPrice(new BigDecimal(txtRentPrice.getText()));
            // room.setStatus(Integer.parseInt(txtStatus.getText()));
            // room.setRoomType((String) cboRoomType.getSelectedItem());
            // room.setNotes(txtNotes.getText());
        } catch (NumberFormatException e) {
            XDialog.alert("Dữ liệu diện tích hoặc giá thuê không hợp lệ!");
            return null;
        }
        return room;
    }

    @Override
    public void fillToTable() {
        DefaultTableModel tblModel = (DefaultTableModel) tblRooms.getModel();
        tblModel.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng phòng

        // Sử dụng instance dao đã được khai báo ở cấp lớp
        listRooms = dao.findAll();

        if (listRooms != null) {
            for (Room room : listRooms) {
                tblModel.addRow(new Object[] {
                        room.getRoomId(),
                        room.getRoomType(),
                        room.getArea(),
                        room.getRentPrice(),
                        room.getStatus(),
                        // eStatus.values()[room.getStatus()].name(),

                        room.getNotes()
                });
            }
        }
    }

    @Override
    public void edit() {
        this.index = tblRooms.getSelectedRow();
        if (this.index >= 0) {
            String roomId = String.valueOf(tblRooms.getValueAt(this.index, 1)); // Lấy RoomId từ cột thứ 2 (index 1)
            Room entity = dao.findById(roomId);
            if (entity != null) {
                this.setForm(entity);
                this.setEditable(false); // Vô hiệu hóa trường RoomId khi chỉnh sửa
            } else {
                XDialog.alert("Không tìm thấy thông tin phòng cho mã này.");
            }
        }
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
        Room room = getForm();
        if (room != null) {
            try {
                dao.update(room);
                XDialog.alert("Cập nhật phòng thành công!");
                this.fillToTable();
                // Không cần clear() ở đây để người dùng có thể thấy thông tin vừa cập nhật
            } catch (Exception e) {
                XDialog.alert("Cập nhật phòng thất bại: " + e.getMessage());
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
        txtRentPrice.setText("");
        // txtStatus.setText(""); // Đặt lại lựa chọn đầu tiên
        cboRoomType.setSelectedIndex(0); // Đặt lại lựa chọn đầu tiên
        txtNotes.setText("");
        this.index = -1;
        this.setEditable(true); // Kích hoạt tất cả trường cho trạng thái thêm mới
        tblRooms.clearSelection(); // Bỏ chọn trên bảng
    }

    @Override
    public void setEditable(boolean editable) {

        txtArea.setEditable(true);
        txtRentPrice.setEditable(true);
        // txtStatus.setEditable(true);
        cboRoomType.setEnabled(true);
        txtNotes.setEditable(true);
        // txtId.setEnabled(!editable);
        // btnCreate.setEnabled(!editable);
        // btnUpdate.setEnabled(editable);
        // btnDelete.setEnabled(editable);
        //
        // int rowCount = tblRooms.getRowCount();
        // btnMoveFirst.setEnabled(editable && rowCount > 0);
        // btnMovePrevious.setEnabled(editable && rowCount > 0);
        // btnMoveNext.setEnabled(editable && rowCount > 0);
        // btnMoveLast.setEnabled(editable && rowCount > 0);
    }

    @Override
    public void checkAll() {
        tblRooms.selectAll();
    }

    @Override
    public void uncheckAll() {
        tblRooms.clearSelection();
    }

    @Override
    public void deleteCheckedItems() {
        int[] selectedRows = tblRooms.getSelectedRows();
        if (selectedRows.length > 0) {
            // Iterate in reverse to avoid issues with index changes after deletion
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                String roomId = String.valueOf(tblRooms.getValueAt(selectedRows[i], 0));
                dao.deleteById(roomId);
            }
            fillToTable();
            clear();
        }
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
    public void fillCategories() {
    }

    private void setCheckedAll(boolean checked) {
        for (int i = 0; i < tblRooms.getRowCount(); i++) {
            tblRooms.setValueAt(checked, i, 5);
        }
    }

    private void fillRoomTypes() {
        DefaultComboBoxModel<String> cboModel = (DefaultComboBoxModel<String>) cboRoomType.getModel();
        cboModel.removeAllElements(); // Xóa tất cả các mục hiện có trong ComboBox

        // Lấy danh sách các loại phòng từ DAO
        List<String> roomTypes = dao.findAllRoomType();

        // Thêm các loại phòng vào ComboBox
        roomTypes.forEach(roomType -> {
            cboModel.addElement(roomType);
        });

        // Chọn mục đầu tiên (ví dụ: "Tất cả") nếu có mục nào đó
        if (cboModel.getSize() > 0) {
            cboRoomType.setSelectedIndex(0);
        }
    }
}
