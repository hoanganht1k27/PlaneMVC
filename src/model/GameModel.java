package model;

import java.awt.*;

public class GameModel {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;
    protected boolean alive = true;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    protected GameModel(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
