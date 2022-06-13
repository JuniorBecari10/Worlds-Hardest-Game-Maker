package com.hardestgame.buttons;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class BeaconType extends Button {

	public BeaconType(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (Editor.selectedItem != "beacon") {
			if (x < Game.WIDTH + 1)
				x += 2;
		}
		else {
			if (x > 217)
				x -= 2;
		}
		
		if (clicked()) {
			Game.interfaces.add(Game.groundTypeSelector);
			
			Game.amostras.add(Game.start);
			Game.amostras.add(Game.end);
		}
	}
}
