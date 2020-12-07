package com.example.corgirun.scenes;

import static com.example.corgirun.clases.Type.DINO_DOUX;
import static com.example.corgirun.clases.Type.DINO_MORT;
import static com.example.corgirun.clases.Type.DINO_SANTA;
import static com.example.corgirun.clases.Type.DINO_TARD;
import static com.example.corgirun.clases.Type.DINO_VITA;

import android.graphics.Color;

import com.example.corgirun.R;
import com.example.corgirun.clases.MainMenuManager;
import com.example.corgirun.objects.Dinosaurs;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class MainMenuScene extends ScenePuz {

    MainMenuManager mainMenuManager;

    public MainMenuScene(CorePuz corePuz) {
        super(corePuz);
        mainMenuManager = new MainMenuManager(corePuz, sceneWidth, sceneHeight);
    }

    @Override
    public void update() {

        int sprite = mainMenuManager.getSprite();
        boolean isBought = mainMenuManager.getDinosaurs().isBought();

        //Новая игра. Переход на GameScene
        if (mainMenuManager.getButtonPlay().isTouch(corePuz)) {
            if (isBought) {
                if (sprite == 0) {
                    corePuz.setScene(new GameScene(corePuz, DINO_VITA));
                }
                if (sprite == 1) {
                    corePuz.setScene(new GameScene(corePuz, DINO_SANTA));
                }
                if (sprite == 2) {
                    corePuz.setScene(new GameScene(corePuz, DINO_MORT));
                }
                if (sprite == 3) {
                    corePuz.setScene(new GameScene(corePuz, DINO_DOUX));
                }
                if (sprite == 4) {
                    corePuz.setScene(new GameScene(corePuz, DINO_TARD));
                }
            }
        }

        if (mainMenuManager.getCoins500().isTouch(corePuz)) {
            if (!isBought && sprite == 1) {
                if (SettingsGameUtils.coins >= 500) {
                    SettingsGameUtils.setCoins(-500);
                    SettingsGameUtils.setIsBought(1, true);
                    mainMenuManager.getDinosaurs().setBought(true);
                }
            }
        }
        if (mainMenuManager.getCoins1000().isTouch(corePuz)) {
            if (!isBought && sprite == 3) {
                if (SettingsGameUtils.coins >= 1000) {
                    SettingsGameUtils.setCoins(-1000);
                    SettingsGameUtils.setIsBought(3, true);
                    mainMenuManager.getDinosaurs().setBought(true);
                }
            }
        }
        if (mainMenuManager.getCoins3000().isTouch(corePuz)) {
            if (!isBought && sprite == 4) {
                if (SettingsGameUtils.coins >= 3000) {
                    SettingsGameUtils.setCoins(-3000);
                    SettingsGameUtils.setIsBought(4, true);
                    mainMenuManager.getDinosaurs().setBought(true);
                }
            }
        }

        if (mainMenuManager.getButtonRight().isTouch(corePuz)) {
            if (sprite < 4) {
                sprite++;
                mainMenuManager.setSprite(sprite);
                mainMenuManager.setDinosaurs(new Dinosaurs(96, 30, sprite, SettingsGameUtils.getIsBought(sprite)));
            }
        }

        if (mainMenuManager.getButtonLeft().isTouch(corePuz)) {
            if (sprite > 0) {
                sprite--;
                mainMenuManager.setSprite(sprite);
                mainMenuManager.setDinosaurs(new Dinosaurs(96, 30, sprite, SettingsGameUtils.getIsBought(sprite)));
            }
        }

        mainMenuManager.update();
    }

    @Override
    public void drawing() {
        graphicsPuz.drawTexture(ResourceUtils.menu, 0, 0);

        mainMenuManager.drawing(graphicsPuz);

        graphicsPuz.drawText("HI  " + SettingsGameUtils.distance, 15, 12, Color.WHITE, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText("BC  " + SettingsGameUtils.coins, 15, 22, Color.YELLOW, 16, ResourceUtils.menuFont);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
