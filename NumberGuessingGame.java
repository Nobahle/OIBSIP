package numberguessinggame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 *
 * @author nobah
 */
public class NumberGuessingGameGUI extends JFrame implements ActionListener {

    private int numberToGuess;
    private int attempts;
    private final int maxAttempts = 5;

    private JTextField txtGuess;
    private JLabel lblFeedback;
    private JLabel lblAttempts;
    private JLabel lblScore;
    private JButton btnGuess;
    private JButton btnPlayAgain;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        JLabel lblWelcome = new JLabel("Guess a number between 1 and 100", SwingConstants.CENTER);
        add(lblWelcome);

        txtGuess = new JTextField();
        add(txtGuess);

        btnGuess = new JButton("Submit Guess");
        btnGuess.addActionListener(this);
        add(btnGuess);

        lblFeedback = new JLabel("", SwingConstants.CENTER);
        add(lblFeedback);

        lblAttempts = new JLabel("", SwingConstants.CENTER);
        add(lblAttempts);
        
        lblScore = new JLabel("", SwingConstants.CENTER);
        add(lblScore);

        btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.addActionListener(e -> resetGame());
        btnPlayAgain.setVisible(false);
        add(btnPlayAgain);

        resetGame();
        setVisible(true);
    }

    public void resetGame() {
        numberToGuess = new Random().nextInt(100) + 1;
        attempts = 0;
        txtGuess.setText("");
        lblFeedback.setText("");
        lblAttempts.setText("Attempts left: " + (maxAttempts - attempts));
        lblScore.setText("");
        btnGuess.setEnabled(true);
        txtGuess.setEnabled(true);
        btnPlayAgain.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = txtGuess.getText().trim();

        int guess;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            lblFeedback.setText("Please enter a valid number.");
            return;
        }

        if (guess < 1 || guess > 100) {
            lblFeedback.setText("Number must be between 1 and 100.");
            return;
        }

        attempts++;

        if (guess == numberToGuess) {
            lblFeedback.setText("Correct! You guessed it in " + attempts + " tries!");
            btnGuess.setEnabled(false);
            btnPlayAgain.setVisible(true);
        } else {
            int diff = Math.abs(guess - numberToGuess);
            if (guess < numberToGuess) {
                lblFeedback.setText(diff <= 2 ? "Too low, but very close!" : "Too low!");
            } else {
                lblFeedback.setText(diff <= 2 ? "Too high, but very close!" : "Too high!");
            }

            if (attempts >= maxAttempts) {
                lblFeedback.setText("Out of attempts! The number was " + numberToGuess);
                btnGuess.setEnabled(false);
                txtGuess.setEnabled(false); //disable input
                btnPlayAgain.setVisible(true);
            }
        }

        lblAttempts.setText("Attempts left: " + (maxAttempts - attempts));
        txtGuess.setText("");
    }

    public static void main(String[] args) {
        new NumberGuessingGameGUI();
    }
}
