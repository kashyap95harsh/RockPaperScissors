import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;
    private int userWins, computerWins, draws;

    public GamePanel() {
        setLayout(new GridLayout(4, 1)); // Adjusted to fit within 720p resolution

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        resultLabel = new JLabel(" ");

        // Set preferred size for buttons to fit within the layout
        Dimension buttonSize = new Dimension(400, 100);
        rockButton.setPreferredSize(buttonSize);
        paperButton.setPreferredSize(buttonSize);
        scissorsButton.setPreferredSize(buttonSize);

        // Set background and foreground colors for buttons and label
        Color buttonColor = new Color(0, 128, 0); // Green color
        Color labelColor = Color.RED; // Red color
        rockButton.setBackground(buttonColor);
        rockButton.setForeground(Color.WHITE); // White text color
        paperButton.setBackground(buttonColor);
        paperButton.setForeground(Color.WHITE);
        scissorsButton.setBackground(buttonColor);
        scissorsButton.setForeground(Color.WHITE);
        resultLabel.setForeground(labelColor);

        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        add(resultLabel);

        rockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playRound("Rock");
            }
        });

        paperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playRound("Paper");
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playRound("Scissors");
            }
        });
    }

    private void playRound(String userChoice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        String computerChoice = choices[(int) (Math.random() * choices.length)];

        if (userChoice.equals(computerChoice)) {
            draws++;
            resultLabel.setText("It's a draw!");
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            userWins++;
            resultLabel.setText("You win!");
        } else {
            computerWins++;
            resultLabel.setText("Computer wins!");
        }

        JOptionPane.showMessageDialog(this,
                "Yon Wins: " + userWins + "\nComputer Wins: " + computerWins + "\nDraws: " + draws);
    }
}
