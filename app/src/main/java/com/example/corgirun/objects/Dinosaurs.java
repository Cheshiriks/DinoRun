package com.example.corgirun.objects;

import com.example.corgirun.objects.animation.AnimationDinosaurs;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;

public class Dinosaurs extends ObjectPuz {

	AnimationDinosaurs animationDinosaurs;
	private boolean isBought;

	public Dinosaurs(double x, double y, int sprite, boolean isBought) {
		this.x = x;
		this.y = y;
		this.isBought = isBought;
		animationDinosaurs = new AnimationDinosaurs(
				ResourceUtils.spriteDinosaurs.get(sprite)
		);
	}

	@Override
	public void update() {
		animationDinosaurs.runAnimation();
	}

	@Override
	public void drawing(GraphicsPuz graphicsPuz) {
		animationDinosaurs.drawingAnimation(graphicsPuz, x, y);
	}

	public AnimationDinosaurs getAnimationDinosaurs() {
		return animationDinosaurs;
	}

	public boolean isBought() {
		return isBought;
	}

	public void setBought(boolean bought) {
		isBought = bought;
	}

}
