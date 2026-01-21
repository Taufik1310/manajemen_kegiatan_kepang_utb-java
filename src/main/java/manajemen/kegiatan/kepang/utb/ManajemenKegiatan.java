/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manajemen.kegiatan.kepang.utb;

/**
 *
 * @author user
 */
// Interface untuk mengatur kontrak pengelola kegiatan
public interface ManajemenKegiatan {
    // Inteface Method
    String tambahKegiatan(Kegiatan k);
    void tampilkanData();
    void cariData(String kode);
    void ubahNama(String kode, String namaBaru);
    void cekStatus(String kode);
    void ubahStatusKegiatan(String kode, StatusKegiatan statusBaru);
}
