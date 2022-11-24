package controller;

import controller.bullet_move.StraightNormalBullet;
import controller.bullet_move.boss1.Boss1StraightBullet;
import gui.GamePanel;
import manager.GameManager;
import model.*;
import view.Boss1View;
import view.BulletView;
import view.GameView;

public class Boss1Controller extends EnemyController {

    private int directionX = 1;
    private int directionY = 1;
    private int bulletPeriod = 0;

    public Boss1Controller(int x, int y, Boss1View boss1View) {
        this(x, y, new Boss1Model(x, y), boss1View);
    }

    public Boss1Controller(int x, int y, GameModel model, GameView view) {
        super(x, y, view, PlaneModel.PLANE_BOTH_ID, EnemyModel.BOSS1_ID);
        this.model = model;
        this.view = view;
    }

    @Override
    public void runForBoss() {
        bulletPeriod++;
        if(bulletPeriod >= Boss1Model.BULLET_PERIOD) {
            bulletPeriod = 0;
            GameManager.controllerManager.add(
                    new BulletController(model.getX(), model.getY() + model.getHeight(), this, PlaneModel.PLANE_BOTH_ID, new BulletView(BulletModel.getBulletUrl(PlaneModel.PLANE_BOTH_ID)), new Boss1StraightBullet())
            );
        }
        if(directionX == 1) {
            if(model.getX() + model.getSpeed() <= GamePanel.SCREEN_WIDTH - model.getWidth()) {
                model.setX(model.getX() + model.getSpeed());
            } else {
                directionX = -1;
                model.setX(model.getX() - model.getSpeed());
            }
        } else {
            if(model.getX() - model.getSpeed() >= 0) {
                model.setX(model.getX() - model.getSpeed());
            } else {
                directionX = 1;
                model.setX(model.getX() + model.getSpeed());
            }
        }

        if(directionY == 1) {
            if(model.getY() + model.getSpeed() <= GamePanel.SCREEN_HEIGHT * 0.6 - model.getHeight()) {
                model.setY(model.getY() + model.getSpeed());
            } else {
                directionY = -1;
                model.setY(model.getY() - model.getSpeed());
            }
        } else {
            if(model.getY() - model.getSpeed() >= 0) {
                model.setY(model.getY() - model.getSpeed());
            } else {
                directionY = 1;
                model.setY(model.getY() + model.getSpeed());
            }
        }
    }
}
