package com.example.corgirun.objects.animation;

import android.graphics.Bitmap;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.service.AnimationPuz;

public class AnimationPicture implements AnimationPuz {

	int countFrames;
	int frames;
	double speedAnimation;

	Bitmap sprite;
	Bitmap sprite1;
	Bitmap sprite2;

	public AnimationPicture(double speedAnimation, Bitmap sprite1, Bitmap sprite2) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		sprite = sprite1;
		frames = 160;
	}

	@Override
	public void runAnimation() {
		if (countFrames==0) {
			sprite = sprite1;
		}
		if (countFrames==140) {
			sprite = sprite2;
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
