package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.corgirun.R;
import com.example.corgirun.clases.GameManager;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class GameScene extends ScenePuz {

    enum GameState {
        READE,
        RUNNING,
        PAUSE,
        END
    }

    GameState gameState;
    GameManager gameManager;

    public GameScene(CorePuz corePuz) {
        super(corePuz);
        gameState = GameState.READE;
        gameManager = new GameManager(corePuz, sceneWidth, sceneHeight);
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

        graphicsPuz.clearScene(Color.BLACK);
        graphicsPuz.drawText("Игровой экран", 400, 300, Color.GREEN, 160, null);

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
        graphicsPuz.drawText(corePuz.getString(R.string.are_you_ready), 600, 300, Color.BLUE, 160, null);

    }

    private void updateStateRunning() {
        gameManager.update();
    }

    private void drawingStateRunning() {
        graphicsPuz.clearScene(Color.BLACK);
        gameManager.drawing(corePuz, graphicsPuz);
    }

    private void updateStatePause() {

    }

    private void drawingStatePause() {

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
