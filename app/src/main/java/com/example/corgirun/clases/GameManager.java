package com.example.corgirun.clases;

import com.example.corgirun.objects.Background;
import com.example.corgirun.objects.ButtonPause;
import com.example.corgirun.objects.Coin;
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
	private int gameCoins;

	private double speedGame;
	private int speedLvl;

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
	ArrayList<ArrayList<Coin>> coinsList = new ArrayList<>();
	ObjectPuz lastEnemy;

	public GameManager(CorePuz corePuz, int sceneWidth, int sceneHeight, Type dinoType) {
		this.maxScreenX = sceneWidth;
		this.maxScreenY = sceneHeight;
		this.minScreenX = 0;
		this.minScreenY = 0;
		distance = 0;
		gameCoins = 0;
		speedGame = 1;
		speedLvl = 1;
		corgi = new Corgi(corePuz, maxScreenX, maxScreenY, minScreenY, dinoType);

		witch = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_RED);
		witch2 = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_GREEN);
		witch3 = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_RED);
		witch4 = new Witch(0, 0.1, 2*maxScreenX, 64, maxScreenX, maxScreenY, Type.WITCH_GREEN);
		ghost = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		ghost2 = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		ghost3 = new Ghost(0, 0.1, 2*maxScreenX, 80, maxScreenX, maxScreenY);
		slime1 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_GREEN);
		slime2 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_GREEN);
		slime3 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_GREEN);
		slime4 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_BLUE);
		slime5 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_BLUE);
		slime6 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_BLUE);
		slime7 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_PINK);
		slime8 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_PINK);
		slime9 = new Slime(0, 2*maxScreenX, 91, maxScreenX, maxScreenY, Type.SLIME_PINK);

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

		createCoinsList(coinsList);
	}

	private void setSpeedEnemiesAndCoins(double speed) {
		for (ObjectPuz enemy : enemiesList) {
			if (enemy.getSpeed() != 0) {
				enemy.setSpeed(speed + 0.5);
			}
		}
		for (ArrayList<Coin> coinsListNew : coinsList) {
			for (Coin coin : coinsListNew) {
				if (coin.getSpeed() != 0) {
					coin.setSpeed(speed);
				}
			}
		}
	}

	public void update() {
		if (distance < 240) {

			if (distance < 120) {
				generateEnemies(enemiesList, 1, 200);
			} else {
				generateEnemies(enemiesList, 1, 100);
			}

			if (speedLvl == 1) {
				setSpeedGame(1);
				speedLvl = 2;
			}
		}
		else if (distance < 720) {

			if (distance < 360) {
				generateEnemies(enemiesList, 1.5, 200);
			} else if (distance < 660) {
				generateEnemies(enemiesList, 1.5, 100);
			} else {
				generateEnemies(enemiesList, 1.5, 200);
			}

			if (speedLvl == 2) {
				setSpeedGame(1.5);
				setSpeedEnemiesAndCoins(1.5);
				corgi.setGRAVITY(-0.235);
				corgi.setJumpSpeed(5);
				speedLvl = 3;
			}
		}
		else if (distance < 1440) {

			if (distance < 840) {
				generateEnemies(enemiesList, 2, 200);
			} else if (distance < 1080) {
				generateEnemies(enemiesList, 2, 100);
			} else if (distance < 1200) {
				generateEnemies(enemiesList, 2, 200);
			} else if (distance < 1320) {
				generateEnemies(enemiesList, 2, 100);
			} else {
				generateEnemies(enemiesList, 2, 200);
			}

			if (speedLvl == 3) {
				setSpeedGame(2);
				setSpeedEnemiesAndCoins(2);
				corgi.setGRAVITY(-0.3375);
				corgi.setJumpSpeed(6);
				speedLvl = 4;
			}
		}
		else if (distance < 2640) {

			if (distance < 1560) {
				generateEnemies(enemiesList, 2.5, 200);
			} else if (distance < 1920) {
				generateEnemies(enemiesList, 2.5, 100);
			} else if (distance < 2100) {
				generateEnemies(enemiesList, 2.5, 200);
			} else if (distance < 2520) {
				generateEnemies(enemiesList, 2.5, 100);
			} else {
				generateEnemies(enemiesList, 2.5, 200);
			}

			if (speedLvl == 4) {
				setSpeedGame(2.5);
				setSpeedEnemiesAndCoins(2.5);
				corgi.setGRAVITY(-0.46);
				corgi.setJumpSpeed(7);
				speedLvl = 5;
			}
		}
		else if (distance < 4080) {

			if (distance < 2880) {
				generateEnemies(enemiesList, 3, 200);
			} else if (distance < 3360) {
				generateEnemies(enemiesList, 3, 100);
			} else if (distance < 3600) {
				generateEnemies(enemiesList, 3, 200);
			} else if (distance < 3840) {
				generateEnemies(enemiesList, 3, 100);
			} else {
				generateEnemies(enemiesList, 3, 200);
			}

			if (speedLvl == 5) {
				setSpeedGame(3);
				setSpeedEnemiesAndCoins(3);
				corgi.setGRAVITY(-0.6);
				corgi.setJumpSpeed(8);
				speedLvl = 6;
			}
		}
		else {

			if ( (distance / 1000) % 2 == 1 ) {
				generateEnemies(enemiesList, 4, 120);
			}
			else {
				generateEnemies(enemiesList, 4, 200);
			}

			if (speedLvl == 6) {
				setSpeedGame(4);
				setSpeedEnemiesAndCoins(4);
				corgi.setGRAVITY(-0.9);
				corgi.setJumpSpeed(10);
				speedLvl = -1;
			}
		}

		background_1.update();
		background_2.update();
		fireplace.update();
		picture.update();
		fire.update();

		buttonPause.update();

		for (ArrayList<Coin> coinsListNew : coinsList) {
			for (Coin coin : coinsListNew) {
				coin.update();
			}
		}

		for (ObjectPuz enemy : enemiesList) {
			enemy.update();
		}

		corgi.update();

		distance += background_1.getSpeed() / 10;

		checkHit();

	}

	//Проверка столкновения игрока с объектом
	private void checkHit() {
		for (ObjectPuz enemy : enemiesList) {
			if (CollisionDetect.collisionDetect(corgi, enemy)) {
				corgi.setHP(corgi.getHP() - 1);
			}
		}

		for (ArrayList<Coin> coinsListNew : coinsList) {
			for (Coin coin : coinsListNew) {
				if (CollisionDetect.collisionDetect(corgi, coin)) {
					coin.setX(2*maxScreenX);
					coin.setSpeed(0);
					gameCoins++;
				}
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

		for (ArrayList<Coin> coinsListNew : coinsList) {
			for (Coin coin : coinsListNew) {
				coin.drawing(graphicsPuz);
			}
		}

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

	public int getGameCoins() {
		return gameCoins;
	}

	//Определяем пора ли выпустить нового врага
	private void generateEnemies(ArrayList<ObjectPuz> enemiesList, double speed, int finalX) {

		if (lastEnemy.getX() < 2*maxScreenX - randomDistance(finalX)) {

			ArrayList<ObjectPuz> enemiesList2 = new ArrayList<>();
			for (ObjectPuz enemy : enemiesList) {
				if (enemy.getX() == 2 * maxScreenX) {
					enemiesList2.add(enemy);
				}
			}

			lastEnemy = enemiesList2.get(randomEnemy(enemiesList2.size() - 1));
			lastEnemy.setSpeed(0.5 + speed);

			//вероятность создать монетки
			if ((Math.random() * 100) < 20) {
				generateCoin(coinsList, speed);
			}

		}
	}

	private void generateCoin(ArrayList<ArrayList<Coin>> coinsList, double speed) {
		ArrayList<ArrayList<Coin>> coinsList2 = new ArrayList<>();
		for (ArrayList<Coin> coinsListNew : coinsList) {
			boolean isSpeed = true;
			for (Coin coin : coinsListNew) {
				if (coin.getSpeed() != 0) {
					isSpeed = false;
					break;
				}
			}
			if (isSpeed) {
				coinsList2.add(coinsListNew);
			}
		}
		int x = -26;
		for (Coin coin : coinsList2.get(randomEnemy(coinsList2.size() - 1))) {
			x += 26;
			coin.setSpeed(speed);
			coin.setX(coin.getX() + x);
		}

	}

	private int randomDistance(int finalX) {
		return finalX + (int) (Math.random() * 500);
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
		SettingsGameUtils.setCoins(gameCoins);
		SettingsGameUtils.saveSettings(corePuz);
	}

	private void createCoinsList(ArrayList<ArrayList<Coin>> coinsList) {
		for (int i = 0; i<3; i++ ) {
			ArrayList<Coin> list = new ArrayList<>();
			ArrayList<Coin> list2 = new ArrayList<>();
			for (int j = 0; j<3; j++ ) {
				list.add(new Coin(0, 2*maxScreenX, 45, maxScreenX, maxScreenY));
				list2.add(new Coin(0, 2*maxScreenX, 100, maxScreenX, maxScreenY));
			}
			coinsList.add(list);
			coinsList.add(list2);
		}
	}

}
