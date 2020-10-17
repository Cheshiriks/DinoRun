package com.example.puzzle.service;

import android.graphics.Bitmap;
import android.graphics.Typeface;

public interface GraphicsPuzService {

    /** заливаем весь экран цветом colorRGB */
    void clearScene(int colorRGB);

    /** закрашиваем один пиксель */
    void drawPixel(int x, int y, int color);

    /** рисуем линию */
    void drawLine(int startX, int startY, int stopX, int stopY, int color);

    /** пишем текс */
    void drawText(String text, int x, int y, int color, int size, Typeface font);

    /** вставляем текстуру */
    void drawTexture(Bitmap textureGame, int x, double y);

    /** получаем ширину FrameBuffer */
    int getWidthFrameBuffer();

    /** получаем высоту FrameBuffer */
    int getHeightFrameBuffer();

    /** загружвем текстуру */
    Bitmap newTexture(String fileName);

}
