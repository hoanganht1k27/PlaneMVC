package manager;

import gui.GamePanel;

import javax.swing.*;
import java.awt.*;

public class GameManager {
    public static JPanel gamePanel;
    public static ControllerManager controllerManager;
    public static CollisionManager collisionManager;
    public GameManager(JPanel gamePanel) {
        this.gamePanel = gamePanel;
        collisionManager = new CollisionManager();
        controllerManager = new ControllerManager();
    }

    private static boolean running = true;

    public static void gameOver() {
        running = false;
    }

    public void run() {
        if(!running) return;
        controllerManager.run();
        collisionManager.run();
    }

    public void draw(Graphics g) {
        controllerManager.draw(g);
        collisionManager.draw(g);
    }
}
