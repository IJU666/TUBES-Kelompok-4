/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasbesarpbo;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import tugasbesarpbo.koneksiDatabase;
import static tugasbesarpbo.koneksiDatabase.mysqlconfig;
/**
 *
 * @author Fauzi
 */
public class laporan extends javax.swing.JFrame {
private laporan database;
String jPemasukan;

koneksiDatabase db = new koneksiDatabase();

    public laporan() {
        initComponents();
        hasilSeluruhPemasukan();
        bacaHasilLaporan();
        hasilSeluruhAset();
        searchDataLaporan();
        rbdana();
        rataRata();
    }
    
     private void hasilLaporan(){
         try {
              String sql = "insert into `laporan`(total_pemasukan,total_pengeluaran, total_aset)" +
                      "select(select sum(jumlahPemasukan) from `pemasukan`) as total_pemasukan," + 
                      "(select sum(jumlahPengeluaran) from `pengeluaran`) as total_pengeluaran," + 
                      "(select sum(nilaiAset) from `aset`) as total_aset";
            PreparedStatement pst = db.configDB().prepareStatement(sql);
            pst.executeUpdate();
         } catch (Exception e) {
         }
    }
     
    private void rbdana(){
     try {
              String sql = "select sum(jumlahDanaDarurat) from danadarurat"; 
//                      " join danadarurat using(id_danaDarurat) " + 
//                      "join rencanabudget using(id_rencanaBudget)";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {            
            hasilSimpanan.setText(res.getString(1));
        }
        } catch (Exception e) {
        }
    }
    
    
    private void bacaHasilLaporan(){
    DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id_laporan");
            model.addColumn("Jumlah Pemasukan");
            model.addColumn("Jumlah Pengeluaran");
            model.addColumn("Jumlah Aset");

        try {
            String sql = "SELECT * FROM `laporan`";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {            
            model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3), res.getString(4), res.getString(5)});
        }
            tableHasilLaporan.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void rataRata(){
         try {
              String sql = "select round(sum(jumlahPengeluaran),3) from pengeluaran"; 
//                      " join danadarurat using(id_danaDarurat) " + 
//                      "join rencanabudget using(id_rencanaBudget)";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {            
            rataRata.setText(res.getString(1));
        }
        } catch (Exception e) {
        }
    }
    
    private void hasilSeluruhPemasukan(){
   try {
              String sql = "SELECT sum(jumlahPemasukan) FROM `pemasukan`";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {            
            hasilPemasukan.setText(res.getString(1));
        }
        } catch (Exception e) {
        }
    }
    
    private void searchDataLaporan(){
     DefaultTableModel ob = (DefaultTableModel) tableHasilLaporan.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tableHasilLaporan.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(formCariLaporan.getText()));
    }
    
   
    
    private void hasilSeluruhAset(){
   try {
              String sql = "SELECT sum(nilaiAset) FROM `aset`";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {            
            hasilAset.setText(res.getString(1));
        }
        } catch (Exception e) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hasilPemasukan = new javax.swing.JLabel();
        hasilAset = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        hasilSimpanan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHasilLaporan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        formCariLaporan = new javax.swing.JTextField();
        cariData = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rfLaporan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rataRata = new javax.swing.JLabel();
        rataRata1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        buttonKembali = new javax.swing.JMenuItem();
        buttonKeluar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(215, 218, 239));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Dashboard Si Jagu");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugasbesarpbo/navbar.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 771, -1));

        hasilPemasukan.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        hasilPemasukan.setText("jLabel5");
        hasilPemasukan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hasilPemasukanMouseEntered(evt);
            }
        });
        getContentPane().add(hasilPemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 160, 70));

        hasilAset.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        hasilAset.setText("d");
        getContentPane().add(hasilAset, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 160, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugasbesarpbo/hasilAset.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        hasilSimpanan.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        hasilSimpanan.setText("jLabel7");
        getContentPane().add(hasilSimpanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 130, 40));

        tableHasilLaporan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableHasilLaporan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 920, 270));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugasbesarpbo/formPemasukan.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 240, 130));
        getContentPane().add(formCariLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 150, 40));

        cariData.setText("Cari Data");
        cariData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariDataActionPerformed(evt);
            }
        });
        getContentPane().add(cariData, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 90, 40));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugasbesarpbo/hasilSimpanan.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        rfLaporan.setText("refresh laporan");
        rfLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfLaporanActionPerformed(evt);
            }
        });
        getContentPane().add(rfLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setText("Rata rata pengeluaran");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, -1, -1));

        rataRata.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        rataRata.setForeground(new java.awt.Color(255, 102, 102));
        rataRata.setText("jLabel9");
        getContentPane().add(rataRata, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 130, -1));

        rataRata1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        rataRata1.setForeground(new java.awt.Color(255, 102, 102));
        rataRata1.setText("Rp");
        getContentPane().add(rataRata1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        jMenu1.setText("Menu");

        buttonKembali.setText("Kembali");
        buttonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliActionPerformed(evt);
            }
        });
        jMenu1.add(buttonKembali);

        buttonKeluar.setText("Keluar");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });
        jMenu1.add(buttonKeluar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void buttonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliActionPerformed
        Home back = new Home();
        back.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonKembaliActionPerformed

    private void hasilPemasukanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hasilPemasukanMouseEntered
       
    }//GEN-LAST:event_hasilPemasukanMouseEntered

    private void cariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariDataActionPerformed
        searchDataLaporan();
    }//GEN-LAST:event_cariDataActionPerformed

    private void rfLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfLaporanActionPerformed
       hasilLaporan();
       bacaHasilLaporan();
    }//GEN-LAST:event_rfLaporanActionPerformed

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
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buttonKeluar;
    private javax.swing.JMenuItem buttonKembali;
    private javax.swing.JButton cariData;
    private javax.swing.JTextField formCariLaporan;
    private javax.swing.JLabel hasilAset;
    private javax.swing.JLabel hasilPemasukan;
    private javax.swing.JLabel hasilSimpanan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rataRata;
    private javax.swing.JLabel rataRata1;
    private javax.swing.JButton rfLaporan;
    private javax.swing.JTable tableHasilLaporan;
    // End of variables declaration//GEN-END:variables
}
