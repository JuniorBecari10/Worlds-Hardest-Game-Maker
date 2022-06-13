package com.hardestgame.amostras;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class Triple extends Amostra {

	public Triple(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	public void tick() {
		if (clicked()) {
			Tile.groundType = "triple";
			
			Game.groundTypeSelector.removerGround();
		}
	}

}
