package com.example.corgirun;

import com.example.corgirun.scenes.MainMenuScene;
import com.example.puzzle.CorePuz;
import com.example.puzzle.ScenePuz;

public class Main extends CorePuz {

    public ScenePuz getStartScene() {
        return new MainMenuScene(this);
    }

}