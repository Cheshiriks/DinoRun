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
		loadTextureJump(graphicsPuz);

		loadTFireplace(graphicsPuz);
		loadSpriteFireplace(graphicsPuz);
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

	private void loadTexture(GraphicsPuz graphicsPuz) {
		ResourceUtils.textureAtlas = graphicsPuz.newTexture("texture_atlas.png");
	}

	private void loadBackground(GraphicsPuz graphicsPuz) {
		ResourceUtils.background = graphicsPuz.newTexture("background.png");
	}

	private void loadTextureJump(GraphicsPuz graphicsPuz) {
		ResourceUtils.jumpCorgi = graphicsPuz.newSprite(ResourceUtils.textureAtlas, 240, 0, 24, 24);
	}


	private void loadTFireplace(GraphicsPuz graphicsPuz) {
		ResourceUtils.fireplaceAtlas = graphicsPuz.newTexture("fireplace.png");
	}

	private void loadSpriteFireplace(GraphicsPuz graphicsPuz) {

		ResourceUtils.spriteFireplace = new ArrayList<>();

		ResourceUtils.spriteFireplace.add(graphicsPuz.newSprite(ResourceUtils.fireplaceAtlas, 0, 0, 128, 135));
		ResourceUtils.spriteFireplace.add(graphicsPuz.newSprite(ResourceUtils.fireplaceAtlas, 128, 0, 128, 135));
		ResourceUtils.spriteFireplace.add(graphicsPuz.newSprite(ResourceUtils.fireplaceAtlas, 256, 0, 128, 135));

	}

}
