/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasbesarpbo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static tugasbesarpbo.koneksiDatabase.mysqlconfig;

/**
 *
 * @author Fauzi
 */
public class formPemasukan extends javax.swing.JFrame {
private pemasukan database;
//private pemasukan2 database2;
int id_pemasukan;
String catatanPemasukan;
String tanggal;
String bulan;
float jumlahPemasukan;



    /**
     * Creates new form formPemasukan
     */
    public formPemasukan() {
        initComponents();
        readPemasukan();
        
        
    }
    
    private void kosong(){
        formId.setText(null);
        formCatatan.setText(null);
        formBulan.setText(null);
        formTanggal.setText(null);
        formJumlah.setText(null);
        
    }
    

    
    private void deletePemasukan(){
       
        readPemasukan();
        kosong();
        
    }
    
    private void readPemasukan(){
         DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID PEMASUKAN");
            model.addColumn("Catatan");
            model.addColumn("Tanggal");
            model.addColumn("Bulan");
            model.addColumn("Jumlah Pemasukan");

        try {
            String sql = "SELECT * FROM `pemasukan`";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {            
            model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(4), res.getString(3), res.getString(5)});
        }
            tablePemasukan.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePemasukan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        buttonHapus = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        formId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        formCatatan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        formJumlah = new javax.swing.JTextField();
        buttonBatal = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        formTanggal = new javax.swing.JTextField();
        formBulan = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        buttonKembali = new javax.swing.JMenuItem();
        buttonKeluar = new javax.swing.JMenuItem();

        jMenu1.setText("File");

        jMenuItem1.setText("Kembali");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Keluar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FORM PEMASUKAN");

        tablePemasukan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID PEMASUKAN", "Catatan", "Tanggal ", "Bulan ", "Jumlah "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePemasukan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePemasukanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePemasukan);
        if (tablePemasukan.getColumnModel().getColumnCount() > 0) {
            tablePemasukan.getColumnModel().getColumn(0).setResizable(false);
            tablePemasukan.getColumnModel().getColumn(1).setResizable(false);
            tablePemasukan.getColumnModel().getColumn(2).setResizable(false);
            tablePemasukan.getColumnModel().getColumn(3).setResizable(false);
            tablePemasukan.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel6.setText("Bulan Pemasukan");

        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        editButton.setText("Update");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        formId.setEnabled(false);
        formId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formIdActionPerformed(evt);
            }
        });

        jLabel5.setText("ID PEMASUKAN");

        formCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCatatanActionPerformed(evt);
            }
        });

        jLabel3.setText("Catatan Pemasukan");

        jLabel4.setText("Tanggal Pemasukan");

        jLabel7.setText("Jumlah Pemasukan");

        formJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formJumlahActionPerformed(evt);
            }
        });

        buttonBatal.setBackground(new java.awt.Color(220, 53, 69));
        buttonBatal.setForeground(new java.awt.Color(255, 255, 255));
        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        buttonSimpan.setBackground(new java.awt.Color(25, 135, 84));
        buttonSimpan.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        jMenu2.setText("Menu");

        buttonKembali.setText("Kembali");
        buttonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliActionPerformed(evt);
            }
        });
        jMenu2.add(buttonKembali);

        buttonKeluar.setText("Keluar");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });
        jMenu2.add(buttonKeluar);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(editButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buttonHapus)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(buttonBatal)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buttonSimpan))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(formTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(formBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(formCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(455, 455, 455)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(formId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(61, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(formId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(484, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void buttonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliActionPerformed
       Home back = new Home();
        back.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonKembaliActionPerformed

    private void tablePemasukanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePemasukanMouseClicked
     int baris = tablePemasukan.rowAtPoint(evt.getPoint());
     String id = tablePemasukan.getValueAt(baris, 0).toString();
     formId.setText(id);
     String catatan = tablePemasukan.getValueAt(baris, 1).toString();
     formCatatan.setText(catatan);
     String tanggal = tablePemasukan.getValueAt(baris, 2).toString();
     formTanggal.setText(tanggal);
     String bulan = tablePemasukan.getValueAt(baris, 3).toString();
     formBulan.setText(bulan);
     String jumlahPemasukan = tablePemasukan.getValueAt(baris, 4).toString();
     formJumlah.setText(jumlahPemasukan);
    
    }//GEN-LAST:event_tablePemasukanMouseClicked

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        id_pemasukan = Integer.parseInt(formId.getText());
                  catatanPemasukan = formCatatan.getText();
                   tanggal = formTanggal.getText();
                   bulan = formBulan.getText();
                   jumlahPemasukan = Float.parseFloat(formJumlah.getText());
          pemasukan db = new pemasukan(id_pemasukan, catatanPemasukan, tanggal, bulan, jumlahPemasukan);
          db.deletePemasukan(id_pemasukan);
          readPemasukan();
    
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
                   id_pemasukan = Integer.parseInt(formId.getText());
                  catatanPemasukan = formCatatan.getText();
                   tanggal = formTanggal.getText();
                   bulan = formBulan.getText();
                   jumlahPemasukan = Float.parseFloat(formJumlah.getText());
        pemasukan db = new pemasukan(id_pemasukan, catatanPemasukan, tanggal, bulan, jumlahPemasukan);
        // TODO add your handling code here:
        db.updatePemasukan(id_pemasukan, catatanPemasukan, tanggal, bulan, jumlahPemasukan);
        readPemasukan();
        
        
    }//GEN-LAST:event_editButtonActionPerformed

    private void formIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formIdActionPerformed
        formId.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_formIdActionPerformed

    private void formJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formJumlahActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        kosong();
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed

       catatanPemasukan = formCatatan.getText();
       tanggal =formTanggal.getText();
       bulan = formBulan.getText();
       jumlahPemasukan = Float.parseFloat(formJumlah.getText());
       pemasukan mk = new pemasukan(WIDTH, catatanPemasukan, tanggal, bulan, jumlahPemasukan);
       mk.inputPemasukan(catatanPemasukan, tanggal, bulan, jumlahPemasukan);
       JOptionPane.showMessageDialog(rootPane, "Data Berhasil Masuk");
       readPemasukan();
       kosong();

    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void formCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCatatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formCatatanActionPerformed

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
            java.util.logging.Logger.getLogger(formPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPemasukan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JMenuItem buttonKeluar;
    private javax.swing.JMenuItem buttonKembali;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton editButton;
    public javax.swing.JTextField formBulan;
    public javax.swing.JTextField formCatatan;
    public javax.swing.JTextField formId;
    public javax.swing.JTextField formJumlah;
    public javax.swing.JTextField formTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablePemasukan;
    // End of variables declaration//GEN-END:variables
}