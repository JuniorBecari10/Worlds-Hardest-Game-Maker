package com.hardestgame.buttons;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class Deselect extends Button {

	public Deselect(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (clicked()) {
			Editor.playerSelected = false;
			
			Game.buttons.remove(this);
			return;
		}
	}

}
