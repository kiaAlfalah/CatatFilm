public class FilmStreaming extends Film implements DapatDinilai, DapatDiunduh {
    private String platform;
    private String resolusiMaksimal;

    public FilmStreaming(String judul, String sutradara, int tahunRilis, String platform, String resolusiMaksimal) {
        super(judul, sutradara, tahunRilis); 
        this.platform = platform;
        this.resolusiMaksimal = resolusiMaksimal;
    }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getResolusiMaksimal() { return resolusiMaksimal; }
    public void setResolusiMaksimal(String resolusiMaksimal) { this.resolusiMaksimal = resolusiMaksimal; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Streaming] Judul: %-15s | Sutradara: %-10s | Tahun: %d | Platform: %-8s | Resolusi: %s%n", 
                getJudul(), getSutradara(), getTahunRilis(), this.platform, this.resolusiMaksimal);
    }

    @Override
    public void caraNonton() {
        System.out.println("-> Cara Nonton: Buka aplikasi, siapkan internet, lalu tekan play.");
    }

    @Override
    public void tampilkanSyaratNonton() {
        System.out.println("-> Syarat Nonton: Membutuhkan koneksi internet aktif dan akun berlangganan " + this.platform + ".");
    }

    @Override
    public void prosesUnduh() {
        System.out.println("-> [FITUR UNDUH] Film ini sedang diunduh ke perangkat Anda untuk ditonton offline.");
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [RATING STREAMING] Penonton di aplikasi memberi rating " + bintang + "/5 bintang.");
    }
}