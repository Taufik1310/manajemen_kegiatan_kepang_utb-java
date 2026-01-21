/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen.kegiatan.kepang.utb;

/**
 *
 * @author user
 */
import java.io.*;
import java.util.ArrayList;

public class PengelolaKegiatan implements ManajemenKegiatan {

    // Association (Relasi): Pengelola memiliki banyak objek Kegiatan
    private ArrayList<Kegiatan> daftarKegiatan = new ArrayList<>();
    
    // Nama file CSV untuk penyimpanan data
    private final String FILE_NAME = "kegiatan_kepang.csv";

    public PengelolaKegiatan() {
        loadData();
    }

    @Override
    public String tambahKegiatan(Kegiatan k) {

        if (isKodeExist(k.getKode())) {
            return "GAGAL: Kode kegiatan sudah terdaftar.";
        }

        daftarKegiatan.add(k);
        saveData();

        return "BERHASIL: Data kegiatan berhasil ditambahkan.";
    }

    @Override
    public void cariData(String kode) {
        for (Kegiatan k : daftarKegiatan) {
            if (k.getKode().equals(kode)) {
                k.infoDetail();
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }

    @Override
    public void ubahNama(String kode, String namaBaru) {
        for (Kegiatan k : daftarKegiatan) {
            if (k.getKode().equals(kode)) {
                k.setNama(namaBaru);
                saveData();
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }

    @Override
    public void tampilkanData() {
        for (Kegiatan k : daftarKegiatan) {
            k.tampilData();
        }
    }

    @Override
    public void cekStatus(String kode) {
        for (Kegiatan k : daftarKegiatan) {
            if (k.getKode().equals(kode)) {
                System.out.println("Status: " + k.getStatus());
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }
    
    @Override
    public void ubahStatusKegiatan(String kode, StatusKegiatan statusBaru) {
        for (Kegiatan k : daftarKegiatan) {
            if (k.getKode().equals(kode)) {
                k.setStatus(statusBaru);
                saveData();
                System.out.println("Status kegiatan berhasil diubah.");
                return;
            }
        }
        System.out.println("Kegiatan tidak ditemukan.");
    }

    // ================= FILE HANDLING CSV =================
    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Kegiatan k : daftarKegiatan) {

                if (k instanceof Event) {
                    Event e = (Event) k;
                    bw.write(
                        e.getKode() + "," +
                        e.getNama() + "," +
                        "EVENT," +
                        e.getAnggaran() + "," +
                        e.getStatus() + "," +
                        e.getTanggal() + "," +
                        e.getLokasi() + "," +
                        e.getJumlahPeserta()
                    );
                }

                else if (k instanceof ProgramKerja) {
                    ProgramKerja p = (ProgramKerja) k;
                    bw.write(
                        p.getKode() + "," +
                        p.getNama() + "," +
                        "PROGRAM_KERJA," +
                        p.getAnggaran() + "," +
                        p.getStatus() + "," +
                        p.getPeriode() + "," +
                        p.getPenanggungJawab() + "," +
                        p.getDurasiHari()
                    );
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data CSV");
        }
    }

    private void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String kode = data[0];
                String nama = data[1];
                String jenis = data[2];
                Integer anggaran = Integer.valueOf(data[3]);
                StatusKegiatan status = StatusKegiatan.valueOf(data[4]);

                if (jenis.equals("EVENT")) {
                    daftarKegiatan.add(new Event(
                        kode, nama, anggaran, status,
                        data[5], data[6], Integer.valueOf(data[7])
                    ));
                }

                else if (jenis.equals("PROGRAM_KERJA")) {
                    daftarKegiatan.add(new ProgramKerja(
                        kode, nama, anggaran, status,
                        data[5], data[6], Integer.valueOf(data[7])
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Gagal membaca data CSV");
        }
    }
    
    // ================= HELPERS =================
    private boolean isKodeExist(String kode) {
        for (Kegiatan k : daftarKegiatan) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return true;
            }
        }
        return false;
    }
}

