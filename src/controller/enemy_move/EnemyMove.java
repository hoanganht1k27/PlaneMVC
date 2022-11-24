package controller.enemy_move;

import model.GameModel;

public interface EnemyMove {
    public void move(int x, int y, int speed, GameModel model);
}
