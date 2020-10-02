package com.example.puzzle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class LoopPuz extends SurfaceView implements Runnable {

    private final float FPS = 60;

    private final float SECOND = 1_000_000_000;

    private final float UPDATE_TIME = SECOND / FPS;

    private boolean running = false;

    Thread gameThread = null;
    CorePuz corePuz;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public LoopPuz(CorePuz corePuz, Bitmap frameBuffer) {
        super(corePuz);
        this.frameBuffer = frameBuffer;
        this.corePuz = corePuz;
        this.surfaceHolder = getHolder();
        this.rect = new Rect();
        this.canvas = new Canvas();
    }

    //temp - проверка обновления цикла
    float updates = 0;
    float drawing = 0;
    long timer = 0;
    //temp

    @Override
    public void run() {

        float lastTime = System.nanoTime();
        float delta = 0;
        timer = System.currentTimeMillis();

        //Главный цикл игры. Обновляем экран 60 раз в секунду
        while (running) {

            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;
            delta += elapsedTime / UPDATE_TIME;

            if (delta >= 1) {
                updateGame();
                drawingGame();
                delta--;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                Date date = new Date();
                System.out.println("updates " + updates + "drawing " + drawing + " " + date.toString());
                updates = 0;
                drawing = 0;
                timer += 1000;
            }
        }

    }

    public void startGame() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame() {
        if (!running) {
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateGame() {
        updates++;
        corePuz.getCurrentScene().update();

    }

    private void drawingGame() {
        drawing++;
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            corePuz.getCurrentScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
