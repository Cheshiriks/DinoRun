package com.example.corgirun.objects;

import com.example.puzzle.AnimationGamePuz;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;
import com.example.corgirun.utilits.ResourceUtils;

public class Corgi extends ObjectPuz {

	final double GRAVITY = -0.15;
	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;
	AnimationGamePuz animationSpriteCorgi;
	boolean jump;
	boolean duckDown;
	private CorePuz corePuz;

	public Corgi(CorePuz corePuz, int maxScreenX, int maxScreenY, int minScreenY) {

		jump = false;
		duckDown = false;
		x = 30;
		y = 100;
		speed = 0;
		this.corePuz = corePuz;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		//this.maxScreenY = maxScreenY - ResourceUtils.spritePlayer.get(0).getHeight();
		animationSpriteCorgi = new AnimationGamePuz(
				speed,
				ResourceUtils.spritePlayer.get(0),
				ResourceUtils.spritePlayer.get(1),
				ResourceUtils.spritePlayer.get(2),
				ResourceUtils.spritePlayer.get(3),
				ResourceUtils.spritePlayer.get(4),
				ResourceUtils.spritePlayer.get(5),
				ResourceUtils.jumpCorgi,
				ResourceUtils.spriteDuckDown.get(0),
				ResourceUtils.spriteDuckDown.get(1),
				ResourceUtils.spriteDuckDown.get(2),
				ResourceUtils.spriteDuckDown.get(3),
				ResourceUtils.spriteDuckDown.get(4),
				ResourceUtils.spriteDuckDown.get(5)
		);

	}

	public void update() {

		if (corePuz.getTouchListenerPuz().getTouchDown(maxScreenX/2, maxScreenY, maxScreenX, maxScreenY)) {
			doJump(4);
		}
		if (corePuz.getTouchListenerPuz().getTouchDown(0, maxScreenY, maxScreenX/2, maxScreenY)) {
			doDuckDown();
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(0, maxScreenY, maxScreenX, maxScreenY)) {
			stopDuckDown();
		}

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

		if (!jump && !duckDown) {
			animationSpriteCorgi.runAnimation();
		}

		if (jump) {
			animationSpriteCorgi.runAnimationJump();
		}

		if (!jump && duckDown) {
			animationSpriteCorgi.runAnimationDuckDown();
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

	public void doDuckDown() {
		duckDown = true;
	}

	public void stopDuckDown() {
		duckDown = false;
	}

}
