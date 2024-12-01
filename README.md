# Exception-Handling_PerpustakaanInput-Buku

Sistem ini adalah aplikasi sederhana untuk pengelolaan data buku di perpustakaan menggunakan Java Swing. Aplikasi ini memungkinkan pengguna untuk menambahkan data buku ke dalam tabel dengan validasi input yang ketat, serta menampilkan informasi buku dalam format yang mudah dibaca.

## Fitur

- Tambah Data Buku: Pengguna dapat memasukkan data buku seperti judul, pengarang, ISBN, tahun terbit, harga, dan kategori.
- Validasi Input: Input akan divalidasi untuk memastikan data yang dimasukkan sesuai dengan kriteria yang benar (misalnya, ISBN harus 13 digit angka).
- Tabel Buku: Data buku yang sudah dimasukkan akan ditampilkan dalam tabel.
- Pesan Error: Sistem memberikan pesan kesalahan jika ada data yang tidak valid, seperti kategori yang tidak sesuai atau harga yang tidak valid.

## Teknologi

- Java 8 (atau lebih baru)
- Swing untuk antarmuka pengguna grafis (GUI)
- Java Validation untuk validasi input (menggunakan pengecualian 'ValidasiInputException')
