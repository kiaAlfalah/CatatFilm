package com.mycompany.sistemfilm;

public class FilmBioskop extends Film {
    private int hargaTiket;
    private String studio;

    public FilmBioskop(String judul, String sutradara, int tahunRilis, int hargaTiket, String studio) {
        super(judul, sutradara, tahunRilis); // Memanggil constructor superclass
        this.hargaTiket = hargaTiket;
        this.studio = studio;
    }

    public int getHargaTiket() { return hargaTiket; }
    public void setHargaTiket(int hargaTiket) { this.hargaTiket = hargaTiket; }

    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Bioskop]   Judul: %-15s | Sutradara: %-10s | Tahun: %d | Tiket: Rp%d | Studio: %s%n", 
                getJudul(), getSutradara(), getTahunRilis(), this.hargaTiket, this.studio);
    }

    @Override
    public void caraNonton() {
        System.out.println("-> Cara Nonton: Beli tiket fisik/online, datang ke bioskop, dan masuk ke studio yang ditentukan.");
    }
}