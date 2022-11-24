package manager;

import model.Collision;
import util.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CollisionManager {
    private List<Collision> collisions = new ArrayList<>();
    public CollisionManager() {

    }

    public void add(Collision collision) {
        collisions.add(collision);
    }
    public void run() {
        for(Collision cx : collisions) {
            for(Collision cy : collisions) {
                Rectangle rx = cx.getModel().getRect();
                Rectangle ry = cy.getModel().getRect();
                if(rx.intersects(ry)) {
                    cx.onContact(cy);
                }
            }
        }
        refill();
    }

    private void refill() {
        List<Collision> keep = new ArrayList<>();
        for(Collision c : collisions) {
            if(c.getModel().isAlive() && !Utils.outOfGamePanel(c.getModel().getRect())) {
                keep.add(c);
            }
        }
        collisions = keep;
    }

    public void draw(Graphics g) {

    }
}
