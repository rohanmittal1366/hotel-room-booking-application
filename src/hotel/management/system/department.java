package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import net.proteanit.sql.DbUtils;

public class department extends JFrame implements ActionListener {

    JTable t1;
    JButton b1, b2;
    JComboBox c1;
    Choice jc1;
    JCheckBox cb;

    department() {
        t1 = new JTable();
        t1.setBounds(0, 50, 600, 300);
        add(t1);

        JLabel j2 = new JLabel("Department");
        j2.setBounds(100, 10, 120, 30);
        j2.setForeground(Color.black);
        j2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(j2);

        JLabel jl1 = new JLabel("Budget");
        jl1.setBounds(370, 10, 120, 20);
        jl1.setForeground(Color.black);
        jl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl1);

        b1 = new JButton("Submit");
        b1.setBounds(120, 400, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(300, 400, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);
        setBounds(350, 250, 600, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new department().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {
            try {
                conn c = new conn();
                String str = "select * from department";
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
