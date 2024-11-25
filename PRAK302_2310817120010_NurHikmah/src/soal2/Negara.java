package soal2;

import java.util.LinkedList;
import java.util.HashMap;

class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private Integer tanggalKemerdekaan;
    private Integer bulanKemerdekaan;
    private Integer tahunKemerdekaan;

    // Konstruktor untuk negara dengan tanggal kemerdekaan
    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, Integer tanggalKemerdekaan, Integer bulanKemerdekaan, Integer tahunKemerdekaan) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggalKemerdekaan;
        this.bulanKemerdekaan = bulanKemerdekaan;
        this.tahunKemerdekaan = tahunKemerdekaan;
    }

    // Konstruktor untuk negara tanpa tanggal kemerdekaan (monarki)
    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
        this(nama, jenisKepemimpinan, namaPemimpin, null, null, null);
    }

    // Method untuk menampilkan detail negara
    public String getDetail(HashMap<Integer, String> daftarBulan) {
        StringBuilder detail = new StringBuilder();
        detail.append("Negara ").append(nama).append(" mempunyai ");
        if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            detail.append("Raja");
        } else if (jenisKepemimpinan.equalsIgnoreCase("presiden")) {
            detail.append("Presiden");
        } else {
            detail.append("Perdana Menteri");
        }
        detail.append(" bernama ").append(namaPemimpin);

        if (tanggalKemerdekaan != null && bulanKemerdekaan != null && tahunKemerdekaan != null) {
            detail.append("\nDeklarasi Kemerdekaan pada Tanggal ")
                  .append(tanggalKemerdekaan).append(" ")
                  .append(daftarBulan.get(bulanKemerdekaan)).append(" ")
                  .append(tahunKemerdekaan);
        }
        return detail.toString();
    }
}
