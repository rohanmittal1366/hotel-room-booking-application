


package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class reception extends JFrame implements ActionListener{
    
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    
    reception(){
        
        b1 = new JButton("New Coustomer Form");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(10, 30, 200, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Room");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(10, 70, 200, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Department");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(10, 110, 200, 30);
        b3.addActionListener(this);
        add(b3);
      
        
        b4 = new JButton("A.I. Employee");
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setBounds(10, 150, 200, 30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Coustomer Info");
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.setBounds(10, 190, 200, 30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Manager Info");
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setBounds(10, 230, 200, 30);
        b6.addActionListener(this);
        add(b6);
        
        b7 = new JButton("Checkout");
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.setBounds(10, 270, 200, 30);
        b7.addActionListener(this);
        add(b7);
        
        b8 = new JButton("Update Check Status");
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.setBounds(10, 310, 200, 30);
        b8.addActionListener(this);
        add(b8);
        
        b9 = new JButton("Update Room Status");
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.setBounds(10, 350, 200, 30);
        b9.addActionListener(this);
        add(b9);
        
        b10 = new JButton("Pickup Service");
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.setBounds(10, 390, 200, 30);
        b10.addActionListener(this);
        add(b10);
        
        b11 = new JButton("Search Room");
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.setBounds(10, 430, 200, 30);
        b11.addActionListener(this);
        add(b11);
        
        b12 = new JButton("Logout");
        b12.setBackground(Color.black);
        b12.setForeground(Color.white);
        b12.setBounds(10, 470, 200, 30);
        b12.addActionListener(this);
        add(b12);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/Fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl3 = new JLabel(i3);
        jl3.setBounds(250, 30, 500, 470);
        add(jl3);
        
        getContentPane().setBackground(Color.white);
        setBounds(370, 180, 800, 580);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String args[])
    {
       new reception().setVisible(true);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == b1)
        {
            
        } else if(a.getSource() == b2)
        {
            
        }else if(a.getSource() == b3)
        {
            
        }else if(a.getSource() == b4)
        {
           new employeeinfo().setVisible(true);
           this.setVisible(false);
           
        }else if(a.getSource() == b5)
        {
            
        }else if(a.getSource() == b6)
        {
            new managerinfo().setVisible(true);
           this.setVisible(false);
        }else if(a.getSource() == b7)
        {
            
        }else if(a.getSource() == b8)
        {
            
        }else if(a.getSource() == b9)
        {
            
        }else if(a.getSource() == b10)
        {
            
        }else if(a.getSource() == b11)
        {
            
        }else if(a.getSource() == b12)
        {
            
        }
    }
}
