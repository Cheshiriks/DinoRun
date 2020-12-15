package com.example.corgirun.clases;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import com.example.corgirun.R;
import com.example.corgirun.utilits.SettingsGameUtils;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.corgirun.utilits.ResourceUtils;
import java.util.ArrayList;

public class LoaderAssets {

	private CorePuz corePuz;

	public LoaderAssets(CorePuz corePuz, GraphicsPuz graphicsPuz) {

		this.corePuz = corePuz;

		loadTexture(graphicsPuz);
		loadSpritePlayer(graphicsPuz);
		loadTextureJump(graphicsPuz);
		loadTextureDuckDown(graphicsPuz);

		loadDinosaurs(graphicsPuz);

		loadSpriteEnemies(graphicsPuz);

		loadBackground(graphicsPuz);
		loadMenu(graphicsPuz);

		loadFireplace(graphicsPuz);
		loadSpriteFireplace(graphicsPuz);

		loadPicture(graphicsPuz);
		loadSpritePicture(graphicsPuz);

		loadFire(graphicsPuz);
		loadSpriteFire(graphicsPuz);

		loadButton(graphicsPuz);

		loadOther(graphicsPuz);

		loadCoin(graphicsPuz);

		//загружаем звукки и музыку
		loadAudio(corePuz);

		//загружаем настройки и сохранения
		SettingsGameUtils.loadSettings(corePuz);
	}

	private void loadAudio(CorePuz corePuz) {
		//ResourceUtils.gameMusic = corePuz.getAudioPuz().newMusic("horror.mp3");
		//ResourceUtils.coin = corePuz.getAudioPuz().newSound("coin.mp3");
		//ResourceUtils.jump = corePuz.getAudioPuz().newSound("jump.mp3");

	}

	private void loadTexture(GraphicsPuz graphicsPuz) {
		ResourceUtils.textureAtlas = graphicsPuz.newTexture("texture_atlas.png");
	}

