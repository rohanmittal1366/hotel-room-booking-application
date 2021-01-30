

package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;



public class searchroom extends JFrame implements ActionListener{
    
     JTable t1;
    JButton b1, b2;
    JComboBox c1;
    JCheckBox cb;
    searchroom()
    {
        t1 = new JTable();
        t1.setBounds(0, 180, 1000, 320);
        add(t1);

        JLabel jl2 = new JLabel("Search For Room");
        jl2.setBounds(400, 10, 200, 30);
        jl2.setForeground(Color.blue);
        jl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jl2);

        
        JLabel jl3 = new JLabel("Room Bed Type");
        jl3.setBounds(50,70, 120, 20);
        jl3.setForeground(Color.black);
        jl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl3);
        
        c1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c1.setBackground(Color.white);
        c1.setBounds(200, 70, 150, 25);
        add(c1);
        

        cb = new JCheckBox("Only Display Available");
        cb.setBackground(Color.GREEN);
        cb.setBounds(650,70,150,20);
        add(cb);
        
        JLabel jl1 = new JLabel("Room Number");
        jl1.setBounds(50, 150, 100, 20);
        jl1.setForeground(Color.black);
        jl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl1);
        
        JLabel jl4 = new JLabel("Availablility");
        jl4.setBounds(250, 150, 100, 20);
        jl4.setForeground(Color.black);
        jl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl4);

        JLabel jl5 = new JLabel("Cleaning Status");
        jl5.setBounds(450, 150, 100, 20);
        jl5.setForeground(Color.black);
        jl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl5);

        JLabel jl6 = new JLabel("Price");
        jl6.setBounds(680, 150, 100, 20);
        jl6.setForeground(Color.black);
        jl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl6);
        
        JLabel jl7 = new JLabel("Bed Type");
        jl7.setBounds(850, 150, 100, 20);
        jl7.setForeground(Color.black);
        jl7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(jl7);
        
        b1 = new JButton("Submit");
        b1.setBounds(320, 520, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(520, 520, 120, 30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        
        getContentPane().setBackground(Color.white);
        setBounds(250, 150, 1000, 620);
        setLayout(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
     public static void main(String args[]) {
        new searchroom().setVisible(true);
    }
     
     public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {
            try {
                conn c = new conn();
                String str = "select * from room where bed_type= '"+c1.getSelectedItem()+"'";
                String str1 = "select * from room where avaliable = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                
                

                if(cb.isSelected())
                {
                    ResultSet rs1 = c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs1));
                }
                else
                {
                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (a.getSource() == b2) {
            new reception().setVisible(true);
            this.setVisible(false);
        }
    }
     
}
