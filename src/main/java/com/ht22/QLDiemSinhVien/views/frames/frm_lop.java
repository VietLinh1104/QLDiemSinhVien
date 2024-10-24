/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ht22.QLDiemSinhVien.views.frames;

import com.ht22.QLDiemSinhVien.DAO.DAOKhoa;
import com.ht22.QLDiemSinhVien.DAO.DAOLop;
import com.ht22.QLDiemSinhVien.entity.Khoa;
import com.ht22.QLDiemSinhVien.entity.Lop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author linht
 */
public class frm_lop extends javax.swing.JFrame {

    DAOLop lopDAO = new DAOLop();
    DAOKhoa khoaDAO = new DAOKhoa();
    private String tableValueSelected;

    /**
     * Creates new form frm_lop
     */
    public frm_lop() {
        initComponents();
        initTable();
        initList();
        initComboBox();
    }

//    setModel Table
    public void setModelTable(List<Lop> lopList ){
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"Tên Lớp", "Mã Lớp", "Mã Khoa", "Số Sinh Viên"}, 0
        );


        for (Lop lop : lopList) {
            // Thêm một hàng với các giá trị lấy từ đối tượng Lop
            tableModel.addRow(new Object[]{
                    lop.getTenLop(),
                    lop.getMaLop(),
                    lop.getMaKhoa(),
                    lop.getSoSV()
            });
        }

        jTableLop.setModel(tableModel);
        jScrollPaneLop.setViewportView(jTableLop);
    }

//    setTable
    public void initTable(){
//
        List<Lop> lopList = lopDAO.getAll();
//        Set model data for Table
        setModelTable( lopList );

//        handle click data on table
        jTableLop.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTableLop.getSelectedRow(); // Lấy chỉ số hàng được chọn

                if (selectedRow >= 0) { // Kiểm tra xem có hàng nào được chọn không

                    String maLop = jTableLop.getValueAt(selectedRow, 1).toString();
                    tableValueSelected = maLop;
                }
            }
        });
    }

//  set List
    private void initList(){
        //        List Khoa
        List<Khoa> khoas = khoaDAO.getAll();

        // Set List data for models
        DefaultListModel<Khoa> models = new DefaultListModel<>();

//      add data from khoas list for models
        for (Khoa khoa : khoas){
            models.addElement(khoa);
        }

//        Set models to List
        jListKhoa.setModel(models);
        jScrollPaneKhoa.setViewportView(jListKhoa);

//        handle click row list
        jListKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jListKhoa.getSelectedIndex();

                if (selectedRow >= 0) {

                    String maKhoa = jListKhoa.getSelectedValue().getMaKhoa();
                    List<Lop> lopList = lopDAO.getAllByKhoaID(maKhoa);

//                    show data table by id of listSelected
                    setModelTable( lopList );

                }
            }
        });

    }

