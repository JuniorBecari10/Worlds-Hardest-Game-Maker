package com.hardestgame.buttons;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class GroundType extends Button {
	
	public boolean jaAdd = false;
	
	private int wait = 0, maxWait = 5;

	public GroundType(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (clicked() && !jaAdd) { 
			Game.interfaces.add(Game.groundTypeSelector);
			
			Game.amostras.add(Game.all);
			Game.amostras.add(Game.one);
			Game.amostras.add(Game.doubleColumn);
			Game.amostras.add(Game.doubleCorner);
			Game.amostras.add(Game.triple);
			Game.amostras.add(Game.none);
			
			jaAdd = true;
		}
		
		if (Editor.selectedItem != "ground") {
			wait++;
			
		if (wait >= maxWait) {
			if (x < Game.WIDTH + 1)
				x += 2;
			}
		}
		
		else {
			if (x > 218) {
				x -= 2;
			}
			
			wait = 0;
			}
	}
}
