package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class checkout extends JFrame implements ActionListener {

    JTextField j2;
    JButton b1, b2, b3;
    Choice c2;

    checkout() {
        JLabel jl2 = new JLabel("Check Out");
        jl2.setBounds(20, 10, 250, 30);
        jl2.setForeground(Color.blue);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(jl2);

        JLabel jl3 = new JLabel("Customer ID");
        jl3.setBounds(30, 80, 120, 20);
        jl3.setForeground(Color.black);
        jl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl3);

        c2 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                c2.add(rs.getString("number"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        c2.setBounds(200, 80, 188, 50);
        add(c2);

        JLabel jl4 = new JLabel("Room Number");
        jl4.setBounds(30, 120, 150, 20);
        jl4.setForeground(Color.black);
        jl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl4);

        j2 = new JTextField();
        j2.setBounds(200, 120, 150, 30);
        add(j2);

        b1 = new JButton("Checkout");
        b1.setBounds(40, 200, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(200, 200, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(360, 80, 20, 20);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(350, 220, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel jl15 = new JLabel(i6);
        jl15.setBounds(400, 20, 350, 220);
        add(jl15);

        getContentPane().setBackground(Color.white);
        setBounds(350, 250, 800, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new checkout().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {

            
            String id = c2.getSelectedItem();
            String room = j2.getText();
            String str = "delete from customer where number='"+id+"'";
            String str1 = "update room set avaliable = 'available' where rnum = '"+room+"'";
            conn c = new conn();
            try {

                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Check out done");
                new reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (a.getSource() == b3) {

            try {
                conn c = new conn();
                String id = c2.getSelectedItem();
                ResultSet rs = c.s.executeQuery("select * from customer where number = '" + id + "' ");
                while (rs.next()) {
                    j2.setText(rs.getString("room"));
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (a.getSource() == b2) {
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }

}
