package manager;

import controller.GameController;
import controller.MapController;
import util.Utils;
import view.MapView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapManager {
    public static final int MAP1_WIDTH = 400;
    public static final int MAP1_HEIGHT = 770;
    public static final int MAP1_SPEED = 1;
    public static final String MAP1_URL = "map/background2.jpg";

    private List<GameController> controllers = new ArrayList<>();

    public MapManager() {
        controllers.add(new MapController(0, 0, MAP1_WIDTH, MAP1_HEIGHT, MAP1_SPEED, new MapView(MAP1_URL)));
        controllers.add(new MapController(0, -MAP1_HEIGHT, MAP1_WIDTH, MAP1_HEIGHT, MAP1_SPEED, new MapView(MAP1_URL)));
    }

    public void run() {
        for(GameController controller : controllers) {
            controller.run();
        }

        for(GameController controller : controllers) {
            if(controller.getModel().getY() >= MAP1_HEIGHT) {
                controller.getModel().setY(-MAP1_HEIGHT);
            }
        }
    }

    public void draw(Graphics g) {
        for(GameController controller : controllers) {
            controller.draw(g);
        }
    }


}
