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
public abstract class controllerAset {
    public int id;
    public String namaAset;
    public String kategoriAset;
    public float nilaiAset;
    public String bulanAset;
    
    abstract void inputAset(String namaAset,String kategoriAset, String bulanAset, float nilaiAset);
    abstract void updateAset(int id,String namaAset,String kategoriAset, String bulanAset, float nilaiAset);
    abstract void deleteAset(int id);
    abstract void readAset(int id);
    koneksiDatabase db = new koneksiDatabase();
}

class Aset extends controllerAset{
    public Aset(int id, String namaAset, String kategoriAset, String bulanAset, float nilaiAset){
    this.id = id;
    this.namaAset = namaAset;
    this.kategoriAset = kategoriAset;
    this.bulanAset = bulanAset;
    this.nilaiAset = nilaiAset;
    }

    @Override
    void inputAset(String namaAset, String kategoriAset, String bulanAset, float nilaiAset) {
        try {
            String queryInsert = "INSERT INTO `aset`(namaAset, kategori, nilaiAset, bulan) VALUES (?,?,?,?)" ;
            PreparedStatement pst = db.configDB().prepareStatement(queryInsert);
            
            pst.setString(1, namaAset);
            pst.setString(2, kategoriAset);
            pst.setFloat(3, nilaiAset);
            pst.setString(4, bulanAset);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal dimasukan");
        }
    }

    @Override
    void updateAset(int id, String namaAset, String kategoriAset, String bulanAset, float nilaiAset) {
        try {
            
              String sql = " UPDATE aset SET  namaAset = '" + namaAset + "', kategori = '" + kategoriAset + "', bulan = '" + bulanAset + "' , nilaiAset = '" + nilaiAset + "' WHERE id_aset = '" + id + "'";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di update");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal di update" + e.getMessage());
        }
    }

    @Override
    void deleteAset(int id) {
    try {
            String sql ="delete from aset where id_aset='"+id+"'";
            java.sql.Connection conn = new koneksiDatabase().configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    void readAset(int id) {
    }

}

