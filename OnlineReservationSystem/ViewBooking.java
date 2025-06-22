import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author nobah
 */

public class ViewBooking extends JFrame {

    public ViewBooking() {
        setTitle("All Bookings");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = {
            "ID", "Passenger Name", "Train Number", "Train Name",
            "Class", "Date", "From", "To"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        try (ResultSet rs = BookingDB.getAllBookings()) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("passengerName"),
                    rs.getString("trainNumber"),
                    rs.getString("trainName"),
                    rs.getString("classType"),
                    rs.getString("date"),
                    rs.getString("fromPlace"),
                    rs.getString("toPlace")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading bookings: " + e.getMessage());
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}

