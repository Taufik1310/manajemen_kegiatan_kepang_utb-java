/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen.kegiatan.kepang.utb;

/**
 *
 * @author user
 */
// Abstract class sebagai superclass kegiatan
public abstract class Kegiatan {

    // Enkapsulasi: atribut dibuat private
    private String kode;
    private String nama;
    private Integer anggaran; // Wrapper Class
    private StatusKegiatan status;

    // Constructor berparameter
    public Kegiatan(String kode, String nama, Integer anggaran, StatusKegiatan status) {
        this.kode = kode;
        this.nama = nama;
        this.anggaran = anggaran;
        this.status = status;
    }

    // Getter & Setter
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public Integer getAnggaran() { return anggaran; }
    public StatusKegiatan getStatus() { return status; }

    public void setNama(String nama) { this.nama = nama; }
    public void setAnggaran(Integer anggaran) { this.anggaran = anggaran; }
    public void setStatus(StatusKegiatan status) { this.status = status; }

    // Abstract Method
    public abstract String getJenisKegiatan();
    public abstract void infoDetail();

    // Method tambahan
    public void tampilData() {
        System.out.printf(
            "| %-6s | %-64s | %-15s | %-10d | %-14s |\n",
            kode,
            nama,
            getJenisKegiatan(),
            anggaran,
            status
        );
    }
}

