package com.example.corgirun.objects;


import com.example.corgirun.objects.animation.AnimationPicture;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Picture extends ObjectPuz {

	final int MAX_SPEED = 15;
	final int MIN_SPEED = 1;

	private int weight;
	AnimationPicture animationPicture;

	public Picture(int speed, int x, int y, int maxScreenX, int maxScreenY) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.maxScreenX = maxScreenX;
		this.maxScreenY = maxScreenY;
		weight = ResourceUtils.spritePicture.get(0).getWidth();
		animationPicture = new AnimationPicture(
				speed,
				ResourceUtils.spritePicture.get(0),
				ResourceUtils.spritePicture.get(1)
		);
	}

	public void update() {
		x -= speed;
		if (x <= -weight) {
			x = (480-weight);
		}
		animationPicture.runAnimation();
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		animationPicture.drawingAnimation(graphicsPuz, x, y);
	}

}
