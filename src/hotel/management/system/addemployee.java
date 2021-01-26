package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class addemployee extends JFrame implements ActionListener{

    JTextField jtf1, jtf3, jtf5, jtf6;
    JFormattedTextField jtf2, jtf4;
    JRadioButton r1, r2;
    JComboBox cb;
    JButton jb1;
    ButtonGroup bg;

    addemployee() {
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

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job.setBounds(60, 180, 120, 30);
        add(job);

        String str[] = {"Front Desk Clerks", "Porters", "HouseKeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        cb = new JComboBox(str);
        cb.setBackground(Color.white);
        cb.setBounds(200, 180, 150, 30);
        add(cb);

        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salary.setBounds(60, 230, 120, 30);
        add(salary);

        jtf3 = new JTextField();
        jtf3.setBounds(200, 230, 150, 30);
        add(jtf3);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone.setBounds(60, 280, 120, 30);
        add(phone);

        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##########");
        } catch (ParseException ex) {
            Logger.getLogger(addemployee.class.getName()).log(Level.SEVERE, null, ex);
        }

        jtf4 = new JFormattedTextField(formatter);
        jtf4.setBounds(200, 280, 150, 30);
        add(jtf4);

        JLabel adhar = new JLabel("ADHAAR CARD");
        adhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        adhar.setBounds(60, 330, 120, 30);
        add(adhar);

        jtf5 = new JTextField();
        jtf5.setBounds(200, 330, 150, 30);
        add(jtf5);

        JLabel email = new JLabel("EMAIL ID ");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 380, 120, 30);
        add(email);

        jtf6 = new JTextField();
        jtf6.setBounds(200, 380, 150, 30);
        add(jtf6);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl3 = new JLabel(i3);
        jl3.setBounds(380, 75, 450, 450);
        add(jl3);
        
        JLabel j2 = new JLabel("ADD EMPLOYEE DETAILS");
        j2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        j2.setForeground(Color.blue);
        j2.setBounds(420,30,400,30);
        add(j2);
        
        
        jb1 = new JButton("SUBMIT");
        jb1.setBackground(Color.black);
        jb1.setForeground(Color.white);
        jb1.setBounds(200,430,150,30);
        jb1.addActionListener(this);
        add(jb1);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(370, 200, 850, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent A)
    {
        String name =   jtf1.getText();
        String age =    jtf2.getText();
        String salary = jtf3.getText();
        String phone =  jtf4.getText();
        String adhar =  jtf5.getText();
        String email =  jtf6.getText();
        String gender = null;
        
        if(r1.isSelected())
            gender = "Male";
        else if(r2.isSelected())
            gender = "Female";
        
        String job = (String)cb.getSelectedItem();
      
    }
    
    
    public static void main(String args[]) {
        new addemployee().setVisible(true);
    }

}
