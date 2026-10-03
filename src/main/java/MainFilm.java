package com.mycompany.sistemfilm;

import java.util.Scanner;

public class MainFilm {

    // Method Overloading 1: Pencarian berdasarkan Judul (String)
    public static void cariFilm(String judul, Film[] daftarFilm, int jumlahFilm) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Judul: " + judul + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilm; i++) {
            if (daftarFilm[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.print("- Ditemukan: ");
                daftarFilm[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Film dengan judul tersebut tidak ditemukan.");
    }

    // Method Overloading 2: Pencarian berdasarkan Tahun Rilis (int)
    public static void cariFilm(int tahunRilis, Film[] daftarFilm, int jumlahFilm) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Tahun: " + tahunRilis + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahFilm; i++) {
            if (daftarFilm[i].getTahunRilis() == tahunRilis) {
                System.out.print("- Ditemukan: ");
                daftarFilm[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Film pada tahun tersebut tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Film[] daftarFilm = new Film[10]; // Array wadah data
        int jumlahFilm = 0;
        boolean isRunning = true;

        System.out.println("=================================================");
        System.out.println("       SELAMAT DATANG DI SISTEM PENDATAAN FILM   ");
        System.out.println("=================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Film Baru");
            System.out.println("2. Tampilkan Seluruh Data Film");
            System.out.println("3. Cari Film (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan sisa enter

            switch (pilihan) {
                case 1 -> {
                    if (jumlahFilm < daftarFilm.length) {
                        System.out.println("\n--- Pilih Jenis Film ---");
                        System.out.println("1. Film Bioskop");
                        System.out.println("2. Film Streaming (Digital)");
                        System.out.print("Pilih jenis (1/2): ");
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

                            // Instansiasi objek subclass FilmBioskop
                            daftarFilm[jumlahFilm] = new FilmBioskop(judulBaru, sutradaraBaru, tahunBaru, harga, studio);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Platform (Netflix/Disney+): ");
                            String platform = scanner.nextLine();
                            System.out.print("Masukkan Resolusi (4K/1080p)       : ");
                            String resolusi = scanner.nextLine();

                            // Instansiasi objek subclass FilmStreaming
                            daftarFilm[jumlahFilm] = new FilmStreaming(judulBaru, sutradaraBaru, tahunBaru, platform, resolusi);
                        }

                        jumlahFilm++;
                        System.out.println("Sukses! Data film berhasil ditambahkan.");
                    } else {
                        System.out.println("Maaf, kapasitas penyimpanan data film penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Seluruh Film Terdaftar ---");
                    if (jumlahFilm == 0) {
                        System.out.println("Belum ada data film yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahFilm; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarFilm[i].tampilkanInfo();   // Polimorfisme & Overriding
                            daftarFilm[i].caraNonton();      // Memanggil method hasil overriding
                            System.out.println();
                        }
                        System.out.println("* Total Seluruh Film Terdaftar: " + Film.totalFilmDibuat);
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("\n--- Menu Pencarian Film ---");
                    System.out.println("1. Cari Berdasarkan Judul (Teks)");
                    System.out.println("2. Cari Berdasarkan Tahun Rilis (Angka)");
                    System.out.print("Pilih mode (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Judul yang dicari: ");
                        String kataKunci = scanner.nextLine();
                        cariFilm(kataKunci, daftarFilm, jumlahFilm); // Memanggil Overloading 1
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Tahun yang dicari: ");
                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();
                        cariFilm(angkaKunci, daftarFilm, jumlahFilm); // Memanggil Overloading 2
                    } else {
                        System.out.println("Pilihan mode tidak valid.");
                    }
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("Terima kasih telah menggunakan Sistem Pendataan Film!");
                    isRunning = false;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-4.");
            }
        }
        scanner.close();
    }
}