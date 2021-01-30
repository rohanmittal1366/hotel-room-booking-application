package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class customerinfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;

    customerinfo() {

        t1 = new JTable();
        t1.setBounds(0, 40, 980, 500);
        add(t1);

        JLabel jl2 = new JLabel("Document Type");
        jl2.setBounds(10, 10, 100, 20);
        jl2.setForeground(Color.black);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl2);

        JLabel jl3 = new JLabel("Number");
        jl3.setBounds(150, 10, 70, 20);
        jl3.setForeground(Color.black);
        jl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl3);

        JLabel jl4 = new JLabel("Name");
        jl4.setBounds(275, 10, 70, 20);
        jl4.setForeground(Color.black);
        jl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl4);

        JLabel jl5 = new JLabel("Gender");
        jl5.setBounds(400, 10, 100, 20);
        jl5.setForeground(Color.black);
        jl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl5);

        JLabel jl6 = new JLabel("Country");
        jl6.setBounds(525, 10, 100, 20);
        jl6.setForeground(Color.black);
        jl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl6);

        JLabel jl7 = new JLabel("Room No.");
        jl7.setBounds(640, 10, 100, 20);
        jl7.setForeground(Color.black);
        jl7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl7);

        JLabel jl8 = new JLabel("Checked in");
        jl8.setBounds(760, 10, 100, 20);
        jl8.setForeground(Color.black);
        jl8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl8);

        JLabel jl9 = new JLabel("Deposit");
        jl9.setBounds(890, 10, 100, 20);
        jl9.setForeground(Color.black);
        jl9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl9);

        b1 = new JButton("Load Data");
        b1.setBounds(350, 560, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(530, 560, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);
        setBounds(250, 150, 1000, 650);
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new customerinfo().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {
            try {
                conn c = new conn();
                String str = "select * from customer";
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
