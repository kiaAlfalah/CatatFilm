package com.mycompany.sistemfilm;

import java.util.Scanner;

public class MainFilm {

    public static void cariFilm(String judul, Film[] daftarFilm, int jumlahFilm) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Judul (Teks): " + judul + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilm; i++) {
            if (daftarFilm[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.print("- Ditemukan: ");
                daftarFilm[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Film tidak ditemukan.");
    }

    public static void cariFilm(int tahunRilis, Film[] daftarFilm, int jumlahFilm) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Tahun (Angka): " + tahunRilis + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilm; i++) {
            if (daftarFilm[i].getTahunRilis() == tahunRilis) {
                System.out.print("- Ditemukan: ");
                daftarFilm[i].tampilkanInfo();
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
        Film[] daftarFilm = new Film[10]; 
        int jumlahFilm = 0;
        boolean isRunning = true;

        System.out.println("=================================================");
        System.out.println("       SELAMAT DATANG DI FILMDEX TRACKER         ");
        System.out.println("=================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Film Baru");
            System.out.println("2. Lihat Daftar Film & Simulasi Nonton");
            System.out.println("3. Cari Film (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahFilm < daftarFilm.length) {
                        System.out.println("\n-- Pilih Format Film --");
                        System.out.println("1. Film Bioskop");
                        System.out.println("2. Film Streaming (Digital)");
                        System.out.println("3. Film Fisik (DVD/Blu-ray)");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Judul Film      : ");
                        String judulBaru = scanner.nextLine();
                        System.out.print("Masukkan Sutradara       : ");
                        String sutradaraBaru = scanner.nextLine();
                        System.out.print("Masukkan Tahun Rilis     : ");
                        int tahunBaru = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Harga Tiket (Rp): ");
                            int harga = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Nama Studio     : ");
                            String studio = scanner.nextLine();
                            daftarFilm[jumlahFilm] = new FilmBioskop(judulBaru, sutradaraBaru, tahunBaru, harga, studio);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Platform (Netflix/Disney+) : ");
                            String platform = scanner.nextLine();
                            System.out.print("Masukkan Resolusi (4K/1080p)        : ");
                            String resolusi = scanner.nextLine();
                            daftarFilm[jumlahFilm] = new FilmStreaming(judulBaru, sutradaraBaru, tahunBaru, platform, resolusi);
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Format (DVD/Blu-ray)       : ");
                            String format = scanner.nextLine();
                            System.out.print("Masukkan Harga Beli Fisik (Rp)      : ");
                            int hargaBeli = scanner.nextInt();
                            scanner.nextLine();
                            daftarFilm[jumlahFilm] = new FilmDVD(judulBaru, sutradaraBaru, tahunBaru, format, hargaBeli);
                        }

                        jumlahFilm++;
                        System.out.println("Sukses! Film berhasil ditambahkan ke koleksi.");
                    } else {
                        System.out.println("Maaf, kapasitas penyimpanan data film penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Koleksi Film ---");
                    if (jumlahFilm == 0) {
                        System.out.println("Belum ada data film yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahFilm; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarFilm[i].tampilkanInfo();
                            
                            // Dynamic Binding beraksi: Memanggil method dengan argumen array Superclass
                            simulasiNonton(daftarFilm[i]);
                            System.out.println();
                        }
                        System.out.println("* Total Film Dibuat: " + Film.totalFilmDibuat);
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("\n-- Fitur Cari Film --");
                    System.out.println("1. Cari berdasarkan Judul Teks (String)");
                    System.out.println("2. Cari berdasarkan Tahun (Integer)");
                    System.out.print("Pilih (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Judul: ");
                        String kataKunci = scanner.nextLine();
                        cariFilm(kataKunci, daftarFilm, jumlahFilm);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Tahun: ");
                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();
                        cariFilm(angkaKunci, daftarFilm, jumlahFilm);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("Terima kasih telah menggunakan Filmdex Tracker!");
                    isRunning = false;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}