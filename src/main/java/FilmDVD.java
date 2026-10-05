package com.mycompany.sistemfilm;

public class FilmDVD extends Film {
    private String format; 
    private int hargaBeli;

    public FilmDVD(String judul, String sutradara, int tahunRilis, String format, int hargaBeli) {
        super(judul, sutradara, tahunRilis); 
        this.format = format;
        this.hargaBeli = hargaBeli;
    }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public int getHargaBeli() { return hargaBeli; }
    public void setHargaBeli(int hargaBeli) { this.hargaBeli = hargaBeli; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Fisik DVD] Judul: %-15s | Sutradara: %-10s | Tahun: %d | Format: %-8s | Harga: Rp%d%n", 
                getJudul(), getSutradara(), getTahunRilis(), this.format, this.hargaBeli);
    }

    @Override
    public void caraNonton() {
        System.out.println("-> Cara Nonton: Masukkan kepingan " + this.format + " ke dalam pemutar disk/konsol, lalu sambungkan ke TV.");
    }
}