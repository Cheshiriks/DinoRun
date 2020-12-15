package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.corgirun.clases.GameManager;
import com.example.corgirun.clases.GameOverManager;
import com.example.corgirun.clases.PauseManager;
import com.example.corgirun.clases.Type;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.MusicPuz;
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
    GameOverManager gameOverManager;
    Type dinoType;
    MusicPuz music;

    public GameScene(CorePuz corePuz, Type dinoType) {
        super(corePuz);
        this.dinoType = dinoType;
        gameState = GameState.READE;
        gameManager = new GameManager(corePuz, sceneWidth, sceneHeight, dinoType);
        pauseManager = new PauseManager(corePuz, sceneWidth, sceneHeight);
        gameOverManager = new GameOverManager(corePuz, sceneWidth, sceneHeight);
        music = corePuz.getAudioPuz().newMusic("horror.mp3");

        music.play(true, 1f);
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
            SettingsGameUtils.setTraining(false);
            gameState = GameState.RUNNING;
        }
    }

    private void drawingStateReady() {
        if (SettingsGameUtils.isTraining()) {
            graphicsPuz.drawTexture(ResourceUtils.training, 0, 0);
        }
        else {
            gameState = GameState.RUNNING;
        }
    }

    private void updateStateRunning() {
        if (gameManager.getButtonPause().isTouch(corePuz)) {
            music.stop();
            gameState = GameState.PAUSE;
        }
        if (gameManager.getCorgi().getHP() <= 0) {
            music.stop();
            gameState = GameState.END;
        }
        gameManager.update();
    }

    //----------Debug FPS------------
    float updates = 0;
    float drawings = 0;
    long timer = System.currentTimeMillis();;
    //----------Debug FPS------------


    private void drawingStateRunning() {
        gameManager.drawing(corePuz, graphicsPuz);
        graphicsPuz.drawText("HI  " + (int)gameManager.getDistance(), 190, 12, Color.WHITE, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText("BC  " + (int)gameManager.getGameCoins(), 190, 22, Color.YELLOW, 16, ResourceUtils.menuFont);

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
            music.play(true, 2f);
            gameState = GameState.RUNNING;
        }
        if (pauseManager.getButtonPauseExit().isTouch(corePuz)) {
            music.dispose();
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
        if (gameOverManager.getButtonExitAgain().isTouch(corePuz)) {
            music.dispose();
            gameManager.gameOver(corePuz);
            corePuz.setScene(new GameScene(corePuz, dinoType));
        }
        if (gameOverManager.getButtonPauseExit().isTouch(corePuz)) {
            music.dispose();
            gameManager.gameOver(corePuz);
            corePuz.setScene(new MainMenuScene(corePuz));
        }
        gameOverManager.update();
    }

    private void drawingStateEnd() {
        graphicsPuz.drawTexture(ResourceUtils.backPause, 76, 42);
        gameOverManager.drawing(corePuz, graphicsPuz);
    }


    @Override
    public void pause() {
        gameState = GameState.PAUSE;
        music.stop();
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        music.dispose();
        gameManager.getCorgi().getJumpSound().dispose();
        gameManager.getCoinSound().dispose();

        gameManager.getButtonPause().getButtonSound().dispose();
        gameOverManager.getButtonExitAgain().getButtonSound().dispose();
        gameOverManager.getButtonPauseExit().getButtonSound().dispose();
        pauseManager.getButtonPauseContinue().getButtonSound().dispose();
        pauseManager.getButtonPauseExit().getButtonSound().dispose();
    }
}
