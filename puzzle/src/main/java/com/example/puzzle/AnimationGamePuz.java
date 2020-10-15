package com.example.puzzle;

import android.graphics.Bitmap;

public class AnimationGamePuz {

	double speedAnimation;
	int delayIndex;
	int countFrames;
	int frames;

	Bitmap sprite;
	Bitmap sprite1;
	Bitmap sprite2;
	Bitmap sprite3;

	public AnimationGamePuz(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.sprite3 = sprite3;
		sprite = sprite1;
		frames = 3;
	}

	public void runAnimation() {
		delayIndex++;
		if (countFrames==0) {
			sprite = sprite1;
		}
		if (countFrames==1) {
			sprite = sprite2;
		}
		if (countFrames==2) {
			sprite = sprite3;
		}
		countFrames++;

		if (countFrames>frames) {
			countFrames = 0;
		}
	}

	public void drawingAnimation(GraphicsPuz graphicsPuz, int x, int y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
