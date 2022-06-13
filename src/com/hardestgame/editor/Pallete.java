package com.hardestgame.editor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.hardestgame.main.Game;

public class Pallete {

	private BufferedImage sprPallete;
	
	public Pallete(String sprPath) {
		try {
			sprPallete = ImageIO.read(getClass().getResource(sprPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean clicked() {
		if (Game.mouseClicked) {
			if ((Game.mouseX > 34 && Game.mouseX < 206) && (Game.mouseY > 34 && Game.mouseY < 159))
				return false;
		}
		
		return true;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprPallete, 0, 0, null);
	}
}
