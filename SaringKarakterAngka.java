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
import javax.swing.text.*;

  
    



public class SaringKarakterAngka extends jFrame {
    JTextField textAngka = new JTextField();
    JLabel jLabel1 = new JLabel();
    
    public static void main (String[] args) {
        SaringKarakterAngka saringKarakter = new SaringKarakterAngka();
        saringKarakter.setSize(400,150);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int lebar = (screen.width-saringKarakter.getSize().width)/2;
        int tinggi = (screen.height-saringKarakter.getSize().height)/2;
    
    saringKarakter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saringKarakter.setLocation(lebar,tinggi);
        saringKarakter.setResizable(false);
        saringKarakter.setVisible(true);
    }
//    penambahan atribut lainnya
    public SaringKarakterAngka() {
        this.setTitle("Saring Karakter Berupa Angka");
        this.getContentPane().setLayout(null);
        jLabel1.setText("Hanya Angka Yang Bisa dimasukkan");
        jLabel1.setBounds (new Rectangle(14,22,330,18));
        textAngka.setBounds (new Rectangle(13,43,330,26));
        textAngka.setDocument(new hanyaAngka().getHanyaAngka());
        this.getContentPane().add(textAngka, null);
        this.getContentPane().add(jLabel1, null);
    }
    
//    untuk menyaring angka
    class hanyaAngka {
        public hanyaAngka() {
        }
        
////        untuk menset dan menfilter agar angka saja yang dapat dimasukkan
        public PlainDocument getHanyaAngka() {
            PlainDocument filterDigit = new PlainDocument() {
                public void insertString(int offs, String str, AtrributeSet a) throws
                BadLocationException {
                    StringBuffer buffer = new StringBuffer (); //Buffer biasa digunakan untuk string karakter
                    int s = 0;
                    char[] dataInput = str.toCharArray(); //mengembalikan karakter indeks yang telah ditentukaan
                    for (int i=0; i< dataInput.length; i++) {    //memeriksa data yang dimasukkan
                        boolean hanyaAngka = Character.isDigit(dataInput[i]); //menyaring data yang masuk apakah berupa Digit
                        if (hanyaAngka == true) {
                            dataInput[s] = dataInput[i];
                            s++;
                        }
                    }
                    buffer.append(dataInput, 0, s);
                    super.insertString(offs, new String(buffer), a);
                }
            };
            return filterDigit;
        }
    }
}
