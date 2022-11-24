package controller;

import model.GameModel;
import model.MapModel;
import view.GameView;
import view.MapView;

public class MapController extends GameController{
    public MapController(int x, int y, int width, int height, int speed, GameView view) {
        this(new MapModel(x, y, width, height, speed), view);
    }

    public MapController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        model.setY(model.getY() + model.getSpeed());
    }
}
