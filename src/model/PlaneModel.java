package model;

import manager.GameManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlaneModel extends GameModel{
    public static final int PLANE_ID_1 = 1;
    public static final int PLANE_ID_2 = 2;
    public static final int PLANE_BOTH_ID = 3;
    public static final int WIDTH = 48;
    public static final int HEIGHT = 48;
    public static final String PLANE_1_URL = "plane/planeHA.png";
    public static final String PLANE_2_URL = "plane/planeLKL.png";
    public static final int BULLET_PERIOD = 10;
    public static final int SPEED = 5;

    private int planeId;
    private boolean running = false;
    private char direction = 'L';
    private int bulletLevel = 1;

    private boolean runningR, runningL, runningU, runningD;

    public boolean isRunningR() {
        return runningR;
    }

    public boolean isRunningL() {
        return runningL;
    }

    public boolean isRunningU() {
        return runningU;
    }

    public boolean isRunningD() {
        return runningD;
    }

    public PlaneModel(int x, int y, int planeId) {
        super(x, y, WIDTH, HEIGHT, SPEED);
        this.planeId = planeId;
        switch (planeId) {
            case PLANE_ID_1:
                GameManager.gamePanel.addKeyListener(new MyKeyAdapter1());
                break;
            case PLANE_ID_2:
                GameManager.gamePanel.addKeyListener(new MyKeyAdapter2());
                break;
        }
    }

    public int getPlaneId() {
        return planeId;
    }

    public boolean isRunning() {
        return running;
    }

    public char getDirection() {
        return direction;
    }

    public int getBulletLevel() {
        return bulletLevel;
    }

    public void addBulletLevel() {
        this.bulletLevel += 1;
    }

    private class MyKeyAdapter1 extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    running = true;
                    runningR = true;
                    direction = 'R';
                    break;
                case KeyEvent.VK_LEFT:
                    running = true;
                    runningL = true;
                    direction = 'L';
                    break;
                case KeyEvent.VK_UP:
                    running = true;
                    runningU = true;
                    direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    running = true;
                    runningD = true;
                    direction = 'D';
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    runningR = false;
                    if (direction == 'R') {
                        running = false;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    runningL = false;
                    if (direction == 'L') {
                        running = false;
                    }
                    break;
                case KeyEvent.VK_UP:
                    runningU = false;
                    if (direction == 'U') {
                        running = false;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    runningD = false;
                    if (direction == 'D') {
                        running = false;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private class MyKeyAdapter2 extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_D:
                    running = true;
                    direction = 'R';
                    break;
                case KeyEvent.VK_A:
                    running = true;
                    direction = 'L';
                    break;
                case KeyEvent.VK_W:
                    running = true;
                    direction = 'U';
                    break;
                case KeyEvent.VK_S:
                    running = true;
                    direction = 'D';
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_D:
                    if(direction == 'R') {
                        running = false;
                    }
                    break;
                case KeyEvent.VK_A:
                    if(direction == 'L') {
                        running = false;
                    }
                    break;
                case KeyEvent.VK_W:
                    if(direction == 'U') {
                        running = false;
                    }
                    break;
                case KeyEvent.VK_S:
                    if(direction == 'D') {
                        running = false;
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
