package com.example.corgirun.clases;

import com.example.corgirun.objects.ButtonPauseContinue;
import com.example.corgirun.objects.ButtonPauseExit;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class PauseManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	private ButtonPauseContinue buttonPauseContinue;
	private ButtonPauseExit buttonPauseExit;

	public PauseManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;

		buttonPauseContinue = new ButtonPauseContinue(corePuz, 90, 51);
		buttonPauseExit = new ButtonPauseExit(corePuz, 90, 70);
	}

	public void update() {
		buttonPauseContinue.update();
		buttonPauseExit.update();

	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {

		buttonPauseContinue.drawing(graphicsPuz);
		buttonPauseExit.drawing(graphicsPuz);

	}

	public ButtonPauseContinue getButtonPauseContinue() {
		return buttonPauseContinue;
	}

	public ButtonPauseExit getButtonPauseExit() {
		return buttonPauseExit;
	}

}
