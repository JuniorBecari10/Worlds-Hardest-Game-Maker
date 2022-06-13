package com.hardestgame.palleteitems;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;

public class CoinPallete extends PalleteItem {

	public CoinPallete(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (clicked())
			Editor.selectedItem = "coin";
		
		if (Editor.selectedItem == "coin")
			pular(2, 8);
		

		else
			y = 12;
	}
}
