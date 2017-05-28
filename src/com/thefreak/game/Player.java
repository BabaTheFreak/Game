package com.thefreak.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random random = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((int) x, 0, Game.WIDTH - 37);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 60);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.white, 32, 32, 0.06f, handler));

        collision();
    }

    private void collision() {
        for(int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getID() == ID.BasicEnemy
                    || tempObject.getID() == ID.FastEnemy
                    || tempObject.getID() == ID.SmartEnemy) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }


}
