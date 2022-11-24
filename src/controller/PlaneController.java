package controller;

import controller.bullet_move.LeftNormalBullet;
import controller.bullet_move.RightNormalBullet;
import controller.bullet_move.StraightNormalBullet;
import controller.bullet_move.boss1.Boss1StraightBullet;
import gui.GamePanel;
import manager.GameManager;
import model.*;
import view.BulletView;
import view.GameView;
import view.PlaneView;

public class PlaneController extends GameController implements Collision {

    private int bulletPeriod = 0;

    public PlaneController(int x, int y, int planeId, PlaneView planeView) {
        this(new PlaneModel(x, y, planeId), planeView);
        GameManager.collisionManager.add(this);
    }

    public PlaneController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onContact(Collision other) {
        if(other instanceof BonusController) {
            ((PlaneModel) model).addBulletLevel();
            other.getModel().setAlive(false);
        }
    }

    private void checkCollision() {
        if(((PlaneModel) model).isRunningL()) {
            if(model.getX() >= model.getSpeed()) {
                model.setX(model.getX() - model.getSpeed());
            }
        }
        if(((PlaneModel) model).isRunningR()) {
            if(model.getX() + model.getSpeed() + model.getWidth() <= GamePanel.SCREEN_WIDTH) {
                model.setX(model.getX() + model.getSpeed());
            }
        }
        if(((PlaneModel) model).isRunningU()) {
            if(model.getY() >= model.getSpeed()) {
                model.setY(model.getY() - model.getSpeed());
            }
        }
        if(((PlaneModel) model).isRunningD()) {
            if(model.getY() + model.getSpeed() + model.getHeight() <= GamePanel.SCREEN_HEIGHT) {
                model.setY(model.getY() + model.getSpeed());
            }
        }
    }

    @Override
    public void run() {
        if(model instanceof PlaneModel) {
//            if(((PlaneModel) model).isRunning() && checkCollision()) {
//                if(((PlaneModel) model).getDirection() == 'L') {
//                    model.setX(model.getX() - model.getSpeed());
//                } else if(((PlaneModel) model).getDirection() == 'R') {
//                    model.setX(model.getX() + model.getSpeed());
//                } else if(((PlaneModel) model).getDirection() == 'U') {
//                    model.setY(model.getY() - model.getSpeed());
//                } else if(((PlaneModel) model).getDirection() == 'D') {
//                    model.setY(model.getY() + model.getSpeed());
//                }
//            }
//            if(checkCollision()) {
//                if(((PlaneModel) model).isRunningL()) {
//                    model.setX(model.getX() - model.getSpeed());
//                }
//                if(((PlaneModel) model).isRunningR()) {
//                    model.setX(model.getX() + model.getSpeed());
//                }
//                if(((PlaneModel) model).isRunningU()) {
//                    model.setY(model.getY() - model.getSpeed());
//                }
//                if(((PlaneModel) model).isRunningD()) {
//                    model.setY(model.getY() + model.getSpeed());
//                }
//            }
            checkCollision();

            bulletPeriod++;
            if(bulletPeriod >= PlaneModel.BULLET_PERIOD) {
                bulletPeriod = 0;
                genNewBulletLayer();
//                int planeId = ((PlaneModel) model).getPlaneId();
//                GameManager.controllerManager.add(new BulletController(model.getX(), model.getY() - 10, this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
            }
        }
    }

    private void genNewBulletLayer() {
        int bulletLevel = ((PlaneModel) model).getBulletLevel();
        int planeId = ((PlaneModel) model).getPlaneId();
        int[] idx = new int[bulletLevel];
        int[] idy = new int[bulletLevel];

        if(bulletLevel % 2 == 0) {
            int startX = model.getX() + model.getWidth() / 2 - BulletModel.BULLET_SPACE / 2 - BulletModel.WIDTH;
            int startY = model.getY() - BulletModel.HEIGHT;

            for(int i = 1; i <= bulletLevel; i++) {
                int bulletX = startX - (bulletLevel / 2 - i) * (BulletModel.BULLET_SPACE + BulletModel.WIDTH);
                idx[i - 1] = bulletX;
                idy[i - 1] = startY;
            }
        } else {
            int startX = model.getX() + model.getWidth() / 2 - BulletModel.WIDTH / 2;
            int startY = model.getY() - BulletModel.HEIGHT;

            for(int i = 1; i <= bulletLevel; i++) {
                int bulletX = startX - (bulletLevel / 2 - i + 1) * (BulletModel.BULLET_SPACE + BulletModel.WIDTH);
                idx[i - 1] = bulletX;
                idy[i - 1] = startY;
            }
        }
        switch (bulletLevel) {
            case 1:
                GameManager.controllerManager.add(new BulletController(idx[0], idy[0], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                break;
            case 2:
                GameManager.controllerManager.add(new BulletController(idx[0], idy[0], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                GameManager.controllerManager.add(new BulletController(idx[1], idy[1], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                break;
            case 3:
                GameManager.controllerManager.add(new BulletController(idx[0], idy[0], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                GameManager.controllerManager.add(new BulletController(idx[1], idy[1], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                GameManager.controllerManager.add(new BulletController(idx[2], idy[2], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                break;
            case 4:
                GameManager.controllerManager.add(new BulletController(idx[0], idy[0], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new LeftNormalBullet()));
                GameManager.controllerManager.add(new BulletController(idx[1], idy[1], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                GameManager.controllerManager.add(new BulletController(idx[2], idy[2], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new StraightNormalBullet()));
                GameManager.controllerManager.add(new BulletController(idx[3], idy[3], this, planeId, new BulletView(BulletModel.getBulletUrl(planeId)), new RightNormalBullet()));
                break;


        }
    }
}
