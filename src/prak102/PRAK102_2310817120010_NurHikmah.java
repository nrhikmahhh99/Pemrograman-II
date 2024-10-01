package prak102;
import java.util.Scanner;

public class PRAK102_2310817120010_NurHikmah {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInput");
            String input = scanner.nextLine();

            // Jika input adalah 'exit', keluar dari program
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Mengonversi input menjadi angka
            int angkaAwal = Integer.parseInt(input);

            // Mengatur jumlah baris yang ditampilkan (10 baris)
            int count = 0;
            int currentNumber = angkaAwal;

            System.out.println("Output");
            while (count < 11) {
                if (currentNumber % 5 == 0) {
                    // Jika kelipatan 5, bagi 5 dan kurangi 1
                    System.out.print((currentNumber / 5) - 1);
                } else {
                    // Jika bukan kelipatan 5, tampilkan angka aslinya
                    System.out.print(currentNumber);
                }

                // Tambah koma jika belum di akhir deret
                if (count < 10) {
                    System.out.print(", ");
                }

                // Increment current number dan count
                currentNumber++;
                count++;
            }

            System.out.println(); // Pindah ke baris baru setelah deret selesai
        }

        System.out.println("Program selesai.");
    }
}