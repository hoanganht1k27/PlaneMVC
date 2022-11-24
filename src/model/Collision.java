package model;

public interface Collision {
    public GameModel getModel();
    public void onContact(Collision other);
}
