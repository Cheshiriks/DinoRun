package com.example.corgirun.objects;

import com.example.corgirun.objects.animation.AnimationGhost;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Ghost extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	private int weight;
	private double speedY;
	private double Yo;
	AnimationGhost animationGhost;

	public Ghost(double speedX, double speedY, double x, double y, int maxScreenX, int maxScreenY) {
		this.x = x;
		this.y = y;
		this.speed = speedX;
		this.speedY = speedY;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		this.Yo = y;
		weight = ResourceUtils.spriteGhost.getWidth();
		animationGhost = new AnimationGhost(
				speed,
				ResourceUtils.spriteGhost
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
		animationGhost.runAnimation();
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		animationGhost.drawingAnimation(graphicsPuz, x, y);
	}

}
