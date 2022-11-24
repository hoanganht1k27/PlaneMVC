package controller;

import manager.GameManager;
import model.BonusModel;
import model.Collision;
import model.GameModel;
import view.GameView;

public class BonusController extends GameController implements Collision {

    public BonusController(int x, int y, GameView view) {
        this(new BonusModel(x, y), view);
        GameManager.collisionManager.add(this);
    }

    public BonusController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        model.setY(model.getY() + model.getSpeed());
    }
    @Override
    public void onContact(Collision other) {

    }
}