	private void loadSpritePlayer(GraphicsPuz graphicsPuz) {

		ResourceUtils.spritePlayer = new ArrayList<>();

		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 96, 0, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 120, 0, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 144, 0, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 168, 0, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 192, 0, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 216, 0, 24, 24));

		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 96, 24, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 120, 24, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 144, 24, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 168, 24, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 192, 24, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 216, 24, 24, 24));

		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 96, 48, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 120, 48, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 144, 48, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 168, 48, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 192, 48, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 216, 48, 24, 24));

		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 96, 72, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 120, 72, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 144, 72, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 168, 72, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 192, 72, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 216, 72, 24, 24));

		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 96, 96, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 120, 96, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 144, 96, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 168, 96, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 192, 96, 24, 24));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 216, 96, 24, 24));

	}

	private void loadTextureDuckDown(GraphicsPuz graphicsPuz) {

		ResourceUtils.spriteDuckDown = new ArrayList<>();

		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 432, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 456, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 480, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 504, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 528, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 552, 0, 24, 24));

		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 432, 24, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 456, 24, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 480, 24, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 504, 24, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 528, 24, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 552, 24, 24, 24));

		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 432, 48, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 456, 48, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 480, 48, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 504, 48, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 528, 48, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 552, 48, 24, 24));

		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 432, 72, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 456, 72, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 480, 72, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 504, 72, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 528, 72, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 552, 72, 24, 24));

		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 432, 96, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 456, 96, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 480, 96, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 504, 96, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 528, 96, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 552, 96, 24, 24));

	}

	private void loadTextureJump(GraphicsPuz graphicsPuz) {

		ResourceUtils.jumpCorgi = new ArrayList<>();

		ResourceUtils.jumpCorgi.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 240, 0, 24, 24));
		ResourceUtils.jumpCorgi.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 240, 24, 24, 24));
		ResourceUtils.jumpCorgi.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 240, 48, 24, 24));
		ResourceUtils.jumpCorgi.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 240, 72, 24, 24));
		ResourceUtils.jumpCorgi.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 240, 96, 24, 24));
	}

	private void loadDinosaurs(GraphicsPuz graphicsPuz) {

		ResourceUtils.dinosaursAtlas = graphicsPuz.newTexture("dinosaurs.png");

		ResourceUtils.spriteDinosaurs = new ArrayList<>();
		ResourceUtils.spriteDinosaurs.add(graphicsPuz.newSprite(ResourceUtils.dinosaursAtlas, 0, 0, 48, 60));
		ResourceUtils.spriteDinosaurs.add(graphicsPuz.newSprite(ResourceUtils.dinosaursAtlas, 48, 0, 48, 60));
		ResourceUtils.spriteDinosaurs.add(graphicsPuz.newSprite(ResourceUtils.dinosaursAtlas, 96, 0, 48, 60));
		ResourceUtils.spriteDinosaurs.add(graphicsPuz.newSprite(ResourceUtils.dinosaursAtlas, 144, 0, 48, 60));
		ResourceUtils.spriteDinosaurs.add(graphicsPuz.newSprite(ResourceUtils.dinosaursAtlas, 192, 0, 48, 60));

	}

	private void loadSpriteEnemies(GraphicsPuz graphicsPuz) {

		ResourceUtils.witchAtlas = graphicsPuz.newTexture("witch_atlas.png");

		ResourceUtils.spriteWitch = new ArrayList<>();
		ResourceUtils.spriteWitch.add(graphicsPuz.newSprite(ResourceUtils.witchAtlas, 0, 0, 36, 40));
		ResourceUtils.spriteWitch.add(graphicsPuz.newSprite(ResourceUtils.witchAtlas, 36, 0, 36, 40));
		ResourceUtils.spriteWitch.add(graphicsPuz.newSprite(ResourceUtils.witchAtlas, 0, 40, 36, 40));
		ResourceUtils.spriteWitch.add(graphicsPuz.newSprite(ResourceUtils.witchAtlas, 36, 40, 36, 40));

		ResourceUtils.slimeAtlas = graphicsPuz.newTexture("slime_atlas.png");

		ResourceUtils.spriteSlime = new ArrayList<>();
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 0, 0, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 32, 0, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 64, 0, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 96, 0, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 128, 0, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 160, 0, 32, 32));

		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 0, 32, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 32, 32, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 64, 32, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 96, 32, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 128, 32, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 160, 32, 32, 32));

		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 0, 64, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 32, 64, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 64, 64, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 96, 64, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 128, 64, 32, 32));
		ResourceUtils.spriteSlime.add(graphicsPuz.newSprite(ResourceUtils.slimeAtlas, 160, 64, 32, 32));

		ResourceUtils.spriteGhost = graphicsPuz.newTexture("ghost.png");

	}

	private void loadBackground(GraphicsPuz graphicsPuz) {
		ResourceUtils.background = graphicsPuz.newTexture("background.png");
	}

	private void loadCoin(GraphicsPuz graphicsPuz) {
		ResourceUtils.spriteCoin = graphicsPuz.newTexture("coin.png");
	}

  //загружаем камин----start
	private void loadFireplace(GraphicsPuz graphicsPuz) {
		ResourceUtils.fireplaceAtlas = graphicsPuz.newTexture("fireplace.png");
	}

	private void loadSpriteFireplace(GraphicsPuz graphicsPuz) {
		ResourceUtils.spriteFireplace = new ArrayList<>();
		ResourceUtils.spriteFireplace.add(graphicsPuz.newSprite(ResourceUtils.fireplaceAtlas, 0, 0, 128, 135));
		ResourceUtils.spriteFireplace.add(graphicsPuz.newSprite(ResourceUtils.fireplaceAtlas, 128, 0, 128, 135));
		ResourceUtils.spriteFireplace.add(graphicsPuz.newSprite(ResourceUtils.fireplaceAtlas, 0, 0, 128, 135));
		ResourceUtils.spriteFireplace.add(graphicsPuz.newSprite(ResourceUtils.fireplaceAtlas, 256, 0, 128, 135));
	}
	//загружаем камин----end


	//загружаем картину----start
	private void loadPicture(GraphicsPuz graphicsPuz) {
		ResourceUtils.pictureAtlas = graphicsPuz.newTexture("picture.png");
	}

	private void loadSpritePicture(GraphicsPuz graphicsPuz) {
		ResourceUtils.spritePicture = new ArrayList<>();
		ResourceUtils.spritePicture.add(graphicsPuz.newSprite(ResourceUtils.pictureAtlas, 0, 0, 48, 135));
		ResourceUtils.spritePicture.add(graphicsPuz.newSprite(ResourceUtils.pictureAtlas, 48, 0, 48, 135));
	}
	//загружаем картину----end


	//загружаем подсвечник----start
	private void loadFire(GraphicsPuz graphicsPuz) {
		ResourceUtils.fireAtlas = graphicsPuz.newTexture("fire.png");
	}

	private void loadSpriteFire(GraphicsPuz graphicsPuz) {
		ResourceUtils.spriteFire = new ArrayList<>();
		ResourceUtils.spriteFire.add(graphicsPuz.newSprite(ResourceUtils.fireAtlas, 0, 0, 48, 135));
		ResourceUtils.spriteFire.add(graphicsPuz.newSprite(ResourceUtils.fireAtlas, 48, 0, 48, 135));
		ResourceUtils.spriteFire.add(graphicsPuz.newSprite(ResourceUtils.fireAtlas, 96, 0, 48, 135));
		ResourceUtils.spriteFire.add(graphicsPuz.newSprite(ResourceUtils.fireAtlas, 48, 0, 48, 135));
	}
	//загружаем подсвечник----end


	//загружаем меню и экран обучения ----start
	private void loadMenu(GraphicsPuz graphicsPuz) {
		ResourceUtils.menu = graphicsPuz.newTexture("menu.png");
		ResourceUtils.training = graphicsPuz.newTexture("training.png");
	}
	//загружаем меню и экран обучения ----end

	private void loadButton(GraphicsPuz graphicsPuz) {

		ResourceUtils.buttPauseAtlas = graphicsPuz.newTexture("butt_pause.png");

		ResourceUtils.buttPause = new ArrayList<>();
		ResourceUtils.buttPause.add(graphicsPuz.newSprite(ResourceUtils.buttPauseAtlas, 0, 0, 20, 20));
		ResourceUtils.buttPause.add(graphicsPuz.newSprite(ResourceUtils.buttPauseAtlas, 0, 20, 20, 20));

		ResourceUtils.buttonsPauseAtlas = graphicsPuz.newTexture("butt_menu_pause.png");

		ResourceUtils.buttPauseContinue = new ArrayList<>();
		ResourceUtils.buttPauseContinue.add(graphicsPuz.newSprite(ResourceUtils.buttonsPauseAtlas, 1, 1, 58, 15));
		ResourceUtils.buttPauseContinue.add(graphicsPuz.newSprite(ResourceUtils.buttonsPauseAtlas, 64, 1, 58, 15));
		ResourceUtils.buttPauseExit = new ArrayList<>();
		ResourceUtils.buttPauseExit.add(graphicsPuz.newSprite(ResourceUtils.buttonsPauseAtlas, 1, 20, 58, 15));
		ResourceUtils.buttPauseExit.add(graphicsPuz.newSprite(ResourceUtils.buttonsPauseAtlas, 64, 20, 58, 15));

		ResourceUtils.buttonsExitAtlas = graphicsPuz.newTexture("butt_menu_exit.png");

		ResourceUtils.buttExitAgain = new ArrayList<>();
		ResourceUtils.buttExitAgain.add(graphicsPuz.newSprite(ResourceUtils.buttonsExitAtlas, 1, 1, 58, 15));
		ResourceUtils.buttExitAgain.add(graphicsPuz.newSprite(ResourceUtils.buttonsExitAtlas, 64, 1, 58, 15));
		ResourceUtils.buttExitExit = new ArrayList<>();
		ResourceUtils.buttExitExit.add(graphicsPuz.newSprite(ResourceUtils.buttonsExitAtlas, 1, 20, 58, 15));
		ResourceUtils.buttExitExit.add(graphicsPuz.newSprite(ResourceUtils.buttonsExitAtlas, 64, 20, 58, 15));

		ResourceUtils.buttonsArrowsAtlas = graphicsPuz.newTexture("butt_arrows.png");

		ResourceUtils.buttArrows = new ArrayList<>();
		ResourceUtils.buttArrows.add(graphicsPuz.newSprite(ResourceUtils.buttonsArrowsAtlas, 0, 0, 17, 21));
		ResourceUtils.buttArrows.add(graphicsPuz.newSprite(ResourceUtils.buttonsArrowsAtlas, 0, 25, 17, 21));
		ResourceUtils.buttArrows.add(graphicsPuz.newSprite(ResourceUtils.buttonsArrowsAtlas, 19, 0, 17, 21));
		ResourceUtils.buttArrows.add(graphicsPuz.newSprite(ResourceUtils.buttonsArrowsAtlas, 19, 25, 17, 21));

		ResourceUtils.buttonsPlayAtlas = graphicsPuz.newTexture("butt_play.png");

		ResourceUtils.buttPlay = new ArrayList<>();
		ResourceUtils.buttPlay.add(graphicsPuz.newSprite(ResourceUtils.buttonsPlayAtlas, 25, 0, 21, 21));
		ResourceUtils.buttPlay.add(graphicsPuz.newSprite(ResourceUtils.buttonsPlayAtlas, 0, 0, 21, 21));

		ResourceUtils.buttonsCoinsAtlas = graphicsPuz.newTexture("butt_coins.png");

		ResourceUtils.buttCoins = new ArrayList<>();
		ResourceUtils.buttCoins.add(graphicsPuz.newSprite(ResourceUtils.buttonsCoinsAtlas, 0, 0, 58, 15));
		ResourceUtils.buttCoins.add(graphicsPuz.newSprite(ResourceUtils.buttonsCoinsAtlas, 58, 0, 58, 15));
		ResourceUtils.buttCoins.add(graphicsPuz.newSprite(ResourceUtils.buttonsCoinsAtlas, 0, 15, 58, 15));
		ResourceUtils.buttCoins.add(graphicsPuz.newSprite(ResourceUtils.buttonsCoinsAtlas, 58, 15, 58, 15));
		ResourceUtils.buttCoins.add(graphicsPuz.newSprite(ResourceUtils.buttonsCoinsAtlas, 0, 30, 58, 15));
		ResourceUtils.buttCoins.add(graphicsPuz.newSprite(ResourceUtils.buttonsCoinsAtlas, 58, 30, 58, 15));

	}

	private void loadOther(GraphicsPuz graphicsPuz) {

		ResourceUtils.backPause = graphicsPuz.newTexture("back_pause.png");
		ResourceUtils.lock = graphicsPuz.newTexture("lock.png");

		if (VERSION.SDK_INT >= VERSION_CODES.O) {
			ResourceUtils.menuFont = corePuz.getResources().getFont(R.font.thintel);
		}
	}

}
