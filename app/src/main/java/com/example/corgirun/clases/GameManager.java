package com.example.corgirun.clases;

import com.example.corgirun.objects.Background;
import com.example.corgirun.objects.ButtonPause;
import com.example.corgirun.objects.Corgi;
import com.example.corgirun.objects.Fire;
import com.example.corgirun.objects.Fireplace;
import com.example.corgirun.objects.Ghost;
import com.example.corgirun.objects.Picture;
import com.example.corgirun.objects.Witch;
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
	Ghost ghost4;

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

		witch = new Witch(0, 0.1, 2*maxScreenX, 60, maxScreenX, maxScreenY);
		witch2 = new Witch(0, 0.1, 2*maxScreenX, 60, maxScreenX, maxScreenY);
		ghost = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		ghost2 = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		witch3 = new Witch(0, 0.1, 2*maxScreenX, 60, maxScreenX, maxScreenY);
		witch4 = new Witch(0, 0.1, 2*maxScreenX, 60, maxScreenX, maxScreenY);
		ghost3 = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		ghost4 = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);

		background_1 = new Background(1, 0, 0, maxScreenX, maxScreenY);
		background_2 = new Background(1, background_1.getWeight(), 0, maxScreenX, maxScreenY);
		fireplace = new Fireplace(1, 144, 0, maxScreenX, maxScreenY);
		picture = new Picture(1, 96, 0, maxScreenX, maxScreenY);
		fire = new Fire(1, 432, 0, maxScreenX, maxScreenY);

		buttonPause = new ButtonPause(corePuz, 0, 0);

		enemiesList.add(witch);
		enemiesList.add(ghost);
		enemiesList.add(witch2);
		enemiesList.add(ghost2);
		enemiesList.add(witch3);
		enemiesList.add(ghost3);
		enemiesList.add(witch4);
		enemiesList.add(ghost4);

		lastEnemy = enemiesList.get(0);
		lastEnemy.setSpeed(1.5);
	}

	public void update() {
		background_1.update();
		background_2.update();
		fireplace.update();
		picture.update();
		fire.update();

		buttonPause.update();

		witch.update();
		witch2.update();
		ghost.update();
		ghost2.update();
		witch3.update();
		witch4.update();
		ghost3.update();
		ghost4.update();

		corgi.update();

		distance += background_1.getSpeed() / 10;

		generateEnemies(enemiesList);
	}

	public void drawing(CorePuz corePuz, GraphicsPuz graphicsPuz) {
		background_1.drawing(graphicsPuz);
		background_2.drawing(graphicsPuz);
		fireplace.drawing(graphicsPuz);
		picture.drawing(graphicsPuz);
		fire.drawing(graphicsPuz);

		buttonPause.drawing(graphicsPuz);

		witch.drawing(graphicsPuz);
		witch2.drawing(graphicsPuz);
		ghost.drawing(graphicsPuz);
		ghost2.drawing(graphicsPuz);
		witch3.drawing(graphicsPuz);
		witch4.drawing(graphicsPuz);
		ghost3.drawing(graphicsPuz);
		ghost4.drawing(graphicsPuz);

		corgi.drawing(graphicsPuz);
	}

	public ButtonPause getButtonPause() {
		return buttonPause;
	}

	public double getDistance() {
		return distance;
	}

	private void generateEnemies(ArrayList<ObjectPuz> enemiesList) {

		if (lastEnemy.getX() < 2*maxScreenX - randomDistance()) {

			ArrayList<ObjectPuz> enemiesList2 = new ArrayList<>();
			for (ObjectPuz enemy : enemiesList) {
				if (enemy.getX() == 2 * maxScreenX) {
					enemiesList2.add(enemy);
				}
			}

			lastEnemy = enemiesList2.get(randomEnemy(enemiesList2.size() - 1));
			lastEnemy.setSpeed(1.5);
		}
	}

	private int randomDistance() {
		return 140 + (int) (Math.random() * 100);
	}

	private int randomEnemy(int max) {
		return (int) (Math.random()*max);
	}

}
