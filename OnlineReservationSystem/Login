import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nobah
 */
public class Login extends JFrame implements ActionListener {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    private static final String VALID_USERNAME = "administrator";
    private static final String VALID_PASSWORD = "password";

    public Login() {
        setTitle("Login to Reservation System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JLabel lblWelcome = new JLabel("Please login", SwingConstants.CENTER);
        add(lblWelcome);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Username:"));
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
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
            new ReservationForm();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Try again.");
        }
    }
}

