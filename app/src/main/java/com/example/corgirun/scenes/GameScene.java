package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.corgirun.R;
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

    public GameScene(CorePuz corePuz) {
        super(corePuz);
        gameState = GameState.READE;
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

    }

    private void drawingStateRunning() {
        graphicsPuz.clearScene(Color.BLACK);
        graphicsPuz.drawText("Go!", 600, 300, Color.BLUE, 160, null);
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
