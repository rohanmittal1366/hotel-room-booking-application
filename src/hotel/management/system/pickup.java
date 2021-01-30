package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class pickup extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;
    JComboBox c1;
    Choice jc1;
    JCheckBox cb;

    pickup() {
        t1 = new JTable();
        t1.setBounds(0, 190, 1000, 250);
        add(t1);

        JLabel j2 = new JLabel("Type of Car");
        j2.setBounds(50, 70, 120, 30);
        j2.setForeground(Color.black);
        j2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j2);

        jc1 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from driver";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                jc1.add(rs.getString("car_model"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        jc1.setBounds(200, 70, 200, 30);
        add(jc1);

        JLabel jl1 = new JLabel("Name");
        jl1.setBounds(40, 150, 100, 20);
        jl1.setForeground(Color.black);
        jl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl1);

        JLabel jl2 = new JLabel("Age");
        jl2.setBounds(200, 150, 100, 20);
        jl2.setForeground(Color.black);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl2);

        JLabel jl3 = new JLabel("Gender");
        jl3.setBounds(330, 150, 100, 20);
        jl3.setForeground(Color.black);
        jl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl3);

        JLabel jl4 = new JLabel("Company");
        jl4.setBounds(480, 150, 100, 20);
        jl4.setForeground(Color.black);
        jl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl4);

        JLabel jl5 = new JLabel("Brand");
        jl5.setBounds(620, 150, 100, 20);
        jl5.setForeground(Color.black);
        jl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl5);

        JLabel jl6 = new JLabel("Availablility");
        jl6.setBounds(750, 150, 100, 20);
        jl6.setForeground(Color.black);
        jl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl6);

        JLabel jl7 = new JLabel("Location");
        jl7.setBounds(900, 150, 100, 20);
        jl7.setForeground(Color.black);
        jl7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl7);

        b1 = new JButton("Submit");
        b1.setBounds(320, 460, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(520, 460, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);
        setBounds(250, 150, 1000, 550);
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new pickup().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {
            try {
                conn c = new conn();
                String str = "select * from driver where car_model= '" + jc1.getSelectedItem() + "'";
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
