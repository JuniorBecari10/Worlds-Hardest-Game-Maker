package com.hardestgame.interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.hardestgame.main.Game;

public class CourseReset extends Interface {
	
	public BufferedImage[] sprites;
	
	private int wait = 0, maxWait = 60;
	
	public int index = 0;

	public CourseReset(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		sprites = new BufferedImage[3];
		
		for (int i = 0; i < 3; i++) {
			try {
				sprites[i] = ImageIO.read(getClass().getResource("/resetAnimation/reset" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void tick() {
		wait++;
		
		if (wait == maxWait) {
			wait = 0;
			
			index++;
			
			if (index == 3) {
				index = 0;
				Game.interfaces.add(Game.resetRocket);
				
				Game.level.tiles.clear();
				
				Game.interfaces.remove(this);
				return;
			}
		}
 	}
	
	public void render(Graphics g) {
		g.drawImage(sprites[index], x, y, width, height, null);
	}

}
