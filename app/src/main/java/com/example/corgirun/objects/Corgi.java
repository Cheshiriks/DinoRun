package com.example.corgirun.objects;

import com.example.puzzle.AnimationGamePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;
import com.example.corgirun.utilits.ResourceUtils;

public class Corgi extends ObjectPuz {

	final double GRAVITY = -0.15;
	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;
	AnimationGamePuz animationSpriteCorgi;
	boolean jump;

	public Corgi(int maxScreenX, int maxScreenY, int minScreenY) {

		jump = false;
		x = 30;
		y = 100;
		speed = 0;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY - ResourceUtils.spritePlayer.get(0).getHeight();
		animationSpriteCorgi = new AnimationGamePuz(
				speed,
				ResourceUtils.spritePlayer.get(0),
				ResourceUtils.spritePlayer.get(1),
				ResourceUtils.spritePlayer.get(2),
				ResourceUtils.spritePlayer.get(3),
				ResourceUtils.spritePlayer.get(4),
				ResourceUtils.spritePlayer.get(5),
				ResourceUtils.jumpCorgi
		);

	}

	public void update() {

		//speed != 0
		if (jump) {
			y -= speed;
			speed += GRAVITY;
		}

		if (y < (minScreenY+40)) {
			y = (minScreenY+40);
		}

		if (y > 100) {
			y = 100;
			speed = 0;
			jump = false;
		}

		if (!jump) {
			animationSpriteCorgi.runAnimation();
		}

		if (jump) {
			animationSpriteCorgi.runAnimationJump();
		}

	}

	public void drawing(GraphicsPuz graphicsPuz) {

		animationSpriteCorgi.drawingAnimation(graphicsPuz, x, y);

	}

	public void doJump(int speed) {
		if (!jump) {
			this.speed = speed;
			jump = true;
		}
	}

}
