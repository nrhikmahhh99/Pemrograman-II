package prak101;

import java.util.Scanner;

public class PRAK101_2310817120010_NurHikmah {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Memasukkan input
        System.out.print("Masukkan Nama Lengkap: ");
        String namaLengkap = input.nextLine();
        System.out.print("Masukkan Tempat Lahir: ");
        String tempatLahir = input.nextLine();
        System.out.print("Masukkan Tanggal Lahir: ");
        int tanggalLahir = input.nextInt();
        System.out.print("Masukkan Bulan Lahir: ");
        int bulanLahir = input.nextInt();
        System.out.print("Masukkan Tahun Lahir: ");
        int tahunLahir = input.nextInt();
        System.out.print("Masukkan Tinggi Badan: ");
        double tinggiBadan = input.nextDouble();
        System.out.print("Masukkan Berat Badan: ");
        double beratBadan = input.nextDouble();

        // Menampilkan output
        System.out.println("\nNama Lengkap " + namaLengkap + ", Lahir di " + tempatLahir + " pada Tanggal " + tanggalLahir + " " + bulanKeNama(bulanLahir) + " " + tahunLahir);
        System.out.println("Tinggi Badan " + tinggiBadan + " cm dan Berat Badan " + beratBadan + " kilogram");
    }

    // Fungsi untuk mengubah angka bulan menjadi nama bulan
    public static String bulanKeNama(int bulan) {
        String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        return namaBulan[bulan - 1];
    }
}