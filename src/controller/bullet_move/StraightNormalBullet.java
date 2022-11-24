package controller.bullet_move;

import model.GameModel;

public class StraightNormalBullet implements BulletMove{
    @Override
    public void move(int x, int y, int speed, GameModel model) {
        model.setY(y - speed);
    }
}
