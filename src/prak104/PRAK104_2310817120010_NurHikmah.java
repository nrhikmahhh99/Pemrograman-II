package prak104;
import java.util.Scanner;

public class PRAK104_2310817120010_NurHikmah {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gameCount = 0;  // Penghitung permainan

        while (gameCount < 3) {
            // Input pilihan Abu
        	System.out.println("Input");
            System.out.print("Tangan Abu: ");
            String abuInput = input.nextLine().toUpperCase();

            // Input pilihan Bagas
            System.out.print("Tangan Bagas: ");
            String bagasInput = input.nextLine().toUpperCase();

            // Pisahkan input Abu dan Bagas berdasarkan spasi
            String[] tanganAbu = abuInput.split(" ");
            String[] tanganBagas = bagasInput.split(" ");

            int skorAbu = 0;
            int skorBagas = 0;

            // Terdapat tiga ronde, hitung masing-masing rondenya
            for (int i = 0; i < 3; i++) {
                String tanganA = tanganAbu[i];
                String tanganB = tanganBagas[i];

                // Menentukan pemenang dari setiap ronde
                if (tanganA.equals(tanganB)) {
                    // Seri, tidak ada poin yang ditambahkan
                    continue;
                } else if ((tanganA.equals("B") && tanganB.equals("G")) ||  // Batu mengalahkan Gunting
                           (tanganA.equals("G") && tanganB.equals("K")) ||  // Gunting mengalahkan Kertas
                           (tanganA.equals("K") && tanganB.equals("B"))) {  // Kertas mengalahkan Batu
                    skorAbu++; // Abu menang di ronde ini
                } else {
                    skorBagas++; // Bagas menang di ronde ini
                }
            }

            // Menentukan pemenang berdasarkan skor
            System.out.println("Output");
            if (skorAbu > skorBagas) {
                System.out.println("Abu");
            } else if (skorBagas > skorAbu) {
                System.out.println("Bagas");
            } else {
                System.out.println("Seri");
            }
            
         // Tambah penghitung permainan setelah selesai satu permainan
            gameCount++;

            System.out.println();  // Pindah ke baris baru untuk memperjelas output
        }
    }
}