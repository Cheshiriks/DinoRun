package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class GameScene extends ScenePuz {

    public GameScene(CorePuz corePuz) {
        super(corePuz);
    }

    @Override
    public void update() {

    }

    @Override
    public void drawing() {

        graphicsPuz.clearScene(Color.BLACK);
        graphicsPuz.drawText("Игровой экран", 400, 300, Color.GREEN, 160, null);

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
