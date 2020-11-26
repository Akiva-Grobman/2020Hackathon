package com.bmdc;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class DataBase {

    private final KeyInput keyInput;
    private int previousX;
    private int previousY;
    private int pieceX;
    private int pieceY;
    private int[][] board;
    private int[][] currentPiece;
    private int[][] nextPiece;

    public DataBase(KeyInput keyInput) {
        this.keyInput = keyInput;
        currentPiece = Pieces.getRandomPiece();
        nextPiece = Pieces.getRandomPiece();
        pieceX = 4;
        pieceY = 0;
        previousX = 4;
        previousY = 0;
        board = initBoard();
    }

    private int[][] initBoard() {
        int[][] init = new int[12][24];
        for (int[] line: init) {
            Arrays.fill(line, 0);
        }
        return init;
    }

    public Color[][] getBoard() {
        Color[][] colors = new Color[12][24];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                colors[i][j] = getColor(board[i][j]);
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

    public void update() {
        boolean isClickingRight = keyInput.getKeyValue(KeyEvent.VK_RIGHT);
        boolean isClickingLeft = keyInput.getKeyValue(KeyEvent.VK_LEFT);
        boolean isClickingDown = keyInput.getKeyValue(KeyEvent.VK_DOWN);
        boolean isClickingUP = keyInput.getKeyValue(KeyEvent.VK_UP);
        // right
        if(isClickingRight && pieceX + 4 < 12) {
            boolean canMove = true;
            for (int i = 0; i < currentPiece.length; i++) {
                for (int j = 0; j < currentPiece[i].length; j++) {
                    if(currentPiece[i][j] != 0) {
                        if (i + 1 < 4 && currentPiece[i + 1][j] == 0) {
                            if (board[pieceX + i + 1][j] != 0) {
                                canMove = false;
                            }
                        }
                    }
                }
            }
            if(canMove) {
                pieceX++;
            }
        }
        // left
        if(isClickingLeft && pieceX > 0) {
            boolean canMove = true;
            for (int i = 0; i < currentPiece.length; i++) {
                for (int j = 0; j < currentPiece[i].length; j++) {
                    if(currentPiece[i][j] != 0) {
                        if(i - 1 >= 0 && currentPiece[i - 1][j] == 0) {
                            if (board[pieceX + i - 1][j] != 0) {
                                canMove = false;
                            }
                        }
                    }
                }
            }
            if(canMove) {
                pieceX--;
            }
        }
        // flip
        if(isClickingUP) {
            boolean canMove = true;
            for (int i = 0; i < currentPiece.length; i++) {
                for (int j = 0; j < currentPiece[i].length; j++) {
                    if(currentPiece[i][j] != 0) {
                        if (i + 1 < 4 && currentPiece[i + 1][j] == 0) {
                            if (board[pieceX + i + 1][j] != 0) {
                                canMove = false;
                            }
                        }
                    }
                }
            }
            if(canMove) {
                currentPiece = getRotatedInstanceOfPiece(getRotatedInstanceOfPiece(getRotatedInstanceOfPiece(currentPiece)));
            }
        }
        // down
        if(isClickingDown) {
            if(pieceY + 4 < 24) {
                boolean canMove = true;
//            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < currentPiece.length; i++) {
                    for (int j = 0; j < currentPiece[i].length; j++) {
                        if (currentPiece[i][j] != 0) {
                            if (j + 1 < 4 && currentPiece[i][j + 1] == 0) {
                                if (board[pieceX + i][pieceY + j + 1] != 0) {
                                    canMove = false;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (canMove) {
                    pieceY++;
                }
//            }
                if (!canMove || pieceY >= 19) {
                    currentPiece = nextPiece;
                    nextPiece = Pieces.getRandomPiece();
                    pieceX = 4;
                    pieceY = 0;
                    previousY = 4;
                    previousX = 0;
                }
            } else {
                currentPiece = nextPiece;
                nextPiece = Pieces.getRandomPiece();
                pieceX = 4;
                pieceY = 0;
                previousY = 4;
                previousX = 0;
            }
        }
        concatenate();
    }

    private void concatenate() {
        for (int i = 0; i < currentPiece.length; i++) {
            for (int j = 0; j < currentPiece[i].length; j++) {
                if(currentPiece[i][j] != 0) {
                    board[previousX + i][previousY + j] = 0;
                }
            }
        }
        previousX = pieceX;
        previousY = pieceY;
        for (int i = 0; i < currentPiece.length; i++) {
            for (int j = 0; j < currentPiece[i].length; j++) {
                if(currentPiece[i][j] != 0) {
                    board[pieceX + i][pieceY + j] = currentPiece[i][j];
                }
            }
        }
    }

    public Color[][] getNextPiece() {
        Color[][] nextPiece = new Color[4][4];
        for (int i = 0; i < nextPiece.length; i++) {
            for (int j = 0; j < nextPiece[i].length; j++) {
                nextPiece[i][j] = getColor(this.nextPiece[i][j]);
            }
        }
        return nextPiece;
    }

    private int[][] getRotatedInstanceOfPiece(int[][] board) {
        int matrixDimension = 4;
        int[][] rotated = new int[matrixDimension][matrixDimension];
        for (int x = 0; x < matrixDimension / 2; x++) {
            for (int y = x; y < matrixDimension - x - 1; y++) {
                int temp = board[x][y];
                rotated[x][y] = board[y][matrixDimension - 1 - x];
                rotated[y][matrixDimension - 1 - x]
                        = board[matrixDimension - 1 - x][matrixDimension - 1 - y];
                rotated[matrixDimension - 1 - x][matrixDimension - 1 - y] = board[matrixDimension - 1 - y][x];
                rotated[matrixDimension - 1 - y][x] = temp;
            }
        }
        return rotated;
    }

    public void second() {
        if(pieceY < 19) {
            pieceY++;
            concatenate();
        }
    }

}
