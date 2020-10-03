package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.corgirun.R;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class MainMenuScene extends ScenePuz {

    public MainMenuScene(CorePuz corePuz) {
        super(corePuz);
    }

    @Override
    public void update() {
        if (corePuz.getTouchListenerPuz().getTouchUp(150, 700, 350, 70)) {
            corePuz.setScene(new GameScene(corePuz));
        }
    }

    @Override
    public void drawing() {
        graphicsPuz.clearScene(Color.BLACK);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_app_name), 600, 300, Color.BLUE, 160, null);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_new_game), 150, 700, Color.BLUE, 60, null);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_settings), 150, 800, Color.BLUE, 60, null);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_results), 150, 900, Color.BLUE, 60, null);

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
