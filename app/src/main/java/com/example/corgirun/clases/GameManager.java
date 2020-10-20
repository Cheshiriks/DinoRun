package com.example.corgirun.clases;

import com.example.corgirun.objects.Background;
import com.example.corgirun.objects.ButtonPause;
import com.example.corgirun.objects.Corgi;
import com.example.corgirun.objects.Fire;
import com.example.corgirun.objects.Fireplace;
import com.example.corgirun.objects.Picture;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class GameManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	Corgi corgi;
	Background background_1;
	Background background_2;
	Fireplace fireplace;
	Picture picture;
	Fire fire;

	ButtonPause buttonPause;

	public GameManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;
		corgi = new Corgi(corePuz, maxScreenX, maxScreenY, minScreenY);
		background_1 = new Background(1, 0, 0, maxScreenX, maxScreenY);
		background_2 = new Background(1, background_1.getWeight(), 0, maxScreenX, maxScreenY);
		fireplace = new Fireplace(1, 144, 0, maxScreenX, maxScreenY);
		picture = new Picture(1, 96, 0, maxScreenX, maxScreenY);
		fire = new Fire(1, 432, 0, maxScreenX, maxScreenY);

		buttonPause = new ButtonPause(corePuz, 0, 0);
	}

	public void update() {
		background_1.update();
		background_2.update();
		fireplace.update();
		picture.update();
		fire.update();

		buttonPause.update();

		corgi.update();
	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {
		background_1.drawing(graphicsPuz);
		background_2.drawing(graphicsPuz);
		fireplace.drawing(graphicsPuz);
		picture.drawing(graphicsPuz);
		fire.drawing(graphicsPuz);

		buttonPause.drawing(graphicsPuz);

		corgi.drawing(graphicsPuz);
	}

	public ButtonPause getButtonPause() {
		return buttonPause;
	}

}
