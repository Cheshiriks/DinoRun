package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.corgirun.R;
import com.example.corgirun.clases.GameManager;
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

        if (corePuz.getTouchListenerPuz().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameManager.getCorgi().doJump(4);
        }

        //----------Debug FPS------------
        graphicsPuz.drawText("FPS " + drawings, 20, 20, Color.WHITE, 12, null);
        updates++;
        if (System.currentTimeMillis() - timer > 1000) {
            Date date = new Date();
            drawings = updates;
            System.out.println("FPS " + updates);
            updates = 0;
            timer += 1000;
        }
        //----------Debug FPS------------

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
