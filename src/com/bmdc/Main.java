package com.bmdc;

public class Main {

    private static boolean gameLoopIsRunning = false;
    private static Window window;
    private static DataBase dataBase;

    public static void main(String[] args) {
        gameLoopIsRunning = true;
        KeyInput keyInput = new KeyInput();
        dataBase = new DataBase(keyInput);
        window = new Window(dataBase);
        window.addKeyListener(keyInput);
        final double FRAMES_PER_SECOND = 60;
        double timePerUpdate = 1000000000 / FRAMES_PER_SECOND;
        double timeFromLastUpdate = 0;
        long now;
        long last = System.nanoTime();
        while (gameLoopIsRunning) {
            now = System.nanoTime();
            timeFromLastUpdate += (now - last) / timePerUpdate;
            last = now;
            if(timeFromLastUpdate >= 1) {
                tick();
                render();
                timeFromLastUpdate--;
            }
        }
    }

    private static void tick() {
        dataBase.update();
    }

    private static void render() {
        window.validate();
        window.setBoard(dataBase.getBoard());
        window.setNextPiece(dataBase.getNextPiece());
        window.refresh();
    }

    public static void stop() {
        gameLoopIsRunning = false;
    }


}
