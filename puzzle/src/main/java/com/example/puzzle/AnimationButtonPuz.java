package com.example.puzzle;

import android.graphics.Bitmap;

public class AnimationButtonPuz {

	Bitmap sprite;
	Bitmap sprite1;
	Bitmap sprite2;

	public AnimationButtonPuz(Bitmap sprite1, Bitmap sprite2) {
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
		sprite = sprite1;
	}

	public void runAnimationOff() {
		sprite = sprite1;
	}

	public void runAnimationOn() {
		sprite = sprite2;
	}

	public void drawingAnimation(GraphicsPuz graphicsPuz, int x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
