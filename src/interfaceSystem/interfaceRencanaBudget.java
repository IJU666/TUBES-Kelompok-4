/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceSystem;

/**
 *
 * @author Fauzi
 */
public interface interfaceRencanaBudget {
    void input(String kategori, String tanggalAwal, String tanggalAkhir, float jumlahRencana, String bulanRencana);
    void update(int id, String kategori, String tanggalAwal, String tanggalAkhir, float jumlahRencana, String bulanRencana);
    void delete(int id);
    void read();
    tugasbesarpbo.koneksiDatabase db = new tugasbesarpbo.koneksiDatabase();
}
