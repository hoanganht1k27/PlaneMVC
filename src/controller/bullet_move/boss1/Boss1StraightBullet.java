package controller.bullet_move.boss1;

import controller.bullet_move.BulletMove;
import model.GameModel;

public class Boss1StraightBullet implements BulletMove {
    @Override
    public void move(int x, int y, int speed, GameModel model) {
        model.setY(y + speed);
    }
}
