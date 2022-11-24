package gui;

import manager.GameManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public static final int THREAD_PERIOD = 30;
    public static final int SCREEN_WIDTH = 400;
    public static final int SCREEN_HEIGHT = 400;

    private Thread gameThread;

    private GameManager gameManager;
    private boolean running = true;

    public GamePanel() {
        gameManager = new GameManager(this);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // rendering better
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null) {
            if(running) {
                gameManager.run();
                repaint();
            } else {
                gameThread = null;
            }

            try {
                Thread.sleep(THREAD_PERIOD);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameManager.draw(g);
    }
}
