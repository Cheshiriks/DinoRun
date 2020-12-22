package com.example.corgirun.clases;

import com.example.corgirun.objects.ButtonExit100;
import com.example.corgirun.objects.ButtonExitAd;
import com.example.corgirun.objects.ButtonExitAgain;
import com.example.corgirun.objects.ButtonExitExit;
import com.example.corgirun.objects.ButtonExitX2Coin;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class GameOverManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	private ButtonExitAgain buttonExitAgain;
	private ButtonExitExit buttonExitExit;
	private ButtonExit100 buttonExit100;
	private ButtonExitAd buttonExitAd;
	private ButtonExitX2Coin buttonExitX2Coin;

	public GameOverManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;

		buttonExit100 = new ButtonExit100(corePuz, 56, 42);
		buttonExitAd = new ButtonExitAd(corePuz, 125, 42);
		buttonExitAgain = new ButtonExitAgain(corePuz, 90, 60);
		buttonExitX2Coin = new ButtonExitX2Coin(corePuz, 56, 78);
		buttonExitExit = new ButtonExitExit(corePuz, 125, 78);
	}

	public void update() {
		buttonExit100.update();
		buttonExitAd.update();
		buttonExitAgain.update();
		buttonExitX2Coin.update();
		buttonExitExit.update();

	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {
		graphicsPuz.drawTexture(ResourceUtils.backEnd, 41, 35);

		buttonExit100.drawing(graphicsPuz);
		buttonExitAd.drawing(graphicsPuz);
		buttonExitAgain.drawing(graphicsPuz);
		buttonExitX2Coin.drawing(graphicsPuz);
		buttonExitExit.drawing(graphicsPuz);

	}

	public ButtonExitAgain getButtonExitAgain() {
		return buttonExitAgain;
	}

	public ButtonExitExit getButtonExitExit() {
		return buttonExitExit;
	}

	public ButtonExit100 getButtonExit100() {
		return buttonExit100;
	}

	public ButtonExitAd getButtonExitAd() {
		return buttonExitAd;
	}

	public ButtonExitX2Coin getButtonExitX2Coin() {
		return buttonExitX2Coin;
	}

}
