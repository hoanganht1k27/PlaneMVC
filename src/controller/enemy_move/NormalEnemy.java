package controller.enemy_move;

import model.GameModel;

public class NormalEnemy implements EnemyMove{
    public static final int FULL_BLOOD = 10;
    @Override
    public void move(int x, int y, int speed, GameModel model) {
        model.setY(y + speed);
    }
}
