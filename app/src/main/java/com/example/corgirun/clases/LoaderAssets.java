package com.example.corgirun.clases;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import com.example.corgirun.R;
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

	}

	private void loadTextureDuckDown(GraphicsPuz graphicsPuz) {

		ResourceUtils.spriteDuckDown = new ArrayList<>();

		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 432, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 456, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 480, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 504, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 528, 0, 24, 24));
		ResourceUtils.spriteDuckDown.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 552, 0, 24, 24));

	}

	private void loadTextureJump(GraphicsPuz graphicsPuz) {
		ResourceUtils.jumpCorgi = graphicsPuz.newSprite(ResourceUtils.textureAtlas, 240, 0, 24, 24);
	}

	private void loadSpriteEnemies(GraphicsPuz graphicsPuz) {

		ResourceUtils.witchAtlas = graphicsPuz.newTexture("witch_atlas.png");

		ResourceUtils.spriteWitch = new ArrayList<>();

		ResourceUtils.spriteWitch.add(graphicsPuz.newSprite(ResourceUtils.witchAtlas, 0, 0, 48, 48));
		ResourceUtils.spriteWitch.add(graphicsPuz.newSprite(ResourceUtils.witchAtlas, 48, 0, 48, 48));

		ResourceUtils.spriteGhost = graphicsPuz.newTexture("ghost.png");

	}

	private void loadBackground(GraphicsPuz graphicsPuz) {
		ResourceUtils.background = graphicsPuz.newTexture("background.png");
	}

  //----загружаем камин----start
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
	//----загружаем камин----end


	//----загружаем картину----start
	private void loadPicture(GraphicsPuz graphicsPuz) {
		ResourceUtils.pictureAtlas = graphicsPuz.newTexture("picture.png");
	}

	private void loadSpritePicture(GraphicsPuz graphicsPuz) {
		ResourceUtils.spritePicture = new ArrayList<>();
		ResourceUtils.spritePicture.add(graphicsPuz.newSprite(ResourceUtils.pictureAtlas, 0, 0, 48, 135));
		ResourceUtils.spritePicture.add(graphicsPuz.newSprite(ResourceUtils.pictureAtlas, 48, 0, 48, 135));
	}
	//----загружаем картину----end

	//----загружаем подсвечник----start
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
	//----загружаем подсвечник----end

	//----загружаем меню----start
	private void loadMenu(GraphicsPuz graphicsPuz) {
		ResourceUtils.menu = graphicsPuz.newTexture("menu.png");
	}
	//----загружаем меню----end

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

	}

	private void loadOther(GraphicsPuz graphicsPuz) {

		ResourceUtils.backPause = graphicsPuz.newTexture("back_pause.png");

		if (VERSION.SDK_INT >= VERSION_CODES.O) {
			ResourceUtils.menuFont = corePuz.getResources().getFont(R.font.thintel);
		}
	}

}
