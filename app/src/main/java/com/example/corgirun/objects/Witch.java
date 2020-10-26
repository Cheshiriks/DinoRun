package com.example.corgirun.objects;

import com.example.corgirun.objects.animation.AnimationWitch;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Witch extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	private int weight;
	private double speedY;
	private double Yo;
	AnimationWitch animationWitch;

	public Witch(double speedX, double speedY, double x, double y, int maxScreenX, int maxScreenY) {
		this.x = x;
		this.y = y;
		this.speed = speedX;
		this.speedY = speedY;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		this.Yo = y;
		weight = ResourceUtils.spriteWitch.get(0).getWidth();
		animationWitch = new AnimationWitch(
				speed,
				ResourceUtils.spriteWitch.get(0),
				ResourceUtils.spriteWitch.get(1)
		);
	}

	public void update() {
		y += speedY;
		if (y >= Yo + 3 || y == Yo) {
			speedY *= -1;
		}

		x -= speed;
		if (x <= -weight) {
			x = 2*maxScreenX;
			speed = 0;
		}
		animationWitch.runAnimation();
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		animationWitch.drawingAnimation(graphicsPuz, x, y);
	}

}
