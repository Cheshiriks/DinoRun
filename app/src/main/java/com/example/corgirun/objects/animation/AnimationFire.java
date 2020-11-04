package com.example.corgirun.objects.animation;

import android.graphics.Bitmap;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.service.AnimationPuz;

public class AnimationFire implements AnimationPuz {

	int countFrames;
	int frames;
	double speedAnimation;

	Bitmap sprite;
	Bitmap sprite1;
	Bitmap sprite2;
	Bitmap sprite3;
	Bitmap sprite4;

	public AnimationFire(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.sprite3 = sprite3;
		this.sprite4 = sprite4;
		sprite = sprite1;
		frames = 24;
	}

	@Override
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
		if (countFrames==18) {
			sprite = sprite4;
		}
		countFrames++;

		if (countFrames>frames) {
			countFrames = 0;
		}
	}

	@Override
	public void drawingAnimation(GraphicsPuz graphicsPuz, double x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
