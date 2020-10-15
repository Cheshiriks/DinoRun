package com.example.corgirun.clases;

import com.example.corgirun.objects.Background;
import com.example.corgirun.objects.Corgi;
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

	public GameManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;
		corgi = new Corgi(maxScreenX, maxScreenY, minScreenY);
		background_1 = new Background(60, 0, 0, maxScreenX, maxScreenY);
		background_2 = new Background(60, background_1.getWeight(), 0, maxScreenX, maxScreenY);
	}

	public void update() {
		background_1.update();
		background_2.update();
		corgi.update();
	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {
		background_1.drawing(graphicsPuz);
		background_2.drawing(graphicsPuz);
		corgi.drawing(graphicsPuz);
	}

}
