/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

/**
 *
 * @author Dimas
 */
public class Buku {
    private String judul;
    private String pengarang;
    private String isbn;
    private int tahunTerbit;
    private double harga;
    private String kategori;

    // Konstruktor dengan validasi
    public Buku(String judul, String pengarang, String isbn, 
                int tahunTerbit, double harga, String kategori) throws ValidasiInputException {
        // Validasi Judul
        if (judul == null || judul.trim().isEmpty()) {
            throw new ValidasiInputException("Judul tidak boleh kosong");
        }

        // Validasi Pengarang
        if (pengarang == null || pengarang.trim().isEmpty()) {
            throw new ValidasiInputException("Pengarang tidak boleh kosong");
        }

        // Validasi ISBN
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new ValidasiInputException("ISBN harus 13 angka");
        }

        // Validasi Tahun Terbit
        int tahunSekarang = java.time.Year.now().getValue();
        if (tahunTerbit < 1000 || tahunTerbit > tahunSekarang) {
            throw new ValidasiInputException("Tahun terbit harus antara 1000 dan " + tahunSekarang);
        }

        // Validasi Harga
        if (harga <= 0) {
            throw new ValidasiInputException("Harga harus bernilai positif");
        }

        // Validasi Kategori
        String[] kategoriValid = {"Fiksi", "Non-Fiksi", "Edukasi", "Sains", "Sejarah"};
        boolean kategorValid = false;
        for (String k : kategoriValid) {
            if (k.equals(kategori)) {
                kategorValid = true;
                break;
            }
        }
        if (!kategorValid) {
            throw new ValidasiInputException("Kategori tidak valid");
        }

        // Set nilai jika validasi berhasil
        this.judul = judul;
        this.pengarang = pengarang;
        this.isbn = isbn;
        this.tahunTerbit = tahunTerbit;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Getter untuk semua atribut
    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public double getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }
}