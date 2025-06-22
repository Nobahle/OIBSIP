
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 *
 * @author nobah
 */

public class ReservationForm extends JFrame implements ActionListener {

    private JTextField txtName, txtTrainNum, txtTrainName, txtDate, txtFrom, txtTo;
    private JComboBox<String> cmbClass;
    private JButton btnBook, btnView, btnCancel;
    private HashMap<String, String> trainMap;

    public ReservationForm() {
        setTitle("Train Reservation Form");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(11, 2));

        trainMap = new HashMap<>();
        trainMap.put("1001", "Shatabdi Express");
        trainMap.put("1002", "Rajdhani Express");
        trainMap.put("1003", "Duronto Express");

        txtName = new JTextField();
        txtTrainNum = new JTextField();
        txtTrainName = new JTextField();
        txtTrainName.setEditable(false);
        cmbClass = new JComboBox<>(new String[]{"AC", "Sleeper", "General"});
        txtDate = new JTextField();
        txtFrom = new JTextField();
        txtTo = new JTextField();
        btnBook = new JButton("Book Now");
        btnView = new JButton("View All Bookings");
        btnCancel = new JButton("Cancel Booking");

        txtTrainNum.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String trainNum = txtTrainNum.getText();
                txtTrainName.setText(trainMap.getOrDefault(trainNum, "Not Found"));
            }
        });

        add(new JLabel("Passenger Name:")); add(txtName);
        add(new JLabel("Train Number:")); add(txtTrainNum);
        add(new JLabel("Train Name:")); add(txtTrainName);
        add(new JLabel("Class Type:")); add(cmbClass);
        add(new JLabel("Date:")); add(txtDate);
        add(new JLabel("From:")); add(txtFrom);
        add(new JLabel("To:")); add(txtTo);
        add(btnBook); add(btnView);
        add(btnCancel); add(new JLabel(""));

        btnBook.addActionListener(this);
        btnView.addActionListener(e -> new ViewBooking());
        btnCancel.addActionListener(e -> new CancelBooking());

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtName.getText();
        String number = txtTrainNum.getText();
        String train = txtTrainName.getText();
        String type = (String) cmbClass.getSelectedItem();
        String date = txtDate.getText();
        String from = txtFrom.getText();
        String to = txtTo.getText();

        if (name.isEmpty() || number.isEmpty() || train.equals("Not Found") || date.isEmpty() || from.isEmpty() || to.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly.");
            return;
        }

        BookingDB.insertBooking(name, number, train, type, date, from, to);
        JOptionPane.showMessageDialog(this, "Booking successful!");
        clearForm();
    }

    private void clearForm() {
        txtName.setText("");
        txtTrainNum.setText("");
        txtTrainName.setText("");
        txtDate.setText("");
        txtFrom.setText("");
        txtTo.setText("");
        cmbClass.setSelectedIndex(0);
    }
}

