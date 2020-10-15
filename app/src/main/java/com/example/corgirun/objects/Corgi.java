package com.example.corgirun.objects;

import com.example.puzzle.AnimationGamePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;
import com.example.corgirun.utilits.ResourceUtils;

public class Corgi extends ObjectPuz {

	final int GRAVITY = -3;
	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;
	AnimationGamePuz animationSpriteCorgi;

	public Corgi(int maxScreenX, int maxScreenY, int minScreenY) {

		x = 200;
		y = 700;
		speed = 1;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY - ResourceUtils.spritePlayer.get(0).getHeight();
		animationSpriteCorgi = new AnimationGamePuz(speed, ResourceUtils.spritePlayer.get(0), ResourceUtils.spritePlayer.get(1), ResourceUtils.spritePlayer.get(2));

	}

	public void update() {

		y -= (speed + GRAVITY);

		if (y < minScreenY) {
			y = minScreenY;
		}

		if (y > 700) {
			y = 700;
		}

		animationSpriteCorgi.runAnimation();

	}

	public void drawing(GraphicsPuz graphicsPuz) {

		animationSpriteCorgi.drawingAnimation(graphicsPuz, x, y);

	}

}
