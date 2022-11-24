package manager;

import controller.Boss1Controller;
import controller.EnemyController;
import controller.GameController;
import view.Boss1View;
import view.GameView;

import java.awt.*;

public class BossManager {

    private int level = 0;
    private final int[] SHOW_BOSS_SCORE = {1, 10000, 1000000};
    private boolean bossing = false;
    private GameController boss;

    private boolean justKilled = false;

    public boolean isJustKilled() {
        return justKilled;
    }

    public void setJustKilled(boolean justKilled) {
        this.justKilled = justKilled;
    }

    public void run() {
        boss.run();
        if(bossing && !boss.isAlive()) {
            justKilled = true;
            bossing = false;
            boss = null;
        }
    }

    public void draw(Graphics g) {
        if(boss == null) return;
        boss.draw(g);
    }

    public BossManager() {

    }

    public int showBossScore() {
        return SHOW_BOSS_SCORE[level];
    }

    private void increaseLevel() {
        level++;
    }

    public int getLevel() {
        return level;
    }

    public boolean isBossing() {
        return bossing;
    }

    public void setBossing(boolean b) {
        this.bossing = b;
    }

    public void createNewBoss() {
        switch (level) {
            case 0:
                boss = new Boss1Controller(50, 50, new Boss1View("boss/boss1.png"));
                break;

        }

        increaseLevel();
    }

}
