package me.max.simplefirstgame;

import java.awt.*;
import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class Player extends GameObject{

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public void tick() {
        x += velX;
        y += velY;


        x = Game.clamp(x, 0, Game.WIDTH - 39);
        y = Game.clamp(y, 0, Game.HEIGHT - 62);

        collision();

        handler.addObject(new Trial(x, y, ID.Trial, Color.white, 32, 32, 0.09f, handler));

    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy){

                if (getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }

            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
