package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class addroooms extends JFrame implements ActionListener {

    JTextField jtf1, jtf2, jtf3, jtf4;
    JComboBox c1, c2, c3;
    JButton b1, b2;

    addroooms() {

        JLabel l1 = new JLabel("ADD ROOMS");
        l1.setFont(new Font("Tahoma", Font.BOLD, 22));
        l1.setBounds(650, 10, 150, 20);
        add(l1);

        JLabel room = new JLabel("ROOM NO");
        room.setFont(new Font("Tahoma", Font.PLAIN, 16));
        room.setBounds(60, 80, 120, 30);
        add(room);

        jtf1 = new JTextField();
        jtf1.setBounds(250, 80, 150, 30);
        add(jtf1);

        JLabel aval = new JLabel("AVAILABLE");
        aval.setFont(new Font("Tahoma", Font.PLAIN, 16));
        aval.setBounds(60, 130, 120, 30);
        add(aval);

        c1 = new JComboBox(new String[]{"Available", "Occuppied"});
        c1.setBackground(Color.white);
        c1.setBounds(250, 130, 150, 30);
        add(c1);

        JLabel status = new JLabel("CLEANING STATUS");
        status.setFont(new Font("Tahoma", Font.PLAIN, 16));
        status.setBounds(60, 180, 150, 30);
        add(status);

        c2 = new JComboBox(new String[]{"Clean", "Dirty"});
        c2.setBackground(Color.white);
        c2.setBounds(250, 180, 150, 30);
        add(c2);

        JLabel price = new JLabel("PRICE");
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        price.setBounds(60, 230, 120, 30);
        add(price);

        jtf2 = new JTextField();
        jtf2.setBounds(250, 230, 150, 30);
        add(jtf2);

        JLabel type = new JLabel("BED TYPE");
        type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        type.setBounds(60, 280, 120, 30);
        add(type);

        c3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c3.setBackground(Color.white);
        c3.setBounds(250, 280, 150, 30);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60, 350, 150, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CANCEL");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(230, 350, 150, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl3 = new JLabel(i3);
        jl3.setBounds(450, 40, 500, 350);
        add(jl3);

        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 1000, 500);
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new addroooms().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == b1) {
            String room = jtf1.getText();
            String aval = (String) c1.getSelectedItem();
            String status = (String) c2.getSelectedItem();
            String price = jtf2.getText();
            String type = (String) c3.getSelectedItem();

            conn c = new conn();
            try {

                String str = "insert into room values('" + room + "','" + aval + "','" + status + "','" + price + "','" + type + "')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added");
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (a.getSource() == b2) {
            this.setVisible(false);
        }

    }
}
