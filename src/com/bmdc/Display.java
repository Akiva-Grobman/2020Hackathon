package com.bmdc;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {

    private static final int SIZE = 35;
    private Color[][] colors;
    private Color[][] nextPiece;

    public Display(Dimension dimension) {
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        setBackground(Color.black);
    }

    public void setColors(Color[][] colors) {
        this.colors = colors;
    }

    public void setNextPiece(Color[][] nextPiece) {
        this.nextPiece = nextPiece;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if(colors == null) {
            return;
        }
        // this is where you will draw stuff
        for (int x = 400; x < 880; x += 40) {
            for (int y = 0; y < 960; y += 40) {
                graphics.setColor(colors[(x - 400) / 40][y / 40]);
                graphics.fillRect(x, y, SIZE, SIZE);

            }
        }
        for (int x = 40; x < 200; x += 40) {
            for (int y = 40; y < 200; y += 40) {
                graphics.setColor(nextPiece[(x - 40) / 40][(y - 40) / 40]);
                graphics.fillRect(x, y, SIZE, SIZE);
            }
        }
        int[][] shape = Pieces.lightBlue();
        int i;
        int j = 0;
        for (int x = 1230; x < 1390; x += 40) {
            i = 0;
            for (int y = 50; y < 80; y += 40) {
                if (shape[i][j] == 1) {
                    graphics.setColor(Color.cyan);
                } else {
                    graphics.setColor(Color.black);
                }
                graphics.fillRect(x, y, SIZE, SIZE);
                i++;
            }
            j++;
        }
        int[][] shape1 = Pieces.blue();
        int i1 = 0;
        int j1;
        for (int x = 1230; x < 1390; x += 40) {
            j1 = 0;
            for (int y = 120; y < 200; y += 40) {
                if (shape1[j1][i1] == 1) {
                    graphics.setColor(Color.blue);
                } else {
                    graphics.setColor(Color.black);
                }
                graphics.fillRect(x, y, SIZE, SIZE);
                j1++;
            }
            i1++;
        }
        int[][] shape2 = Pieces.orange();
        int i2 = 0;
        int j2;
        for (int x = 1230; x < 1390; x += 40) {
            j2 = 0;
            for (int y = 240; y < 320; y += 40) {
                if (shape2[j2][i2] == 1) {
                    graphics.setColor(Color.orange);
                } else {
                    graphics.setColor(Color.black);
                }
                graphics.fillRect(x, y, SIZE, SIZE);
                j2++;
            }
            i2++;
        }
        int[][] shape3 = Pieces.yellow();
        int i3 = 0;
        int j3;
        for (int x = 1230; x < 1390; x += 40) {
            j3 = 0;
            for (int y = 360; y < 440; y += 40) {
                if (shape3[j3][i3] == 1) {
                    graphics.setColor(Color.yellow);
                } else {
                    graphics.setColor(Color.black);
                }
                graphics.fillRect(x, y, SIZE, SIZE);
                j3++;
            }
            i3++;
        }
        int[][] shape4 = Pieces.green();
        int i4 = 0;
        int j4;
        for (int x = 1230; x < 1390; x += 40) {
            j4 = 0;
            for (int y = 480; y < 560; y += 40) {
                if (shape4[j4][i4] == 1) {
                    graphics.setColor(Color.green);
                } else {
                    graphics.setColor(Color.black);
                }
                graphics.fillRect(x, y, SIZE, SIZE);
                j4++;
            }
            i4++;
        }
        int[][] shape5 = Pieces.red();
        int i5 = 0;
        int j5;
        for (int x = 1230; x < 1390; x += 40) {
            j5 = 0;
            for (int y = 600; y < 680; y += 40) {
                if (shape5[j5][i5] == 1) {
                    graphics.setColor(Color.red);
                } else {
                    graphics.setColor(Color.black);
                }
                graphics.fillRect(x, y, SIZE, SIZE);
                j5++;
            }
            i5++;
        }
        int[][] shape6 = Pieces.pink();
        int i6 = 0;
        int j6;
        for (int x = 1230; x < 1390; x += 40) {
            j6 = 0;
            for (int y = 720; y < 800; y += 40) {
                if (shape6[j6][i6] == 1) {
                    graphics.setColor(Color.pink);
                } else {
                    graphics.setColor(Color.black);
                }
                graphics.fillRect(x, y, SIZE, SIZE);
                j6++;
            }
            i6++;
        }
    }
}
