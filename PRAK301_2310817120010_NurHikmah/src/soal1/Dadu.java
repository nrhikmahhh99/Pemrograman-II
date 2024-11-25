package soal1;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class Dadu {
    private int nilai;
    private static LinkedList<Dadu> koleksiDadu = new LinkedList<>();

    // Konstruktor: menginisialisasi nilai dadu secara acak
    public Dadu() {
        acakNilai();
    }

    // Method untuk mengacak nilai dadu
    private void acakNilai() {
        Random random = new Random();
        this.nilai = random.nextInt(6) + 1; // Nilai antara 1-6
    }

    // Getter untuk nilai dadu
    public int getNilai() {
        return nilai;
    }

    // Method untuk memproses satu sesi permainan
    public static void prosesDadu(Scanner scanner) {
        // Bersihkan koleksi dadu untuk sesi baru
        koleksiDadu.clear();

        System.out.print("");
        int jumlahDadu = scanner.nextInt();

        int totalNilai = 0;

        // Membuat dan mengolah objek dadu
        for (int i = 0; i < jumlahDadu; i++) {
            Dadu dadu = new Dadu();
            koleksiDadu.add(dadu);

            int nilaiDadu = dadu.getNilai();
            totalNilai += nilaiDadu;

            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilaiDadu);
        }

        // Menampilkan total nilai dadu
        System.out.println("Total nilai dadu keseluruhan " + totalNilai);
        System.out.println(); // Baris kosong untuk pemisah
    }
}
