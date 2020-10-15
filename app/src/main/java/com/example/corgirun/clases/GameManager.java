package com.example.corgirun.clases;

import com.example.corgirun.objects.Corgi;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class GameManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	Corgi corgi;

	public GameManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;
		corgi = new Corgi(maxScreenX, maxScreenY, minScreenY);
	}

	public void update() {
		corgi.update();
	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {
		corgi.drawing(graphicsPuz);
	}

}
