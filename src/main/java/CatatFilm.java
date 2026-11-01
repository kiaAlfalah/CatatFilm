import java.util.ArrayList;
import java.util.HashMap;

public class CatatFilm {
    private String namaSistem;
    private ServerSistem serverUtama;
    private ArrayList<Film> daftarFilm;
    private HashMap<String, Member> dataMember;

    public CatatFilm(String namaSistem) {
        this.namaSistem = namaSistem;
        this.serverUtama = new ServerSistem("Server-CatatFilm-01");
        this.daftarFilm = new ArrayList<>();
        this.dataMember = new HashMap<>();
    }

    public void bukaSistem() {
        System.out.println("\n*** Memuat sistem " + this.namaSistem + " ***");
        serverUtama.cekServer(); 
    }

    public void tambahFilm(Film f) {
        daftarFilm.add(f);
        System.out.println("Sukses! Film ditambahkan. (Total: " + daftarFilm.size() + ")");
    }

    public void lihatSemuaFilm() {
        if (daftarFilm.isEmpty()) {
            System.out.println("Belum ada koleksi film.");
            return;
        }
        for (int i = 0; i < daftarFilm.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarFilm.get(i).tampilkanInfo();
        }
    }

    public void cariFilm(String judul) throws InvalidFilmException {
        System.out.println("Mencari film: " + judul);
        boolean ditemukan = false;
        for (Film f : daftarFilm) {
            if (f.getJudul().equalsIgnoreCase(judul)) {
                f.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new InvalidFilmException("Gagal: Film berjudul '" + judul + "' tidak terdaftar!");
        }
    }

    public void tambahMember(Member m) {
        dataMember.put(m.getIdMember(), m);
        System.out.println("Berhasil menambahkan member!");
    }

    public void cariMember(String id) {
        if (dataMember.containsKey(id)) {
            System.out.println("Ditemukan! Nama: " + dataMember.get(id).getNama());
        } else {
            System.out.println("Member dengan ID tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaMember() {
        System.out.println("Total Member: " + dataMember.size());
        for (Member m : dataMember.values()) {
            System.out.println("- ID: " + m.getIdMember() + " | Nama: " + m.getNama());
        }
    }

    public Member getMember(String id) { return dataMember.get(id); }
    public Film getFilmInt(int index) { return daftarFilm.get(index); }
    public int getJumlahFilm() { return daftarFilm.size(); }
}