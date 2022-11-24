package model;

public class BulletModel extends GameModel{
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    public static final int SPEED = 3;
    public static final String BULLET_URL_PLANE_1 = "bullet/bullet_1.png";
    public static final String BULLET_URL_BOSS_1 = "bullet/boss1_bullet.png";
    public static final int BULLET_SPACE = 4;
    private int planeId;

    public BulletModel(int x, int y, int planeId) {
        super(x, y, WIDTH, HEIGHT, SPEED);
        this.planeId = planeId;
    }
    public static String getBulletUrl(int planeId) {
        switch (planeId) {
            case PlaneModel.PLANE_ID_1:
                return BULLET_URL_PLANE_1;
            case PlaneModel.PLANE_BOTH_ID:
                return BULLET_URL_BOSS_1;
            default:
                return "";

        }
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }
}
