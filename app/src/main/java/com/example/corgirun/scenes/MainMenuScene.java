package com.example.corgirun.scenes;

import static com.example.corgirun.clases.Type.DINO_SANTA;
import static com.example.corgirun.clases.Type.DINO_VITA;

import android.graphics.Color;

import com.example.corgirun.R;
import com.example.corgirun.clases.MainMenuManager;
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
        //Новая игра. Переход на GameScene
        if (corePuz.getTouchListenerPuz().getTouchUp(20, 100, 45, 9)) {
            corePuz.setScene(new GameScene(corePuz, DINO_SANTA));
        }
        mainMenuManager.update();
    }

    @Override
    public void drawing() {
        graphicsPuz.drawTexture(ResourceUtils.menu, 0, 0);

        mainMenuManager.drawing(graphicsPuz);

        graphicsPuz.drawText("HI  " + SettingsGameUtils.distance, 15, 12, Color.WHITE, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText("BC  " + SettingsGameUtils.coins, 15, 22, Color.YELLOW, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_app_name), 75, 35, Color.BLUE, 20, null);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_new_game), 20, 100, Color.BLUE, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_settings), 20, 115, Color.BLUE, 16, ResourceUtils.menuFont);
        graphicsPuz.drawText(corePuz.getString(R.string.main_menu_results), 20, 130, Color.BLUE, 16, ResourceUtils.menuFont);

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
