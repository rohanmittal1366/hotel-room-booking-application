package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {

        setBounds(100, 100, 1300, 665);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/download.jpg"));
        JLabel jl = new JLabel(i1);
        jl.setBounds(0, 0, 1300, 665);
        add(jl);

        JLabel jl2 = new JLabel("Hotel Management System");
        jl2.setBounds(300, 10, 1000, 70);
        jl2.setForeground(Color.GREEN);
        jl2.setFont(new Font("serif", Font.PLAIN, 70));
        jl.add(jl2);

        JButton jb1 = new JButton("Next");
        jb1.setBackground(Color.white);
        jb1.setForeground(Color.black);
        jb1.setBounds(1100, 560, 120, 30);
        jl.add(jb1);

        jb1.addActionListener(this);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        while (true) {
            jl2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            jl2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        new login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {

        new HotelManagementSystem();
    }

}
