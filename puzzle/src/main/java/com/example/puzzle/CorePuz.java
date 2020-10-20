package com.example.puzzle;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CorePuz extends AppCompatActivity {

    private final float FRAME_BUFFER_WIDTH = 240;
    private final float FRAME_BUFFER_HEIGHT = 135;

    private LoopPuz loopPuz;
    private GraphicsPuz graphicsPuz;
    private ScenePuz scenePuz;
    private TouchListenerPuz touchListenerPuz;

    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;

    private float sceneWidth;
    private float sceneHeight;

    private boolean stateOnPause;
    private boolean stateOnResume;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //отключаем спящий режим для приложения

        sizeDisplay = new Point();

        //получаем размер экрана
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap((int) FRAME_BUFFER_WIDTH, (int) FRAME_BUFFER_HEIGHT, Bitmap.Config.ARGB_8888);
        sceneWidth = FRAME_BUFFER_WIDTH / sizeDisplay.x;
        sceneHeight = FRAME_BUFFER_HEIGHT / sizeDisplay.y;

        loopPuz = new LoopPuz(this, frameBuffer);
        graphicsPuz = new GraphicsPuz(getAssets(), frameBuffer);
        touchListenerPuz = new TouchListenerPuz(loopPuz, sceneWidth, sceneHeight);

        scenePuz = getStartScene();

        stateOnPause = false;
        stateOnResume = false;

        setContentView(loopPuz);
    }

    public CorePuz() {

    }

    public void onResume() {
        super.onResume();
        scenePuz.resume();
        loopPuz.startGame();
    }

    public void onPause() {
        super.onPause();
        scenePuz.pause();
        loopPuz.stopGame();
        stateOnPause = true;

        if (isFinishing()) {
            scenePuz.dispose();
        }
    }

    public TouchListenerPuz getTouchListenerPuz() {
        return touchListenerPuz;
    }

    public GraphicsPuz getGraphicsPuz() {
        return graphicsPuz;
    }

    public ScenePuz getCurrentScene() {
        return scenePuz;
    }

    public ScenePuz getStartScene() {
        return scenePuz;
    }

    public void setScene(ScenePuz scenePuz) {
        if (scenePuz == null) {
            throw new IllegalArgumentException("Неудалось загрузить сцену");
        }
        this.scenePuz.pause();
        this.scenePuz.dispose();
        scenePuz.resume();
        scenePuz.update();
        this.scenePuz = scenePuz;
    }

}
