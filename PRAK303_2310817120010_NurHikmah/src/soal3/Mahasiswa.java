package soal3;

import java.util.ArrayList;

class Mahasiswa {
    private String nama;
    private String nim;
    private static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    // Menambahkan mahasiswa baru
    public static void tambahMahasiswa(String nama, String nim) {
        if (daftarMahasiswa.stream().noneMatch(m -> m.getNim().equals(nim))) {
            daftarMahasiswa.add(new Mahasiswa(nama, nim));
            System.out.println("Mahasiswa " + nama + " ditambahkan.");
        } else {
            System.out.println("NIM sudah ada. Tidak bisa menambahkan mahasiswa.");
        }
    }

    // Menghapus mahasiswa berdasarkan NIM
    public static void hapusMahasiswa(String nim) {
        boolean ditemukan = daftarMahasiswa.removeIf(m -> m.getNim().equals(nim));
        if (ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + nim + " dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    // Mencari mahasiswa berdasarkan NIM
    public static void cariMahasiswa(String nim) {
        Mahasiswa hasil = daftarMahasiswa.stream()
                .filter(m -> m.getNim().equals(nim))
                .findFirst()
                .orElse(null);
        if (hasil != null) {
            System.out.println("Mahasiswa ditemukan: NIM: " + hasil.getNim() + ", Nama: " + hasil.getNama());
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    // Menampilkan semua mahasiswa
    public static void tampilkanSemuaMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Daftar mahasiswa kosong.");
        } else {
            for (Mahasiswa m : daftarMahasiswa) {
                System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
            }
        }
    }
}