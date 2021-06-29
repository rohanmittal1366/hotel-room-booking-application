
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1, b2;
    
    AddDriver(){
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("ADD DRIVERS");
        title.setBounds(150, 10, 150, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(title);
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(60, 70, 100, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200, 70, 150, 30);
        add(t1);
        
        JLabel age = new JLabel("Age");
        age.setBounds(60, 110, 100, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200, 110, 150, 30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(60, 150, 100, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(200, 150, 70, 30);
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setBounds(280, 150, 70, 30);
        r2.setBackground(Color.white);
        add(r2);
        
        JLabel car = new JLabel("Car");
        car.setBounds(60, 190, 100, 30);
        car.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(car);
        
        t3 = new JTextField();
        t3.setBounds(200, 190, 150, 30);
        add(t3);
        
        JLabel model = new JLabel("Model");
        model.setBounds(60, 230, 100, 30);
        model.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(model);
        
        t4 = new JTextField();
        t4.setBounds(200, 230, 150, 30);
        add(t4);
        
        JLabel available = new JLabel("Available");
        available.setBounds(60, 270, 100, 30);
        available.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(available);
        
        c1 = new JComboBox(new String[] {"Available", "Busy"});
        c1.setBounds(200, 270, 150, 30);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel location = new JLabel("Location");
        location.setBounds(60, 310, 100, 30);
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(location);
        
        t5 = new JTextField();
        t5.setBounds(200, 310, 150, 30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60, 370, 130, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(210, 370, 130, 30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400, 80, 500, 300);
        add(l1);
        
        
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setBounds(230, 150, 970, 470);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddDriver();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==b1){
            
            String name = t1.getText();
            String age = t2.getText();
            String gender = null;
            
            if(r1.isSelected()){
                gender = "Male";
            }else if(r2.isSelected()){
                gender = "Female";
            }
            
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String) c1.getSelectedItem();
            String location = t5.getText();
            
            conn c = new conn();
            
            if (name == null) {
                JOptionPane.showMessageDialog(null, "Detail is Required ");
            } else if (age == null) {
                JOptionPane.showMessageDialog(null, "Name is Required ");
            } else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Enter all Values");
            } else if (company == null) {
                JOptionPane.showMessageDialog(null, "Country is Required ");
            } else if (brand == null) {
                JOptionPane.showMessageDialog(null, "Room Number is Required ");
            } else if (available == null) {
                JOptionPane.showMessageDialog(null, "Status is Required ");
            } else if (location == null) {
                JOptionPane.showMessageDialog(null, "Amount is Required ");
            } else {
            
            String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
            
            try{
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                
                
            }catch(Exception e){
                System.out.println(e);
            }
            }
            
            
        }else if(ae.getSource()==b2){
            setVisible(false);
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
