package soal3;

import java.util.Scanner;

public class Soal3Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = scanner.nextLine();
                    Mahasiswa.tambahMahasiswa(nama, nim);
                    break;

                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    Mahasiswa.hapusMahasiswa(nimHapus);
                    break;

                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String nimCari = scanner.nextLine();
                    Mahasiswa.cariMahasiswa(nimCari);
                    break;

                case 4:
                    Mahasiswa.tampilkanSemuaMahasiswa();
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
