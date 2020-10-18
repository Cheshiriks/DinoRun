package com.example.corgirun.scenes;

import android.graphics.Color;

import com.example.corgirun.R;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class MainMenuScene extends ScenePuz {

    public MainMenuScene(CorePuz corePuz) {
        super(corePuz);
    }

    @Override
    public void update() {
        //Новая игра. Переход на GameScene
        if (corePuz.getTouchListenerPuz().getTouchUp(20, 100, 45, 9)) {
            corePuz.setScene(new GameScene(corePuz));
        }
    }

    @Override
    public void drawing() {
        graphicsPuz.clearScene(Color.BLACK);
        graphicsPuz.drawTexture(ResourceUtils.menu, 0, 0);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_app_name), 75, 35, Color.BLUE, 20, null);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_new_game), 20, 100, Color.BLUE, 8, null);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_settings), 20, 115, Color.BLUE, 8, null);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_results), 20, 130, Color.BLUE, 8, null);

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
