package soal2;

import java.util.Scanner;

public class Soal2Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int nomor = input.nextInt();

        if (nomor == 1) {
            String r = null;
            String n = null;
            String w = null;
            Kucing meow = new Kucing(r, n, w);
            meow.displayDetailKucing();
        } else if (nomor == 2) {
            String r = null;
            String n = null;
            String w = null;
            String[] k = null;
            Anjing guk = new Anjing(r, n, w, k);
            guk.displayDetailAnjing();
        }
    }
}