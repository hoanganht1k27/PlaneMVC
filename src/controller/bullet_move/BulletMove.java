package controller.bullet_move;

import model.GameModel;

public interface BulletMove {
    public void move(int x, int y, int speed, GameModel model);
}
