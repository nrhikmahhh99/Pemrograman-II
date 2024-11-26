package soal2;

import java.util.*;

public class Soal2Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Negara> daftarNegara = new LinkedList<>();
	    HashMap<Integer, String> daftarBulan = new HashMap<>();

	        // Inisialisasi nama bulan
	        daftarBulan.put(1, "Januari");
	        daftarBulan.put(2, "Februari");
	        daftarBulan.put(3, "Maret");
	        daftarBulan.put(4, "April");
	        daftarBulan.put(5, "Mei");
	        daftarBulan.put(6, "Juni");
	        daftarBulan.put(7, "Juli");
	        daftarBulan.put(8, "Agustus");
	        daftarBulan.put(9, "September");
	        daftarBulan.put(10, "Oktober");
	        daftarBulan.put(11, "November");
	        daftarBulan.put(12, "Desember");
	        
	     // Input jumlah negara
	        System.out.print("");
	        int jumlahNegara = Integer.parseInt(scanner.nextLine());
	
	     // Input data negara
	        for (int i = 0; i < jumlahNegara; i++) {
	            System.out.print("");
	            String nama = scanner.nextLine();
	            System.out.print("");
	            String jenisKepemimpinan = scanner.nextLine();
	            System.out.print("");
	            String namaPemimpin = scanner.nextLine();
	
	            if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
	                // Monarki tidak memiliki tanggal kemerdekaan
	                daftarNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin));
	            } else {
	                System.out.print("");
	                int tanggalKemerdekaan = Integer.parseInt(scanner.nextLine());
	                System.out.print("");
	                int bulanKemerdekaan = Integer.parseInt(scanner.nextLine());
	                System.out.print("");
	                int tahunKemerdekaan = Integer.parseInt(scanner.nextLine());
	
	                daftarNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan));
	            }
	        }
	
	        // Output data negara
	        System.out.println();
	        for (Negara negara : daftarNegara) {
	            System.out.println(negara.getDetail(daftarBulan));
	            System.out.println();
	        }
	}
}
