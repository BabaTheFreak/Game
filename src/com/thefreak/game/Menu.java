package com.thefreak.game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    //private Game game;
    private Handler handler;
    private Random random = new Random();
    private HUD hud;

    public Menu(Game game, Handler handler, HUD hud) {
        //this.game = game;
        this.handler = handler;
        this.hud = hud;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        int mx = event.getX();
        int my = event.getY();

        //play button
        if (Game.gameState == Game.STATE.Menu) {
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                Game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }

            //help button
            if (mouseOver(my, my, 210, 250, 200, 64)) {
                Game.gameState = Game.STATE.Help;
            }


            //quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }

        //back button for help
        if (Game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                Game.gameState = Game.STATE.Menu;
            }
        }

        //new game button
        if (Game.gameState == Game.STATE.End) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                Game.gameState = Game.STATE.Game;
                hud.setLevel(1);
                hud.setScore(0);
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        return mx > x && mx < x + width && my > y && my < y + height;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 20);
        if (Game.gameState == Game.STATE.Menu) {


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Dots", 240, 70);

            g.setFont(fnt2);
            g.setColor(Color.green);
            g.drawString("PLAY", 270, 190);

            g.setColor(Color.green);
            g.drawString("HELP", 270, 290);

            g.setColor(Color.red);
            g.drawString("QUIT", 270, 390);

            g.setColor(Color.white);
            g.drawRect(210, 150, 200, 64);

            g.setColor(Color.white);
            g.drawRect(210, 250, 200, 64);

            g.setColor(Color.white);
            g.drawRect(210, 350, 200, 64);
        } else if (Game.gameState == Game.STATE.Help) {
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("back", 270, 390);

            g.setFont(fnt3);
            g.setColor(Color.yellow);
            g.drawString("Use WASD keys to move player and dodge enemies", 70, 200);
        } else if (Game.gameState == Game.STATE.End) {
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 180, 70);

            g.setFont(fnt3);
            g.setColor(Color.yellow);
            g.drawString("You lost with a score of: " + hud.getScore(), 170, 200);

            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Try Again", 245, 390);
        }
    }
}
