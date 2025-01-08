/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceSystem;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
//import static tugasbesarpbo.koneksiDatabase.mysqlconfig;
/**
 *
 * @author Fauzi
 */
public class controllerDanaDarurat implements interfaceSiJagu {
    int id;
    String catatanDanaDarurat;
    String bulanDana;
    String tanggalDana;
    float jumlahDanaDarurat;
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCatatanDanaDarurat(String catatanDanaDarurat) {
        this.catatanDanaDarurat = catatanDanaDarurat;
    }

    public void setBulan(String bulan) {
        this.bulanDana = bulan;
    }

    public void setTanggal(String tanggal) {
        this.tanggalDana = tanggal;
    }

    public void setJumlahDanaDarurat(float jumlahDanaDarurat) {
        this.jumlahDanaDarurat = jumlahDanaDarurat;
    }

    

    @Override
    public void input(String catatanDanaDarurat, String tanggalDana, String bulanDana, float jumlahDanaDarurat) {
          try {
            String queryInsert = "INSERT INTO `danadarurat`(catatanDanaDarurat, tanggal, bulan, jumlahDanaDarurat) VALUES (?,?,?,?)" ;
            PreparedStatement pst = db.configDB().prepareStatement(queryInsert);
            pst.setString(1, catatanDanaDarurat);
            pst.setString(2, tanggalDana);
            pst.setString(3, bulanDana);
            pst.setFloat(4, jumlahDanaDarurat);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan"); 
       }
    }

    @Override
    public void update(int id, String catatanDanaDarurat, String tanggalDana, String bulanDana, float jumlahDanaDarurat) {
       try { 
                String sql = " UPDATE danadarurat SET  catatanDanaDarurat = '" + catatanDanaDarurat + "', tanggal = '" + tanggalDana + "', bulan = '" + bulanDana + "' , jumlahDanaDarurat = '" + jumlahDanaDarurat + "' WHERE id_danaDarurat = '" + id + "'";
                java.sql.PreparedStatement pst = db.configDB().prepareStatement(sql);
                pst.execute(); 
                JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void delete(int id) {
            try {
            String sql ="delete from danaDarurat where id_danaDarurat='"+id+"'";
            java.sql.PreparedStatement pst=db.configDB().prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ada yang salah");
        }
    }

    @Override
    public void read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
}
