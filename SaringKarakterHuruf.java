/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validasiprimarykey;

import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

/**
 *
 * @author andositopu
 */

public class SaringKarakterHuruf extends JFrame {
    JTextField textHuruf = new JTextField();
  JLabel jLabel1 = new JLabel();

  /**
   * Methode main
   * @param args : arguments
   */
  public static void main(String[] args) {
    SaringKarakterHuruf saringKarakter = new SaringKarakterHuruf();
    saringKarakter.setSize(400, 150);
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int lebar = (screen.width - saringKarakter.getSize().width) / 2;
    int tinggi = (screen.height - saringKarakter.getSize().height) / 2;

    saringKarakter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    saringKarakter.setLocation(lebar, tinggi);
    saringKarakter.setResizable(false);
    saringKarakter.setVisible(true);
  }

  /**
   * Konstuktor
   * Methode ini berisikan pembuatan komponen dan penambahan attribut
   */
  public SaringKarakterHuruf() {
    this.setTitle("Saring Karakter Berupa Huruf (Only Letter)");
    this.getContentPane().setLayout(null);
    jLabel1.setText("Hanya Karakter Huruf (Letter) yang bisa dimasukkan");
    jLabel1.setBounds(new Rectangle(14, 22, 330, 18));
    textHuruf.setBounds(new Rectangle(13, 43, 333, 26));
    // Mengatur atribut untuk only Letter
    textHuruf.setDocument(new onlyLetter().getOnlyLetter());
    this.getContentPane().add(textHuruf, null);
    this.getContentPane().add(jLabel1, null);
  }

  /**
   * Kelas Untuk Menyaring hanya karakter huruf (Letter)
   */
  class onlyLetter {
    public onlyLetter() {
    }

    /** methode ini dipakai untuk mengeset dan mendapatkan filter
     *  @return mengembalikan filter bertype PlainDocument
     *  Menyaring Hanya karakter huruf (Letter) yang bisa dimasukkan
     */
    public PlainDocument getOnlyLetter() {
      PlainDocument filterLetter = new PlainDocument() {
        public void insertString(int offs, String str, AttributeSet a) throws
            BadLocationException {
          StringBuffer buffer = new StringBuffer();
          int s = 0;
          char[] dataInput = str.toCharArray();
          // Memeriksa semua data yang dimasukkan
          for (int i = 0; i < dataInput.length; i++) {
            // Menyaring Apakah data masukkan berupa LETTER ??
            boolean isOnlyLetter = Character.isLetter(dataInput[i]);
            if (isOnlyLetter == true) {
              dataInput[s] = dataInput[i];
              s++;
            }
          }
          buffer.append(dataInput, 0, s);
          super.insertString(offs, new String(buffer), a);
        }
      };
      return filterLetter;
    }
  }
}


