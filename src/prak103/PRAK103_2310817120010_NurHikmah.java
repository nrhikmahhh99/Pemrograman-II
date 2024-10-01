package prak103;
import java.util.Scanner;

public class PRAK103_2310817120010_NurHikmah {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            // Memasukkan input untuk N dan bilangan awal
            System.out.println();
            int N = scanner.nextInt();   // Jumlah bilangan yang akan ditampilkan
            int startNumber = scanner.nextInt(); // Angka awal dari deret

            // Cek kondisi untuk berhenti jika N adalah 0 atau negatif
            if (N <= 0) {
                break;  // Menghentikan program jika N adalah 0 atau negatif
            }

            int count = 0; // Penghitung untuk jumlah bilangan yang sudah ditampilkan
            int currentNumber = startNumber; // Angka saat ini di dalam deret

            do {
                // Cek apakah bilangan ganjil
                if (currentNumber % 2 != 0) {
                    System.out.print(currentNumber);
                    count++; // Menambah penghitung hanya jika bilangan ditampilkan

                    // Tambahkan koma setelah angka, kecuali setelah angka terakhir
                    if (count < N) {
                        System.out.print(", ");
                    }
                }
                // Naikkan angka saat ini
                currentNumber++;
            } while (count < N);

            System.out.println(); // Pindah ke baris baru setelah deret selesai
        }
    }
}