/*
 * Aplikasi Penghitung Kata
 * Tugas 5 PBO2 - Romi Jsai
 * Fitur:
 * - Hitung jumlah kata, karakter, kalimat, paragraf
 * - Pencarian kata tertentu
 * - Simpan teks & hasil ke file
 * - Real-time update menggunakan DocumentListener
 */

 import javax.swing.*;
 import javax.swing.event.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;
 import java.util.regex.*;
 
 public class AplikasiPenghitungKata extends JFrame {
     private JTextArea textArea;
     private JTextField txtCari;
     private JLabel lblKata, lblKarakter, lblKalimat, lblParagraf, lblCari;
     private JButton btnHitung, btnCari, btnSimpan;
 
     public AplikasiPenghitungKata() {
         setTitle("Aplikasi Penghitung Kata");
         setSize(600, 500);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout(10, 10));
 
         // =======================
         // SUSUNAN KOMPONEN GUI
         // =======================
 
         // Panel atas → untuk pencarian dan tombol
         JPanel panelAtas = new JPanel(new FlowLayout(FlowLayout.LEFT));
         panelAtas.add(new JLabel("Cari Kata:"));
         txtCari = new JTextField(12);
         panelAtas.add(txtCari);
         btnCari = new JButton("Cari");
         panelAtas.add(btnCari);
         btnHitung = new JButton("Hitung");
         panelAtas.add(btnHitung);
         btnSimpan = new JButton("Simpan ke File");
         panelAtas.add(btnSimpan);
         add(panelAtas, BorderLayout.NORTH);
 
         // Panel tengah → area teks dalam scroll
         textArea = new JTextArea();
         textArea.setLineWrap(true);
         textArea.setWrapStyleWord(true);
         JScrollPane scrollPane = new JScrollPane(textArea);
         add(scrollPane, BorderLayout.CENTER);
 
         // Panel bawah → label hasil
         JPanel panelBawah = new JPanel(new GridLayout(5, 1));
         lblKata = new JLabel("Jumlah Kata: 0");
         lblKarakter = new JLabel("Jumlah Karakter: 0");
         lblKalimat = new JLabel("Jumlah Kalimat: 0");
         lblParagraf = new JLabel("Jumlah Paragraf: 0");
         lblCari = new JLabel("Hasil Pencarian: -");
         panelBawah.add(lblKata);
         panelBawah.add(lblKarakter);
         panelBawah.add(lblKalimat);
         panelBawah.add(lblParagraf);
         panelBawah.add(lblCari);
         add(panelBawah, BorderLayout.SOUTH);
 
         // =======================
         // EVENT HANDLER
         // =======================
         // Tombol Hitung
         btnHitung.addActionListener(e -> hitungSemua());
 
         // Pencarian Kata
         btnCari.addActionListener(e -> cariKata());
 
         // Simpan ke File
         btnSimpan.addActionListener(e -> simpanKeFile());
 
         // Hitung otomatis setiap teks berubah
         textArea.getDocument().addDocumentListener(new DocumentListener() {
             public void insertUpdate(DocumentEvent e) { hitungSemua(); }
             public void removeUpdate(DocumentEvent e) { hitungSemua(); }
             public void changedUpdate(DocumentEvent e) { hitungSemua(); }
         });
     }
 
     // =======================
     // LOGIKA PROGRAM
     // =======================
     private void hitungSemua() {
         String teks = textArea.getText().trim();
         if (teks.isEmpty()) {
             lblKata.setText("Jumlah Kata: 0");
             lblKarakter.setText("Jumlah Karakter: 0");
             lblKalimat.setText("Jumlah Kalimat: 0");
             lblParagraf.setText("Jumlah Paragraf: 0");
             return;
         }
 
         int jumlahKarakter = teks.length();
         int jumlahKata = teks.split("\\s+").length;
         int jumlahKalimat = teks.split("[.!?]+").length;
         int jumlahParagraf = teks.split("\\n+").length;
 
         lblKata.setText("Jumlah Kata: " + jumlahKata);
         lblKarakter.setText("Jumlah Karakter: " + jumlahKarakter);
         lblKalimat.setText("Jumlah Kalimat: " + jumlahKalimat);
         lblParagraf.setText("Jumlah Paragraf: " + jumlahParagraf);
     }
 
     private void cariKata() {
         String teks = textArea.getText().toLowerCase();
         String kataDicari = txtCari.getText().toLowerCase().trim();
 
         if (kataDicari.isEmpty()) {
             lblCari.setText("Hasil Pencarian: Masukkan kata terlebih dahulu");
             return;
         }
 
         Pattern pattern = Pattern.compile("\\b" + Pattern.quote(kataDicari) + "\\b");
         Matcher matcher = pattern.matcher(teks);
 
         int count = 0;
         while (matcher.find()) count++;
 
         lblCari.setText("Hasil Pencarian: \"" + kataDicari + "\" muncul " + count + " kali");
     }
 
     private void simpanKeFile() {
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setDialogTitle("Simpan ke File");
 
         if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
 
             try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                 writer.println("=== TEKS ASLI ===");
                 writer.println(textArea.getText());
                 writer.println("\n=== HASIL PERHITUNGAN ===");
                 writer.println(lblKata.getText());
                 writer.println(lblKarakter.getText());
                 writer.println(lblKalimat.getText());
                 writer.println(lblParagraf.getText());
                 writer.println(lblCari.getText());
                 JOptionPane.showMessageDialog(this, "Berhasil disimpan ke file: " + file.getName());
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(this, "Gagal menyimpan file!", "Error", JOptionPane.ERROR_MESSAGE);
             }
         }
     }
 
     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> new AplikasiPenghitungKata().setVisible(true));
     }
 }
 