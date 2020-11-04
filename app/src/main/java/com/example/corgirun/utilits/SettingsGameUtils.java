package com.example.corgirun.utilits;

import android.content.SharedPreferences;
import com.example.puzzle.CorePuz;

public class SettingsGameUtils {

	public static int distance = 0;
	public static int coins = 0;

	public static void saveSettings(CorePuz corePuz) {
		SharedPreferences.Editor editor = corePuz.getSharedPreferences().edit();
		editor.clear(); //очищаем файл
		editor.putInt("passedDistance", distance);
		editor.putInt("gameCoins", coins);
		editor.apply(); //сохраняем в файл
	}

	public static void loadSettings(CorePuz corePuz) {
		distance = corePuz.getSharedPreferences().getInt("passedDistance", distance);
		coins = corePuz.getSharedPreferences().getInt("gameCoins", coins);
	}

	public static void addDistance(int values) {
		if (distance < values) {
			distance = values;
		}
	}

	public static void setCoins(int values) {
		coins += values;
	}

}
