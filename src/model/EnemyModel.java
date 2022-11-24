package model;

public class EnemyModel extends GameModel{
    public static final int NORMAL_ENEMY_STRAIGHT = 1;
    public static final int NORMAL_ENEMY_LEFT = 2;
    public static final int NORMAL_ENEMY_RIGHT = 3;
    public static final int NORMAL_ENEMY_FULL_BLOOD = 10;

    public static final int NORMAL_ENEMY_WIDTH = 32;
    public static final int NORMAL_ENEMY_HEIGHT = 32;
    public static final int NORMAL_ENEMY_SPEED = 1;
    public static final String NORMAL_ENEMY_STRAIGHT_URL = "enemy/normal_enemy.png";
    public static final String NORMAL_ENEMY_LEFT_URL = "enemy/enemy_green.png";
    public static final String NORMAL_ENEMY_RIGHT_URL = "enemy/enemy_pink.png";
    public static final int NORMAL_ENEMY_SCORE = 1;

    public static final int BOSS1_ID = 6;
    public static final int BOSS1_SCORE = 100;

    private int planeId;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public EnemyModel(int x, int y, int width, int height, int speed, int planeId, int score) {
        super(x, y,width, height, speed);
        this.planeId = planeId;
        this.score = score;
    }
}
