package me.max.squared.menus;

import me.max.squared.Game;
import me.max.squared.effects.GameEffect;
import me.max.squared.enums.ID;
import me.max.squared.handlers.main.EffectHandler;
import me.max.squared.handlers.main.Handler;
import me.max.squared.handlers.others.HUD;
import me.max.squared.handlers.others.KeyInput;
import me.max.squared.handlers.others.Spawn;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 4-6-2017.
 * © Copyright 2017 Max Berkelmans
 */
public class MenuShop extends MouseAdapter {

    public static SkinSTATE lookingSkinState = SkinSTATE.White;
    public static List<SkinSTATE> purchasedSkins = new ArrayList<>();
    public static SkinSTATE currentSkin = SkinSTATE.White;
    public static SkinSTATE skinSTATE = currentSkin;
    public static List<StoreUpgrades> purchasedUpgrades = new ArrayList<>();
    public static Color PlayerColor;
    private GameEffect speedEffect;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Color LookingColor;

    public MenuShop(Handler handler, HUD hud, Spawn spawner) {
        this.handler = handler;
        this.hud = hud;
        this.spawner = spawner;
    }

    public void mouseClicked(MouseEvent e) {
        if (Game.gameState == Game.STATE.MenuShop) {
            if (e.getButton() == 1) {
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, 25, 360, 20, 20)) {
                    if (lookingSkinState == SkinSTATE.Red) {
                        lookingSkinState = SkinSTATE.White;
                    } else if (lookingSkinState == SkinSTATE.Blue) {
                        lookingSkinState = SkinSTATE.Red;
                    } else if (lookingSkinState == SkinSTATE.Green) {
                        lookingSkinState = SkinSTATE.Blue;
                    } else if (lookingSkinState == SkinSTATE.Yellow) {
                        lookingSkinState = SkinSTATE.Green;
                    } else if (lookingSkinState == SkinSTATE.Orange) {
                        lookingSkinState = SkinSTATE.Yellow;
                    } else if (lookingSkinState == SkinSTATE.Pink) {
                        lookingSkinState = SkinSTATE.Orange;
                    } else if (lookingSkinState == SkinSTATE.Gray) {
                        lookingSkinState = SkinSTATE.Pink;
                    } else if (lookingSkinState == SkinSTATE.Yellow) {
                        lookingSkinState = SkinSTATE.Green;
                    } else if (lookingSkinState == SkinSTATE.Orange) {
                        lookingSkinState = SkinSTATE.Yellow;
                    } else if (lookingSkinState == SkinSTATE.Pink) {
                        lookingSkinState = SkinSTATE.Orange;
                    } else if (lookingSkinState == SkinSTATE.Gray) {
                        lookingSkinState = SkinSTATE.Pink;
                    }
                } else if (mouseOver(mx, my, 25 + 45 + 39, 360, 20, 20)) {
                    if (lookingSkinState == SkinSTATE.White) {
                        lookingSkinState = SkinSTATE.Red;
                    } else if (lookingSkinState == SkinSTATE.Red) {
                        lookingSkinState = SkinSTATE.Blue;
                    } else if (lookingSkinState == SkinSTATE.Blue) {
                        lookingSkinState = SkinSTATE.Green;
                    } else if (lookingSkinState == SkinSTATE.Green) {
                        lookingSkinState = SkinSTATE.Yellow;
                    } else if (lookingSkinState == SkinSTATE.Yellow) {
                        lookingSkinState = SkinSTATE.Orange;
                    } else if (lookingSkinState == SkinSTATE.Orange) {
                        lookingSkinState = SkinSTATE.Pink;
                    } else if (lookingSkinState == SkinSTATE.Pink) {
                        lookingSkinState = SkinSTATE.Gray;
                    }
                } else if (mouseOver(mx, my, 15, 100, 120, 60)) {
                    Game.gameState = Game.STATE.Menu;
                    lookingSkinState = SkinSTATE.White;
                } else if (!(purchasedSkins == null) && !(purchasedSkins.isEmpty()) && !(purchasedSkins.contains(lookingSkinState))) {
                    if (mouseOver(mx, my, 80, 390, 50, 20)) {
                        if (HUD.coins >= 50) {
                            purchasedSkins.add(lookingSkinState);
                            currentSkin = lookingSkinState;
                            HUD.coins -= 50;
                        }
                    }
                } else if (currentSkin == lookingSkinState && (purchasedSkins.contains(lookingSkinState))) {
                    if (mouseOver(mx, my, 25 + 20 + 4, 390, 55, 20)) {
                        currentSkin = SkinSTATE.White;
                    }
                } else if (!(purchasedSkins == null) && !(purchasedSkins.isEmpty()) && purchasedSkins.contains(lookingSkinState) && !(currentSkin == lookingSkinState)) {
                    if (mouseOver(mx, my, 25 + 20 + 7, 390, 50, 20)) {
                        currentSkin = lookingSkinState;
                    }
                }
                if (mouseOver(mx, my, 200, 221, 125, 81)) {
                    if (HUD.coins >= 25) {
                        if (!(purchasedUpgrades.contains(StoreUpgrades.Speed_3))) {
                            if (purchasedUpgrades.contains(StoreUpgrades.Speed_2)) {
                                purchasedUpgrades.add(StoreUpgrades.Speed_3);
                                KeyInput.playerSpeed = 6;
                            } else if (purchasedUpgrades.contains(StoreUpgrades.Speed_1)) {
                                purchasedUpgrades.add(StoreUpgrades.Speed_2);
                                KeyInput.playerSpeed = 5.5f;
                            } else {
                                purchasedUpgrades.add(StoreUpgrades.Speed_1);
                                KeyInput.playerSpeed = 5.25f;
                            }
                            HUD.coins -= 25;
                        }
                    }
                }

                if (mouseOver(mx, my, 200, 115, 125, 81)) {
                    if (HUD.coins >= 30) {
                        if (!(purchasedUpgrades.contains(StoreUpgrades.MoreCoins_5))) {
                            if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_4)) {
                                purchasedUpgrades.add(StoreUpgrades.MoreCoins_5);
                                spawner.setCoinChance(Spawn.getCoinChance() - 25);
                            } else if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_3)) {
                                purchasedUpgrades.add(StoreUpgrades.MoreCoins_4);
                                spawner.setCoinChance(Spawn.getCoinChance() - 25);
                            } else if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_2)) {
                                purchasedUpgrades.add(StoreUpgrades.MoreCoins_3);
                                spawner.setCoinChance(Spawn.getCoinChance() - 25);
                            } else if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_1)) {
                                purchasedUpgrades.add(StoreUpgrades.MoreCoins_2);
                                spawner.setCoinChance(Spawn.getCoinChance() - 25);
                            } else {
                                purchasedUpgrades.add(StoreUpgrades.MoreCoins_1);
                                spawner.setCoinChance(Spawn.getCoinChance() - 25);
                            }
                            HUD.coins -= 30;

                        }
                    }
                }
                if (mouseOver(mx, my, 350, 115, 125, 81)) {
                    if (HUD.coins >= 60) {
                        if (!purchasedUpgrades.contains(StoreUpgrades.ExtraLife_1)) {
                            HUD.coins -= 60;
                            purchasedUpgrades.add(StoreUpgrades.ExtraLife_1);
                            HUD.lives = 2;
                        }
                    }
                }
            }
        }
    }

    public void tick() {

        for (int i = 0; i < EffectHandler.object.size(); i++) {
            GameEffect tempEffect = EffectHandler.object.get(i);
            if (tempEffect.getId() == ID.SpeedEffect) {
                speedEffect = tempEffect;
            }
        }
        if (purchasedUpgrades == null) {

        } else {
            if (!purchasedUpgrades.isEmpty()) {
                if (purchasedUpgrades.contains(StoreUpgrades.Speed_3)) {
                    if (!(EffectHandler.object.contains(speedEffect))) {
                        KeyInput.playerSpeed = 6;
                    } else {
                        KeyInput.playerSpeed = 9;
                    }
                } else if (purchasedUpgrades.contains(StoreUpgrades.Speed_2)) {
                    if (!(EffectHandler.object.contains(speedEffect))) {
                        KeyInput.playerSpeed = 5.5f;
                    } else {
                        KeyInput.playerSpeed = 8.5f;
                    }
                } else if (purchasedUpgrades.contains(StoreUpgrades.Speed_1)) {
                    if (!(EffectHandler.object.contains(speedEffect))) {
                        KeyInput.playerSpeed = 5.25f;
                    } else {
                        KeyInput.playerSpeed = 8.25f;
                    }
                } else {
                    if (!EffectHandler.object.contains(speedEffect)) {
                        KeyInput.playerSpeed = 5;
                    } else {
                        KeyInput.playerSpeed = 8;
                    }
                }
            }
        }
        if (skinSTATE == SkinSTATE.White) {
            PlayerColor = Color.white;
        } else if (skinSTATE == SkinSTATE.Red) {
            PlayerColor = Color.red;
        } else if (skinSTATE == SkinSTATE.Green) {
            PlayerColor = Color.green;
        } else if (skinSTATE == SkinSTATE.Blue) {
            PlayerColor = Color.blue;
        } else if (skinSTATE == SkinSTATE.Pink) {
            PlayerColor = Color.pink;
        } else if (skinSTATE == SkinSTATE.Orange) {
            PlayerColor = Color.orange;
        } else if (skinSTATE == SkinSTATE.Yellow) {
            PlayerColor = Color.yellow;
        } else if (skinSTATE == SkinSTATE.Gray) {
            PlayerColor = Color.gray;
        }
        if (Game.gameState == Game.STATE.MenuShop) {
            skinSTATE = currentSkin;
            if (lookingSkinState == SkinSTATE.White) {
                LookingColor = Color.white;
            } else if (lookingSkinState == SkinSTATE.Red) {
                LookingColor = Color.red;
            } else if (lookingSkinState == SkinSTATE.Green) {
                LookingColor = Color.green;
            } else if (lookingSkinState == SkinSTATE.Blue) {
                LookingColor = Color.blue;
            } else if (lookingSkinState == SkinSTATE.Pink) {
                LookingColor = Color.pink;
            } else if (lookingSkinState == SkinSTATE.Orange) {
                LookingColor = Color.orange;
            } else if (lookingSkinState == SkinSTATE.Yellow) {
                LookingColor = Color.yellow;
            } else if (lookingSkinState == SkinSTATE.Gray) {
                LookingColor = Color.gray;
            } else {
                LookingColor = Color.white;
                PlayerColor = Color.white;
            }
        }
    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.MenuShop) {
            Font font = new Font("arial", 1, 50);
            g.setFont(font);
            g.setColor(Color.green);
            g.drawString("Store", Game.WIDTH / 2 - 70, 50);
            Font font2 = new Font("arial", 1, 25);
            g.setFont(font2);
            g.setColor(Color.white);
            g.drawString("Coins: " + HUD.coins, 15, 40);
            g.drawLine(-10, 75, 650, 75);
            g.drawRect(15, 100, 120, 60);
            g.drawString("Back", 45, 138);
            g.drawLine(155, 75, 155, Game.HEIGHT + 10);
            g.setColor(Color.CYAN);
            Font font3 = new Font("arial", 1, 12);
            g.setFont(font3);
            g.drawString("This is the shop.", 13, 183);
            g.drawString("You can buy things here!", 13, 198);
            g.drawString("Such as Skins or more.", 13, 213);
            g.setColor(Color.green);
            Font font4 = new Font("arial", 1, 40);
            g.setFont(font4);
            g.drawString("Skin", 30, 260);
            g.setColor(Color.white);
            g.drawRect(10, 280, 136, 150);
            g.setColor(PlayerColor);
            g.fillRect(25, 305, 45, 45);
            g.setColor(LookingColor);
            g.fillRect(25 + 45 + 15, 305, 45, 45);
            g.setColor(Color.white);
            Font font5 = new Font("arial", 1, 12);
            g.setFont(font5);
            g.drawString("Player", 25, 295);
            g.drawString("Item", 25 + 45 + 15, 295);
            g.setColor(Color.gray);
            g.setFont(font4);
            if (!(lookingSkinState == SkinSTATE.White)) {
                g.drawString("«", 25, 380);
                g.drawRect(25, 360, 20, 20);
            }
            if (!(lookingSkinState == SkinSTATE.Gray)) {
                g.drawString("»", 25 + 45 + 39, 380);
                g.drawRect(25 + 45 + 39, 360, 20, 20);
            }
            g.setColor(Color.white);
            g.drawRect(25 + 20 + 7, 360, 50, 20);
            Font font6 = new Font("arial", 1, 12);
            g.setFont(font6);
            if (lookingSkinState == SkinSTATE.White) {
                g.setColor(Color.white);
                g.drawString("White", 25 + 20 + 17, 374);
                if (lookingSkinState != currentSkin) {
                    g.drawRect(25 + 20 + 7, 390, 50, 20);
                    g.setColor(Color.blue);
                    g.drawString("Select", 25 + 20 + 14, 404);
                }
            } else if (lookingSkinState == SkinSTATE.Red) {
                g.setColor(Color.red);
                g.drawString("Red", 25 + 20 + 19, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            } else if (lookingSkinState == SkinSTATE.Green) {
                g.setColor(Color.green);
                g.drawString("Green", 25 + 20 + 17, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            } else if (lookingSkinState == SkinSTATE.Blue) {
                g.setColor(Color.blue);
                g.drawString("Blue", 25 + 20 + 19, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            } else if (lookingSkinState == SkinSTATE.Pink) {
                g.setColor(Color.pink);
                g.drawString("Pink", 25 + 20 + 19, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            } else if (lookingSkinState == SkinSTATE.Orange) {
                g.setColor(Color.orange);
                g.drawString("Orange", 25 + 20 + 14, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            } else if (lookingSkinState == SkinSTATE.Yellow) {
                g.setColor(Color.yellow);
                g.drawString("Yellow", 25 + 20 + 14, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            } else if (lookingSkinState == SkinSTATE.Gray) {
                g.setColor(Color.gray);
                g.drawString("Gray", 25 + 20 + 19, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            } else {
                g.setColor(Color.white);
                g.drawString("White", 25 + 20 + 17, 374);
                if (purchasedSkins.contains(lookingSkinState)) {
                    if (lookingSkinState == currentSkin) {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 4, 390, 55, 20);
                        g.setColor(Color.blue);
                        g.drawString("Unselect", 25 + 20 + 8, 404);
                    } else {
                        g.setColor(Color.white);
                        g.drawRect(25 + 20 + 7, 390, 50, 20);
                        g.setColor(Color.blue);
                        g.drawString("Select", 25 + 20 + 14, 404);
                    }
                } else {
                    g.setColor(Color.white);
                    g.drawRect(22, 390, 50, 20);
                    g.drawRect(80, 390, 50, 20);
                    g.setColor(Color.green);
                    g.drawString("50 Coins", 24, 405);
                    if (HUD.coins >= 50) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(Color.red);
                    }
                    g.drawString("Buy", 95, 405);
                }
            }

            //COIN CHANCE INCREMENT!
            if (HUD.coins >= 30) {
                g.setColor(Color.green);
            } else if (HUD.coins < 30) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.white);
            }
            if (!(purchasedUpgrades == null) && !(purchasedUpgrades.isEmpty()) && purchasedUpgrades.contains(StoreUpgrades.MoreCoins_5)) {
                g.setColor(Color.white);
            }
            g.drawRect(200, 115, 125, 81);
            g.setColor(Color.white);
            Font font7 = new Font("arial", 1, 12);
            g.setFont(font7);
            g.drawString("Coin spawn chance", 208, 135);
            g.drawString("5% Increment", 222, 153);
            g.drawString("30 Coins", 239, 171);
            g.setColor(Color.green);
            if (!(purchasedUpgrades == null) && !(purchasedUpgrades.isEmpty())) {
                if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_1)) {
                    g.fillRect(201, 186, 24, 10);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_2)) {
                    g.fillRect(226, 186, 24, 10);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_3)) {
                    g.fillRect(251, 186, 24, 10);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_4)) {
                    g.fillRect(276, 186, 24, 10);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.MoreCoins_5)) {
                    g.fillRect(301, 186, 24, 10);
                }

                //SPEED INCREMENT!
                if (HUD.coins >= 25) {
                    g.setColor(Color.green);
                } else if (HUD.coins < 25) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.white);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.Speed_3)) {
                    g.setColor(Color.white);
                }
                g.drawRect(200, 221, 125, 81);
                g.setColor(Color.white);
                g.setFont(font7);
                g.drawString("Player speed", 222, 241);
                g.drawString("5% Increment", 222, 259);
                g.drawString("25 Coins", 239, 277);
                g.setColor(Color.green);
                if (purchasedUpgrades.contains(StoreUpgrades.Speed_1)) {
                    g.fillRect(201, 292, 40, 10);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.Speed_2)) {
                    g.fillRect(242, 292, 40, 10);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.Speed_3)) {
                    g.fillRect(283, 292, 42, 10);
                }


                //EXTRA LIFE!
                if (HUD.coins >= 60) {
                    g.setColor(Color.green);
                } else if (HUD.coins < 60) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.white);
                }
                if (purchasedUpgrades.contains(StoreUpgrades.ExtraLife_1)) {
                    g.setColor(Color.white);
                }
                g.drawRect(350, 115, 125, 81);
                g.setColor(Color.white);
                g.setFont(font7);
                g.drawString("Extra life!", 386, 135);
                g.drawString("1 Extra life", 384, 153);
                g.drawString("60 Coins", 389, 171);
                g.setColor(Color.green);
                if (purchasedUpgrades.contains(StoreUpgrades.ExtraLife_1)) {
                    g.fillRect(351, 186, 124, 10);
                }
            }

        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }

        return false;
    }


    public enum StoreUpgrades {
        none,
        MoreCoins_1,
        MoreCoins_2,
        MoreCoins_3,
        MoreCoins_4,
        MoreCoins_5,
        ExtraLife_1,
        Speed_1,
        Speed_2,
        Speed_3
    }


    public enum SkinSTATE {
        White, //1
        Red, //2
        Blue, //3
        Green, //4
        Yellow, //5
        Orange, //6
        Pink, //7
        Gray //8
    }
}
