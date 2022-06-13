package com.hardestgame.palleteitems;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class BeaconPallete extends PalleteItem {
	
	public static BufferedImage[] sprites;

	public BeaconPallete(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		sprites = new BufferedImage[2];
		
		for (int i = 0; i < 2; i++) {
			sprites[i] = Game.spritesheet.getSprite(32 + (16 * i), 16, 16, 16);
		}
	}
	
	public void tick() {
		if (clicked())
			Editor.selectedItem = "beacon";
		
		if (Editor.selectedItem == "beacon")
			pular(2, 8);

		else
			y = 8;
	}
	
	public void render(Graphics g) {
		super.render(g);
		
		if (Editor.selectedItem == "start")
			sprite = sprites[0];
		
		if (Editor.selectedItem == "end")
			sprite = sprites[1];
	}
}
