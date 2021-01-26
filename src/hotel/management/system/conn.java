package hotel.management.system;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    public conn() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true", "root", "rohan@123");
            //Peoples?autoReconnect=true&amp;useSSL=false&amp;allowPublicKeyRetrieval=true
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
