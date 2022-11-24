package manager;

import controller.BonusController;
import controller.GameController;
import controller.PlaneController;
import gui.GamePanel;
import model.BonusModel;
import model.PlaneModel;
import util.Utils;
import view.BonusView;
import view.PlaneView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlaneManager {
    private List<GameController> controllers = new ArrayList<>();
    private static int score = 0;
    public PlaneManager() {
        controllers.add(new PlaneController(100, GamePanel.SCREEN_HEIGHT - PlaneModel.HEIGHT, PlaneModel.PLANE_ID_1, new PlaneView(PlaneModel.PLANE_1_URL)));
//        controllers.add(new PlaneController(100, 100, PlaneModel.PLANE_ID_2, new PlaneView(PlaneModel.PLANE_2_URL)));
    }

    public static void addScore(int s) {
        score += s;
        System.out.println(score);
    }

    public static int getScore() {
        return score;
    }

    public void run() {
//        if(bonusLevel < BonusModel.BONUS_SHOW_SCORE.length && score >= BonusModel.BONUS_SHOW_SCORE[bonusLevel]) {
//            bonusLevel++;
//            GameManager.controllerManager.add(new BonusController(Utils.getRandomX(BonusModel.WIDTH), -BonusModel.HEIGHT, new BonusView(BonusModel.BONUS_IMAGE_URL)));
//        }
        for(GameController controller : controllers) {
            controller.run();
        }
    }

    public void draw(Graphics g) {
        g.setFont(new Font("Ink Free", Font.BOLD, 20));
        g.drawString("Score: " + score, 5, 15);
        for(GameController controller : controllers) {
            controller.draw(g);
        }
    }
}
