package controller.bullet_move;

import model.GameModel;

public class RightNormalBullet implements BulletMove{
    @Override
    public void move(int x, int y, int speed, GameModel gameModel) {
        gameModel.setX(x + 1);
        gameModel.setY(y - speed);
    }
}
