package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class adddriver extends JFrame implements ActionListener {

    JTextField jtf1, jtf3, jtf4;
    JFormattedTextField jtf2;
    JRadioButton r1, r2;
    JComboBox cb, c1, cb1;
    JButton b1, b2;
    ButtonGroup bg;

    adddriver() {

        JLabel title = new JLabel("ADD DRIVER");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(630, 20, 150, 30);
        add(title);

        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 30, 120, 30);
        add(name);

        jtf1 = new JTextField();
        jtf1.setBounds(200, 30, 150, 30);
        add(jtf1);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        age.setBounds(60, 80, 120, 30);
        add(age);

        MaskFormatter formatter1 = null;
        try {
            formatter1 = new MaskFormatter("##");
        } catch (ParseException ex) {
            Logger.getLogger(addemployee.class.getName()).log(Level.SEVERE, null, ex);
        }

        jtf2 = new JFormattedTextField(formatter1);
        jtf2.setBounds(200, 80, 150, 30);
        add(jtf2);

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender.setBounds(60, 130, 120, 30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setBackground(Color.white);
        r1.setBounds(200, 130, 70, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setBackground(Color.white);
        r2.setBounds(280, 130, 70, 30);
        add(r2);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel car = new JLabel("CAR COMPANY");
        car.setFont(new Font("Tahoma", Font.PLAIN, 17));
        car.setBounds(60, 180, 120, 30);
        add(car);

        jtf3 = new JTextField();
        jtf3.setBounds(200, 180, 150, 30);
        add(jtf3);

        JLabel car1 = new JLabel("CAR MODEL");
        car1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        car1.setBounds(60, 230, 120, 30);
        add(car1);

        jtf4 = new JTextField();
        jtf4.setBounds(200, 230, 150, 30);
        add(jtf4);

        JLabel aval = new JLabel("AVAILABLE");
        aval.setFont(new Font("Tahoma", Font.PLAIN, 16));
        aval.setBounds(60, 280, 120, 30);
        add(aval);

        c1 = new JComboBox(new String[]{"Available", "Busy"});
        c1.setBackground(Color.white);
        c1.setBounds(200, 280, 150, 30);
        add(c1);

        JLabel loc = new JLabel("LOCATION");
        loc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loc.setBounds(60, 330, 120, 30);
        add(loc);

        jtf3 = new JTextField();
        jtf3.setBounds(200, 330, 150, 30);
        add(jtf3);

        b1 = new JButton("Add Driver");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60, 400, 135, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220, 400, 135, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl3 = new JLabel(i3);
        jl3.setBounds(450, 90, 500, 350);
        add(jl3);

        getContentPane().setBackground(Color.white);
        setBounds(300, 200, 1000, 550);
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String args[]) {
        new adddriver().setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == b1) {
            String name = jtf1.getText();
            String age = jtf2.getText();
            String gender = null;

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String carcom = jtf3.getText();
            String carmodel = jtf4.getText();
            String aval = (String) c1.getSelectedItem();
            String location = jtf2.getText();

            conn c = new conn();
            try {

                String str = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + carcom + "','" + carmodel + "','" + aval + "','" + location + "')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Driver Added");
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (a.getSource() == b2) {
            this.setVisible(false);
        }
    }

}
