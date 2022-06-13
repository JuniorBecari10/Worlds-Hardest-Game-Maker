package com.hardestgame.amostras;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class None extends Amostra {

	public None(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	public void tick() {
		if (clicked()) {
			Tile.groundType = "none";
			
			Game.groundTypeSelector.removerGround();
		}
	}
}
