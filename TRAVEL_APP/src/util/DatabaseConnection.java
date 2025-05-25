package util;

import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/travel_app";
       // String user = "root";
        String password = "Jazmyn@2006"; // Replace with your MySQL password
        String email = "me.jazmynsaini2006@gmail.com";
        return DriverManager.getConnection(url, email, password);
        
    }

   
}
