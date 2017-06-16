package me.max.squared;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static me.max.squared.Game.isMac;
import static me.max.squared.Game.isUnix;
import static me.max.squared.Game.isWindows;

/**
 * Created by max on 4-6-2017.
 */
public class DataSaving {

    File f;

    public void tick() throws IOException {


        Datas data;

        data = new Datas();
        data.coins = HUD.coins;
        data.highscore = HUD.highScore;
        if (MenuShop.skinSTATE == MenuShop.SkinSTATE.White){
            data.skinstate = 1;
        } else if (MenuShop.skinSTATE == MenuShop.SkinSTATE.Red){
            data.skinstate = 2;
        } else if (MenuShop.skinSTATE == MenuShop.SkinSTATE.Blue){
            data.skinstate = 3;
        } else if (MenuShop.skinSTATE == MenuShop.SkinSTATE.Green){
            data.skinstate = 4;
        } else if (MenuShop.skinSTATE == MenuShop.SkinSTATE.Yellow){
            data.skinstate = 5;
        } else if (MenuShop.skinSTATE == MenuShop.SkinSTATE.Orange){
            data.skinstate = 6;
        } else if (MenuShop.skinSTATE == MenuShop.SkinSTATE.Pink){
            data.skinstate = 7;
        } else if (MenuShop.skinSTATE == MenuShop.SkinSTATE.Gray){
            data.skinstate = 8;
        }
        data.currentSkin = MenuShop.currentSkin;
        data.purchasedUpgrades = MenuShop.purchasedUpgrades;
        data.purchasedSkins = MenuShop.purchasedSkins;

        if (isWindows()){
            File f = new File(System.getenv("APPDATA") + "\\.squared\\data.dat");
            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            if (!(f.exists())) {
                data.purchasedSkins.add(MenuShop.SkinSTATE.White);
                data.purchasedUpgrades.add(MenuShop.StoreUpgrades.none);
                f.createNewFile();
            }
            try {
                FileOutputStream fout = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(data);
                oos.close();
            }
            catch (Exception e) { e.printStackTrace(); }
        }

        else if (isMac() || isUnix()) {
            File f = new File("~\\Application Support\\.squared\\data.dat");
            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            if (!(f.exists())) {
                data.purchasedSkins.add(MenuShop.SkinSTATE.White);
                data.purchasedUpgrades.add(MenuShop.StoreUpgrades.none);
                f.createNewFile();
            }
            try {
                FileOutputStream fout = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(data);
                oos.close();
            }
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}