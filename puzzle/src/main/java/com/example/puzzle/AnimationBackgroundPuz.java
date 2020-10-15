package com.example.puzzle;

import android.graphics.Bitmap;

public class AnimationBackgroundPuz {

	double speedAnimation;
	Bitmap sprite;

	public AnimationBackgroundPuz(double speedAnimation, Bitmap sprite) {
		this.speedAnimation = speedAnimation;
		this.sprite = sprite;
	}

	public void drawingAnimation(GraphicsPuz graphicsPuz, int x, int y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
