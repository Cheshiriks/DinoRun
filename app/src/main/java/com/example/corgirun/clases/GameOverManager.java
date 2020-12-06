package com.example.corgirun.clases;

import com.example.corgirun.objects.ButtonExitAgain;
import com.example.corgirun.objects.ButtonPauseExit;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class GameOverManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	private ButtonExitAgain buttonExitAgain;
	private ButtonPauseExit buttonPauseExit;

	public GameOverManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;

		buttonExitAgain = new ButtonExitAgain(corePuz, 90, 51);
		buttonPauseExit = new ButtonPauseExit(corePuz, 90, 70);
	}

	public void update() {
		buttonExitAgain.update();
		buttonPauseExit.update();

	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {

		buttonExitAgain.drawing(graphicsPuz);
		buttonPauseExit.drawing(graphicsPuz);

	}

	public ButtonExitAgain getButtonExitAgain() {
		return buttonExitAgain;
	}

	public ButtonPauseExit getButtonPauseExit() {
		return buttonPauseExit;
	}

}
