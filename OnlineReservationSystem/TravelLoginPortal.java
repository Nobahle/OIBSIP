/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlinereservationsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nobah
 */

public class TravelLoginPortal extends JFrame implements ActionListener {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    // Hardcoded credentials (you can later connect this to a DB)
    private final String VALID_USERNAME = "oasis";
    private final String VALID_PASSWORD = "java123";

    public TravelLoginPortal() {
        setTitle("Train Booking Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JLabel lblTitle = new JLabel("Welcome to Online Booking", SwingConstants.CENTER);
        add(lblTitle);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("User ID:"));
        txtUsername = new JTextField();
        inputPanel.add(txtUsername);

        inputPanel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        inputPanel.add(txtPassword);
        add(inputPanel);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        add(btnLogin);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = txtUsername.getText();
        String pass = String.valueOf(txtPassword.getPassword());

        if (user.equals(VALID_USERNAME) && pass.equals(VALID_PASSWORD)) {
            JOptionPane.showMessageDialog(this, "Access Granted!");
            dispose(); // close login
            new ReservationDashboard(); // open next screen
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login. Try again.");
        }
    }

    public static void main(String[] args) {
        new TravelLoginPortal();
    }
}

