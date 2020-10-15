package com.example.corgirun;

import com.example.corgirun.clases.LoaderAssets;
import com.example.corgirun.scenes.MainMenuScene;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class Main extends CorePuz {

    public ScenePuz getStartScene() {
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphicsPuz());
        return new MainMenuScene(this);
    }

}