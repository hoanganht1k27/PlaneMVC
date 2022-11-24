import gui.GamePanel;

import javax.swing.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Plane MVC");
        gamePanel = new GamePanel();
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        gamePanel.startGameThread();
    }

}
