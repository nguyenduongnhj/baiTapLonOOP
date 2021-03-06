/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StudentManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BOT
 */
public class ThemMon extends javax.swing.JFrame {

    /**
     * Creates new form ThemMon
     */
    public ThemMon() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        btnAccept = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên Môn Học:");

        txtTenMon.setText(" ");

        jLabel2.setText("Mã Môn Học:");

        btnAccept.setBackground(new java.awt.Color(0, 153, 0));
        btnAccept.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAccept.setForeground(new java.awt.Color(0, 153, 0));
        btnAccept.setText("Xác Nhận");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 0, 0));
        btnBack.setText("Quay Lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenMon, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtMaMon)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnAccept))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaMon, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnAccept)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        DanhSachMonHoc mh = new DanhSachMonHoc();
        mh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        try {
            // TODO add your handling code here:
            String maMon = txtMaMon.getText();
            String tenMon = txtTenMon.getText();
            StudentManager sm = new StudentManager();
            boolean check = sm.themMon(tenMon, maMon);
            if(maMon.length() < 1 || tenMon.length() < 1){
                JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Đủ Thông Tin");

            } else {
                if(check){
                    JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                     DanhSachMonHoc mh = new DanhSachMonHoc();
                    mh.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Mã Môn Học Đã Tồn Tại");
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThemMon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ThemMon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
