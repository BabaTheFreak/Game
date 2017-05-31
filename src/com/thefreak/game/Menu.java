package com.thefreak.game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random random = new Random();

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        int mx = event.getX();
        int my = event.getY();

        //play button
        if (mouseOver(mx, my, 210, 150, 200, 64) && game.gameState == Game.STATE.Menu) {
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH - 50), random.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        }

        //help button
        if (mouseOver(my, my, 210, 250, 200, 64) && game.gameState == Game.STATE.Menu) {
            game.gameState = Game.STATE.Help;
        }

        //quit button
        if (mouseOver(mx, my, 210, 350, 200, 64) && game.gameState == Game.STATE.Menu) {
            System.exit(1);
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
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        if (game.gameState == Game.STATE.Menu) {


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

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
        } else if (game.gameState == Game.STATE.Help) {
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);
        }


    }

}
