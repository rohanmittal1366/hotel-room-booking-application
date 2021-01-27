/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class dashboard extends JFrame implements ActionListener{

    JMenuBar jmb;
    JMenu jm1, jm2;
    JMenuItem jmi1, jmi2, jmi3, jmi4;

    dashboard() {

        jmb = new JMenuBar();
        add(jmb);

        jm1 = new JMenu("HOTEL MANAGEMENT");
        jm1.setForeground(Color.RED);
        jmb.add(jm1);

        jm2 = new JMenu("ADMIN");
        jm2.setForeground(Color.RED);
        jmb.add(jm2);

        jmi1 = new JMenuItem("RECEPTION");
        jmi1.addActionListener(this);
        jm1.add(jmi1);

        jmi2 = new JMenuItem("ADD EMPLOYEE");
        jmi2.addActionListener(this);
        jm2.add(jmi2);

        jmi3 = new JMenuItem("ADD ROOMS");
        jmi3.addActionListener(this);
        jm2.add(jmi3);

        jmi4 = new JMenuItem("ADD DRIVERS");
        jmi4.addActionListener(this);
        jm2.add(jmi4);

        jmb.setBounds(0, 0, 1950, 30);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));//C:\\Users\\asus\\Documents\\NetBeansProjects\\Hotel Management System\\src\\
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl3 = new JLabel(i3);
        jl3.setBounds(0, 0, 1950, 1000);
        add(jl3);
        
        
        JLabel jl2 = new JLabel("The Taj group welcome you");
        jl2.setBounds(500,80,1000,50);
        jl2.setForeground(Color.white);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 46) );
        jl3.add(jl2);
        
        
        
        setLayout(null);
        setBounds(0, 0, 1950, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new dashboard().setVisible(true);

    }

    private void add(ImageIcon i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void actionPerformed(ActionEvent a){
        
        if(a.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new addemployee().setVisible(true);
        }
        else if(a.getActionCommand().equals("ADD ROOMS"))
        {
            new addroooms().setVisible(true);
        }
        else if(a.getActionCommand().equals("ADD DRIVERS"))
        {
            new adddriver().setVisible(true);
        }
        
    }
}
