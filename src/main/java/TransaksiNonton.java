public class TransaksiNonton {

    public static void prosesNonton(Member member, Film film) {
        System.out.println("\n===== TIKET / AKSES NONTON =====");
        System.out.println("Penonton  : " + member.getNama() + " (ID: " + member.getIdMember() + ")");
        System.out.println("Film      : " + film.getJudul());
        System.out.println("Status    : Akses diberikan.");

        film.caraNonton();
        System.out.println("================================");
    }
}