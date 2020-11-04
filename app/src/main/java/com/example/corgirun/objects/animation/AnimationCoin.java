package com.example.corgirun.objects.animation;

import android.graphics.Bitmap;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.service.AnimationPuz;

public class AnimationCoin implements AnimationPuz {

	double speedAnimation;

	Bitmap sprite;

	public AnimationCoin(double speedAnimation, Bitmap sprite) {
		this.speedAnimation = speedAnimation;
		this.sprite = sprite;
	}

	@Override
	public void runAnimation() {}

	@Override
	public void drawingAnimation(GraphicsPuz graphicsPuz, double x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
