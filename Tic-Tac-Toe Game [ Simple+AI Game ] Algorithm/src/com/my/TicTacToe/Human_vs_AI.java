package com.my.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Human_vs_AI extends JFrame implements ActionListener, Runnable{

    Random random = new Random();

    int[][] board =new int[3][3];
    int turn;

    List<Move> nextMoves;
    List<Integer> nextScores;

    JPanel titPanel, buttoJPanel;
    JLabel textlJLabel;
    JButton[][] buttons = new JButton[3][3];

    private final Thread threadObject;

    boolean player;

    Icon zero = new ImageIcon("src/img/Zero.png");
    Icon cross = new ImageIcon("src/img/Cross.png");

    static class Move{
        int i;
        int j;
        Move(int i,int j)
        {
            this.i=i;
            this.j=j;
        }
    }

    Human_vs_AI(){

       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tic-Tac-Toe Game");
        this.setSize(600, 600);
        this.getContentPane();
        this.setBackground(new Color(50, 50, 50));
        this.setLayout(new BorderLayout());

        textlJLabel = new JLabel();
        textlJLabel.setBackground(Color.YELLOW);
        textlJLabel.setForeground(Color.blue);
        textlJLabel.setFont(new Font("Bold", Font.ITALIC, 60));
        textlJLabel.setHorizontalAlignment(JLabel.CENTER);
        textlJLabel.setText("Human VS AI");
        textlJLabel.setOpaque(true);
        //this.add(textlJLabel);

        titPanel = new JPanel();
        titPanel.setLayout(new BorderLayout());
        titPanel.setBounds(0, 0, 800, 100);

        buttoJPanel = new JPanel();
        buttoJPanel.setLayout(new GridLayout(3, 3));
        buttoJPanel.setBackground(Color.GRAY);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setActionCommand(""+(i*3+j));
                buttoJPanel.add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFocusable(false);
                buttons[i][j].setBackground(Color.WHITE);

                //this.add(buttons[i][j]);
                board[i][j]=-1; // All board positions are empty
            }
        }

        this.add(buttoJPanel);

        titPanel.add(textlJLabel);
        this.add(titPanel, BorderLayout.NORTH);

        //this.setLocationRelativeTo(null);
        turn = 0; // Turn of O player

        player = false;

        this.setVisible(true);

        threadObject = new Thread(this);
        threadObject.start();

    }


    public void firstTurn() {

        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        if (random.nextInt(2)==0){
            turn = 1;
            textlJLabel.setText("AI (0 Turn)");
        } else {
            turn = 0;
            textlJLabel.setText("Player (X Turn)");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String command = e.getActionCommand();
        if(command!=null)
        {
            int pos = Integer.parseInt(command);
            int x=pos/3;
            int y=pos%3;
            player = true;
            boolean set=false;
            if (turn == 1)
            {
                if (board[x][y]==-1){
                    set = true;
                    board[x][y]=1;
                    buttons[x][y].setIcon(zero);
                    turn = 0;

                }
            } else if (turn == 0)
            {
                if (board[x][y]==-1){
                    set=true;
                    board[x][y]=0;
                    buttons[x][y].setIcon(cross);
                    turn = 1;

                }
            }

            firstTurn();

            if (set)
            {
                // Resume
                synchronized(threadObject)
                {
                    threadObject.notify();
                }
            }

        }

    }

    // Game over
    boolean isGameOver()
    {
        if (XWon()||OWon())
            return true;
        return plausibleMoveGenerator().isEmpty();
    }

    // X winning Position
    boolean XWon()
    {
        if((board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[0][0]==1) ||
                (board[2][0]==board[1][1]&&board[2][0]==board[0][2]&&board[2][0]==1))//Diagonal Win
        {
            return true;
        }

        for(int i=0;i<3;i++)
        {
            if((board[0][i]==board[1][i]&&board[0][i]==board[2][i]&&board[0][i]==1)||
                    (board[i][0]==board[i][1]&&board[i][0]==board[i][2]&&board[i][0]==1))
                return true;
        }
        return false;
    }

    // 0 winning Position
    boolean OWon()
    {

        if((board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[0][0]==1) ||
                (board[2][0]==board[1][1]&&board[2][0]==board[0][2]&&board[2][0]==1))//Diagonal Win
        {
            return true;
        }

        for(int i=0;i<3;i++)
        {
            if((board[0][i]==board[1][i]&&board[0][i]==board[2][i]&&board[0][i]==0)||
                    (board[i][0]==board[i][1]&&board[i][0]==board[i][2]&&board[i][0]==0))
                return true;
        }
        return false;

    }


    // Minimax Algorithm
    int minimax(int depth, int turn)
    {
        if(XWon()) {
            // Modify to 10 - depth
            return 10 - depth;
        }
        else if(OWon()) {
            // Modify to depth - 10
            return depth - 10;
        }

        List<Move> availableMoves = plausibleMoveGenerator();
        List<Integer> scores = new ArrayList<>();
        if(availableMoves.isEmpty())
            return 0;

        for (Move move : availableMoves) {
            if (turn == 1) // X's Turn
            {
                // TODO maximizer and Place the move (done by algo so it is needed to be reset afterwards)
                board[move.i][move.j] = 1;
                int currentScore = minimax(depth + 1, 0);

                // TODO Add the current score to the list of all possible Scores
                scores.add(currentScore);
                if (depth == 0) {
                    nextMoves.add(move);
                    nextScores.add(currentScore);
                }
            } else if (turn == 0) // O's Turn
            {
                // TODO Minimize and Place the move
                board[move.i][move.j] = 0;
                int currentScore = minimax(depth + 1, 1);

                // TODO Add the current score to the list of all possible Scores
                scores.add(currentScore);
            }
            board[move.i][move.j] = -1;// Reset board position

        }
        if(turn == 1)
            return getMax(scores);
        else if(turn == 0)
            return getMin(scores);

        return 0;
    }


    // getmax
    int getMax(List<Integer> scores)
    {
        int max = Integer.MIN_VALUE; // As scores can be negative
        for (Integer score : scores) {
            if (score > max)
                max = score;
        }
        return max;
    }


    // getmin
    int getMin(List<Integer> scores)
    {
        int min=Integer.MAX_VALUE; // As scores can be negative
        for (Integer score : scores) {
            if (score < min)
                min = score;
        }
        return min;
    }


    // posible MoveGenerator()
    List<Move> plausibleMoveGenerator()
    {
        List<Move> plausibleMoves = new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==-1) // board position is empty
                {
                    plausibleMoves.add(new Move(i, j));
                }
            }
        }
        return plausibleMoves;

    }


    void AlgorithmMove()
    {
        nextMoves = new ArrayList<>();
        nextScores = new ArrayList<>();
        minimax(0,1);
        Move move = selectBestMove();
        board[move.i][move.j] = 1;
        buttons[move.i][move.j].setIcon(zero);
    }


    Move selectBestMove()
    {
        int max = Integer.MIN_VALUE;
        int index=-1;
        for(int i=0; i<nextMoves.size(); i++)
        {
            if(max<nextScores.get(i))
            {
                max = nextScores.get(i);
                index = i;
            }
        }

        return nextMoves.get(index);
    }

    @Override
    public void run()
    {
        while(!isGameOver())
        {
            synchronized(threadObject)
            {
                // Pause
                try
                {
                    threadObject.wait();
                }
                catch (InterruptedException ignored)
                {
                }
            }
            if(isGameOver())
                break;


            AlgorithmMove();

            if(isGameOver())
                break;
        }

        // GAME OVER
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++) {
                buttons[i][j].removeActionListener(this); // disable();
            }

        }

        if(XWon()) {
            textlJLabel.setText("System (AI) Win");
           // this.setVisible(false);
            JLabel label = new JLabel("Better Luck Next Time (AI Won)");
            label.setFont(new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(this, label,"Game Over",JOptionPane.PLAIN_MESSAGE);
            new child_window2();
        }
        else if(OWon()) {
            textlJLabel.setText("Player Win");
           // this.setVisible(false);
            JLabel label = new JLabel("Congratulation Player Won");
            label.setFont(new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(this, label,"Game Over",JOptionPane.PLAIN_MESSAGE);
            new child_window2();
        }
        else {
            textlJLabel.setText("Draw");
           // this.setVisible(false);
            JLabel label = new JLabel("Draw Match");
            label.setFont(new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(this, label,"Game Over",JOptionPane.PLAIN_MESSAGE);
            new child_window2();
        }

    }

    public static void main(String[] args){

        Human_vs_AI obj = new Human_vs_AI();
        Thread t = new Thread(obj);
        t.start();

    }

}
