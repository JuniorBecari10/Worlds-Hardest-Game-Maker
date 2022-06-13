package com.hardestgame.buttons;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class Rotate extends Button {

	public Rotate(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (clicked())
			Tile.groundDirection++;
		
		if (Tile.groundDirection > 3 && Tile.groundType != "doubleColumn")
			Tile.groundDirection = 0;	
		
		if (Editor.selectedItem != "ground") {
			if (x < Game.WIDTH + 1)
				x += 2;
		}
		else {
			if (x > 218)
				x -= 2;
		}
	}
}
