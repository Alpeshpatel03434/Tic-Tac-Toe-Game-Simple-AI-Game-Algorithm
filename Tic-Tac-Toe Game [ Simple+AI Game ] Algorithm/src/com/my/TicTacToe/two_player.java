package com.my.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class two_player extends JFrame implements ActionListener {

    JLabel title, Player1, Player2;
    JTextField get_Player1, get_Player2;
    JButton Play;

    two_player(){

       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tic-Tac-Toe Game");
        this.setSize(600, 600);
        this.getContentPane();
        this.setBackground(Color.CYAN);
        this.setLayout(null);

        title = new JLabel("Human VS Human");
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Bold", Font.BOLD, 28));
        title.setBounds(180, 80, 300, 60);
        this.add(title);

        Player1 = new JLabel("Player-1");
        Player1.setBackground(Color.CYAN);
        Player1.setForeground(Color.BLACK);
        Player1.setFont(new Font("Bold", Font.BOLD, 16));
        Player1.setBounds(160, 160, 200, 60);
        this.add(Player1);

        get_Player1 = new JTextField();
        get_Player1.setBackground(Color.WHITE);
        get_Player1.setForeground(Color.BLACK);
        get_Player1.setFont(new Font("Bold", Font.BOLD, 16));
        get_Player1.setBounds(260, 160, 200, 60);
        this.add(get_Player1);

        Player2 = new JLabel("Player-2");
        Player2.setBackground(Color.CYAN);
        Player2.setForeground(Color.BLACK);
        Player2.setFont(new Font("Bold", Font.BOLD, 16));
        Player2.setBounds(160, 240, 200, 60);
        this.add(Player2);

        get_Player2 = new JTextField();
        get_Player2.setBackground(Color.WHITE);
        get_Player2.setForeground(Color.BLACK);
        get_Player2.setFont(new Font("Bold", Font.BOLD, 16));
        get_Player2.setBounds(260, 240, 200, 60);
        this.add(get_Player2);

        Play = new JButton("Play");
        Play.setBackground(Color.GREEN);
        Play.setFont(new Font("Bold", Font.BOLD, 16));
        Play.setBounds(280, 330, 100, 60);
        Play.addActionListener(this);
        this.add(Play);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource()==Play){

            String p1 = get_Player1.getText().toString();
            String p2 = get_Player2.getText().toString();

            if (p1=="") {
                JLabel label = new JLabel("Not Valid");
                label.setFont(new Font("Arial", Font.BOLD, 22));
                JOptionPane.showMessageDialog(this, label,"Input",JOptionPane.PLAIN_MESSAGE);
            }
            if (p2=="") {
                JLabel label = new JLabel("Not Valid");
                label.setFont(new Font("Arial", Font.BOLD, 22));
                JOptionPane.showMessageDialog(this, label,"Input",JOptionPane.PLAIN_MESSAGE);
            }

            if (p1!=null && p2!=null) {
                Play.setBackground(Color.RED);
                this.setVisible(false);
                new Human_vs_Human();
            }
        }

    }

//    public static void main(String[] args) {
//
//        new two_player();
//
//    }

}