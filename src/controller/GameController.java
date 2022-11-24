package controller;

import model.GameModel;
import view.GameView;

import java.awt.*;

public class GameController{
    protected GameModel model;
    protected GameView view;

    public GameModel getModel() {
        return model;
    }

    public void run() {

    }

    public void draw(Graphics g) {
        if(!model.isAlive()) return;
        view.draw(g, model);
    }

    public boolean isAlive() {
        return model.isAlive();
    }

    public void setAlive(boolean alive) {
        model.setAlive(alive);
    }
}
