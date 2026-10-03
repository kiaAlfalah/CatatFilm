package com.mycompany.sistemfilm;

public class FilmStreaming extends Film {
    private String platform;
    private String resolusiMaksimal;

    public FilmStreaming(String judul, String sutradara, int tahunRilis, String platform, String resolusiMaksimal) {
        super(judul, sutradara, tahunRilis); // Memanggil constructor superclass
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
        System.out.println("-> Cara Nonton: Berlangganan aplikasi, sambungkan internet, dan langsung streaming secara online.");
    }
}