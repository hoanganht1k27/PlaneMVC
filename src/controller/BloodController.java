package controller;

import gui.GamePanel;
import model.BloodModel;
import model.GameModel;
import view.BloodView;
import view.GameView;

import java.awt.*;

public class BloodController extends GameController{
    private GameController controller;
    public BloodController(int x, int y, int width, int height, int fullBlood, BloodView bloodView, GameController controller) {
        this(new BloodModel(x, y, width, height, fullBlood), bloodView);
        this.controller = controller;
    }

    public BloodController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        model.setX(controller.getModel().getX());
        model.setY(controller.getModel().getY() - 10);
        int fullBlood = ((BloodModel) model).getFullBlood();
        int curBlood = ((BloodModel) model).getCurBlood();
        if(curBlood <= fullBlood * 0.75) ((BloodModel) model).setColor(Color.yellow);
        if(curBlood <= fullBlood * 0.25) ((BloodModel) model).setColor(Color.red);
        model.setWidth(controller.getModel().getWidth() * curBlood / fullBlood);
    }

    public void getHit(int dam) {
        ((BloodModel) model).getHit(dam);
    }
    public boolean die() {
        return ((BloodModel) model).getCurBlood() <= 0;
    }
}
