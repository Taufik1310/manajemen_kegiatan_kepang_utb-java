/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen.kegiatan.kepang.utb;

/**
 *
 * @author user
 */
// Subclass Program Kerja mewarisi abstract class Kegiatan
public class ProgramKerja extends Kegiatan {

    private String periode;
    private String penanggungJawab;
    private Integer durasiHari;

    public ProgramKerja(String kode, String nama, Integer anggaran, StatusKegiatan status,
                        String periode, String penanggungJawab, Integer durasiHari) {
        super(kode, nama, anggaran, status);
        this.periode = periode;
        this.penanggungJawab = penanggungJawab;
        this.durasiHari = durasiHari;
    }

    public String getPeriode() {
        return periode;
    }

    public String getPenanggungJawab() {
        return penanggungJawab;
    }

    public int getDurasiHari() {
        return durasiHari;
    }

    public void setDurasiHari(Integer durasiHari) {
        this.durasiHari = durasiHari;
    }

    @Override
    public String getJenisKegiatan() {
        return "PROGRAM KERJA";
    }
    
    @Override
    public void infoDetail() {
        System.out.println("================================================");
        System.out.println("Kode\t\t\t: " + getKode());
        System.out.println("Nama\t\t\t: " + getNama());
        System.out.println("Anggaran\t\t: " + getAnggaran());
        System.out.println("Status\t\t\t: " + getStatus());
        System.out.println("Periode\t\t\t: " + getPeriode());
        System.out.println("Penanggung Jawab\t: " + getPenanggungJawab());
        System.out.println("Durasi Hari\t\t: " + getDurasiHari() + " Hari");
    }
}

