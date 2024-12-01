/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpustakaan;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author Dimas
 */
public class inputBuku extends javax.swing.JFrame {
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtTahunTerbit;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JTable tableBuku;
    private javax.swing.JLabel lblKeterangan;

    public inputBuku() {
        initComponents();
    }

    private void initComponents() {
        // Inisialisasi komponen
        txtJudul = new javax.swing.JTextField();
        txtPengarang = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        txtTahunTerbit = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        
        // Dropdown Kategori
        String[] kategori = {"Fiksi", "Non-Fiksi", "Edukasi", "Sains", "Sejarah"};
        cmbKategori = new javax.swing.JComboBox<>(kategori);
        
        JButton btnTambah = new JButton("Tambah Data");
        lblKeterangan = new javax.swing.JLabel("Keterangan:");

        // Inisialisasi tabel
        String[] columnNames = {"Judul", "Pengarang", "ISBN", "Tahun Terbit", "Harga", "Kategori"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tableBuku = new javax.swing.JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableBuku);

        // Layout
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Judul:"));
        inputPanel.add(txtJudul);
        inputPanel.add(new JLabel("Pengarang:"));
        inputPanel.add(txtPengarang);
        inputPanel.add(new JLabel("ISBN:"));
        inputPanel.add(txtISBN);
        inputPanel.add(new JLabel("Tahun Terbit:"));
        inputPanel.add(txtTahunTerbit);
        inputPanel.add(new JLabel("Harga:"));
        inputPanel.add(txtHarga);
        inputPanel.add(new JLabel("Kategori:"));
        inputPanel.add(cmbKategori);

        // Tambah action listener untuk tombol
        btnTambah.addActionListener(e -> tambahBuku());

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnTambah, BorderLayout.SOUTH);
        add(lblKeterangan, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void tambahBuku() {
        try {
            // Ambil input dari field
            String judul = txtJudul.getText();
            String pengarang = txtPengarang.getText();
            String isbn = txtISBN.getText();
            int tahunTerbit = Integer.parseInt(txtTahunTerbit.getText());
            double harga = Double.parseDouble(txtHarga.getText());
            String kategori = (String) cmbKategori.getSelectedItem();

            // Buat objek buku dengan validasi
            Buku buku = new Buku(judul, pengarang, isbn, tahunTerbit, harga, kategori);

            // Tambahkan ke tabel
            DefaultTableModel model = (DefaultTableModel) tableBuku.getModel();
            model.addRow(new Object[]{
                buku.getJudul(), 
                buku.getPengarang(), 
                buku.getIsbn(), 
                buku.getTahunTerbit(), 
                buku.getHarga(), 
                buku.getKategori()
            });

            // Reset input
            resetInput();
            lblKeterangan.setText("Buku berhasil ditambahkan");
            lblKeterangan.setForeground(Color.GREEN);

        } catch (NumberFormatException e) {
            lblKeterangan.setText("Error: Tahun terbit atau harga harus angka");
            lblKeterangan.setForeground(Color.RED);
        } catch (ValidasiInputException e) {
            lblKeterangan.setText("Error: " + e.getMessage());
            lblKeterangan.setForeground(Color.RED);
        }
    }

    private void resetInput() {
        txtJudul.setText("");
        txtPengarang.setText("");
        txtISBN.setText("");
        txtTahunTerbit.setText("");
        txtHarga.setText("");
        cmbKategori.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        // Jalankan form di Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new inputBuku().setVisible(true);
        });
    }
}