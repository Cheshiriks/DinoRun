package com.example.corgirun.objects;

import android.graphics.Rect;
import com.example.corgirun.objects.animation.AnimationCoin;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Coin extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	AnimationCoin animationCoin;

	public Coin(double speedX, double x, double y, int maxScreenX, int maxScreenY) {
		this.x = x;
		this.y = y;
		this.speed = speedX;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		weight = ResourceUtils.spriteCoin.getWidth();
		height = ResourceUtils.spriteCoin.getHeight();
		radius = ResourceUtils.spriteCoin.getHeight() / 2;
		animationCoin = new AnimationCoin(
				speed,
				ResourceUtils.spriteCoin
		);
	}

	@Override
	public void update() {
		x -= speed;
		if (x <= -weight) {
			x = 2*maxScreenX;
			speed = 0;
		}

		hitBox = new Rect((int) x, (int) y, weight, height);
	}

	@Override
	public void drawing(GraphicsPuz graphicsPuz) {
		animationCoin.drawingAnimation(graphicsPuz, x, y);
	}

}
