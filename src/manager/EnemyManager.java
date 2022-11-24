package manager;

import controller.EnemyController;
import controller.GameController;
import gui.GamePanel;
import model.EnemyModel;
import model.PlaneModel;
import view.EnemyView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static util.Utils.getRandomX;

public class EnemyManager {
    private List<GameController> controllers = new ArrayList<>();
    private int enemyLevel = 1;
    public EnemyManager() {
//        controllers.add(new EnemyController(200, 0, new EnemyView(EnemyModel.NORMAL_ENEMY_LEFT_URL), PlaneModel.PLANE_ID_1, EnemyModel.NORMAL_ENEMY_LEFT));
        controllers.add(new EnemyController(200, 0, new EnemyView(EnemyModel.NORMAL_ENEMY_STRAIGHT_URL), PlaneModel.PLANE_ID_1, EnemyModel.NORMAL_ENEMY_STRAIGHT));
    }

    private void refill() {
        List<GameController> keep = new ArrayList<>();
        for(GameController controller : controllers) {
            if(controller.isAlive()) {
                keep.add(controller);
            }
        }

        for(int i = keep.size() + 1; i <= enemyLevel; i++) {
            keep.add(new EnemyController(getRandomX(EnemyModel.NORMAL_ENEMY_WIDTH), 0, new EnemyView(EnemyModel.NORMAL_ENEMY_STRAIGHT_URL), PlaneModel.PLANE_ID_1, EnemyModel.NORMAL_ENEMY_STRAIGHT));
        }

        controllers = keep;

    }

    public void increaseLevel() {
        enemyLevel++;
    }

    public void clearAllEnemies() {
        for(GameController controller : controllers) {
            controller.getModel().setAlive(false);
        }

        controllers.clear();
    }

    public void run() {
        for(GameController controller : controllers) {
            controller.run();
        }
        refill();
    }

    public void draw(Graphics g) {
        for(GameController controller : controllers) {
            controller.draw(g);
        }
    }
}
