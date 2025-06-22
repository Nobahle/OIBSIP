import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author nobah
 */

public class CancelBooking extends JFrame {

    private JTextField txtBookingId;
    private JButton btnCancel;

    public CancelBooking() {
        setTitle("Cancel Booking");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Enter Booking ID to cancel:", SwingConstants.CENTER));
        txtBookingId = new JTextField();
        add(txtBookingId);

        btnCancel = new JButton("Cancel Booking");
        add(btnCancel);

        btnCancel.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtBookingId.getText());
                BookingDB.deleteBookingById(id);
                JOptionPane.showMessageDialog(this, "Booking cancelled successfully.");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric Booking ID.");
            }
        });

        setVisible(true);
    }
}



