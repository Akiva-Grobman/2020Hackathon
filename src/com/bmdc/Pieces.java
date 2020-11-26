package com.bmdc;

import java.util.Random;

public abstract class Pieces {

    public static int[][][] pieces = {
            lightBlue(),
            blue(),
            orange(),
            yellow(),
            green(),
            red(),
            pink()
    };

    public static int[][] getRandomPiece() {
        return pieces[new Random().nextInt(pieces.length)];
    }

    public static int[][] lightBlue() {
        return new int[][]{
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

    }

    public static int[][] blue() {
        return new int[][]{
                {0, 2, 0, 0},
                {0, 2, 2, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
    }

    public static int[][] orange () {
        return new int[][]{
                {0, 0, 3, 0},
                {3, 3, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
    }

    public static int[][] yellow () {
        return new int[][]{
                {4, 4, 0, 0},
                {4, 4, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

    }

    public static int[][] green () {
        return new int[][]{
                {0, 5, 5, 0},
                {5, 5, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
    }

    public static int[][] red() {
        return new int[][]{
                {7, 7, 0, 0},
                {0, 7, 7, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
    }

    public static int[][] pink () {
        return new int[][]{
                {0, 6, 0, 0},
                {6, 6, 6, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

    }

}
