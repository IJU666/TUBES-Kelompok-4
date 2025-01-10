/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasbesarpbo;

import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static tugasbesarpbo.koneksiDatabase.mysqlconfig;

/**
 *
 * @author Fauzi
 */
public abstract class controllerPemasukan {
   
    public int id;
    public String catatanPemasukan;
    public String tanggal; 
    public String bulan;
    public float jumlahPemasukan;
//    public DefaultTableModel table;
   
    
    
    abstract void inputPemasukan(String catatanPemasukan, String tanggal, String bulan, float jumlahPemasukan);
    abstract void updatePemasukan(int id, String catatanPemasukan, String tanggal, String bulan, float jumlahPemasukan);
    abstract void deletePemasukan(int id);
    abstract void readPemasukan(DefaultTableModel table);
    koneksiDatabase db = new koneksiDatabase();
}

class pemasukan extends controllerPemasukan{
    
    public pemasukan(int id, String catatanPemasukan, String tanggal, String bulan, float jumlahPemasukan) {
       this.id = id; 
       this.catatanPemasukan = catatanPemasukan; 
       this.tanggal = tanggal; 
       this.bulan = bulan; 
       this.jumlahPemasukan = jumlahPemasukan;
//       this. table = table;
    }
 
//    @Override
//    void inputPemasukan() {
//        try {
//        String queryInsert = "INSERT INTO `pemasukan`(catatanPemasukan, tanggal, bulan, jumlahPemasukan) VALUES (?,?,?,?)" ;
//        PreparedStatement pst = db.configDB().prepareStatement(queryInsert);
//        pst.setString(1, catatanPemasukan);
//        pst.setString(2, tanggal);
//        pst.setString(3, bulan);
//        pst.setFloat(4, jumlahPemasukan);
//        pst.execute(); 
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Terjadi kesalahan"); 
//       }
//    }

    @Override
    void inputPemasukan(String catatanPemasukan, String tanggal, String bulan, float jumlahPemasukan) {
        try {
        String queryInsert = "INSERT INTO `pemasukan`(catatanPemasukan, tanggal, bulan, jumlahPemasukan) VALUES (?,?,?,?)" ;
        PreparedStatement pst = db.configDB().prepareStatement(queryInsert);
        pst.setString(1, catatanPemasukan);
        pst.setString(2, tanggal);
        pst.setString(3, bulan);
        pst.setFloat(4, jumlahPemasukan);
        pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan"); 
       }
    }

    @Override
    void updatePemasukan(int id, String catatanPemasukan, String tanggal, String bulan, float jumlahPemasukan) {
            try { 
                String sql = " UPDATE pemasukan SET  catatanPemasukan = '" + catatanPemasukan + "', tanggal = '" + tanggal + "', bulan = '" + bulan + "' , jumlahPemasukan = '" + jumlahPemasukan + "' WHERE id_pemasukan = '" + id + "'";
                java.sql.PreparedStatement pst = db.configDB().prepareStatement(sql);
                pst.execute(); 
                JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    void deletePemasukan(int id) {
      try {
            String sql ="delete from pemasukan where id_pemasukan='"+id+"'";
            java.sql.PreparedStatement pst=db.configDB().prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ada yang salah");
        }
    }

    @Override
    void readPemasukan(DefaultTableModel table) {
//        DefaultTableModel model = new DefaultTableModel();
//        try {
//            formPemasukan fp = new formPemasukan();
//            model.addColumn("ID PEMASUKAN");
//            model.addColumn("Catatan");
//            model.addColumn("Tanggal");
//            model.addColumn("Bulan");
//            model.addColumn("Jumlah Pemasukan");
//            
//            String sql = "SELECT * FROM `pemasukan`";
//            java.sql.Connection conn = new koneksiDatabase().configDB();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet res = stm.executeQuery(sql);
//            while (res.next()) {            
//            model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(4), res.getString(3), res.getString(5)});
//            table.setModel(model);
//        }
//           
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
    }

}