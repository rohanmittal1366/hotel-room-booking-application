

package hotel.management.system;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class login extends JFrame{
    
    JLabel jl1,jl2;
    JTextField jtf1;
    JPasswordField jpf1;
    JButton jb1,jb2;
    
    
    
    login(){
    
        jl1 = new JLabel("Username");
        jl1.setBounds(40,20,100,30);
        add(jl1);
        
        jl2 = new JLabel("Password");
        jl2.setBounds(40,70,100,30);
        add(jl2);
        
        jtf1 = new JTextField();
        jtf1.setBounds(150,20,150,30);
        add(jtf1);
        
        jpf1 = new JPasswordField();
        jpf1.setBounds(150,70,150,30);
        jpf1.setEchoChar('*');
        add(jpf1);
        
        jb1 = new JButton("Login");
        jb1.setBackground(Color.white);
        jb1.setForeground(Color.black);
        jb1.setBounds(40, 150, 120, 30);
        add(jb1);
        
        jb2 = new JButton("Cancel");
        jb2.setBackground(Color.white);
        jb2.setForeground(Color.black);
        jb2.setBounds(180, 150, 120, 30);
        add(jb2);
                
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\asus\\Documents\\NetBeansProjects\\Hotel Management System\\src\\hotel\\management\\system\\icons\\login.png"));
        JLabel jl3 = new JLabel(i1);
        jl3.setBounds(350,10,200,200);
        add(jl3);
        add(i1);
        
        getContentPane().setBackground(Color.white;
        
        */
        
        
        setLayout(null);
        setBounds(450,300,600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
}
        public static void main(String args[])
        {
            new login();
        }

    private void add(ImageIcon i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
