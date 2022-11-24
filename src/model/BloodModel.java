package model;

import java.awt.*;

public class BloodModel extends GameModel{

    private int fullBlood;
    private int curBlood;
    private Color color = Color.green;

    public BloodModel(int x, int y, int width, int height, int fullBlood) {
        super(x, y, width, height, 0);
        this.fullBlood = fullBlood;
        this.curBlood = fullBlood;
    }

    public int getFullBlood() {
        return fullBlood;
    }

    public void setFullBlood(int fullBlood) {
        this.fullBlood = fullBlood;
    }

    public int getCurBlood() {
        return curBlood;
    }

    public void setCurBlood(int curBlood) {
        this.curBlood = curBlood;
    }
    public void getHit(int dam) {
        this.curBlood -= dam;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
