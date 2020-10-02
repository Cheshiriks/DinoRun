package com.example.puzzle;

public abstract class ScenePuz {

    public CorePuz corePuz;
    public int sceneWidth;
    public int sceneHeight;
    public GraphicsPuz graphicsPuz;

    public ScenePuz(CorePuz corePuz) {
        this.corePuz = corePuz;
        graphicsPuz = corePuz.getGraphicsPuz();
        sceneWidth = corePuz.getGraphicsPuz().getWidthFrameBuffer();
        sceneHeight = corePuz.getGraphicsPuz().getHeightFrameBuffer();
    }

    public abstract void update();

    public abstract void drawing();

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();

}
