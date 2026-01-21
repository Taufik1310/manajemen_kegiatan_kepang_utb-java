/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package manajemen.kegiatan.kepang.utb;

/**
 *
 * @author user
 */
import java.util.Scanner;

// Class utama sebagai entry point program
public class ManajemenKegiatanKepangUtb {

    public static void main(String[] args) {
        // Scanner untuk input user
        Scanner sc = new Scanner(System.in);
        
        // Object pengelola kegiatan (relasi dengan Kegiatan)
        PengelolaKegiatan pengelola = new PengelolaKegiatan();
        
        int menu;

        do {
            // Menu utama aplikasi
            System.out.println("\n=== MANAJEMEN KEGIATAN KEPANG UTB ===");
            System.out.println("1. Tambah Data Kegiatan");
            System.out.println("2. Tampilkan Semua Data Kegiatan");
            System.out.println("3. Cari Data Kegiatan");
            System.out.println("4. Ubah Nama Kegiatan");
            System.out.println("5. Cek Status Data Kegiatan");
            System.out.println("6. Ubah Status Kegiatan");
            System.out.println("7. Keluar");
            System.out.print("Pilih: ");
            menu = Integer.parseInt(sc.nextLine());

            switch (menu) {

                case 1:
                    System.out.print("Kode: ");
                    String kode = sc.nextLine();

                    System.out.print("Nama: ");
                    String nama = sc.nextLine();

                    System.out.print("Anggaran: ");
                    Integer anggaran = Integer.valueOf(sc.nextLine());

                    System.out.println("1. Event");
                    System.out.println("2. Program Kerja");
                    System.out.print("Jenis: ");
                    int jenis = Integer.parseInt(sc.nextLine());
                    
                    // Object Event / ProgramKerja disimpan sebagai Kegiatan
                    Kegiatan k;

                    if (jenis == 1) {
                        System.out.print("Tanggal: ");
                        String tanggal = sc.nextLine();

                        System.out.print("Lokasi: ");
                        String lokasi = sc.nextLine();

                        System.out.print("Jumlah Peserta: ");
                        int jumlahPeserta = Integer.parseInt(sc.nextLine());

                        k = new Event(
                                kode, nama, anggaran,
                                StatusKegiatan.DIRENCANAKAN,
                                tanggal, lokasi, jumlahPeserta
                        );
                    } else {
                        System.out.print("Periode: ");
                        String periode = sc.nextLine();

                        System.out.print("Penanggung Jawab: ");
                        String pj = sc.nextLine();

                        System.out.print("Durasi (hari): ");
                        int durasiHari = Integer.parseInt(sc.nextLine());

                        k = new ProgramKerja(
                                kode, nama, anggaran,
                                StatusKegiatan.DIRENCANAKAN,
                                periode, pj, durasiHari
                        );
                    }

                    System.out.println(pengelola.tambahKegiatan(k));
                    break;

                case 2:
                    pengelola.tampilkanData();
                    break;

                case 3:
                    System.out.print("Kode: ");
                    pengelola.cariData(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Kode: ");
                    String ukode = sc.nextLine();
                    System.out.print("Nama Baru: ");
                    pengelola.ubahNama(ukode, sc.nextLine());
                    break;

                case 5:
                    System.out.print("Kode: ");
                    pengelola.cekStatus(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Kode: ");
                    String kodeStatus = sc.nextLine();

                    System.out.println("Pilih Status Baru:");
                    System.out.println("1. DIRENCANAKAN");
                    System.out.println("2. BERJALAN");
                    System.out.println("3. SELESAI");
                    System.out.println("4. DIBATALKAN");
                    System.out.print("Pilihan: ");

                    int pilihanStatus = Integer.parseInt(sc.nextLine());
                    StatusKegiatan statusBaru = null;

                    switch (pilihanStatus) {
                        case 1:
                            statusBaru = StatusKegiatan.DIRENCANAKAN;
                            break;
                        case 2:
                            statusBaru = StatusKegiatan.BERJALAN;
                            break;
                        case 3:
                            statusBaru = StatusKegiatan.SELESAI;
                            break;
                        case 4:
                            statusBaru = StatusKegiatan.DIBATALKAN;
                            break;
                        default:
                            System.out.println("Pilihan status tidak valid.");
                            break;
                    }

                    if (statusBaru != null) {
                        pengelola.ubahStatusKegiatan(kodeStatus, statusBaru);
                    }
                    break;
            }

        } while (menu != 7);

        System.out.println("Program selesai.");
    }
}

