package me.max.simplefirstgame;

import java.util.Random;

/**
 * Created by max on 25-5-2017.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;

    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep ++;

        if (scoreKeep >= 250){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 1){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }
            if (hud.getLevel() == 2){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }
            if (hud.getLevel() == 3){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }
            if (hud.getLevel() == 4){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.BasicEnemy, handler));
            }
        }

    }

}
