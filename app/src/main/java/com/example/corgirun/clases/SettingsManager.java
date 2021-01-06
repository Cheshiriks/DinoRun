package com.example.corgirun.clases;

import android.graphics.Color;
import com.example.corgirun.objects.ButtonThanksClose;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.SoundPuz;

public class SettingsManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	private ButtonThanksClose buttonThanksClose;
	private SoundPuz buttonSound;
	private boolean buttonOn;

	public SettingsManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;
		buttonOn = false;

		buttonSound = corePuz.getAudioPuz().newSound("button.wav");
		buttonThanksClose = new ButtonThanksClose(corePuz, 153, 37);
	}

	public void update() {
		buttonThanksClose.update();
	}

	public void drawing(GraphicsPuz graphicsPuz) {

		graphicsPuz.drawTexture(ResourceUtils.backPause, 76, 42);
		graphicsPuz.drawText("НАСТРОЙКИ", 96, 58, Color.WHITE, 16, ResourceUtils.menuFont);
		if (SettingsGameUtils.isSettings()) {
			graphicsPuz.drawText("FPS: ВКЛ", 100, 77, Color.GRAY, 16, ResourceUtils.menuFont);
		} else {
			graphicsPuz.drawText("FPS: ВЫКЛ", 100, 77, Color.GRAY, 16, ResourceUtils.menuFont);
		}
		buttonThanksClose.drawing(graphicsPuz);

	}

	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown(115, 76, 25, 10)) {
			if (!buttonOn) {
				buttonSound.play(1f);
			}
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(115, 76, 25, 10)) {
			buttonOn = false;
			return true;
		}
		return false;

	}

	public ButtonThanksClose getButtonThanksClose() {
		return buttonThanksClose;
	}

}