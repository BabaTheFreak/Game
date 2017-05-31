package com.thefreak.game;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    public void clearEnemys() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            if (tempObject.getID() == ID.Player) {
                objects.clear();
                addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
            }
        }
    }
}
