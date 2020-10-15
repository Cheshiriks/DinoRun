package com.example.corgirun.clases;

import android.graphics.Bitmap;
import com.example.puzzle.CorePuz;
import com.example.puzzle.GraphicsPuz;
import com.example.corgirun.utilits.ResourceUtils;
import java.util.ArrayList;

public class LoaderAssets {

	public LoaderAssets(CorePuz corePuz, GraphicsPuz graphicsPuz) {
		loadTexture(graphicsPuz);
		loadSpritePlayer(graphicsPuz);
		loadBackground(graphicsPuz);
	}

	private void loadSpritePlayer(GraphicsPuz graphicsPuz) {
		ResourceUtils.spritePlayer = new ArrayList<>();
		double prop = (double) 1080 / 120;

		Bitmap sprite01 = graphicsPuz.newSprite(ResourceUtils.textureAtlas, 0, 0, 100, 120);
		Bitmap sprite02 = graphicsPuz.newSprite(ResourceUtils.textureAtlas, 100, 0, 100, 120);
		Bitmap sprite03 = graphicsPuz.newSprite(ResourceUtils.textureAtlas, 200, 0, 100, 120);

		Bitmap sprite1 = Bitmap.createScaledBitmap(sprite01, (int)(sprite01.getWidth() * (prop/3)), (int)(sprite01.getHeight() * (prop/3)), true);
		Bitmap sprite2 = Bitmap.createScaledBitmap(sprite02, (int)(sprite02.getWidth() * (prop/3)), (int)(sprite02.getHeight() * (prop/3)), true);
		Bitmap sprite3 = Bitmap.createScaledBitmap(sprite03, (int)(sprite03.getWidth() * (prop/3)), (int)(sprite03.getHeight() * (prop/3)), true);

		ResourceUtils.spritePlayer.add(sprite1);
		ResourceUtils.spritePlayer.add(sprite2);
		ResourceUtils.spritePlayer.add(sprite3);

/*		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 0, 0, 100, 120));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 100, 0, 100, 120));
		ResourceUtils.spritePlayer.add(graphicsPuz.newSprite(ResourceUtils.textureAtlas, 200, 0, 100, 120));*/
	}

	private void loadTexture(GraphicsPuz graphicsPuz) {
		ResourceUtils.textureAtlas = graphicsPuz.newTexture("texture_atlas.png");
	}

	private void loadBackground(GraphicsPuz graphicsPuz) {
		//ResourceUtils.background = graphicsPuz.newTexture("background.png");

		Bitmap background = graphicsPuz.newTexture("background.png");
		double prop = (double) 1080 / background.getHeight();
		ResourceUtils.background = Bitmap.createScaledBitmap(background, (int)(background.getWidth() * (prop)), (int)(background.getHeight() * (prop)), true);

	}

}
