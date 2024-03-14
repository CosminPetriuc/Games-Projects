import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {


    static Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    static JLabel textfield = new JLabel();
    static JButton[] buttons = new JButton[9];
    static boolean player1_turn;


    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(new Color(0, 153, 204));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(255, 0, 0));
        textfield.setForeground(new Color(0, 0, 0));
        textfield.setFont(new Font("Ink Free", Font.ITALIC, 76));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("X si 0");
        textfield.setOpaque(true);


        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 600, 100);
        title_panel.add(textfield);


        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);



        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);


        }

        firstTurn();


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("O");
                        buttons[i].setForeground(new Color(0, 0, 255));
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();

                    }
                }
            }
        }

    }
    public void remakeGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(null);
            buttons[i].setEnabled(true);
        }
        textfield.setText("X si O");
        firstTurn();
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWin(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWin(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWin(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWin(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWin(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWin(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWin(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWin(2, 4, 6);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            OWin(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            OWin(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            OWin(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            OWin(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            OWin(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            OWin(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            OWin(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            OWin(2, 4, 6);
        }
        draw();
    }

    public void xWin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        updateXWins++;
        Comenzi.updateWins(updateXWins, updateOWins, updateDraws);
    }

    public void OWin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        updateOWins++;
        Comenzi.updateWins(updateXWins, updateOWins, updateDraws);
    }
    public void draw(){
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText() == ""){
                return;
            }
        }
        textfield.setText("Draw");
        updateDraws++;
        Comenzi.updateWins(updateXWins, updateOWins, updateDraws);
    }

    public static int updateXWins = 0;
    public static int updateOWins = 0;
    public static int updateDraws = 0;


}
