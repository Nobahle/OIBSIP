import java.sql.*;

public class BookingDB {

    // Derby DB URL (embedded or client based on setup)
    private static final String DB_URL = "jdbc:derby://localhost:1527/reservationDB";
    private static final String USERNAME = "administrator";
    private static final String PASSWORD = "password";

    public static void insertBooking(String name, String number, String train, String type,
                                     String date, String from, String to) {
        String sql = "INSERT INTO Booking (passengerName, trainNumber, trainName, classType, date, from, to) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.setString(3, train);
            pstmt.setString(4, type);
            pstmt.setString(5, date);
            pstmt.setString(6, from);
            pstmt.setString(7, to);

            pstmt.executeUpdate();
            System.out.println("Booking saved");

        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    public static ResultSet getAllBookings() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("SELECT * FROM Booking");
        } catch (SQLException e) {
            System.out.println("Query Error: " + e.getMessage());
            return null;
        }
    }

    public static ResultSet findBooking(String input) {
        String sql = input.matches("\\d+") ?
                "SELECT * FROM Booking WHERE id = ?" :
                "SELECT * FROM Booking WHERE passengerName = ?";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Search Error: " + e.getMessage());
            return null;
        }
    }

    public static void deleteBookingById(int id) {
        String sql = "DELETE FROM Booking WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Booking cancelled");

        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}

