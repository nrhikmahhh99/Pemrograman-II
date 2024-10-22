package praktikum2.soal3;

//Pada baris ini terjadi error karena nama class harus sama dengan nama file.
//File ini bernama Pegawai.java, namun class di sini adalah Employee, jadi akan muncul error nama file dan nama class tidak sesuai.
//public class Employee {
public class Pegawai {
  public String nama; 
  //asal seharusnya bertipe String, bukan char, karena memuat nama daerah yang panjang
  //public char asal;
  public String asal; 
  public String jabatan; 
  //Pada baris ini terjadi error karena umur tidak diinisialisasi. Karena pada output ditentukan umur 17 tahun, maka seharusnya menginisialisasi umur dengan nilai 17.
  //public int umur; 
  public int umur = 17;

  public String getNama() { 
      return nama; 
  } 

  public String getAsal() { 
      return asal; 
  } 

  //Pada baris ini terjadi error karena parameter `j` tidak ditemukan. Harus ada parameter untuk menerima input jabatan.
  //public void setJabatan() {
  //    this.jabatan = j;
  public void setJabatan(String j) {
  	this.jabatan = j;
  } 
} 