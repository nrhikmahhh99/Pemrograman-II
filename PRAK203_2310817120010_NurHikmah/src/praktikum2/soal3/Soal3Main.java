package praktikum2.soal3;

public class Soal3Main { 
    public static void main(String[] args) { 
        Pegawai p1 = new Pegawai(); 
        //Pada baris ini terjadi error karena tidak adanya tanda titik koma (;)
        //p1.nama = "Roi"
        p1.nama = "Roi"; 
        p1.asal = "Kingdom of Orvel"; 
        p1.setJabatan("Assasin"); 
 
        System.out.println("Nama: " + p1.getNama()); 
        System.out.println("Asal: " + p1.getAsal()); 
        System.out.println("Jabatan: " + p1.jabatan); 
        //Penambahan kata "tahun" agar sesuai dengan output yang diinginkan.
        //System.out.println("Umur: " + p1.umur); 
        System.out.println("Umur: " + p1.umur + " tahun"); 
    } 
} 