package controller;

import controller.bullet_move.BulletMove;
import manager.GameManager;
import manager.PlaneManager;
import model.BulletModel;
import view.BulletView;
import model.Collision;
import model.GameModel;
import view.GameView;

public class BulletController extends GameController implements Collision {
    private GameController controller;
    private BulletMove bulletMove;


    public BulletController(int x, int y, GameController controller, int planeId, BulletView bulletView, BulletMove bulletMove) {
        this(new BulletModel(x, y, planeId), bulletView);
        this.controller = controller;
        this.bulletMove = bulletMove;
        GameManager.collisionManager.add(this);
    }

    public BulletController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        bulletMove.move(model.getX(), model.getY(), model.getSpeed(), model);
    }

    @Override
    public void onContact(Collision other) {
        if(other instanceof EnemyController) {
            if(controller instanceof PlaneController) {
                if(!model.isAlive()) return;
                if(!other.getModel().isAlive()) return;
                model.setAlive(false);
                ((EnemyController) other).getHit(1);
                if(((EnemyController) other).die()) {
                    PlaneManager.addScore(((EnemyController) other).getScore());
                }
            }
        }
    }
}
