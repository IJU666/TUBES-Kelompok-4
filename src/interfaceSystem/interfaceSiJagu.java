/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceSystem;

/**
 *
 * @author Fauzi
 */
public interface interfaceSiJagu {
   
    
    void input(String catatan, String tanggal, String bulan, float jumlah);
    void update(int id, String catatan, String tanggal, String bulan, float jumlah);
    void delete(int id);
    void read();
    tugasbesarpbo.koneksiDatabase db = new tugasbesarpbo.koneksiDatabase();
}
