package com.thefreak.game;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random random = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep >= 300) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            } else if(hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            } else if(hud.getLevel() == 4) {
                handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            } else if(hud.getLevel() == 5) {
                handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 6) {
                handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 7) {
                handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 10) {
                handler.clearEnemys();
                handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
            }
        }
    }
}
