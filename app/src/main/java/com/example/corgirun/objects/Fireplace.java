package com.example.corgirun.objects;

import com.example.corgirun.clases.AnimationFireplace;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Fireplace extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	private int weight;
	AnimationFireplace animationFireplace;

	public Fireplace(int speed, int x, int y, int maxScreenX, int maxScreenY) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		weight = ResourceUtils.spriteFireplace.get(0).getWidth();
		animationFireplace = new AnimationFireplace(
				speed,
				ResourceUtils.spriteFireplace.get(0),
				ResourceUtils.spriteFireplace.get(1),
				ResourceUtils.spriteFireplace.get(2)
		);
	}

	public void update() {
		x -= speed;
		if (x == -weight) {
			x = (480-weight);
		}
		animationFireplace.runAnimation();
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		animationFireplace.drawingAnimation(graphicsPuz, x, y);
	}

}
