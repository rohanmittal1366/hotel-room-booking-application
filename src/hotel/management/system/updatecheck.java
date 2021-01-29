package hotel.management.system;

import java.awt.Choice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import net.proteanit.sql.DbUtils;

public class updatecheck extends JFrame implements ActionListener {

    JTextField j1, j2, j3, j4, j5, j6;
    JButton b1, b2, b3;
    Choice c2;

    updatecheck() {

        JLabel jl2 = new JLabel("Check in Details");
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

        JLabel jl5 = new JLabel("Name");
        jl5.setBounds(30, 160, 150, 20);
        jl5.setForeground(Color.black);
        jl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl5);

        j3 = new JTextField();
        j3.setBounds(200, 160, 150, 30);
        add(j3);

        JLabel jl6 = new JLabel("Check in");
        jl6.setBounds(30, 200, 150, 20);
        jl6.setForeground(Color.black);
        jl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl6);

        j4 = new JTextField();
        j4.setBounds(200, 200, 150, 30);
        add(j4);

        JLabel jl1 = new JLabel("Amount Paid");
        jl1.setBounds(30, 240, 150, 20);
        jl1.setForeground(Color.black);
        jl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl1);

        j5 = new JTextField();
        j5.setBounds(200, 240, 150, 30);
        add(j5);

        JLabel jl7 = new JLabel("Pending Amount");
        jl7.setBounds(30, 280, 150, 20);
        jl7.setForeground(Color.black);
        jl7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl7);

        j6 = new JTextField();
        j6.setBounds(200, 280, 150, 30);
        add(j6);

        b1 = new JButton("Check");
        b1.setBounds(120, 350, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBounds(60, 390, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBounds(190, 390, 120, 30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl13 = new JLabel(i3);
        jl13.setBounds(370, 60, 500, 250);
        add(jl13);

        getContentPane().setBackground(Color.white);
        setBounds(330, 220, 900, 480);
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new updatecheck().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {

            String s1 = c2.getSelectedItem();
            String str = "select * from customer where number = '" + s1 + "'";

            conn c = new conn();
            String room = null;
            String deposit = null;
             int amt_paid = 0;
            String price = null;
            try {
                ResultSet rs = c.s.executeQuery(str);

                while (rs.next()) {
                    j2.setText(rs.getString("room"));
                    j3.setText(rs.getString("name"));
                    j4.setText(rs.getString("status"));
                    j5.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }
                
                ResultSet rs1 = c.s.executeQuery("select * from room where rnum = '"+room+"'");
                while(rs1.next())
                {
                    price = rs1.getString("price");
                    amt_paid = Integer.parseInt(price)- Integer.parseInt(deposit);
                    j6.setText(Integer.toString(amt_paid));
                    
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (a.getSource() == b2) {

            try {

                String room = j1.getText();
                String available = j3.getText();
                String status = j2.getText();
                conn c = new conn();

                String str = "update room set avaliable = '" + available + "', status = '" + status + "' where rnum='" + room + "'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room is updated");
                new reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (a.getSource() == b3) {
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
