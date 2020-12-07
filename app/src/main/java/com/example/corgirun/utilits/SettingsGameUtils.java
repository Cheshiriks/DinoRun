package com.example.corgirun.utilits;

import android.content.SharedPreferences;
import com.example.puzzle.CorePuz;

public class SettingsGameUtils {

	public static int distance = 0;
	public static int coins = 0;

	public static boolean vita = true;
	public static boolean santa = false;
	public static boolean mort = true;
	public static boolean doux = false;
	public static boolean tard = false;


	public static void saveSettings(CorePuz corePuz) {
		SharedPreferences.Editor editor = corePuz.getSharedPreferences().edit();
		editor.clear(); //очищаем файл
		editor.putInt("passedDistance", distance);
		editor.putInt("gameCoins", coins);

		editor.putBoolean("dinoSanta", santa);
		editor.putBoolean("dinoDoux", doux);
		editor.putBoolean("dinoTard", tard);
		editor.apply(); //сохраняем в файл
	}

	public static void loadSettings(CorePuz corePuz) {
		distance = corePuz.getSharedPreferences().getInt("passedDistance", distance);
		coins = corePuz.getSharedPreferences().getInt("gameCoins", coins);

		santa = corePuz.getSharedPreferences().getBoolean("dinoSanta", santa);
		tard = corePuz.getSharedPreferences().getBoolean("dinoDoux", doux);
		mort = corePuz.getSharedPreferences().getBoolean("dinoTard", tard);
	}

	public static void addDistance(int values) {
		if (distance < values) {
			distance = values;
		}
	}

	public static void setCoins(int values) {
		coins += values;
	}

	public static void setIsBought(int dino, boolean isBought) {
		if (dino == 1) {
			santa = isBought;
		}
		if (dino == 3) {
			doux = isBought;
		}
		if (dino == 4) {
			tard = isBought;
		}
	}

	public static boolean getIsBought(int dino) {
		if (dino == 1) {
			return santa;
		}
		if (dino == 3) {
			return doux;
		}
		if (dino == 4) {
			return tard;
		}
		return true;
	}

}
