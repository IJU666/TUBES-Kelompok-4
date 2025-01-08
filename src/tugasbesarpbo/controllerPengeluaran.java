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
public abstract class controllerPengeluaran {
    public int id;
    public String catatanPengeluaran;
    public String tanggal;
    public String kategori;
    public String bulan;
    public float jumlahPengeluaran;
    
    abstract void inputPengeluaran(String catatanPengeluaran, String tangal, String kategori, String bulan, float jumlahPengeluaran);
    abstract void updatePengeluaran(int id ,String catatanPengeluaran, String tangal, String kategori, String bulan, float jumlahPengeluaran);
    abstract void deletePengeluaran(int id);
    abstract void readPengeluaran(int id);
    koneksiDatabase db = new koneksiDatabase();
}

class pengeluaran extends controllerPengeluaran{
    
    public pengeluaran(int id, String catatanPengeluaran, String tanggal, String bulan, String kategori, float jumlahPengeluaran) {
       this.id = id; 
       this.catatanPengeluaran = catatanPengeluaran; 
       this.tanggal = tanggal; 
       this.kategori = kategori;
       this.bulan = bulan; 
       this.jumlahPengeluaran = jumlahPengeluaran;
//       this. table = table;
    }
    @Override
    void inputPengeluaran(String catatanPengeluaran, String tangal, String bulan, String kategori, float jumlahPengeluaran) {
        try {
            String queryInsert = "INSERT INTO `pengeluaran`(catatanPengeluaran, tanggal, bulan, kategori, jumlahPengeluaran) VALUES (?,?,?,?,?)" ;
        PreparedStatement pst = db.configDB().prepareStatement(queryInsert);
        pst.setString(1, catatanPengeluaran);
        pst.setString(2, tanggal);
        pst.setString(3, bulan);
        pst.setString(4, kategori);
        pst.setFloat(5, jumlahPengeluaran);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Data berhasil dimasukan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal dimasukan");
        }
    }

    @Override
    void updatePengeluaran(int id, String catatanPengeluaran, String tangal, String bulan, String kategori, float jumlahPengeluaran) {
       try {
            
              String sql = " UPDATE pengeluaran SET  catatanPengeluaran = '" + catatanPengeluaran + "', tanggal = '" + tanggal + "', bulan = '" + bulan + "', kategori = '" + kategori + "' , jumlahPengeluaran = '" + jumlahPengeluaran + "' WHERE id_pengeluaran = '" + id + "'";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di update");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal di update" + e.getMessage());
        } 
    }

    @Override
    void deletePengeluaran(int id) {
       try {
            String sql ="delete from pengeluaran where id_pengeluaran='"+id+"'";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }  
    }

    @Override
    void readPengeluaran(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}