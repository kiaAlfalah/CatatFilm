package com.mycompany.sistemfilm;

public class Film {
    private String judul;
    private String sutradara;
    private int tahunRilis;
    
    // Variabel static untuk menghitung total objek film yang berhasil dibuat
    public static int totalFilmDibuat = 0;

    // Constructor
    public Film(String judul, String sutradara, int tahunRilis) {
        this.judul = judul;
        this.sutradara = sutradara;
        setTahunRilis(tahunRilis); // Menggunakan setter untuk validasi
        totalFilmDibuat++;
    }

    // Getter dan Setter dengan Encapsulation & Validasi
    public String getJudul() { return this.judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getSutradara() { return this.sutradara; }
    public void setSutradara(String sutradara) { this.sutradara = sutradara; }

    public int getTahunRilis() { return this.tahunRilis; }
    public void setTahunRilis(int tahunRilis) {
        if (tahunRilis > 1800) { // Validasi sederhana tahun rilis
            this.tahunRilis = tahunRilis;
        } else {
            this.tahunRilis = 2026; // Default jika tidak valid
            System.out.println("Tahun rilis tidak valid! Otomatis diatur ke 2026.");
        }
    }

    // Method dasar yang nantinya akan di-override
    public void tampilkanInfo() {
        System.out.printf("Judul: %-20s | Sutradara: %-15s | Tahun: %d%n", this.judul, this.sutradara, this.tahunRilis);
    }

    public void caraNonton() {
        System.out.println("Menonton film secara umum.");
    }
}