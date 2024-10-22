package praktikum2.soal1;

public class Buah {
    String namaBuah;
    double berat;
    double harga;
    double jumlahBeli;  
    double hargaSebelumDiskon;
    double totalDiskon;
    double hargaSetelahDiskon;

    public Buah(String namaBuah, double beratBuah, double hargaBuah, double jumlahBeli) {
        this.namaBuah = namaBuah;
        this.berat = beratBuah;
        this.harga = hargaBuah;
        this.jumlahBeli = jumlahBeli;
        this.hargaSebelumDiskon = hargaBuah * (jumlahBeli / beratBuah); 
        this.totalDiskon = (int)(jumlahBeli / 4) * (4 * hargaBuah) * 0.02; 
        this.hargaSetelahDiskon = hargaSebelumDiskon - totalDiskon; 
    }

    public void cetakInfoBuah() {
        System.out.println("Nama Buah: " + namaBuah);
        System.out.println("Berat: " + berat);
        System.out.println("Harga: " + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hargaSebelumDiskon);
        System.out.printf("Total Diskon: Rp%.2f%n", totalDiskon);
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hargaSetelahDiskon);
        System.out.println();
    }
}
