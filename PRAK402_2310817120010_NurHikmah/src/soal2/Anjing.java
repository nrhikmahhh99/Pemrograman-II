package soal2;

import java.util.Arrays;
import java.util.Scanner;

public class Anjing extends HewanPeliharaan{
    private String warnaBulu;
    private String [] kemampuan;

    public Anjing(String r, String n, String w, String [] k) {
        super(r, n);
        Scanner input = new Scanner(System.in);
        System.out.print("Warna Bulu: ");
        w = input.nextLine();
        this.warnaBulu = w;
        System.out.print("Kemampuan : ");
        this.kemampuan = new String[] {input.nextLine()};
    }

    public void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki warna bulu : " + this.warnaBulu);
        System.out.println("Memiliki kemampuan : " + Arrays.toString(this.kemampuan).replace("[","").replace("]","").replace(",",""));
    }
}
