package com.bmdc;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    private static final int SIZE = 35;
    private Color[][] board;
    private Color[][] nextPiece;

    public Display(Dimension dimension) {
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        setBackground(Color.black);
    }

    public void setBoard(Color[][] colors) {
        this.board = colors;
    }

    public void setNextPiece(Color[][] nextPiece) {
        this.nextPiece = nextPiece;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if(board == null) {
            return;
        }

        // draw board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                graphics.setColor(board[i][j]);
                int x = 400 + (i * 40);
                int y = 10 + j * 40;
                graphics.fillRect(x, y, SIZE, SIZE);
            }
        }
        int edgeOfX = 880;
        // draw board boarders
        graphics.setColor(Color.gray);
        graphics.drawLine(400, 8, edgeOfX, 8);
        graphics.drawLine(400, 8, 400, 970);
        graphics.drawLine(edgeOfX, 8, edgeOfX, 970);

        // draw next piece
        for (int i = 0; i < nextPiece.length; i++) {
            for (int j = 0; j < nextPiece[i].length; j++) {
                graphics.setColor(nextPiece[i][j]);
                int x = 40 + (i * 40);
                int y = 40 + (j * 40);
                graphics.fillRect(x, y, SIZE, SIZE);
            }
        }
        Color[][] lightBlueShape = getAsColorArray(Pieces.lightBlue());
        drawShapeOnRight(lightBlueShape, 0, graphics);

        Color[][] blueShape = getAsColorArray(Pieces.blue());
        drawShapeOnRight(blueShape, 1, graphics);

        Color[][] orangeShape = getAsColorArray(Pieces.orange());
        drawShapeOnRight(orangeShape, 2, graphics);

        Color[][] yellowShape = getAsColorArray(Pieces.yellow());
        drawShapeOnRight(yellowShape, 3, graphics);

        Color[][] greenShape = getAsColorArray(Pieces.green());
        drawShapeOnRight(greenShape, 4, graphics);

        Color[][] redShape = getAsColorArray(Pieces.red());
        drawShapeOnRight(redShape, 5, graphics);

        Color[][] pinkShape = getAsColorArray(Pieces.pink());
        drawShapeOnRight(pinkShape, 6, graphics);
    }

    private void drawShapeOnRight(Color[][] shape, int startingY, Graphics graphics) {
        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                graphics.setColor(shape[x][y]);
                int i = 1230 + (x * 25);
                int j = 20 + (120 * startingY) + (y * 25);
                graphics.fillRect(i, j, SIZE / 3 * 2, SIZE  / 3 * 2);
            }
        }
    }

    private Color[][] getAsColorArray(int[][] numArray) {
        Color[][] colors = new Color[numArray.length][numArray[0].length];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                colors[i][j] = getColor(numArray[i][j]);
            }
        }
        return colors;
    }

    private Color getColor(int code) {
        return switch (code) {
            case 1 -> Color.cyan;
            case 2 -> Color.blue;
            case 3 -> Color.orange;
            case 4 -> Color.yellow;
            case 5 -> Color.green;
            case 6 -> Color.pink;
            case 7 -> Color.red;
            default -> Color.black;
        };
    }

}
