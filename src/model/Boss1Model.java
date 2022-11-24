package model;

public class Boss1Model extends EnemyModel{
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int SPEED = 1;
    public static final int SCORE = 100;
    public static final int FULL_BLOOD = 10;
    public static final int BULLET_PERIOD = 20;
    public Boss1Model(int x, int y) {
        super(x, y, WIDTH, HEIGHT, SPEED, PlaneModel.PLANE_BOTH_ID, SCORE);
    }
}
