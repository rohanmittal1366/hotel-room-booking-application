package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class addcustomer extends JFrame implements ActionListener {

    JTextField j1, j2, j3, j4, j5;
    JComboBox c1;
    JButton b1, b2;
    Choice c2;
    JRadioButton r1, r2;
    ButtonGroup bg;

    addcustomer() {
        JLabel jl2 = new JLabel("New Customer Form");
        jl2.setBounds(100, 20, 200, 30);
        jl2.setForeground(Color.blue);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl2);

        JLabel l3 = new JLabel("ID");
        l3.setBounds(35, 80, 100, 20);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(l3);

        c1 = new JComboBox(new String[]{"Passport", "Voter id card", "Driving Licence", "Adhaar card"});
        c1.setBackground(Color.white);
        c1.setBounds(220, 80, 150, 30);
        add(c1);

        JLabel l4 = new JLabel("NUMBER");
        l4.setBounds(35, 120, 100, 20);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(l4);

        j1 = new JTextField();
        j1.setBounds(220, 120, 150, 30);
        add(j1);

        JLabel l5 = new JLabel("NAME");
        l5.setBounds(35, 160, 100, 20);
        l5.setForeground(Color.black);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(l5);

        j2 = new JTextField();
        j2.setBounds(220, 160, 150, 30);
        add(j2);

        JLabel l6 = new JLabel("GENDER");
        l6.setBounds(35, 200, 100, 20);
        l6.setForeground(Color.black);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(l6);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setBackground(Color.white);
        r1.setBounds(220, 200, 70, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setBackground(Color.white);
        r2.setBounds(300, 200, 70, 30);
        add(r2);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel l7 = new JLabel("COUNTRY");
        l7.setBounds(35, 240, 100, 20);
        l7.setForeground(Color.black);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(l7);

        j3 = new JTextField();
        j3.setBounds(220, 240, 150, 30);
        add(j3);

        JLabel l8 = new JLabel("ALLOCATED ROOM NO");
        l8.setBounds(35, 280, 150, 20);
        l8.setForeground(Color.black);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(l8);

        c2 = new Choice();
        try {
            conn c = new conn();
            String str = "select * from room where avaliable='available'";
            ResultSet rs = c.s.executeQuery(str);

            while (rs.next()) {
                c2.add(rs.getString("rnum"));
            }
            //t1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }

        c2.setBounds(220, 280, 188, 50);
        add(c2);

        JLabel l9 = new JLabel("CHECKED IN");
        l9.setBounds(35, 320, 100, 20);
        l9.setForeground(Color.black);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(l9);

        j4 = new JTextField();
        j4.setBounds(220, 320, 150, 30);
        add(j4);

        JLabel jl9 = new JLabel("DEPOSIT");
        jl9.setBounds(35, 360, 100, 20);
        jl9.setForeground(Color.black);
        jl9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl9);

        j5 = new JTextField();
        j5.setBounds(220, 360, 150, 30);
        add(j5);

        b1 = new JButton("Add Customer");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(35, 420, 130, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(200, 420, 130, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl3 = new JLabel(i3);
        jl3.setBounds(450, 40, 500, 350);
        add(jl3);

        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 1000, 550);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new addcustomer().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {

            String id = (String) c1.getSelectedItem();
            String number = j1.getText();
            String name = j2.getText();
            String gender = null;

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String country = j3.getText();
            String room = (String) c2.getSelectedItem();
            String status = j4.getText();
            String deposit = j5.getText();
            String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + status + "','" + deposit + "')";
            String str1 = "update room set avaliable = 'Occupied' where rnum ='" + room + "'";
            try {
                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (a.getSource() == b2) {
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }

}
