package com.example.corgirun.objects.animation;

import android.graphics.Bitmap;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.service.AnimationPuz;

public class AnimationSlime implements AnimationPuz {

	int countFrames;
	int frames;
	double speedAnimation;

	Bitmap sprite;
	Bitmap sprite1;
	Bitmap sprite2;
	Bitmap sprite3;
	Bitmap sprite4;
	Bitmap sprite5;
	Bitmap sprite6;

	public AnimationSlime(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4, Bitmap sprite5, Bitmap sprite6) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.sprite3 = sprite3;
		this.sprite4 = sprite4;
		this.sprite5 = sprite5;
		this.sprite6 = sprite6;
		sprite = sprite1;
		frames = 35;
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
		if (countFrames==24) {
			sprite = sprite5;
		}
		if (countFrames==30) {
			sprite = sprite6;
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
