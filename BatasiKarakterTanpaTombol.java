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
import java.awt.event.*;

public class BatasiKarakterTanpaTombol extends JFrame {
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JTextField jTextFieldl = new JTextField();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    
    public static void main (String [] args) {
        BatasiKarakterTanpaTombol ando = new BatasiKarakterTanpaTombol();
        ando.setSize(300, 200);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int lebar = (screen.width-ando.getSize().width)/2;
        int tinggi = (screen.height-ando.getSize().height)/2;
        ando.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ando.setLocation(lebar, tinggi);
        ando.setResizable(false);
        ando.setVisible(true);
    }
    
//    menambah komponen di ActionListener
    public BatasiKarakterTanpaTombol(){
        jLabel1.setText ("Membatasi Karakter Tanpa Tombol");
        jLabel1.setBounds (new Rectangle(4,22,400,15));
        this.getContentPane().setLayout(null);
        this.setTitle("Batasi karakter Tanpa Tombol");
        jLabel2.setText("Masukkan minimal 6 karakter");
        jLabel2.setBounds (new Rectangle (5,39,239,15));
        jLabel3.setText("Tekan tombol Enter untuk memproses...");
        jLabel4.setText("Tidak dapat memasukkan lebih 6 karakter");
        jLabel4.setBounds(new Rectangle(5,94,330,15));
        jTextFieldl.setText("");
        jTextFieldl.setBounds(new Rectangle(3,59,194,23));
        
//        mengatur batas maksimal karakter
        jTextFieldl.setDocument(new batasiInput((byte) 6).getFilter());
        jTextFieldl.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                int nilai_enter = e.VK_ENTER;
                int kode = e.getKeyCode();
                if (kode == nilai_enter) {
                    jOptionPane.showMessageDialog(null,"tekan tombol Enter untuk memproses");
                }
            }
        });
        this.getContentPane().add(jLabel1,null);
        this.getContentPane().add(jLabel2,null);
        this.getContentPane().add(jTextFieldl,null);
        this.getContentPane().add(jLabel3,null);
        this.getContentPane().add(jLabel4,null);
    }
    
//    membatasi input yang masuk
    class batasiInput {
        byte length;
        PlainDocument filter;
        public batasiInput (byte length) {
            this.length = length;
        }
        
        public PlainDocument getFilter() {
            filter = new javax.swing.text.PlainDocument() {
                
//                membatasi jumlah karakter yang diinput
                public void insertString(int offs, String str, AttributeSet a) throws
                        BadLocationException {
                    int ab = jTextFieldl.getText().length();
                    if (ab < length) {
                        super.insertString(offs, str, a);
                    }
                }      
            };
            return filter;
        }
    }
}
