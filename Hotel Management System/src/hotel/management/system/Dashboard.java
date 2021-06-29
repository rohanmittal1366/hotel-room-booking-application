
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        mb = new JMenuBar();
        add(mb);
        
        m1 = new JMenu("Hotel Management");
        m1.setForeground(Color.red);
        mb.add(m1);
        
        m2 = new JMenu("Admin");
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        
        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("Add Drivers");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(0,0,1380, 30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1380, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0, 1380, 800);
        add(l1);
        
        JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
        l2.setBounds(400, 50, 1000, 50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 40)); 
        l1.add(l2);
        
        setLayout(null);
        setBounds(0, 0, 1380, 800);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDriver().setVisible(true);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
