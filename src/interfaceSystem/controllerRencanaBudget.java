/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceSystem;

import static interfaceSystem.interfaceRencanaBudget.db;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import tugasbesarpbo.koneksiDatabase;

/**
 *
 * @author Fauzi
 */
public class controllerRencanaBudget implements interfaceSystem.interfaceRencanaBudget {
 int id; 
    String kategori;
    String bulanRencana;
    String tanggalAwal;
    String tanggalAkhir;
    float jumlahRencana;
    
    public void setId(int id) {
        this.id = id;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setBulanRencana(String bulanRencana) {
        this.bulanRencana = bulanRencana;
    }

    public void setTanggalAwal(String tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
    }

    public void setTanggalAkhir(String tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public void setJumlahRencana(float jumlahRencana) {
        this.jumlahRencana = jumlahRencana;
    }
   
    
   
   

  
    
    @Override
    public void input(String kategori, String tanggalAwal, String tanggalAkhir, float jumlahRencana, String bulanRencana) {
       try {
            String queryInsert = "INSERT INTO `rencanabudget`(kategori,jumlahBudget, bulan, tglAwal_RB, tglAkhir_RB) VALUES (?,?,?,?,?)" ;
            PreparedStatement pst = db.configDB().prepareStatement(queryInsert);
            pst.setString(1, kategori);
            pst.setFloat(2, jumlahRencana);
            pst.setString(3, bulanRencana);
            pst.setString(4, tanggalAwal);
            pst.setString(5, tanggalAkhir);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan"); 
       } 
    }

    @Override
    public void update(int id, String kategori, String tanggalAwal, String tanggalAkhir, float jumlahRencana, String bulanRencana) {
         try { 
                String sql = " UPDATE rencanabudget SET  kategori = '" + kategori + "', jumlahBudget = '" + jumlahRencana + "', bulan = '" + bulanRencana + "' , tglAwal_RB = '" + tanggalAwal + "' , tglAkhir_RB = '" + tanggalAkhir + "' WHERE id_rencanaBudget = '" + id + "'";
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
            String sql ="delete from rencanaBudget where id_rencanaBudget = '"+id+"'";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
