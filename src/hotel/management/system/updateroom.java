package hotel.management.system;

import java.awt.Choice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class updateroom extends JFrame implements ActionListener {

    JTextField j1, j2, j3, j4, j5;
    JButton b1, b2, b3;
    Choice c2;

    updateroom() {
        JLabel jl2 = new JLabel("Update Room Status");
        jl2.setBounds(20, 10, 250, 30);
        jl2.setForeground(Color.blue);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(jl2);

        JLabel jl3 = new JLabel("Guest ID");
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

        JLabel jl4 = new JLabel("Room No");
        jl4.setBounds(30, 120, 150, 20);
        jl4.setForeground(Color.black);
        jl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl4);

        j1 = new JTextField();
        j1.setBounds(200, 120, 150, 30);
        add(j1);

        JLabel jl5 = new JLabel("Availablility");
        jl5.setBounds(30, 160, 150, 20);
        jl5.setForeground(Color.black);
        jl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl5);

        j3 = new JTextField();
        j3.setBounds(200, 160, 150, 30);
        add(j3);

        JLabel jl6 = new JLabel("Clean Status");
        jl6.setBounds(30, 200, 150, 20);
        jl6.setForeground(Color.black);
        jl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl6);

        j2 = new JTextField();
        j2.setBounds(200, 200, 150, 30);
        add(j2);

        b1 = new JButton("Check");
        b1.setBounds(120, 270, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBounds(60, 310, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBounds(190, 310, 120, 30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(410, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl13 = new JLabel(i3);
        jl13.setBounds(370, 20, 410, 320);
        add(jl13);

        getContentPane().setBackground(Color.white);
        setBounds(350, 250, 800, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new updateroom().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {

            String room = null;
            String s1 = c2.getSelectedItem();
            conn c = new conn();

            try {
                ResultSet rs = c.s.executeQuery("select * from customer where number='" + s1 + "'");

                while (rs.next()) {
                    j1.setText(rs.getString("room"));
                    room = rs.getString("room");
                }
                ResultSet rs1 = c.s.executeQuery("select * from room where rnum='" + room + "'");
                while (rs1.next()) {
                    j3.setText(rs1.getString("avaliable"));
                    j2.setText(rs1.getString("status"));
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
