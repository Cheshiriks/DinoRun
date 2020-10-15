package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationBackgroundPuz;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Background extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	private int weight;
	AnimationBackgroundPuz animationBackground;

	public Background(int speed, int x, int y, int maxScreenX, int maxScreenY) {

		this.x = x;
		this.y = y;
		this.speed = speed;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		animationBackground = new AnimationBackgroundPuz(speed, ResourceUtils.background);
		weight = ResourceUtils.background.getWidth();

	}

	public void update() {

		x -= speed;

		if (x == -weight) {
			x = weight;
		}

	}

	public void drawing(GraphicsPuz graphicsPuz) {

		animationBackground.drawingAnimation(graphicsPuz, x, y);

	}

	public int getWeight() {
		return weight;
	}

}
