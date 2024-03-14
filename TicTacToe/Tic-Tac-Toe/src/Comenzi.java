import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comenzi extends JFrame {

    private TicTacToe tictactoe;
    private int xWins = 0;
    private int oWins = 0;
    private int draws = 0;

    JLabel titleLabel = new JLabel("X si 0");
    JButton remakeButton = new JButton("Remake");
    static JLabel scoreLabel = new JLabel("Wins:X - 0 |Wins:O - 0 | Draws: 0");

    Comenzi(){
        tictactoe = new TicTacToe();
        setTitle("Comenzi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 600);
        setResizable(false);

        JPanel containrePanel = new JPanel();
        containrePanel.setLayout(new BoxLayout(containrePanel, BoxLayout.Y_AXIS));
        getContentPane().add(containrePanel);

        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(300, 100));
        titlePanel.add(titleLabel);
        containrePanel.add(titlePanel);

        JPanel scorePanel = new JPanel();
        scorePanel.setPreferredSize(new Dimension(300, 200));
        scorePanel.add(scoreLabel);
        containrePanel.add(scorePanel);

        JPanel remakePanel = new JPanel();
        remakePanel.setPreferredSize(new Dimension(20, 70));
        remakePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        remakePanel.add(remakeButton);
        containrePanel.add(remakePanel);

        remakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tictactoe.remakeGame();
            }
        });


        setVisible(true);
        
    }

    public static void updateWins(int xWins, int oWins, int draws) {
        scoreLabel.setText("Wins: X - " + xWins + " | O - " + oWins + " | Draws - " + draws);
    }


}
