public class FilmBioskop extends Film implements DapatDinilai {
    private int hargaTiket;
    private String studio;

    public FilmBioskop(String judul, String sutradara, int tahunRilis, int hargaTiket, String studio) {
        super(judul, sutradara, tahunRilis); 
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
        System.out.println("-> Cara Nonton: Beli tiket, datang ke bioskop, dan masuk ke studio.");
    }

    @Override
    public void tampilkanSyaratNonton() {
        System.out.println("-> Syarat Nonton: Harus datang ke bioskop sesuai jam tayang dan membawa tiket fisik/e-ticket.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [RATING BIOSKOP] Pengunjung memberi rating film ini " + bintang + "/5 bintang.");
    }
}