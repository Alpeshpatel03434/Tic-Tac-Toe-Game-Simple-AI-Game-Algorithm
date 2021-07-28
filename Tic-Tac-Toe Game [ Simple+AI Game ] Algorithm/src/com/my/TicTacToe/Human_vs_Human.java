package com.my.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Human_vs_Human extends JFrame implements ActionListener{

    Random random = new Random();

    JPanel titPanel, buttoJPanel, colsebuttonPanel;
    JLabel textlJLabel;
    JButton buttons[] = new JButton[9];
    JButton close;

    boolean Player1_turn;

    Icon zero = new ImageIcon("src/img/Zero.png");
    Icon cross = new ImageIcon("src/img/Cross.png");

    Human_vs_Human(){

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
        textlJLabel.setText("Human VS Human");
        textlJLabel.setOpaque(true);

        titPanel = new JPanel();
        titPanel.setLayout(new BorderLayout());
        titPanel.setBounds(0, 0, 800, 100);

        buttoJPanel = new JPanel();
        buttoJPanel.setLayout(new GridLayout(3, 3));
        buttoJPanel.setBackground(Color.GRAY);


        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttoJPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Bold", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titPanel.add(textlJLabel);
        this.add(titPanel, BorderLayout.NORTH);
        this.add(buttoJPanel);

        this.setVisible(true);
    }

    public void firstTurn() throws InterruptedException{

        Thread.sleep(2000);

        if (random.nextInt(2)==0){
            Player1_turn = true;
            textlJLabel.setText("Player-1 (0 Turn)");
        } else {
            Player1_turn = false;
            textlJLabel.setText("Player-2 (X Turn)");
        }
    }

    public void Check(){

        // Check X win Condition
        if (
                (buttons[0].getIcon()==cross) &&
                        (buttons[1].getIcon()==cross) &&
                        (buttons[2].getIcon()==cross)
        ) {
            XWin(0, 1, 2);
        }
        if (
                (buttons[3].getIcon()==cross) &&
                        (buttons[4].getIcon()==cross) &&
                        (buttons[5].getIcon()==cross)
        ) {
            XWin(3, 4, 5);
        }
        if (
                (buttons[6].getIcon()==cross) &&
                        (buttons[7].getIcon()==cross) &&
                        (buttons[8].getIcon()==cross)
        ) {
            XWin(6, 7, 8);
        }
        if (
                (buttons[0].getIcon()==cross) &&
                        (buttons[3].getIcon()==cross) &&
                        (buttons[6].getIcon()==cross)
        ) {
            XWin(0, 3, 6);
        }
        if (
                (buttons[1].getIcon()==cross) &&
                        (buttons[4].getIcon()==cross) &&
                        (buttons[7].getIcon()==cross)
        ) {
            XWin(1, 4, 7);
        }
        if (
                (buttons[2].getIcon()==cross) &&
                        (buttons[5].getIcon()==cross) &&
                        (buttons[8].getIcon()==cross)
        ) {
            XWin(2, 5, 8);
        }
        if (
                (buttons[0].getIcon()==cross) &&
                        (buttons[4].getIcon()==cross) &&
                        (buttons[8].getIcon()==cross)
        ) {
            XWin(0, 4, 8);
        }
        if (
                (buttons[2].getIcon()==cross) &&
                        (buttons[4].getIcon()==cross) &&
                        (buttons[6].getIcon()==cross)
        ) {
            XWin(2, 4, 6);
        }


        // Check 0 Win Condition
        if (
                (buttons[0].getIcon()==zero) &&
                        (buttons[1].getIcon()==zero) &&
                        (buttons[2].getIcon()==zero)
        ) {
            OWin(0, 1, 2);
        }
        if (
                (buttons[3].getIcon()==zero) &&
                        (buttons[4].getIcon()==zero) &&
                        (buttons[5].getIcon()==zero)
        ) {
            OWin(3, 4, 5);
        }
        if (
                (buttons[6].getIcon()==zero) &&
                        (buttons[7].getIcon()==zero) &&
                        (buttons[8].getIcon()==zero)
        ) {
            OWin(6, 7, 8);
        }
        if (
                (buttons[0].getIcon()==zero) &&
                        (buttons[3].getIcon()==zero) &&
                        (buttons[6].getIcon()==zero)
        ) {
            OWin(0, 3, 6);
        }
        if (
                (buttons[1].getIcon()==zero) &&
                        (buttons[4].getIcon()==zero) &&
                        (buttons[7].getIcon()==zero)
        ) {
            OWin(1, 4, 7);
        }
        if (
                (buttons[2].getIcon()==zero) &&
                        (buttons[5].getIcon()==zero) &&
                        (buttons[8].getIcon()==zero)
        ) {
            OWin(2, 5, 8);
        }
        if (
                (buttons[0].getIcon()==zero) &&
                        (buttons[4].getIcon()==zero) &&
                        (buttons[8].getIcon()==zero)
        ) {
            OWin(0, 4, 8);
        }
        if (
                (buttons[2].getIcon()==zero) &&
                        (buttons[4].getIcon()==zero) &&
                        (buttons[6].getIcon()==zero)
        ) {
            OWin(2, 4, 6);
        }

    }


    public void OWin(int a, int b, int c){

        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);

        for (int i=0; i<9; i++){

            if (a==i){
                buttons[i].setEnabled(true);
            } else if (b==i){
                buttons[i].setEnabled(true);
            } else if (c==i){
                buttons[i].setEnabled(true);
            } else {
                buttons[i].setEnabled(false);
            }

        }

        textlJLabel.setText("Player-1 Win");
        new child_window1();
        JLabel label = new JLabel("Congratulation Player-1 Won");
        label.setFont(new Font("Arial", Font.BOLD, 22));
        JOptionPane.showMessageDialog(this, label,"Game Over",JOptionPane.PLAIN_MESSAGE);
        // this.setVisible(false);
    }

    public void XWin(int a, int b, int c){

        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);

        for (int i=0; i<9; i++){

            if (a==i){
                buttons[i].setEnabled(true);
            } else if (b==i){
                buttons[i].setEnabled(true);
            } else if (c==i){
                buttons[i].setEnabled(true);
            } else {
                buttons[i].setEnabled(false);
            }

        }

        textlJLabel.setText("Player-2 Win");
        new child_window1();
        JLabel label = new JLabel("Congratulation Player-2 Won");
        label.setFont(new Font("Arial", Font.BOLD, 22));
        JOptionPane.showMessageDialog(this, label,"Game Over",JOptionPane.PLAIN_MESSAGE);
       // this.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        for (int i=0; i<9; i++){
            if (e.getSource()==buttons[i]){
                if (Player1_turn){

                    if(buttons[i].getIcon()==null){
                        buttons[i].setIcon(cross);
                        Player1_turn = false;
                        textlJLabel.setText("Player-1 (0 Turn)");
                        Check();
                    }

                } else {

                    if(buttons[i].getIcon()==null){
                        buttons[i].setIcon(zero);
                        Player1_turn = true;
                        textlJLabel.setText("Player-2 (X Turn)");
                        Check();
                    }

                }
            }
        }

    }


    public static void main(String args[]){

        new Human_vs_Human();

    }

}