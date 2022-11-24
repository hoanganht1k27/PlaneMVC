package manager;

import controller.BonusController;
import controller.GameController;
import controller.MapController;
import model.BonusModel;
import util.Utils;
import view.BonusView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerManager {
    private PlaneManager planeManager;
    private EnemyManager enemyManager;
    private BossManager bossManager;
    private MapManager mapManager;
    private List<GameController> controllers = new ArrayList<>();
    private int bonusLevel = 0;
    private int enemyLevel = 0;
    public ControllerManager() {
        planeManager = new PlaneManager();
        enemyManager = new EnemyManager();
        bossManager = new BossManager();
        mapManager = new MapManager();
    }

    public void add(GameController controller) {
        controllers.add(controller);
    }

    public void run() {
        mapManager.run();
        if(bonusLevel < BonusModel.BONUS_SHOW_SCORE.length && PlaneManager.getScore() >= BonusModel.BONUS_SHOW_SCORE[bonusLevel]) {
            bonusLevel++;
            GameManager.controllerManager.add(new BonusController(Utils.getRandomX(BonusModel.WIDTH), -BonusModel.HEIGHT, new BonusView(BonusModel.BONUS_IMAGE_URL)));
        }

        if(enemyLevel < BonusModel.BONUS_SHOW_SCORE.length && PlaneManager.getScore() >= BonusModel.BONUS_SHOW_SCORE[enemyLevel] + 4) {
            enemyLevel++;
            enemyManager.increaseLevel();
        }
        planeManager.run();
        if(!bossManager.isBossing()) {
            enemyManager.run();
        } else {
            bossManager.run();
        }
        for(GameController controller : controllers) {
            controller.run();
        }
        refill();
        if(planeManager.getScore() >= bossManager.showBossScore()) {
            bossManager.createNewBoss();
            enemyManager.clearAllEnemies();
            bossManager.setBossing(true);
        }
    }

    private void refill() {
        List<GameController> keep = new ArrayList<>();
        for(GameController controller : controllers) {
            if(!Utils.outOfGamePanel(controller.getModel().getRect())) {
                keep.add(controller);
            }
        }
        controllers = keep;
    }

    public void draw(Graphics g) {
        mapManager.draw(g);
        planeManager.draw(g);
        if(!bossManager.isBossing()) {
            enemyManager.draw(g);
        } else {
            bossManager.draw(g);
        }
        for(GameController controller : controllers) {
            controller.draw(g);
        }
    }
}
