package com.hardestgame.interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class Selected extends Interface {
	
	private BufferedImage[] selected;
	
	private int wait = 0, maxWait = 5;
	private int frame = 0, maxFrames = 5;

	public Selected(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		selected = new BufferedImage[5];
		
		for (int i = 0; i < 5; i++) {
			selected[i] = Game.spritesheet.getSprite(80 + (16 * i), 48, 16, 16);
		}
	}
	
	public void tick() {
		if (Editor.playerSelected) {
			x = Math.round(Game.player.getX() / 16) * 16;
			y = Math.round(Game.player.getY() / 16) * 16;
			
			wait++;
			
			if (wait == maxWait) {
				wait = 0;
				
				frame++;
				
				if (frame == maxFrames)
					frame = 0;
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(selected[frame], x, y, width, height, null);
	}

}
