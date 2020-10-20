package com.example.puzzle;

public abstract class ButtonPuz extends ObjectPuz {

	final protected CorePuz corePuz;
	protected AnimationButtonPuz animationButton;
	protected boolean buttonOn;

	public ButtonPuz(CorePuz corePuz) {
		this.corePuz = corePuz;
	}

	public void update() {

		isTouch(corePuz);

		if (!buttonOn) {
			animationButton.runAnimationOff();
		}

		if (buttonOn) {
			animationButton.runAnimationOn();
		}
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		animationButton.drawingAnimation(graphicsPuz, x, y);
	}

	public abstract boolean isTouch(CorePuz corePuz);

}
