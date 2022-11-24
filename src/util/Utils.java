package util;

import gui.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Utils {
    public static Image loadImageFromRes(String url) {
        try {
            Image image = ImageIO.read(new File("resources/" + url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int getRandomX(int width) {
        Random r = new Random();
        return r.nextInt(GamePanel.SCREEN_WIDTH - width);
    }

    public static boolean outOfGamePanel(Rectangle rectangle) {
        return !rectangle.intersects(new Rectangle(0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT));
    }
}
