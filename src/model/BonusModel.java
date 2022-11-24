package model;

public class BonusModel extends GameModel{
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    public static final int SPEED = 3;
    public static final int[] BONUS_SHOW_SCORE = {1, 103, 110};
    public static final String BONUS_IMAGE_URL = "bonus/bonus.png";
    public BonusModel(int x, int y) {
        super(x, y, WIDTH, HEIGHT, SPEED);
    }
}
