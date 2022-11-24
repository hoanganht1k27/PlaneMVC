package controller.bullet_move;

import model.GameModel;

public class LeftNormalBullet implements BulletMove{
    @Override
    public void move(int x, int y, int speed, GameModel model) {
        model.setX(x - 1);
        model.setY(y - speed);
    }
}
