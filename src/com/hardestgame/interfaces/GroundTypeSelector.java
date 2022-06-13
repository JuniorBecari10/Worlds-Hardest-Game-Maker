package com.hardestgame.interfaces;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class GroundTypeSelector extends Interface {

	public GroundTypeSelector(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	public void tick() {	
		if (Game.mousePressed && !clicked()) {
			Game.mousePressed = false;
			
			if (Editor.selectedItem != "ground" && Editor.selectedItem != "beacon")
				removerGround();
		}
	}
	
	public void removerGround() {
		Game.groundType.jaAdd = false;
		
		Game.amostras.remove(Game.all);
		Game.amostras.remove(Game.one);
		Game.amostras.remove(Game.doubleColumn);
		Game.amostras.remove(Game.doubleCorner);
		Game.amostras.remove(Game.triple);
		Game.amostras.remove(Game.none);
		
		Game.interfaces.remove(Game.groundTypeSelector);
		return;
	}
	
	public void removerBeacon() {
		Game.amostras.remove(Game.start);
		Game.amostras.remove(Game.end);
		
		Game.interfaces.remove(Game.groundTypeSelector);
		return;
	}
}
