package com.example.corgirun.clases;

import com.example.corgirun.objects.ButtonLeft;
import com.example.corgirun.objects.ButtonRight;
import com.example.corgirun.objects.Fire;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class MainMenuManager {

	private int maxScreenY;
	private int maxScreenX;

	Fire fire1;
	Fire fire2;

	ButtonLeft buttonLeft;
	ButtonRight buttonRight;

	public MainMenuManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {

		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;

		fire1 = new Fire(0, 0, 0, maxScreenX, maxScreenY);
		fire2 = new Fire(0, 192, 0, maxScreenX, maxScreenY);

		buttonLeft = new ButtonLeft(corePuz, 61, 55);
		buttonRight = new ButtonRight(corePuz, 161, 55);
	}

	public void update() {
		fire1.update();
		fire2.update();

		buttonLeft.update();
		buttonRight.update();
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		fire1.drawing(graphicsPuz);
		fire2.drawing(graphicsPuz);

		buttonLeft.drawing(graphicsPuz);
		buttonRight.drawing(graphicsPuz);
	}

}
