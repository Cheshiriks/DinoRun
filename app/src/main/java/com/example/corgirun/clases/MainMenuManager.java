package com.example.corgirun.clases;

import com.example.corgirun.objects.ButtonCoins;
import com.example.corgirun.objects.ButtonLeft;
import com.example.corgirun.objects.ButtonPlay;
import com.example.corgirun.objects.ButtonQues;
import com.example.corgirun.objects.ButtonRight;
import com.example.corgirun.objects.Dinosaurs;
import com.example.corgirun.objects.Fire;
import com.example.corgirun.utilits.ResourceUtils;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;

public class MainMenuManager {

	private int maxScreenY;
	private int maxScreenX;

	private int sprite;

	private Fire fire1;
	private Fire fire2;

	private ButtonLeft buttonLeft;
	private ButtonRight buttonRight;

	private ButtonCoins coins500;
	private ButtonCoins coins1000;
	private ButtonCoins coins3000;
	private ButtonCoins hi20000;

	private ButtonPlay buttonPlay;
	private ButtonQues buttonQues;

	private Dinosaurs dinosaurs;

	public MainMenuManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		sprite = 0;

		fire1 = new Fire(0, 0, 0, maxScreenX, maxScreenY);
		fire2 = new Fire(0, 192, 0, maxScreenX, maxScreenY);

		buttonLeft = new ButtonLeft(corePuz, 61, 55);
		buttonRight = new ButtonRight(corePuz, 161, 55);

		coins500 = new ButtonCoins(corePuz, 90, 96, 500);
		coins1000 = new ButtonCoins(corePuz, 90, 96, 1000);
		coins3000 = new ButtonCoins(corePuz, 90, 96, 3000);
		hi20000 = new ButtonCoins(corePuz, 90, 96, 20000);

		buttonPlay = new ButtonPlay(corePuz, 109, 93);
		buttonQues = new ButtonQues(corePuz, 220, 4);

		dinosaurs = new Dinosaurs(96, 30, sprite, SettingsGameUtils.getIsBought(sprite));
	}

	public void update() {
		fire1.update();
		fire2.update();
		buttonQues.update();

		buttonLeft.update();
		buttonRight.update();

		if (sprite == 1 && !dinosaurs.isBought()) {

			coins500.setX(90);
			coins1000.setX(-200);
			coins3000.setX(-200);
			hi20000.setX(-200);
			buttonPlay.setX(-200);

			coins500.update();
		}
		if (sprite == 3 && !dinosaurs.isBought()) {

			coins500.setX(-200);
			coins1000.setX(90);
			coins3000.setX(-200);
			hi20000.setX(-200);
			buttonPlay.setX(-200);

			coins1000.update();
		}
		if (sprite == 4 && !dinosaurs.isBought()) {

			coins500.setX(-200);
			coins1000.setX(-200);
			coins3000.setX(90);
			hi20000.setX(-200);
			buttonPlay.setX(-200);

			coins3000.update();
		}
		if (sprite == 5 && !dinosaurs.isBought()) {

			coins500.setX(-200);
			coins1000.setX(-200);
			coins3000.setX(-200);
			hi20000.setX(90);
			buttonPlay.setX(-200);

			hi20000.update();
		}

		if (dinosaurs.isBought()) {

			coins500.setX(-200);
			coins1000.setX(-200);
			coins3000.setX(-200);
			hi20000.setX(-200);
			buttonPlay.setX(109);

			buttonPlay.update();
		}

		dinosaurs.update();
	}

	public void drawing(GraphicsPuz graphicsPuz) {
		fire1.drawing(graphicsPuz);
		fire2.drawing(graphicsPuz);
		buttonQues.drawing(graphicsPuz);

		buttonLeft.drawing(graphicsPuz);
		buttonRight.drawing(graphicsPuz);

		if (sprite == 1 && !dinosaurs.isBought()) {
			coins500.drawing(graphicsPuz);
		}
		if (sprite == 3 && !dinosaurs.isBought()) {
			coins1000.drawing(graphicsPuz);
		}
		if (sprite == 4 && !dinosaurs.isBought()) {
			coins3000.drawing(graphicsPuz);
		}
		if (sprite == 5 && !dinosaurs.isBought()) {
			hi20000.drawing(graphicsPuz);
		}

		if (dinosaurs.isBought()) {
			buttonPlay.drawing(graphicsPuz);
		}

		dinosaurs.drawing(graphicsPuz);


		//замок для некупленных
		if (!dinosaurs.isBought()) {
			graphicsPuz.drawTexture(ResourceUtils.lock, 119, 44);
		}

		//затемнение стрелок на границе
		if (sprite == 0) {
			graphicsPuz.drawTexture(ResourceUtils.buttArrows.get(1), 61, 55);
		}
		if (sprite == 5) {
			graphicsPuz.drawTexture(ResourceUtils.buttArrows.get(3), 161, 55);
		}
	}

	public ButtonQues getButtonQues() {
		return buttonQues;
	}

	public ButtonLeft getButtonLeft() {
		return buttonLeft;
	}

	public ButtonRight getButtonRight() {
		return buttonRight;
	}

	public ButtonPlay getButtonPlay() {
		return buttonPlay;
	}

	public ButtonCoins getCoins500() {
		return coins500;
	}

	public ButtonCoins getCoins1000() {
		return coins1000;
	}

	public ButtonCoins getCoins3000() {
		return coins3000;
	}

	public ButtonCoins getHi20000() {
		return hi20000;
	}

	public int getSprite() {
		return sprite;
	}

	public void setSprite(int sprite) {
		this.sprite = sprite;
	}

	public Dinosaurs getDinosaurs() {
		return dinosaurs;
	}

	public void setDinosaurs(Dinosaurs dinosaurs) {
		this.dinosaurs = dinosaurs;
	}

}
