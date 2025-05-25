package dao;

import model.Booking;
import util.DatabaseConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingDAO {

    public boolean bookPackage(Booking booking) {
        String sql = "INSERT INTO bookings (user_id, package_id, booking_date) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getPackageId());

            // Convert String to java.sql.Date if necessary
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(booking.getBookingDate()); // Ensure bookingDate is a String
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            stmt.setDate(3, sqlDate);

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Booking> getAllBookings() {
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("package_id"),
                        rs.getDate("booking_date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateUserCredentials(int userId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateUserCredentials'");
    }
}