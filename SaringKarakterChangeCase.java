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
import javax.swing.text.*;

public class SaringKarakterChangeCase extends JFrame {
    JTextField textLower = new JTextField ();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JTextField textUpper = new JTextField();
    
    public static void main (String[] args) {
        SaringKarakterChangeCase saringKarakter = new SaringKarakterChangeCase();
        saringKarakter.setSize(400,200);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int lebar = (screen.width-saringKarakter.getSize().width)/2;
        int tinggi = (screen.height-saringKarakter.getSize().height)/2;
        saringKarakter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saringKarakter.setLocation(lebar, tinggi);
        saringKarakter.setResizable(false);
        saringKarakter.setVisible(true);
    }
    public SaringKarakterChangeCase () {
        this.getContentPane().setLayout(null);
        jLabel1.setBounds (new Rectangle(16,10,354,15));
        jLabel1.setText("merubah semua huruf menjadi huruf kecil");
        jLabel2.setBounds(new Rectangle (16,80,354,15));
        jLabel2.setText("Merubah semua huruf menjadi huruf besar");
        
//        mengatur atribut lower
        textLower.setBounds(new Rectangle (17,40,292,25));
        textLower.setDocument(new changeCase().getToLowerCase());
//        mengatur untuk atribut upper
        textUpper.setBounds(new Rectangle(17,40,292,25));
        textUpper.setDocument(new changeCase().getToUpperCase());
        this.setState(Frame.NORMAL);
        this.setTitle("Merubah bentuk huruf");
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(textLower, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(textUpper, null);
    }
    class changeCase {
          public changeCase(){
              
          }
          
          public PlainDocument getToUpperCase() {
      PlainDocument filterUpper = new PlainDocument() {
        public void insertString(int offs, String str, AttributeSet a) throws
            BadLocationException {
          char[] upper = str.toCharArray();
          for (int i = 0; i < upper.length; i++) {
            // Menjadi upper case
            upper[i] = Character.toUpperCase(upper[i]);
          }
          super.insertString(offs, new String(upper), a);
        }
      };
      return filterUpper;
    }
          public PlainDocument getToLowerCase() {
      PlainDocument filterLower = new PlainDocument() {
        public void insertString(int offs, String str, AttributeSet a) throws
            BadLocationException {
          char[] lower = str.toCharArray();
          for (int i = 0; i < lower.length; i++) {
            // Menjadi lower case
            lower[i] = Character.toLowerCase(lower[i]);
          }
          super.insertString(offs, new String(lower), a);
        }
      };
      return filterLower;
    }
  }

}
