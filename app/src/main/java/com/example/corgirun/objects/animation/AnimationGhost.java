package com.example.corgirun.objects.animation;

import android.graphics.Bitmap;
import com.example.puzzle.GraphicsPuz;

public class AnimationGhost {

	int frames;
	double speedAnimation;

	Bitmap sprite;
	Bitmap sprite1;

	public AnimationGhost(double speedAnimation, Bitmap sprite1) {
		this.speedAnimation = speedAnimation;
		this.sprite1 = sprite1;
		sprite = sprite1;
		frames = 170;
	}

	public void runAnimation() {
		sprite = sprite1;
	}

	public void drawingAnimation(GraphicsPuz graphicsPuz, double x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
