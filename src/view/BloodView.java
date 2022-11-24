package view;

import model.BloodModel;
import model.GameModel;

import java.awt.*;

public class BloodView extends GameView{
    public BloodView(Image image) {
        super(image);
    }

    public BloodView(String url) {
        super(url);
    }

    public BloodView() {
        super();
    }

    @Override
    public void draw(Graphics g, GameModel model) {
        g.setColor(((BloodModel) model).getColor());
        g.fillRect(model.getX(), model.getY(), model.getWidth(), model.getHeight());
    }
}
