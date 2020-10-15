package com.example.puzzle;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.puzzle.service.GraphicsPuzService;

import java.io.IOException;
import java.io.InputStream;

public class GraphicsPuz implements GraphicsPuzService {

    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame;
    private Canvas canvasGame;
    private Paint paintGame;
    private Bitmap textureGame;

    public GraphicsPuz(AssetManager assetManagerGame, Bitmap frameBufferGame) {
        this.assetManagerGame = assetManagerGame;
        this.frameBufferGame = frameBufferGame;
        //передаем frameBufferGame в canvas. Будет отрисовывать игру не на canvas, а на frameBufferGame, чтобы масштабировать на всех устройствах
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }

    @Override
    public void clearScene(int colorRGB) {
        canvasGame.drawRGB(colorRGB, colorRGB, colorRGB);
    }

    @Override
    public void drawPixel(int x, int y, int color) {
        paintGame.setColor(color);
        canvasGame.drawPoint(x, y, paintGame);
    }

    @Override
    public void drawLine(int startX, int startY, int stopX, int stopY, int color) {
        paintGame.setColor(color);
        canvasGame.drawLine(startX, startY, stopX, stopY, paintGame);
    }

    @Override
    public void drawText(String text, int x, int y, int color, int size, Typeface font) {
        paintGame.setColor(color);
        paintGame.setTextSize(size);
        paintGame.setTypeface(font);
        canvasGame.drawText(text, x, y, paintGame);
    }

    @Override
    public void drawTexture(Bitmap textureGame, int x, int y) {
        canvasGame.drawBitmap(textureGame, x, y, null);
    }

    @Override
    public int getWidthFrameBuffer() {
        return frameBufferGame.getWidth();
    }

    @Override
    public int getHeightFrameBuffer() {
        return frameBufferGame.getHeight();
    }

    @Override
    public Bitmap newTexture(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = assetManagerGame.open(fileName);
            textureGame = BitmapFactory.decodeStream(inputStream);
            if (textureGame == null) {
                throw new RuntimeException("Неудалось загрузить файл " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ненайден файл " + fileName);
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return textureGame;
    }

    public Bitmap newSprite(Bitmap textureAtlas, int x, int y, int widthSprite, int heightSprite) {
        Bitmap newSprite = Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
        return newSprite;
    }

}
