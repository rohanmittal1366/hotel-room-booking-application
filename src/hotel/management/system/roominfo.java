package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class roominfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    roominfo() {

        t1 = new JTable();
        t1.setBounds(0, 40, 500, 350);
        add(t1);

        JLabel jl2 = new JLabel("Room no");
        jl2.setBounds(20, 10, 70, 20);
        jl2.setForeground(Color.black);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl2);

        JLabel jl3 = new JLabel("Availability");
        jl3.setBounds(110, 10, 70, 20);
        jl3.setForeground(Color.black);
        jl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl3);

        JLabel jl4 = new JLabel("status");
        jl4.setBounds(230, 10, 70, 20);
        jl4.setForeground(Color.black);
        jl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl4);

        JLabel jl5 = new JLabel("Price");
        jl5.setBounds(330, 10, 100, 20);
        jl5.setForeground(Color.black);
        jl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl5);

        JLabel jl6 = new JLabel("Bed Type");
        jl6.setBounds(410, 10, 100, 20);
        jl6.setForeground(Color.black);
        jl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl6);

        b1 = new JButton("Load Data");
        b1.setBounds(100, 440, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250, 440, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j3 = new JLabel(i3);
        j3.setBounds(520, 50, 500, 400);
        add(j3);

        getContentPane().setBackground(Color.white);
        setBounds(250, 150, 1050, 550);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new roominfo().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {
            try {
                conn c = new conn();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (a.getSource() == b2) {
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
}
