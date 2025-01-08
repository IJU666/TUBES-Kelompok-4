package tugasbesarpbo;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksiDatabase {
    protected static Connection mysqlconfig;
    public Connection configDB(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection("jdbc:mysql://localhost:3306/manajemenKeuangan","root","1234");
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal!");
            e.printStackTrace();
        }     
        return mysqlconfig;
    }
  }

class aset extends koneksiDatabase{
    public void inputAset(String namaAset, String kategori, float nilaiAset, String bulan) throws SQLException{
         String queryInsert = "INSERT INTO `aset`(namaAset, kategori, nilaiAset, bulan) VALUES (?,?,?,?)" ;
            PreparedStatement pst = mysqlconfig.prepareStatement(queryInsert);
            
            pst.setString(1, namaAset);
            pst.setString(2, kategori);
            pst.setFloat(3, nilaiAset);
            pst.setString(4, bulan);
            pst.executeUpdate();
    }
}

//class pemasukan extends koneksiDatabase{
//    public void inputPemasukan(String catatanPemasukan, String tanggal, String bulan, float jumlahPemasukan) throws SQLException{
//     String queryInsert = "INSERT INTO `pemasukan`(catatanPemasukan, tanggal, bulan, jumlahPemasukan) VALUES (?,?,?,?)" ;
//     PreparedStatement pst = mysqlconfig.prepareStatement(queryInsert);
//     pst.setString(1, catatanPemasukan);
//     pst.setString(2, tanggal);
//     pst.setString(3, bulan);
//     pst.setFloat(4, jumlahPemasukan);
//     pst.execute();
//    }
//}

class danaDarurat extends koneksiDatabase{
    public void inputPemasukan(String catatanDanaDarurat, String tanggal, String bulan, float jumlahDanaDarurat) throws SQLException{
     String queryInsert = "INSERT INTO `danaDarurat`(catatanDanaDarurat, tanggal, bulan, jumlahDanaDarurat) VALUES (?,?,?,?)" ;
     PreparedStatement pst = mysqlconfig.prepareStatement(queryInsert);
     pst.setString(1, catatanDanaDarurat);
     pst.setString(2, tanggal);
     pst.setString(3, bulan);
     pst.setFloat(4, jumlahDanaDarurat);
     pst.execute();
    }
}

//class pengeluaran extends koneksiDatabase{
//    public void inputPemasukan(String catatanPengeluaran, String tanggal, String bulan, String kategori, float jumlahPengeluaran) throws SQLException{
//     String queryInsert = "INSERT INTO `pengeluaran`(catatanPengeluaran, tanggal, bulan, kategori, jumlahPengeluaran) VALUES (?,?,?,?,?)" ;
//     PreparedStatement pst = mysqlconfig.prepareStatement(queryInsert);
//     pst.setString(1, catatanPengeluaran);
//     pst.setString(2, tanggal);
//     pst.setString(3, bulan);
//     pst.setString(4, kategori);
//     pst.setFloat(5, jumlahPengeluaran);
//     pst.execute();
//    }
//}

class rencanaBudget extends koneksiDatabase{
    public void inputPemasukan(String kategori, float jumlahBudget, String bulan, String tanggalAwal, String tanggalAkhir) throws SQLException{
     String queryInsert = "INSERT INTO `rencanaBudget`(kategori, jumlahBudget, bulan, tglAwal_RB, tglAkhir_RB) VALUES (?,?,?,?,?)" ;
     PreparedStatement pst = mysqlconfig.prepareStatement(queryInsert);
     pst.setString(1, kategori);
     pst.setFloat(2, jumlahBudget);
     pst.setString(3, bulan);
     pst.setString(4, tanggalAwal);
     pst.setString(5, tanggalAkhir);
     pst.execute();
    }
}


