package com.my.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class child_window2 extends JFrame implements ActionListener {

    JButton replay, home, exit;

    child_window2(){

       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tic-Tac-Toe Game");
        this.setSize(400, 400);
        this.getContentPane();
        this.setBackground(Color.CYAN);
        this.setLayout(null);

        replay = new JButton("RePlay");
        replay.setBackground(Color.CYAN);
        replay.setFont(new Font("Bold", Font.BOLD, 16));
        replay.setBounds(140, 80, 100, 60);
        replay.addActionListener(this);
        this.add(replay);

        home = new JButton("Home");
        home.setBackground(Color.YELLOW);
        home.setFont(new Font("Bold", Font.BOLD, 16));
        home.setBounds(140, 160, 100, 60);
        home.addActionListener(this);
        this.add(home);

        exit = new JButton("Exit");
        exit.setBackground(Color.GREEN);
        exit.setFont(new Font("Bold", Font.BOLD, 16));
        exit.setBounds(140, 240, 100, 60);
        exit.addActionListener(this);
        this.add(exit);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource()==replay){
            replay.setBackground(Color.RED);
            this.setVisible(false);
            //new Human_vs_AI();
            Human_vs_Human obj = new Human_vs_Human();
            obj.buttons[0].setIcon(null);
            obj.buttons[1].setIcon(null);
            obj.buttons[2].setIcon(null);
            obj.buttons[3].setIcon(null);
            obj.buttons[4].setIcon(null);
            obj.buttons[5].setIcon(null);
            obj.buttons[6].setIcon(null);
            obj.buttons[7].setIcon(null);
            obj.buttons[8].setIcon(null);
        }

        if (e.getSource()==home){
            home.setBackground(Color.RED);
            this.setVisible(false);
            Human_vs_Human obj = new Human_vs_Human();
            obj.setVisible(false);
            new Main();
        }

        if (e.getSource()==exit){
            exit.setBackground(Color.RED);
            this.setVisible(false);
            System.exit(0);
        }

    }

//    public static void main(String[] args) {
//
//        new child_window2();
//
//    }

}