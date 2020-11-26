package com.bmdc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class KeyInput implements KeyListener {

    private final boolean[] keys;

    public KeyInput() {
        keys = new boolean[4];
        Arrays.fill(keys, false);
    }

    public boolean getKeyValue(int keyCode) {
        return keys[keyCode - KeyEvent.VK_LEFT];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        final int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_ESCAPE) {
            Main.stop();
        }
        if(isArrowKey(keyCode)) {
            click(true, keyCode - KeyEvent.VK_LEFT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        final int keyCode = e.getKeyCode();
        if(isArrowKey(keyCode)) {
            click(false, keyCode - KeyEvent.VK_LEFT);
        }
    }

    private boolean isArrowKey(int keyCode) {
        return keyCode >= KeyEvent.VK_LEFT && keyCode <= KeyEvent.VK_DOWN;
    }

    private void click(boolean value, int index) {
        keys[index] = value;
    }

}
