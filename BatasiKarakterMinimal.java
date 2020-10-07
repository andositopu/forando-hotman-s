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
import java.awt.event.*;

public class BatasiKarakterMinimal extends JFrame implements ActionListener {

    private static class privite {

        public privite() {
        }
    }
    JLabel jLabel1 = new JLabel ();
    JLabel jLabel2 = new JLabel ();
    JTextField data = new JTextField();
    JButton jButton1 = new JButton ();
    
    public static void main(String[] args) {
        BatasiKarakterMinimal raya = new BatasiKarakterMinimal ();
        raya.setSize(350, 150);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int lebar = (screen.width-raya.getSize().width) /2;
        int tinggi = (screen.height-raya.getSize().height) /2;
        
        raya.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        raya.setLocation(lebar, tinggi);
        raya.setResizable(false);
        raya.setVisible(true);
        }
    
//    menambahkan komponen ActionListener
    public BatasiKarakterMinimal(){
        this.getContentPane().setLayout(null);
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel1.setText("Membatasi karakter Minimal Menggunakan Tombol");
        jLabel1.setBounds(new Rectangle(26,8,300,22));
        jLabel2.setRequestFocusEnabled(true);
        jLabel2.setText("Minimal 6 Karakter");
        jLabel2.setBounds(new Rectangle(26,26,287,27));
        data.setBounds (new Rectangle (70,53,165,23));
        jButton1.setBounds (new Rectangle (126,87,65,20));
        jButton1.setText("OK");
        jButton1.addActionListener(this);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(data, null);
        this.getContentPane().add(jButton1, null);
        
        try {
            jbInit();
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
//    membuat source agar tulisan 'OK' dapat ditekan
    public void actionPerformed(ActionEvent e) {
        batasiKarakter();
    }
    
//    sekarang kita buat untuk panjang karakter data yang dimasukkan
    public void batasiKarakter () {
        int banyakKarakter = data.getText().length ();
        if (banyakKarakter > 9){
            jOptionPane.showMessageDialog(null, "Karakter yang anda masukkan lebih dari 9");
            data.setText(" ");
        }
        else {
            jOptionPane.showMessageDialog(null, "Karakter yang anda masukkan tidak lebih dari 9");
            data.setText("");
            
        }
    }
    
    private void jbInit() throws Exception {
        this.setTitle("Batasi Karakter Minimal");
    }
}

