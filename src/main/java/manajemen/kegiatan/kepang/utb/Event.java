/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen.kegiatan.kepang.utb;

/**
 *
 * @author user
 */
// Subclass Event mewarisi abstract class Kegiatan
public class Event extends Kegiatan {

    private String tanggal;
    private String lokasi;
    private Integer jumlahPeserta;

    public Event(String kode, String nama, Integer anggaran, StatusKegiatan status,
                 String tanggal, String lokasi, Integer jumlahPeserta) {
        super(kode, nama, anggaran, status);
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.jumlahPeserta = jumlahPeserta;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getJumlahPeserta() {
        return jumlahPeserta;
    }

    public void setJumlahPeserta(Integer jumlahPeserta) {
        this.jumlahPeserta = jumlahPeserta;
    }
    
    @Override
    public String getJenisKegiatan() {
        return "EVENT";
    }
    
    @Override
    public void infoDetail() {
        System.out.println("================================================");
        System.out.println("Kode\t\t: " + getKode());
        System.out.println("Nama\t\t: " + getNama());
        System.out.println("Anggaran\t: " + getAnggaran());
        System.out.println("Status\t\t: " + getStatus());
        System.out.println("Tanggal\t\t: " + getTanggal());
        System.out.println("Lokasi\t\t: " + getLokasi());
    }
}

