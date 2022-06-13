package com.hardestgame.palleteitems;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;

public class SpikePallete extends PalleteItem {

	public SpikePallete(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (clicked())
			Editor.selectedItem = "spike";
		
		if (Editor.selectedItem == "spike")
			pular(2, 8);

		else
			y = 11;
	}
}
