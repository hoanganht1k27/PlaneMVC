package controller;

import controller.enemy_move.EnemyMove;
import gui.GamePanel;
import manager.GameManager;
import model.*;
import view.BloodView;
import view.EnemyView;
import view.GameView;

import java.awt.*;

public class EnemyController extends GameController implements Collision {

    private BloodController bloodController;
    private int enemyId;

    public EnemyController(int x, int y, GameView enemyView, int planeId, int enemyId) {
        switch (enemyId) {
            case EnemyModel.NORMAL_ENEMY_STRAIGHT:
            case EnemyModel.NORMAL_ENEMY_LEFT:
            case EnemyModel.NORMAL_ENEMY_RIGHT:
                create(new EnemyModel(x, y, EnemyModel.NORMAL_ENEMY_WIDTH, EnemyModel.NORMAL_ENEMY_HEIGHT, EnemyModel.NORMAL_ENEMY_SPEED, planeId, EnemyModel.NORMAL_ENEMY_SCORE), enemyView);
                bloodController = new BloodController(x, y - 10, EnemyModel.NORMAL_ENEMY_WIDTH, 5, EnemyModel.NORMAL_ENEMY_FULL_BLOOD, new BloodView(), this);
                break;
            case EnemyModel.BOSS1_ID:
                create(new EnemyModel(x, y, Boss1Model.WIDTH, Boss1Model.HEIGHT, Boss1Model.SPEED, PlaneModel.PLANE_BOTH_ID, Boss1Model.SCORE), enemyView);
                bloodController = new BloodController(x, y - 10, Boss1Model.WIDTH, 5, Boss1Model.FULL_BLOOD, new BloodView(), this);
                break;
        }

        GameManager.collisionManager.add(this);
        this.enemyId = enemyId;
    }

    private void create(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        switch (enemyId) {
            case EnemyModel.NORMAL_ENEMY_STRAIGHT:
                model.setY(model.getY() + model.getSpeed());
                break;
            case EnemyModel.NORMAL_ENEMY_LEFT:
                model.setX(model.getX() - 1);
                model.setY(model.getY() + model.getSpeed());
                break;
            case EnemyModel.NORMAL_ENEMY_RIGHT:
                model.setX(model.getX() + 1);
                model.setY(model.getY() + model.getSpeed());
                break;
            case EnemyModel.BOSS1_ID:
                runForBoss();
                break;
        }
        bloodController.run();
        checkCollision();
    }

    private void checkCollision() {
        if(model.getY() + model.getHeight() >= GamePanel.SCREEN_HEIGHT) {
            GameManager.gameOver();
        }
    }

    protected void runForBoss() {

    }

    public void getHit(int dam) {
        bloodController.getHit(dam);
    }

    public boolean die() {
        if(bloodController.die()) {
            model.setAlive(false);
            return true;
        }
        return false;
    }

    public int getScore() {
        return ((EnemyModel) model).getScore();
    }

    @Override
    public void onContact(Collision other) {
        if(other instanceof PlaneController) {
            GameManager.gameOver();
        }
    }

    @Override
    public void draw(Graphics g) {
        if(!isAlive()) return;
        view.draw(g, model);
        bloodController.draw(g);
    }
}
