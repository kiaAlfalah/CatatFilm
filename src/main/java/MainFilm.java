import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFilm {

    public static void cariFilm(String judul, ArrayList<Film> daftarFilm) {
        System.out.println("\n--- Pencarian Judul: " + judul + " ---");
        boolean ditemukan = false;
        for (Film f : daftarFilm) {
            if (f.getJudul().equalsIgnoreCase(judul)) {
                f.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Film tidak ditemukan.");
    }

    public static void simulasiNonton(Film item) {
        item.caraNonton();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Film> daftarFilm = new ArrayList<>();
        HashMap<String, String> dataMember = new HashMap<>();
        dataMember.put("M001", "Ghulaman Zakia"); 
        dataMember.put("M002", "Budi Santoso");

        boolean isRunning = true;

        System.out.println("=================================================");
        System.out.println("       SELAMAT DATANG DI FILMDEX TRACKER         ");
        System.out.println("=================================================");

        while (isRunning) {
            try { 
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Data Film (Try-Catch & Custom Exception)");
                System.out.println("2. Lihat Daftar Film (ArrayList)");
                System.out.println("3. Cari Film");
                System.out.println("4. Kelola Data Member (HashMap)");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu (1-5): ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n-- Pilih Format Film --");
                        System.out.println("1. Film Bioskop");
                        System.out.println("2. Film Streaming");
                        System.out.println("3. Film Fisik (DVD)");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Judul Film      : ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan Sutradara       : ");
                        String sutradara = scanner.nextLine();
                        System.out.print("Masukkan Tahun Rilis     : ");
                        int tahun = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Harga Tiket (Rp): ");
                            int harga = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Nama Studio     : ");
                            String studio = scanner.nextLine();
                            daftarFilm.add(new FilmBioskop(judul, sutradara, tahun, harga, studio));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Platform        : ");
                            String platform = scanner.nextLine();
                            System.out.print("Masukkan Resolusi        : ");
                            String resolusi = scanner.nextLine();
                            daftarFilm.add(new FilmStreaming(judul, sutradara, tahun, platform, resolusi));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Format          : ");
                            String format = scanner.nextLine();
                            System.out.print("Masukkan Harga Beli (Rp) : ");
                            int hargaBeli = scanner.nextInt();
                            scanner.nextLine();
                            daftarFilm.add(new FilmDVD(judul, sutradara, tahun, format, hargaBeli));
                        }
                        System.out.println("Sukses! Film berhasil ditambahkan ke koleksi.");
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi Film ---");
                        if (daftarFilm.isEmpty()) { 
                            System.out.println("Belum ada data film yang tersimpan.");
                        } else {
                            for (int i = 0; i < daftarFilm.size(); i++) { 
                                System.out.print((i + 1) + ". ");
                                Film f = daftarFilm.get(i); 
                                f.tampilkanInfo();
                                simulasiNonton(f);
                                
                                if (f instanceof DapatDiunduh itemUnduh) itemUnduh.prosesUnduh();
                                if (f instanceof DapatDinilai itemBisaDinilai) itemBisaDinilai.beriRating(5); 
                                System.out.println(); 
                            }
                        }
                    }
                    case 3 -> {
                        System.out.print("\nMasukkan Judul: ");
                        String kataKunci = scanner.nextLine();
                        cariFilm(kataKunci, daftarFilm);
                    }
                    case 4 -> {
                        System.out.println("\n--- Kelola Data Member (HashMap) ---");
                        System.out.println("1. Tambah Member");
                        System.out.println("2. Cari Member");
                        System.out.println("3. Lihat Semua Member");
                        System.out.print("Pilih opsi (1-3): ");
                        int opsiMember = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (opsiMember == 1) {
                            System.out.print("Masukkan ID Member: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama     : ");
                            String nama = scanner.nextLine();
                            dataMember.put(id, nama); 
                            System.out.println("Member berhasil ditambahkan!");
                        } else if (opsiMember == 2) {
                            System.out.print("Masukkan ID yang dicari: ");
                            String cariId = scanner.nextLine();
                            if (dataMember.containsKey(cariId)) { 
                                System.out.println("Ditemukan: " + dataMember.get(cariId)); 
                            } else {
                                System.out.println("Member dengan ID tersebut tidak ditemukan.");
                            }
                        } else if (opsiMember == 3) {
                            System.out.println("Daftar Member:");
                            for (String key : dataMember.keySet()) {
                                System.out.println("ID: " + key + " | Nama: " + dataMember.get(key));
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Terima kasih telah menggunakan Filmdex Tracker!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Anda memasukkan huruf/karakter tidak valid! Harap masukkan angka.");
                scanner.nextLine();
            } 
            catch (InvalidFilmException e) {
                System.out.println("\n[ERROR VALIDASI] " + e.getMessage());
            } 
            finally {
                System.out.println("-> [Sistem] Sesi eksekusi menu selesai. Mengembalikan ke menu utama...");
            }
        }
        scanner.close();
    }
}