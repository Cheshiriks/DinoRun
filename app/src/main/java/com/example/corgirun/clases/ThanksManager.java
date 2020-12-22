package com.example.corgirun.clases;

import com.example.corgirun.objects.ButtonThanksClose;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class ThanksManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	private ButtonThanksClose buttonThanksClose;

	public ThanksManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;

		buttonThanksClose = new ButtonThanksClose(corePuz, 153, 37);
	}

	public void update() {
		buttonThanksClose.update();
	}

	public void drawing(GraphicsPuz graphicsPuz) {

		graphicsPuz.drawTexture(ResourceUtils.thanks, 76, 42);
		buttonThanksClose.drawing(graphicsPuz);

	}

	public ButtonThanksClose getButtonThanksClose() {
		return buttonThanksClose;
	}

}