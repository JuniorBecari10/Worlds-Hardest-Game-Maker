package com.hardestgame.amostras;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class All extends Amostra {

	public All(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (clicked()) {
			Tile.groundType = "all";
			
			Game.groundTypeSelector.removerGround();
		}
	}
}
