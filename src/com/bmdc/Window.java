package com.bmdc;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private static final int FACTOR  = 4;
    private static final int WIDTH =  350 * FACTOR;
    private static final int HEIGHT = 250 * FACTOR;
    private final Display display;
    private DataBase dataBase;

    public Window(DataBase dataBase) {
        this.dataBase = dataBase;
        display = new Display(new Dimension(WIDTH, HEIGHT));
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(display);
        setVisible(true);
    }

    public void refresh() {
        display.repaint();
    }


    public void setBoard(Color[][] board) {
        display.setColors(board);
    }

    public void setNextPiece(Color[][] nextPiece) {
        display.setNextPiece(nextPiece);
    }
}
