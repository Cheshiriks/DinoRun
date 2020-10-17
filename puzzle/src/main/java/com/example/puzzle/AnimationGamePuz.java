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
	Bitmap sprite4;
	Bitmap sprite5;
	Bitmap sprite6;
	Bitmap spriteJump;

	public AnimationGamePuz(double speedAnimation, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4, Bitmap sprite5, Bitmap sprite6, Bitmap spriteJump) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.sprite3 = sprite3;
		this.sprite4 = sprite4;
		this.sprite5 = sprite5;
		this.sprite6 = sprite6;
		this.spriteJump = spriteJump;
		sprite = sprite1;
		frames = 18;
	}

	public void runAnimation() {
		delayIndex++;
		if (countFrames==0) {
			sprite = sprite1;
		}
		if (countFrames==3) {
			sprite = sprite2;
		}
		if (countFrames==6) {
			sprite = sprite3;
		}
		if (countFrames==9) {
			sprite = sprite4;
		}
		if (countFrames==12) {
			sprite = sprite5;
		}
		if (countFrames==15) {
			sprite = sprite6;
		}
		countFrames++;

		if (countFrames>frames) {
			countFrames = 0;
		}
	}

	public void runAnimationJump() {
		sprite = spriteJump;
	}

	public void drawingAnimation(GraphicsPuz graphicsPuz, int x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
