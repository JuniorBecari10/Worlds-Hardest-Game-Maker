package com.hardestgame.amostras;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class One extends Amostra {

	public One(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	public void tick() {
		if (clicked()) {
			Tile.groundType = "one";
			
			Game.groundTypeSelector.removerGround();
		}
	}
}
