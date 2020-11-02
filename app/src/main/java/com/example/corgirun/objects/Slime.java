package com.example.corgirun.objects;

import android.graphics.Rect;
import com.example.corgirun.clases.Type;
import com.example.corgirun.objects.animation.AnimationSlime;
import com.example.corgirun.objects.animation.AnimationWitch;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Slime extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	private double speedY;
	private double Yo;

	private final Type type;
	AnimationSlime animationSlime;

	public Slime(double speedX, double speedY, double x, double y, int maxScreenX, int maxScreenY, Type type) {
		this.x = x;
		this.y = y;
		this.speed = speedX;
		this.speedY = speedY;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		this.Yo = y;
		this.type = type;
		weight = ResourceUtils.spriteSlime.get(0).getWidth();
		height = ResourceUtils.spriteSlime.get(0).getHeight();
		radius = ResourceUtils.spriteSlime.get(0).getHeight() / 2;

		switch (type) {
			case SLIME_GREEN:
				animationSlime = new AnimationSlime(
						speed,
						ResourceUtils.spriteSlime.get(0),
						ResourceUtils.spriteSlime.get(1),
						ResourceUtils.spriteSlime.get(2),
						ResourceUtils.spriteSlime.get(3),
						ResourceUtils.spriteSlime.get(4),
						ResourceUtils.spriteSlime.get(5)
				);
				break;
			case SLIME_BLUE:
				animationSlime = new AnimationSlime(
						speed,
						ResourceUtils.spriteSlime.get(6),
						ResourceUtils.spriteSlime.get(7),
						ResourceUtils.spriteSlime.get(8),
						ResourceUtils.spriteSlime.get(9),
						ResourceUtils.spriteSlime.get(10),
						ResourceUtils.spriteSlime.get(11)
				);
				break;
			case SLIME_PINK:
				animationSlime = new AnimationSlime(
						speed,
						ResourceUtils.spriteSlime.get(12),
						ResourceUtils.spriteSlime.get(13),
						ResourceUtils.spriteSlime.get(14),
						ResourceUtils.spriteSlime.get(15),
						ResourceUtils.spriteSlime.get(16),
						ResourceUtils.spriteSlime.get(17)
				);
				break;
		}
	}

	@Override
	public void update() {
		x -= speed;
		if (x <= -weight) {
			x = 2 * maxScreenX;
			speed = 0;
		}
		animationSlime.runAnimation();

		hitBox = new Rect((int) x, (int) y, weight, height);
	}

	@Override
	public void drawing(GraphicsPuz graphicsPuz) {
		animationSlime.drawingAnimation(graphicsPuz, x, y);
	}

}
