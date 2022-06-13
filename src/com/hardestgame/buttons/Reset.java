package com.hardestgame.buttons;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;

public class Reset extends Button {
	
	private int wait = 0, maxWait = 5;
	private int pos = 0;
	
	private boolean jaAdd = false;
	
	/*
	 * valor de pos:
	 * 
	 * 0 meio - para direita
	 * 1 direita
	 * 2 - meio - para esquerda
	 * 3 esquerda
	 * 4 ir para 0
	 */

	public Reset(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	public void tick() {
		if (holded()) {
			tremer();
			
			if (!jaAdd) {
				Game.interfaces.add(Game.courseReset);
				
				jaAdd = true;
			}
			
		}
		else {
			x = 218;
			
			Game.interfaces.remove(Game.courseReset);
			jaAdd = false;
			
			sprite = Game.spritesheet.getSprite(16, 48, 16, 16);
			height = 16;
			
			Game.courseReset.index = 0;
		}
	}
	
	private void tremer() {
		sprite = Game.spritesheet.getSprite(16, 48, 16, 32);
		height = 32;
		
		wait++;
		
		if (wait == maxWait) {
			wait = 0;
			
			if (pos == 0)
				x = 218;
			
			else if (pos == 1)
				x = 220;
			
			else if (pos == 2)
				x = 218;
			
			else if (pos == 3)
				x = 216;
			
			if (pos == 4)
				pos = 0;
				
			pos++;
		}
	}
}
