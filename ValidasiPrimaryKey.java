/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasiprimarykey;

/**
 *
 * @author andositopu
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.text.*;


public class ValidasiPrimaryKey extends JFrame {
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JTextField textKode = new JTextField();
    JTextField textNama = new JTextField();
    List daftar = new List();
    JLabel jLabel3 = new JLabel();
    Button button1 = new Button();
    Connection konek;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ValidasiPrimaryKey validasiPrimaryKey = new ValidasiPrimaryKey();
        validasiPrimaryKey.setSize(400, 400);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int Lebar = (screen.width - validasiPrimaryKey.getSize().width) /2;
        int Tinggi = (screen.width - validasiPrimaryKey.getSize().height) /2;
        
    validasiPrimaryKey.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        validasiPrimaryKey.setLocation(Lebar, Tinggi);
        validasiPrimaryKey.setResizable(false);
        validasiPrimaryKey.setVisible(true);  
    }
    public ValidasiPrimaryKey(){
        this.getContentPane().setLayout (null);
        this.setTitle ("Validasi Primary key");
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("Kode Siswa :");
        jLabel1.setBounds(new Rectangle (10, 13, 86, 15));
        jLabel2.setBounds(new Rectangle (10, 43, 86, 15));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("Nama Siswa :");
        textKode.setText(null);
        textKode.setBounds(new Rectangle (100,13,187,21));
        textKode.setDocument(new batasiInput((byte) 9).getFilter());
        textNama.setText(null);
        textNama.setBounds(new Rectangle (100,43,187,21));
        daftar.setBounds (new Rectangle (29,127,288,182));
        jLabel3.setText("Daftar kode-kode siswa yang tersimpan sebelumnya");
        jLabel3.setBounds(new Rectangle(29,109,343,15));
        button1.setLabel("Cek dan Simpan");
        button1.setBounds (new Rectangle (97,77,128,24));
        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cekAndSaveData(e);
            }

            private void cekAndSaveData(ActionEvent e) {
                throw new UnsupportedOperationException("Not yet implemented");
            }
        });
  
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(textKode, null);
        this.getContentPane().add(daftar, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(button1, null);
        
        koneksiDatabase();
        daftarKode();
    }
    public void koneksiDatabase(){
        try {
            Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
                    System.out.println("Sukses driver JDBC ditemukan...");
              
                    try {
                        String url = "jdbc:odbc:dsndbmahasiswa";
                        String user =" ";
                        String pass = "";
                        konek = DriverManager.getConnection(url, user, pass);
                        System.out.println("Sukses Koneksi...");
                    }
//                  
//                    untuk pemberitahuan koneksi gagal
                    catch (SQLException se) {
                        System.out.println("Koneksi gagal = " + se);
                    }  
        }
//        untuk memanggil drivermanager
        catch (ClassNotFoundException cnfe) {
            System.out.println("Class tidak ditemukan...Eror : " + cnfe);
        }
    }
        
        public void daftarKode() {
            daftar.removeAll();

            //            mengirim data sql
           try {
               Statement stat = konek.createStatement();
               ResultSet rSet = stat.executeQuery("Select * from mahasiswa");

               //               mengambil hasil sql
               while (rSet.next()) {
                   daftar.add(rSet.getString("nim")+" "+rSet.getString("nama"));
               }
               stat.close();
           } 
           catch (SQLException se) {
               System.out.println("SQL salah = " +se);
           }
           catch (Exception e) {
               System.out.println("Pesan error= " + e);
           }
        }
        
       void cekAndSaveData(ActionEvent e) {
           try{
               PreparedStatement stat = konek.prepareStatement("Insert Into mahasiswa values (?,?");
               try {
                   stat.setString (1, textKode.getText());
                   stat.setString(2, textNama.getText());
                   stat.executeUpdate();
               }
               catch (SQLException se) {
                   System.out.println("Gagal Menyimpan..Pesan Errror=" + se);
                   JOptionPane.showMessageDialog(null, "Kode yang anda masukkna sebelumnya telah ada \nGagal disimpan...coba Lagi \nPesan error:\n"+"<html><font color = #FF0000>"+ se + "</font></html>");
                   textKode.setFocusable(true);
               }
               daftarKode();
               stat.close();
           }
           catch (Exception er) {
               System.out.println("Pesan Error = " + er);
               }
       }
}
   
//untuk membatasi data class yang masuk
class batasiInput {
    byte length;
    PlainDocument filter;
    public batasiInput(byte length) {
      this.length = length;
    }

    public PlainDocument getFilter() {
        filter = new javax.swing.text.PlainDocument() {
            public void insertString(int offs, String str, AttributeSet a) throws
                    BadLocationException {
                int ab = textKode.getText().length();
                if (ab < length); {
                        super.insertString(offs, str, a);
                }
            }
        };
    return filter;
    }
 }
//offs = menunjukkan posisi karakter yang diinput
//str = menunjukkan string yang diinput
//a = menunjukkan atribut yang diinput