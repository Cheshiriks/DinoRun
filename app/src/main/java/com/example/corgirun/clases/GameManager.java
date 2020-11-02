package com.example.corgirun.clases;

import com.example.corgirun.objects.Background;
import com.example.corgirun.objects.ButtonPause;
import com.example.corgirun.objects.Corgi;
import com.example.corgirun.objects.Fire;
import com.example.corgirun.objects.Fireplace;
import com.example.corgirun.objects.Ghost;
import com.example.corgirun.objects.Picture;
import com.example.corgirun.objects.Slime;
import com.example.corgirun.objects.Witch;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.puzzle.ObjectPuz;
import java.util.ArrayList;

public class GameManager {

	private int maxScreenY;
	private int maxScreenX;
	private int minScreenY;
	private int minScreenX;

	private double distance;

	Corgi corgi;

	Witch witch;
	Witch witch2;
	Ghost ghost;
	Ghost ghost2;
	Witch witch3;
	Witch witch4;
	Ghost ghost3;
	Slime slime1;
	Slime slime2;
	Slime slime3;
	Slime slime4;
	Slime slime5;
	Slime slime6;
	Slime slime7;
	Slime slime8;
	Slime slime9;

	Background background_1;
	Background background_2;
	Fireplace fireplace;
	Picture picture;
	Fire fire;

	ButtonPause buttonPause;

	ArrayList<ObjectPuz> enemiesList = new ArrayList<>();
	ObjectPuz lastEnemy;

	public GameManager(CorePuz corePuz, int sceneWidth, int sceneHeight) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;
		distance = 0;
		corgi = new Corgi(corePuz, maxScreenX, maxScreenY, minScreenY);

		witch = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_RED);
		witch2 = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_GREEN);
		witch3 = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_RED);
		witch4 = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_GREEN);
		ghost = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		ghost2 = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		ghost3 = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		slime1 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_GREEN);
		slime2 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_GREEN);
		slime3 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_GREEN);
		slime4 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_BLUE);
		slime5 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_BLUE);
		slime6 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_BLUE);
		slime7 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_PINK);
		slime8 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_PINK);
		slime9 = new Slime(0, 0.1, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_PINK);

		background_1 = new Background(1, 0, 0, maxScreenX, maxScreenY);
		background_2 = new Background(1, background_1.getWeight(), 0, maxScreenX, maxScreenY);
		fireplace = new Fireplace(1, 144, 0, maxScreenX, maxScreenY);
		picture = new Picture(1, 96, 0, maxScreenX, maxScreenY);
		fire = new Fire(1, 432, 0, maxScreenX, maxScreenY);

		buttonPause = new ButtonPause(corePuz, 0, 0);

		enemiesList.add(witch);
		enemiesList.add(slime4);
		enemiesList.add(ghost);
		enemiesList.add(slime7);
		enemiesList.add(slime1);
		enemiesList.add(witch2);
		enemiesList.add(slime5);
		enemiesList.add(slime8);
		enemiesList.add(ghost2);
		enemiesList.add(slime2);
		enemiesList.add(witch3);
		enemiesList.add(slime9);
		enemiesList.add(slime6);
		enemiesList.add(ghost3);
		enemiesList.add(slime3);
		enemiesList.add(witch4);

		lastEnemy = enemiesList.get(0);
		lastEnemy.setSpeed(1.5);
	}

	public void update() {

		generateEnemies(enemiesList, 1);
		setSpeedGame(1);

		background_1.update();
		background_2.update();
		fireplace.update();
		picture.update();
		fire.update();

		buttonPause.update();

		for (ObjectPuz enemy : enemiesList) {
			enemy.update();
		}

		corgi.update();

		distance += background_1.getSpeed() / 10;

		checkHit();

	}

	//Проверка столкновения игрока с объектами
	private void checkHit() {
		for (ObjectPuz enemy : enemiesList) {
			if (CollisionDetect.collisionDetect(corgi, enemy)) {
				corgi.setHP(corgi.getHP() - 1);
			}
		}
	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {
		background_1.drawing(graphicsPuz);
		background_2.drawing(graphicsPuz);
		fireplace.drawing(graphicsPuz);
		picture.drawing(graphicsPuz);
		fire.drawing(graphicsPuz);

		buttonPause.drawing(graphicsPuz);

		for (ObjectPuz enemy : enemiesList) {
			enemy.drawing(graphicsPuz);
		}

		corgi.drawing(graphicsPuz);
	}

	public ButtonPause getButtonPause() {
		return buttonPause;
	}

	public double getDistance() {
		return distance;
	}

	//Определяем пора ли выпустить нового врага
	private void generateEnemies(ArrayList<ObjectPuz> enemiesList, double speed) {

		if (lastEnemy.getX() < 2*maxScreenX - randomDistance()) {

			ArrayList<ObjectPuz> enemiesList2 = new ArrayList<>();
			for (ObjectPuz enemy : enemiesList) {
				if (enemy.getX() == 2 * maxScreenX) {
					enemiesList2.add(enemy);
				}
			}

			lastEnemy = enemiesList2.get(randomEnemy(enemiesList2.size() - 1));
			lastEnemy.setSpeed(0.5 + speed);
		}
	}

	private int randomDistance() {
		return 140 + (int) (Math.random() * 100);
	}

	private int randomEnemy(int max) {
		return (int) (Math.random()*max);
	}

	private void setSpeedGame(double speed) {

		background_1.setSpeed(speed);
		background_2.setSpeed(speed);
		fireplace.setSpeed(speed);
		picture.setSpeed(speed);
		fire.setSpeed(speed);

	}

	public Corgi getCorgi() {
		return corgi;
	}

	public void gameOver(CorePuz corePuz) {
		SettingsGameUtils.addDistance((int)distance);
		SettingsGameUtils.saveSettings(corePuz);
	}

}
