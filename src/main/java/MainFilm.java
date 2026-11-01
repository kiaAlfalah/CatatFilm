import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFilm {
    public static void main(String[] args) {
        CatatFilm tracker = new CatatFilm("CatatFIlm Terbaru nih bos v2");
        tracker.bukaSistem();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("=================================================");
        System.out.println("       SELAMAT DATANG DI CATAT FILM        ");
        System.out.println("=================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Film");
            System.out.println("2. Lihat Daftar Film");
            System.out.println("3. Cari Film");
            System.out.println("4. Manajemen Member");
            System.out.println("5. Simulasi Nonton (Demo Association)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n-- Pilih Format Film --");
                        System.out.println("1. Film Bioskop | 2. Film Streaming | 3. Film Fisik (DVD)");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Judul Film  : ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan Sutradara   : ");
                        String sutradara = scanner.nextLine();
                        System.out.print("Masukkan Tahun Rilis : ");
                        int tahun = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Harga Tiket (Rp): ");
                            int harga = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Masukkan Nama Studio : ");
                            String studio = scanner.nextLine();
                            tracker.tambahFilm(new FilmBioskop(judul, sutradara, tahun, harga, studio));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Platform    : ");
                            String platform = scanner.nextLine();
                            System.out.print("Masukkan Resolusi    : ");
                            String resolusi = scanner.nextLine();
                            tracker.tambahFilm(new FilmStreaming(judul, sutradara, tahun, platform, resolusi));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Format      : ");
                            String format = scanner.nextLine();
                            System.out.print("Masukkan Harga (Rp)  : ");
                            int hargaBeli = scanner.nextInt();
                            scanner.nextLine();
                            tracker.tambahFilm(new FilmDVD(judul, sutradara, tahun, format, hargaBeli));
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Koleksi Film ---");
                        tracker.lihatSemuaFilm();
                    }
                    case 3 -> {
                        System.out.print("\nMasukkan Judul Film: ");
                        String kataKunci = scanner.nextLine();
                        tracker.cariFilm(kataKunci);
                    }
                    case 4 -> {
                        System.out.println("\n-- Manajemen Member --");
                        System.out.println("1. Tambah Member Baru");
                        System.out.println("2. Cari Member via ID");
                        System.out.println("3. Lihat Semua Member");
                        System.out.print("Pilih (1-3): ");
                        int menuA = scanner.nextInt();
                        scanner.nextLine();

                        if (menuA == 1) {
                            System.out.print("Masukkan ID Member : ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap: ");
                            String nama = scanner.nextLine();
                            // Agregasi: Pembuatan objek Member dilempar ke dalam sistem
                            tracker.tambahMember(new Member(id, nama));
                        } else if (menuA == 2) {
                            System.out.print("Masukkan ID yg dicari: ");
                            tracker.cariMember(scanner.nextLine());
                        } else if (menuA == 3) {
                            tracker.lihatSemuaMember();
                        }
                    }
                    case 5 -> {
                        System.out.println("\n-- Simulasi Nonton (Asosiasi) --");
                        System.out.print("Masukkan ID Member: ");
                        String inputId = scanner.nextLine();
                        
                        Member penonton = tracker.getMember(inputId);
                        
                        if (penonton == null) {
                            System.out.println("Gagal: Member tidak terdaftar!");
                        } else if (tracker.getJumlahFilm() == 0) {
                            System.out.println("Gagal: Belum ada film di sistem.");
                        } else {
                            tracker.lihatSemuaFilm();
                            System.out.print("Pilih Nomor Film yang ingin ditonton: ");
                            int noFilm = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noFilm >= 0 && noFilm < tracker.getJumlahFilm()) {
                                Film filmDipilih = tracker.getFilmInt(noFilm);
                                TransaksiNonton.prosesNonton(penonton, filmDipilih);
                            } else {
                                System.out.println("Nomor film tidak valid!");
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan Catat Film");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Input tidak valid! Harap masukkan angka.");
                scanner.nextLine();
            } catch (InvalidFilmException e) {
                System.out.println("\n[ERROR] " + e.getMessage());
            }
        }
        scanner.close();
    }
}