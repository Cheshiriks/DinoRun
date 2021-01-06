package com.example.corgirun.scenes;

import static com.example.corgirun.clases.Type.DINO_CROCY;
import static com.example.corgirun.clases.Type.DINO_DOUX;
import static com.example.corgirun.clases.Type.DINO_MORT;
import static com.example.corgirun.clases.Type.DINO_NEG;
import static com.example.corgirun.clases.Type.DINO_SANTA;
import static com.example.corgirun.clases.Type.DINO_TARD;
import static com.example.corgirun.clases.Type.DINO_VITA;

import android.graphics.Color;

import com.example.corgirun.clases.MainMenuManager;
import com.example.corgirun.clases.SettingsManager;
import com.example.corgirun.clases.ThanksManager;
import com.example.corgirun.objects.Dinosaurs;
import com.example.corgirun.scenes.GameScene.GameState;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class MainMenuScene extends ScenePuz {

    MainMenuManager mainMenuManager;
    ThanksManager thanksManager;
    SettingsManager settingsManager;
    GameState gameState;

    public MainMenuScene(CorePuz corePuz) {
        super(corePuz);
        mainMenuManager = new MainMenuManager(corePuz, sceneWidth, sceneHeight);
        thanksManager = new ThanksManager(corePuz, sceneWidth, sceneHeight);
        settingsManager = new SettingsManager(corePuz, sceneWidth, sceneHeight);
        gameState = GameState.RUNNING;
    }

    @Override
    public void update() {
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.SETTINGS) {
            updateStateSettings();
        }
    }

    @Override
    public void drawing() {
        if (gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if (gameState == GameState.SETTINGS) {
            drawingStateSettings();
        }
    }

    private void updateStateRunning() {

        int sprite = mainMenuManager.getSprite();
        boolean isBought = mainMenuManager.getDinosaurs().isBought();

        if (mainMenuManager.getButtonQues().isTouch(corePuz)) {
            gameState = GameState.PAUSE;
        }
        if (mainMenuManager.getButtonSett().isTouch(corePuz)) {
            gameState = GameState.SETTINGS;
        }

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
                if (sprite == 5) {
                    corePuz.setScene(new GameScene(corePuz, DINO_NEG));
                }
                if (sprite == 6) {
                    corePuz.setScene(new GameScene(corePuz, DINO_CROCY));
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
        if (mainMenuManager.getHi20000().isTouch(corePuz)) {
            if (!isBought && sprite == 5) {
                if (SettingsGameUtils.distance >= 20000) {
                    SettingsGameUtils.setIsBought(5, true);
                    mainMenuManager.getDinosaurs().setBought(true);
                }
            }
        }
        if (mainMenuManager.getCoins5000().isTouch(corePuz)) {
            if (!isBought && sprite == 6) {
                if (SettingsGameUtils.coins >= 5000) {
                    SettingsGameUtils.setCoins(-5000);
                    SettingsGameUtils.setIsBought(6, true);
                    mainMenuManager.getDinosaurs().setBought(true);
                }
            }
        }

        if (mainMenuManager.getButtonRight().isTouch(corePuz)) {
            if (sprite < 6) {
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

    private void drawingStateRunning() {
        graphicsPuz.drawTexture(ResourceUtils.menu, 0, 0);

        mainMenuManager.drawing(graphicsPuz);

        graphicsPuz.drawText("HI  " + SettingsGameUtils.distance, 15, 12, Color.WHITE, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText("BC  " + SettingsGameUtils.coins, 15, 22, Color.YELLOW, 16, ResourceUtils.menuFont);

    }

    private void updateStatePause() {
        if (thanksManager.getButtonThanksClose().isTouch(corePuz)) {
            gameState = GameState.RUNNING;
        }
        thanksManager.update();
    }

    private void drawingStatePause() {
        thanksManager.drawing(graphicsPuz);
    }

    private void updateStateSettings() {
        if (settingsManager.getButtonThanksClose().isTouch(corePuz)) {
            gameState = GameState.RUNNING;
        }
        if (settingsManager.isTouch(corePuz)) {
            SettingsGameUtils.setSettings(!SettingsGameUtils.isSettings());
        }
        settingsManager.update();
    }

    private void drawingStateSettings() {
        settingsManager.drawing(graphicsPuz);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        mainMenuManager.getButtonRight().getButtonSound().dispose();
        mainMenuManager.getButtonLeft().getButtonSound().dispose();
        mainMenuManager.getButtonPlay().getButtonSound().dispose();
        mainMenuManager.getCoins500().getButtonSound().dispose();
        mainMenuManager.getCoins1000().getButtonSound().dispose();
        mainMenuManager.getCoins3000().getButtonSound().dispose();
        mainMenuManager.getHi20000().getButtonSound().dispose();
        mainMenuManager.getCoins5000().getButtonSound().dispose();
        settingsManager.getButtonThanksClose().getButtonSound().dispose();
        thanksManager.getButtonThanksClose().getButtonSound().dispose();
    }
}
