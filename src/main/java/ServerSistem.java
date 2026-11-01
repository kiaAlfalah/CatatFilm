public class ServerSistem {
    private String namaServer;
    private String status;

    public ServerSistem(String namaServer) {
        this.namaServer = namaServer;
        this.status = "Online";
    }

    public void cekServer() {
        System.out.println("-> [Sistem] Terhubung ke server: " + this.namaServer + " (" + this.status + ")");
    }
}