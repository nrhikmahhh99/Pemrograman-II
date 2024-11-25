package soal1;

import java.util.Scanner;

public class Soal1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Jalankan proses tiga kali
        for (int run = 1; run <= 3; run++) {
            Dadu.prosesDadu(scanner);
        }

        scanner.close();
    }
}
