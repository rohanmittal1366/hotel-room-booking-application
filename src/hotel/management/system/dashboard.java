/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Color;
import javax.swing.*;

public class dashboard extends JFrame {

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
        jm1.add(jmi1);

        jmi2 = new JMenuItem("ADD EMPLOYEE");
        jm2.add(jmi2);

        jmi3 = new JMenuItem("ADD ROOMS");
        jm2.add(jmi3);

        jmi4 = new JMenuItem("ADD DRIVERS");
        jm2.add(jmi4);

        jmb.setBounds(0, 0, 1950, 30);

        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        JLabel jl = new JLabel(i1);
        jl.setBounds(0, 0, 1950, 1000);
        add(jl);*/

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
}
