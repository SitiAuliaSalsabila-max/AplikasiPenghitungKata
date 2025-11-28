/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

 import javax.swing.event.DocumentEvent;
 import javax.swing.event.DocumentListener;
 import java.io.FileWriter;
 import java.io.IOException;
 import javax.swing.JFileChooser;
 import javax.swing.JOptionPane;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 
 public class FormPenghitungKata extends javax.swing.JFrame {
     
     // Method untuk menghitung kata
     private int hitungKata(String teks) {
         if (teks == null || teks.trim().isEmpty()) {
             return 0;
         }
         // Menggunakan regex untuk menghitung kata
         String[] kata = teks.trim().split("\\s+");
         return kata.length;
     }
 
     // Method untuk menghitung karakter (tanpa spasi)
     private int hitungKarakter(String teks) {
         if (teks == null) {
             return 0;
         }
         return teks.replaceAll("\\s", "").length();
     }
 
     // Method untuk menghitung karakter dengan spasi
     private int hitungKarakterDenganSpasi(String teks) {
         if (teks == null) {
             return 0;
         }
         return teks.length();
     }
 
     // Method untuk menghitung kalimat
     private int hitungKalimat(String teks) {
         if (teks == null || teks.trim().isEmpty()) {
             return 0;
         }
         // Menghitung berdasarkan tanda titik, tanda tanya, dan tanda seru
         Pattern pattern = Pattern.compile("[.!?]+");
         Matcher matcher = pattern.matcher(teks);
         int count = 0;
         while (matcher.find()) {
             count++;
         }
         return count;
     }
 
     // Method untuk menghitung paragraf
     private int hitungParagraf(String teks) {
         if (teks == null || teks.trim().isEmpty()) {
             return 0;
         }
         // Menghitung paragraf berdasarkan baris kosong
         String[] paragraf = teks.split("\\n\\s*\\n");
         return paragraf.length;
     }
 
     // Method untuk melakukan perhitungan dan update tampilan
     private void lakukanPerhitungan() {
         String teks = textAreaInput.getText();
         
         int jumlahKata = hitungKata(teks);
         int jumlahKarakter = hitungKarakter(teks);
         int jumlahKalimat = hitungKalimat(teks);
         int jumlahParagraf = hitungParagraf(teks);
         
         LabelJumlahKata.setText(String.valueOf(jumlahKata));
         LabelJumlahKarakter.setText(String.valueOf(jumlahKarakter));
         LabelJumlahKalimat.setText(String.valueOf(jumlahKalimat));
         LabelJumlahParagraf.setText(String.valueOf(jumlahParagraf));
     }
 
     // Method untuk mencari kata tertentu
     private void cariKata() {
         String teks = textAreaInput.getText();
         String kataCari = txtFieldCari.getText();
         
         if (kataCari.isEmpty()) {
             LabelHasilCari.setText("Masukkan kata yang ingin dicari!");
             return;
         }
         
         // Menggunakan regex untuk mencari kata (case-insensitive)
         Pattern pattern = Pattern.compile("\\b" + Pattern.quote(kataCari) + "\\b", Pattern.CASE_INSENSITIVE);
         Matcher matcher = pattern.matcher(teks);
         
         int jumlahDitemukan = 0;
         while (matcher.find()) {
             jumlahDitemukan++;
         }
         
         LabelHasilCari.setText("Kata '" + kataCari + "' ditemukan: " + jumlahDitemukan + " kali");
     }
 
     // Method untuk menyimpan ke file
     private void simpanKeFile() {
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setDialogTitle("Simpan Hasil Perhitungan");
 
         int userSelection = fileChooser.showSaveDialog(this);
 
         if (userSelection == JFileChooser.APPROVE_OPTION) {
             try {
                 FileWriter writer = new FileWriter(fileChooser.getSelectedFile() + ".txt");
 
                 // Menulis teks
                 writer.write("===== TEKS =====\n");
                 writer.write(textAreaInput.getText());
                 writer.write("\n\n");
 
                 // Menulis hasil perhitungan
                 writer.write("===== HASIL PERHITUNGAN =====\n");
                 writer.write("Jumlah Kata: " + LabelJumlahKata.getText() + "\n");
                 writer.write("Jumlah Karakter: " + LabelJumlahKarakter.getText() + "\n");
                 writer.write("Jumlah Kalimat: " + LabelJumlahKalimat.getText() + "\n");
                 writer.write("Jumlah Paragraf: " + LabelJumlahParagraf.getText() + "\n");
 
                 writer.close();
 
                 JOptionPane.showMessageDialog(this, "File berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
 
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
         }
     }
 
     public FormPenghitungKata() {
         initComponents(); 
         // Menambahkan DocumentListener untuk perhitungan real-time
         textAreaInput.getDocument().addDocumentListener(new DocumentListener() {
             @Override
             public void insertUpdate(DocumentEvent e) {
                 //lakukanPerhitungan();
             }
 
             @Override
             public void removeUpdate(DocumentEvent e) {
                 //lakukanPerhitungan();
             }
 
             @Override
             public void changedUpdate(DocumentEvent e) {
                 //lakukanPerhitungan();
             }
         });
     }
 
     /**
      * This method is called from within the constructor to initialize the form.
      * WARNING: Do NOT modify this code. The content of this method is always
      * regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaInput = new javax.swing.JTextArea();
        btnHitung = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelJumlahKata = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LabelJumlahKarakter = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LabelJumlahKalimat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LabelJumlahParagraf = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFieldCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        LabelHasilCari = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("            Aplikasi Penghitung Kata");

        jLabel2.setText("Masukkan Teks");

        textAreaInput.setColumns(20);
        textAreaInput.setRows(5);
        jScrollPane1.setViewportView(textAreaInput);

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        jLabel3.setText("Hasil Perhitungan");

        jLabel4.setText("Jumlah Kata");

        LabelJumlahKata.setText("0");

        jLabel6.setText("Jumlah Karakter");

        LabelJumlahKarakter.setText("0");

        jLabel8.setText("Jumlah Kalimat");

        LabelJumlahKalimat.setText("0");

        jLabel10.setText("Jumlah Paragraf");

        LabelJumlahParagraf.setText("0");

        jLabel12.setText("Cari Kata");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        LabelHasilCari.setText("Hasil pencarian akan muncul di sini");

        btnSimpan.setText("Simpan Ke File");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFieldCari)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelJumlahParagraf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(LabelHasilCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(24, 24, 24)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelJumlahKarakter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelJumlahKata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(LabelJumlahKalimat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHitung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(LabelJumlahKata)
                            .addComponent(jLabel8)
                            .addComponent(LabelJumlahKalimat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(LabelJumlahParagraf)
                            .addComponent(LabelJumlahKarakter)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addComponent(LabelHasilCari)
                .addGap(27, 27, 27)
                .addComponent(btnSimpan)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
     private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
         lakukanPerhitungan();
     }//GEN-LAST:event_btnHitungActionPerformed
 
     private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
         cariKata();
     }//GEN-LAST:event_btnCariActionPerformed
 
     private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
         simpanKeFile();
     }//GEN-LAST:event_btnSimpanActionPerformed
 
     /**
      * @param args the command line arguments
      */
     public static void main(String args[]) {
         /* Set the Nimbus look and feel */
         //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
         /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
          * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
          */
         try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>
 
         /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new FormPenghitungKata().setVisible(true);
             }
         });
     }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelHasilCari;
    private javax.swing.JLabel LabelJumlahKalimat;
    private javax.swing.JLabel LabelJumlahKarakter;
    private javax.swing.JLabel LabelJumlahKata;
    private javax.swing.JLabel LabelJumlahParagraf;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaInput;
    private javax.swing.JTextField txtFieldCari;
    // End of variables declaration//GEN-END:variables
 }