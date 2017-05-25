package com.thefreak.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random random = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        if (id == ID.Player) {
            g.setColor(Color.white);
        } else {
            g.setColor(Color.yellow);
        }

        g.fillRect(x, y, 32, 32);
    }
}
