package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.corgirun.R;
import com.example.corgirun.clases.GameManager;
import com.example.corgirun.clases.PauseManager;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;
import java.util.Date;

public class GameScene extends ScenePuz {

    enum GameState {
        READE,
        RUNNING,
        PAUSE,
        END
    }

    GameState gameState;
    GameManager gameManager;
    PauseManager pauseManager;

    public GameScene(CorePuz corePuz) {
        super(corePuz);
        gameState = GameState.READE;
        gameManager = new GameManager(corePuz, sceneWidth, sceneHeight);
        pauseManager = new PauseManager(corePuz, sceneWidth, sceneHeight);
    }

    @Override
    public void update() {
        if (gameState == GameState.READE) {
            updateStateReady();
        }
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.END) {
            updateStateEnd();
        }
    }

    @Override
    public void drawing() {
        if (gameState == GameState.READE) {
            drawingStateReady();
        }
        if (gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if (gameState == GameState.END) {
            drawingStateEnd();
        }
    }

    private void updateStateReady() {
        if (corePuz.getTouchListenerPuz().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }

    private void drawingStateReady() {
        graphicsPuz.clearScene(Color.BLACK);
        graphicsPuz.drawText(corePuz.getString(R.string.are_you_ready), 75, 35, Color.BLUE, 20, null);

    }

    private void updateStateRunning() {
        if (gameManager.getButtonPause().isTouch(corePuz)) {
            gameState = GameState.PAUSE;
        }
        if (gameManager.getCorgi().getHP() <= 0) {
            gameManager.gameOver(corePuz);
            gameState = GameState.PAUSE;
        }
        gameManager.update();
    }

    //----------Debug FPS------------
    float updates = 0;
    float drawings = 0;
    long timer = System.currentTimeMillis();;
    //----------Debug FPS------------


    private void drawingStateRunning() {
        graphicsPuz.clearScene(Color.BLACK);
        gameManager.drawing(corePuz, graphicsPuz);
        graphicsPuz.drawText("HI  " + (int)gameManager.getDistance(), 190, 15, Color.WHITE, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText("BC  " + (int)gameManager.getGameCoins(), 190, 25, Color.YELLOW, 16, ResourceUtils.menuFont);

        //----------Debug FPS------------
        graphicsPuz.drawText("FPS " + drawings, 30, 15, Color.WHITE, 16, ResourceUtils.menuFont);
        updates++;
        if (System.currentTimeMillis() - timer > 1000) {
            Date date = new Date();
            drawings = updates;
            updates = 0;
            timer += 1000;
        }
        //----------Debug FPS------------

    }

    private void updateStatePause() {
        if (pauseManager.getButtonPauseContinue().isTouch(corePuz)) {
            gameState = GameState.RUNNING;
        }
        if (pauseManager.getButtonPauseExit().isTouch(corePuz)) {
            gameManager.gameOver(corePuz);
            corePuz.setScene(new MainMenuScene(corePuz));
        }
        pauseManager.update();
    }

    private void drawingStatePause() {
        graphicsPuz.drawTexture(ResourceUtils.backPause, 76, 42);
        pauseManager.drawing(corePuz, graphicsPuz);
    }

    private void updateStateEnd() {

    }

    private void drawingStateEnd() {

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
