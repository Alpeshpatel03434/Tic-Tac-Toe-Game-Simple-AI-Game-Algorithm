package com.my.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JButton button1, button2;

    Main(){

       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tic-Tac-Toe Game");
        this.setSize(600, 600);
        this.getContentPane();
        this.setBackground(Color.CYAN);
        this.setLayout(null);

        button1 = new JButton("Human VS Human");
        button1.setBackground(Color.GREEN);
        button1.setFont(new Font("Bold", Font.BOLD, 16));
        button1.setBounds(200, 180, 200, 60);
        button1.addActionListener(this);
        this.add(button1);

        button2 = new JButton("Human VS AI");
        button2.setBackground(Color.GREEN);
        button2.setFont(new Font("Bold", Font.BOLD, 16));
        button2.setBounds(200, 280, 200, 60);
        button2.addActionListener(this);
        this.add(button2);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource()== button1){
            button1.setBackground(Color.RED);
            new two_player();
            this.setVisible(false);
        }

        if (e.getSource()== button2){
            button2.setBackground(Color.RED);
            new one_player();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
	// write your code here

        new Main();

    }
}
