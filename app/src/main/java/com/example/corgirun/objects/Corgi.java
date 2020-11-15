package com.example.corgirun.objects;

import android.graphics.Rect;
import com.example.puzzle.AnimationGamePuz;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;
import com.example.corgirun.utilits.ResourceUtils;

public class Corgi extends ObjectPuz {

	private double GRAVITY = -0.15;
	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;
	final private CorePuz corePuz;
	AnimationGamePuz animationSpriteCorgi;
	boolean jump;
	boolean jumpUp;
	private int jumpSpeed;
	boolean duckDown;
	private int HP;

	public Corgi(CorePuz corePuz, int maxScreenX, int maxScreenY, int minScreenY) {

		jump = false;
		jumpUp = false;
		duckDown = false;
		x = 30;
		y = 100;
		speed = 0;
		jumpSpeed = 4;
		HP = 1;
		weight = ResourceUtils.spritePlayer.get(0).getWidth();
		height = ResourceUtils.spritePlayer.get(0).getHeight();
		this.corePuz = corePuz;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;

		radius = (ResourceUtils.spritePlayer.get(0).getHeight() - 8) / 2;

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
			doJump(jumpSpeed);
		}
		if (corePuz.getTouchListenerPuz().getTouchDown(0, maxScreenY, maxScreenX/2, maxScreenY)) {
			doDuckDown();
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(0, maxScreenY, maxScreenX, maxScreenY)) {
			stopDuckDown();
			stopJump();
		}

		y -= speed;
		speed += GRAVITY;

		if (y < (minScreenY+40)) {
			y = (minScreenY+40);
		}

		if (y >= 100) {
			y = 100;
			speed = 0;
			if (jump) {
				speed = jumpSpeed;
			}
			else {
				jumpUp = false;
			}
		}

		if (!jump && !duckDown && speed == 0) {
			animationSpriteCorgi.runAnimation();
		}

		if (jump || speed != 0) {
			animationSpriteCorgi.runAnimationJump();
		}

		if (!jump && speed == 0 && duckDown) {
			animationSpriteCorgi.runAnimationDuckDown();
		}

		hitBox = new Rect((int) x, (int) y, ResourceUtils.spritePlayer.get(0).getWidth(), ResourceUtils.spritePlayer.get(0).getHeight());

	}

	public void drawing(GraphicsPuz graphicsPuz) {

		animationSpriteCorgi.drawingAnimation(graphicsPuz, x, y);

	}

	private void doJump(int speed) {
		jump = true;
		if (!jumpUp) {
			this.speed = speed;
			jumpUp = true;
		}
	}

	private void stopJump() {
		jump = false;
	}

	private void doDuckDown() {
		duckDown = true;
	}

	private void stopDuckDown() {
		duckDown = false;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public boolean isDuckDown() {
		return duckDown;
	}

	public boolean isJump() {
		return jump;
	}

	public void setGRAVITY(double GRAVITY) {
		this.GRAVITY = GRAVITY;
	}

	public void setJumpSpeed(int jumpSpeed) {
		this.jumpSpeed = jumpSpeed;
	}

}
