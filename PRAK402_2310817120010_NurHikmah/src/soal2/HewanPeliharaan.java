package soal2;

import java.util.Scanner;

public abstract class HewanPeliharaan {
    private String nama;
    private String ras;

    public HewanPeliharaan(String r, String n) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama hewan peliharaan: ");
        this.nama = input.nextLine();
        System.out.print("Ras: ");
        this.ras = input.nextLine();
    }
    
    public void display(){
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + this.nama);
        System.out.println("Dengan ras : " + this.ras);
    }
}
