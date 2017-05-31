package com.thefreak.game;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    Random random = new Random();
    private Handler handler;

    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (random.nextInt(5 - -5) + -5);
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

//        if(y <= 0 || y >= Game.HEIGHT - 32) {
//            velY *= -1;
//        }
//
//        if(x <= 0 || x >= Game.WIDTH - 16) {
//            velX *= -1;
//        }

        if (y >= Game.HEIGHT) handler.removeObject(this);
        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.yellow, 16, 16, 0.03f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}
