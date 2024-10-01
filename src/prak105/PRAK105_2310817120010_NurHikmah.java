package prak105;
import java.util.Scanner;

public class PRAK105_2310817120010_NurHikmah {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double PHI = Math.PI;  // Konstanta phi untuk nilai π

        while (true) {
            // Input jari-jari
        	System.out.println("Input");
            System.out.print("Masukkan jari-jari: ");
            String inputJariJari = scanner.nextLine();

            // memeriksa apakah ingin keluar
            if (inputJariJari.equalsIgnoreCase("exit")) {
                break;  // Keluar dari loop jika menginputkan 'exit'
            }

            // Input tinggi
            System.out.print("Masukkan tinggi: ");
            String inputTinggi = scanner.nextLine();

            // memeriksa apakah ingin keluar
            if (inputTinggi.equalsIgnoreCase("exit")) {
                break;  // Keluar dari loop jika menginputkan 'exit'
            }

            // Mengonversi input menjadi double
            double jariJari = Double.parseDouble(inputJariJari);
            double tinggi = Double.parseDouble(inputTinggi);

            // Menghitung volume tabung
            double volume = 3.14 * jariJari * jariJari * tinggi;

            // Menampilkan hasil
            System.out.println("Output");
            System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f cm3\n", jariJari, tinggi, volume);
            System.out.println();  // Pindah ke baris baru untuk memperjelas output
        }

        System.out.println("Program selesai.");
        scanner.close();
    }
}