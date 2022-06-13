package com.hardestgame.amostras;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class DoubleColumn extends Amostra {

	public DoubleColumn(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (clicked()) {
			Tile.groundType = "doubleColumn";
			
			Game.groundTypeSelector.removerGround();
		}
	}
}
