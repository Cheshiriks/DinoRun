package com.example.corgirun.objects.animation;

import android.graphics.Bitmap;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.service.AnimationPuz;

public class AnimationDinosaurs implements AnimationPuz {

	Bitmap sprite;

	public AnimationDinosaurs(Bitmap sprite1) {
		sprite = sprite1;
	}

	@Override
	public void runAnimation() {
	}

	@Override
	public void drawingAnimation(GraphicsPuz graphicsPuz, double x, double y) {
		graphicsPuz.drawTexture(sprite, x, y);
	}

}
