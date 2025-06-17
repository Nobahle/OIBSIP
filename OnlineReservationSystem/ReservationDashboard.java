/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinereservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 *
 * @author nobah
 */

public class ReservationDashboard extends JFrame implements ActionListener {

    private JTextField txtPassengerName, txtTrainNumber, txtTrainName, txtDate, txtFrom, txtTo;
    private JComboBox<String> cmbClassType;
    private JButton btnBook;

    // Fake train database (train number -> train name)
    private HashMap<String, String> trainData;

    public ReservationDashboard() {
        setTitle("Book Your Train Ticket");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 5, 5));

        initTrainData();

        add(new JLabel("Passenger Name:"));
        txtPassengerName = new JTextField();
        add(txtPassengerName);

        add(new JLabel("Train Number:"));
        txtTrainNumber = new JTextField();
        txtTrainNumber.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String num = txtTrainNumber.getText().trim();
                if (trainData.containsKey(num)) {
                    txtTrainName.setText(trainData.get(num));
                } else {
                    txtTrainName.setText("Invalid Train #");
                }
            }
        });
        add(txtTrainNumber);

        add(new JLabel("Train Name:"));
        txtTrainName = new JTextField();
        txtTrainName.setEditable(false); // Auto-filled
        add(txtTrainName);

        add(new JLabel("Class Type:"));
        String[] classOptions = {"AC", "Sleeper", "General"};
        cmbClassType = new JComboBox<>(classOptions);
        add(cmbClassType);

        add(new JLabel("Date of Journey (YYYY-MM-DD):"));
        txtDate = new JTextField();
        add(txtDate);

        add(new JLabel("From:"));
        txtFrom = new JTextField();
        add(txtFrom);

        add(new JLabel("To:"));
        txtTo = new JTextField();
        add(txtTo);

        btnBook = new JButton("Insert Booking ✅");
        btnBook.addActionListener(this);
        add(btnBook);

        // Empty cell for spacing
        add(new JLabel(""));

        setVisible(true);
    }

    private void initTrainData() {
        trainData = new HashMap<>();
        trainData.put("101", "Shatabdi Express");
        trainData.put("202", "Rajdhani Express");
        trainData.put("303", "Duronto Express");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtPassengerName.getText();
        String trainNum = txtTrainNumber.getText();
        String trainName = txtTrainName.getText();
        String classType = (String) cmbClassType.getSelectedItem();
        String date = txtDate.getText();
        String from = txtFrom.getText();
        String to = txtTo.getText();

        if (name.isEmpty() || trainNum.isEmpty() || trainName.equals("Invalid Train #")
                || date.isEmpty() || from.isEmpty() || to.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❗ Please fill in all fields correctly.");
        } else {
            // Here you can insert into DB or ArrayList
            JOptionPane.showMessageDialog(this, "Booking Confirmed!\n" +
                    "Passenger: " + name + "\nTrain: " + trainName + "\nDate: " + date);
        }
    }
}

