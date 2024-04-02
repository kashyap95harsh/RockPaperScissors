import javax.swing.JFrame;


public class RockPaperScissors extends JFrame {
    private GamePanel gamePanel;

    public RockPaperScissors() {
        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();
        getContentPane().add(gamePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
   
}