//    set models data for combobox
    public void initComboBox(){
        List<Khoa> khoas = khoaDAO.getAll();

//        set models
        DefaultComboBoxModel<Khoa> model = new DefaultComboBoxModel<>();

        // set data from khoa to model
        for (Khoa khoa : khoas){
            model.addElement(khoa);  // Thêm đối tượng Khoa
        }

        // get in to Combobox
        jComboBoxKhoa.setModel(model);
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelKhoa = new javax.swing.JPanel();
        jLabelKhoa = new javax.swing.JLabel();
        jScrollPaneKhoa = new javax.swing.JScrollPane();
        jListKhoa = new JList<Khoa>();
        jButtonQuanLyKhoa = new javax.swing.JButton();
        jPanelLop = new javax.swing.JPanel();
        jLabelLop = new javax.swing.JLabel();
        jScrollPaneLop = new javax.swing.JScrollPane();
        jTableLop = new javax.swing.JTable();
        jPanelLopAction = new javax.swing.JPanel();
        jPanelInputTenLop = new javax.swing.JPanel();
        jLabelInputTenLop = new javax.swing.JLabel();
        jScrollPaneInputLop = new javax.swing.JScrollPane();
        jTextPaneInputTenLop = new javax.swing.JTextPane();
        jButtonXoaLop = new javax.swing.JButton();
        jButtonThemLop = new javax.swing.JButton();
        jPanelInputMaLop = new javax.swing.JPanel();
        jLabelInputMaLop = new javax.swing.JLabel();
        jScrollPaneMaLop = new javax.swing.JScrollPane();
        jTextPaneInputMaLop = new javax.swing.JTextPane();
        jPanelInputMaLop1 = new javax.swing.JPanel();
        jLabelInputKhoa = new javax.swing.JLabel();
        jComboBoxKhoa = new JComboBox<Khoa>();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenuBack = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelKhoa.setText("Khoa");

        jScrollPaneKhoa.setViewportView(jListKhoa);

        jButtonQuanLyKhoa.setText("Quản Lý Khoa");

        jButtonQuanLyKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuanLyKhoaActionPerformed(evt);
            }
        });

        jLabelLop.setText("Danh Sách Lớp");

        jTableLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneLop.setViewportView(jTableLop);

        jLabelInputTenLop.setText("Tên Lớp");

        jScrollPaneInputLop.setViewportView(jTextPaneInputTenLop);

        jButtonXoaLop.setText("Xóa Lớp");
        jButtonXoaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaLopActionPerformed(evt);
            }
        });

        jButtonThemLop.setText("Thêm Lớp");
        jButtonThemLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemLopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInputTenLopLayout = new javax.swing.GroupLayout(jPanelInputTenLop);
        jPanelInputTenLop.setLayout(jPanelInputTenLopLayout);
        jPanelInputTenLopLayout.setHorizontalGroup(
            jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                        .addGroup(jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneInputLop)
                            .addComponent(jLabelInputTenLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                        .addComponent(jButtonXoaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))))
        );
        jPanelInputTenLopLayout.setVerticalGroup(
            jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputTenLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputTenLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneInputLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInputTenLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonXoaLop)
                    .addComponent(jButtonThemLop))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabelInputMaLop.setText("Mã Lớp");

        jScrollPaneMaLop.setViewportView(jTextPaneInputMaLop);

        javax.swing.GroupLayout jPanelInputMaLopLayout = new javax.swing.GroupLayout(jPanelInputMaLop);
        jPanelInputMaLop.setLayout(jPanelInputMaLopLayout);
        jPanelInputMaLopLayout.setHorizontalGroup(
            jPanelInputMaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(jLabelInputMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelInputMaLopLayout.setVerticalGroup(
            jPanelInputMaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInputMaLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelInputKhoa.setText("Khoa");


        jComboBoxKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKhoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInputMaLop1Layout = new javax.swing.GroupLayout(jPanelInputMaLop1);
        jPanelInputMaLop1.setLayout(jPanelInputMaLop1Layout);
        jPanelInputMaLop1Layout.setHorizontalGroup(
            jPanelInputMaLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputMaLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInputKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                        .addComponent(jComboBoxKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInputMaLop1Layout.setVerticalGroup(
            jPanelInputMaLop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputMaLop1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInputKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelLopActionLayout = new javax.swing.GroupLayout(jPanelLopAction);
        jPanelLopAction.setLayout(jPanelLopActionLayout);
        jPanelLopActionLayout.setHorizontalGroup(
            jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopActionLayout.createSequentialGroup()
                .addComponent(jPanelInputTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInputMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInputMaLop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLopActionLayout.setVerticalGroup(
            jPanelLopActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInputTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanelInputMaLop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanelInputMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanelLopLayout = new javax.swing.GroupLayout(jPanelLop);
        jPanelLop.setLayout(jPanelLopLayout);
        jPanelLopLayout.setHorizontalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLopLayout.createSequentialGroup()
                .addGroup(jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPaneLop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addComponent(jPanelLopAction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelLopLayout.setVerticalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelLopAction, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelKhoaLayout = new javax.swing.GroupLayout(jPanelKhoa);
        jPanelKhoa.setLayout(jPanelKhoaLayout);
        jPanelKhoaLayout.setHorizontalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneKhoa)
                    .addComponent(jButtonQuanLyKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelKhoaLayout.setVerticalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonQuanLyKhoa)
                .addContainerGap())
            .addComponent(jPanelLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenuHome.setText("Home");
        jMenuBar.add(jMenuHome);

        jMenuBack.setText("Back");
        jMenuBar.add(jMenuBack);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
     * Handle Clicked
     */


    private void jButtonQuanLyKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKhoaActionPerformed
        // TODO add your handling code here:
        // Ẩn frame hiện tại
//        setVisible(false);

        // Hiển thị frame mới
        new frm_khoa().setVisible(true);
    }//GEN-LAST:event_jComboBoxKhoaActionPerformed

    private void jComboBoxKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxKhoaActionPerformed

    private void jButtonXoaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaLopActionPerformed
        // TODO add your handling code here:
        lopDAO.delete(tableValueSelected);
        initTable();
    }//GEN-LAST:event_jButtonXoaLopActionPerformed

    private void jButtonThemLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemLopActionPerformed
        // TODO add your handling code here:

        String tenLop = jTextPaneInputTenLop.getText();
        String maLop = jTextPaneInputMaLop.getText();

//        get Khoa ID from comboBox selected
        Khoa selectedKhoa = (Khoa) jComboBoxKhoa.getSelectedItem();
        String khoa = selectedKhoa.getMaKhoa();


        //  Create object from form input
        Lop lop = new Lop(tenLop, maLop, khoa, 0);

        try {
//            DAO insert
            lopDAO.insert(lop);
        } catch (SQLIntegrityConstraintViolationException e) {
            // Lỗi trùng khóa chính (hoặc unique key)
            JOptionPane.showMessageDialog(this, "Mã lớp đã tồn tại. Vui lòng nhập mã lớp khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // Lỗi chung liên quan đến cơ sở dữ liệu
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Bắt các ngoại lệ khác nếu có
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi không xác định: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        // Cập nhật lại bảng sau khi thêm thành công
        initTable();
    }//GEN-LAST:event_jButtonThemLopActionPerformed

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
            java.util.logging.Logger.getLogger(frm_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_lop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuanLyKhoa;
    private javax.swing.JButton jButtonThemLop;
    private javax.swing.JButton jButtonXoaLop;
    private JComboBox<Khoa> jComboBoxKhoa;
    private javax.swing.JLabel jLabelInputKhoa;
    private javax.swing.JLabel jLabelInputMaLop;
    private javax.swing.JLabel jLabelInputTenLop;
    private javax.swing.JLabel jLabelKhoa;
    private javax.swing.JLabel jLabelLop;
    private JList<Khoa> jListKhoa;
    private javax.swing.JMenu jMenuBack;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JPanel jPanelInputMaLop;
    private javax.swing.JPanel jPanelInputMaLop1;
    private javax.swing.JPanel jPanelInputTenLop;
    private javax.swing.JPanel jPanelKhoa;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelLopAction;
    private javax.swing.JScrollPane jScrollPaneKhoa;
    private javax.swing.JScrollPane jScrollPaneLop;
    private javax.swing.JScrollPane jScrollPaneInputLop;
    private javax.swing.JScrollPane jScrollPaneMaLop;
    private javax.swing.JTable jTableLop;
    private javax.swing.JTextPane jTextPaneInputMaLop;
    private javax.swing.JTextPane jTextPaneInputTenLop;
    // End of variables declaration//GEN-END:variables
}
