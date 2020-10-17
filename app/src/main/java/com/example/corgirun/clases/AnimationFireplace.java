package com.example.corgirun.clases;

import android.graphics.Bitmap;
import com.example.puzzle.GraphicsPuz;

public class AnimationFireplace {

	int countFrames;
	int frames;
	double speedAnimation;

	Bitmap sprite;
	Bitmap sprite1;
	Bitmap sprite2;
	Bitmap sprite3;

	public AnimationFireplace(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.sprite3 = sprite3;
		sprite = sprite1;
		frames = 18;
	}

	public void runAnimation() {
		if (countFrames==0) {
			sprite = sprite1;
		}
		if (countFrames==6) {
			sprite = sprite2;
		}
		if (countFrames==12) {
			sprite = sprite3;
		}
		countFrames++;

		if (countFrames>frames) {
			countFrames = 0;
		}
	}

	public void drawingAnimation(GraphicsPuz graphicsPuz, int x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
