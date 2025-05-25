package dao;

import java.sql.*;
import model.User;
import util.DatabaseConnection;

public class UserDAO {

    // Method 1: Login with User object
    public boolean login(User user) {
        return login(user.getEmail(), user.getPassword());
    }

    // Method 2: Login with email and password directly
    public static boolean login(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

