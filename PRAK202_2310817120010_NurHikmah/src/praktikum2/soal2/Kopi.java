package praktikum2.soal2;

public class Kopi {
    // Atribut
    String namaKopi;
    String ukuran;
    double harga;
    private String pembeli;

    // Metode untuk menampilkan informasi kopi
    public void info() {
        System.out.println("Nama Kopi: " + namaKopi);
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Harga: Rp. " + harga);
    }

    // Setter untuk pembeli
    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }

    // Getter untuk pembeli
    public String getPembeli() {
        return pembeli;
    }

    // Metode untuk menghitung pajak
    public double getPajak() {
        double pajak = 0.11 * harga;
        return pajak;
    }
}