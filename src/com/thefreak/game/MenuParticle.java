package com.thefreak.game;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;
    private Random random = new Random();

    private Color color;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;


        velX = (random.nextInt(7 - -7) + -7);
        velY = (random.nextInt(7 - -7) + -7);
        if (velX == 0) {
            velX = (random.nextInt(5 - -5) + -5);
        }
        if (velY == 0) {
            velY = (random.nextInt(5 - -5) + -5);
        }

        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 48) {
            velY *= -1;
        }

        if (x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, color, 16, 16, 0.03f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}
