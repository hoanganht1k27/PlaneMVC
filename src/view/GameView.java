package view;

import model.GameModel;
import util.Utils;

import java.awt.*;

public class GameView {
    protected Image image;

    public GameView(Image image) {
        this.image = image;
    }

    public GameView(String url) {
        this.image = Utils.loadImageFromRes(url);
    }
    public GameView() {

    }

    public void draw(Graphics g, GameModel model) {
        g.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeight(), null);
    }
}
