package com.example.puzzle;

import android.graphics.Bitmap;

public class AnimationGamePuz {

	double speedAnimation;
	int delayIndex;
	int countFrames;
	int countFramesDD;
	int frames;

	Bitmap sprite;
	Bitmap sprite1;
	Bitmap sprite2;
	Bitmap sprite3;
	Bitmap sprite4;
	Bitmap sprite5;
	Bitmap sprite6;
	Bitmap spriteJump;
	Bitmap duckDown1;
	Bitmap duckDown2;
	Bitmap duckDown3;
	Bitmap duckDown4;
	Bitmap duckDown5;
	Bitmap duckDown6;

	public AnimationGamePuz(double speedAnimation, Bitmap sprite1,
			Bitmap sprite2, Bitmap sprite3,
			Bitmap sprite4, Bitmap sprite5,
			Bitmap sprite6, Bitmap spriteJump,
			Bitmap duckDown1, Bitmap duckDown2,
			Bitmap duckDown3, Bitmap duckDown4,
			Bitmap duckDown5, Bitmap duckDown6) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		this.sprite3 = sprite3;
		this.sprite4 = sprite4;
		this.sprite5 = sprite5;
		this.sprite6 = sprite6;
		this.spriteJump = spriteJump;
		this.duckDown1 = duckDown1;
		this.duckDown2 = duckDown2;
		this.duckDown3 = duckDown3;
		this.duckDown4 = duckDown4;
		this.duckDown5 = duckDown5;
		this.duckDown6 = duckDown6;
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

	public void runAnimationDuckDown() {
		if (countFramesDD==0) {
			sprite = duckDown1;
		}
		if (countFramesDD==3) {
			sprite = duckDown2;
		}
		if (countFramesDD==6) {
			sprite = duckDown3;
		}
		if (countFramesDD==9) {
			sprite = duckDown4;
		}
		if (countFramesDD==12) {
			sprite = duckDown5;
		}
		if (countFramesDD==15) {
			sprite = duckDown6;
		}
		countFramesDD++;

		if (countFramesDD>frames) {
			countFramesDD = 0;
		}
	}

	public void runAnimationJump() {
		sprite = spriteJump;
	}

	public void drawingAnimation(GraphicsPuz graphicsPuz, int x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
