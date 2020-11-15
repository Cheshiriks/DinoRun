package com.example.corgirun.objects;

import com.example.corgirun.objects.animation.AnimationFire;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Fire extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	private int weight;
	AnimationFire animationFire;

	public Fire(int speed, int x, int y, int maxScreenX, int maxScreenY) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		weight = ResourceUtils.spriteFire.get(0).getWidth();
		animationFire = new AnimationFire(
				speed,
				ResourceUtils.spriteFire.get(0),
				ResourceUtils.spriteFire.get(1),
				ResourceUtils.spriteFire.get(2),
				ResourceUtils.spriteFire.get(3)
		);
	}

	public void update() {
		x -= speed;
		if (x <= -weight) {
			x = (480-weight);
		}
		animationFire.runAnimation();
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		animationFire.drawingAnimation(graphicsPuz, x, y);
	}

}
