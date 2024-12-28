package application;


public class Penjualan {
 private int penjualan_id;
 private int jumlah;
 private double totalHarga;
 private String tanggal;
 private int pelangganId;
 private int bukuId;

 public Penjualan(int jumlah, double totalHarga, String tanggal) {
     this.jumlah = jumlah;
     this.totalHarga = totalHarga;
     this.tanggal = tanggal;
}

public int getPenjualanId() {
     return penjualan_id;
 }

 public void setPenjualanId(int penjualanId) {
     this.penjualan_id = penjualanId;
 }

 public int getJumlah() {
     return jumlah;
 }

 public void setJumlah(int jumlah) {
     this.jumlah = jumlah;
 }

 public double getTotalHarga() {
     return totalHarga;
 }

 public void setTotalHarga(double totalHarga) {
     this.totalHarga = totalHarga;
 }

 public String getTanggal() {
     return tanggal;
 }

 public void setTanggal(String tanggal) {
     this.tanggal = tanggal;
 }

 public int getPelangganId() {
     return pelangganId;
 }

 public void setPelangganId(int pelangganId) {
     this.pelangganId = pelangganId;
 }

 public int getBukuId() {
     return bukuId;
 }

 public void setBukuId(int bukuId) {
     this.bukuId = bukuId;
 }
}
