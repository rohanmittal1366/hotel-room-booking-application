package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class login extends JFrame implements ActionListener {

    JLabel jl1, jl2;
    JTextField jtf1;
    JPasswordField jpf1;
    JButton jb1, jb2;

    login() {

        jl1 = new JLabel("Username");
        jl1.setBounds(40, 20, 100, 30);
        add(jl1);

        jl2 = new JLabel("Password");
        jl2.setBounds(40, 70, 100, 30);
        add(jl2);

        jtf1 = new JTextField();
        jtf1.setBounds(150, 20, 150, 30);
        add(jtf1);

        jpf1 = new JPasswordField();
        jpf1.setBounds(150, 70, 150, 30);
        jpf1.setEchoChar('*');
        add(jpf1);

        jb1 = new JButton("Login");
        jb1.setBackground(Color.white);
        jb1.setForeground(Color.black);
        jb1.setBounds(40, 150, 120, 30);
        jb1.addActionListener(this);
        add(jb1);

        jb2 = new JButton("Cancel");
        jb2.setBackground(Color.white);
        jb2.setForeground(Color.black);
        jb2.setBounds(180, 150, 120, 30);
        jb2.addActionListener(this);
        add(jb2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login.png"));//C:\\Users\\asus\\Documents\\NetBeansProjects\\Hotel Management System\\src\\
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl3 = new JLabel(i3);
        jl3.setBounds(360, 2, 200, 200);
        add(jl3);
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(450, 300, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == jb1) {
            String username = jtf1.getText();
            String password = jpf1.getText();
            conn c = new conn();

            String str = "select * from login where username = '" + username + "' and password= '" + password + "'";
            try {
                ResultSet rs = c.s.executeQuery(str);

                if (rs.next()) {
                    new dashboard().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                    this.setVisible(false);

                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (a.getSource() == jb2) {
            System.exit(0);
        }

    }

    public static void main(String args[]) {
        new login();
    }
}
