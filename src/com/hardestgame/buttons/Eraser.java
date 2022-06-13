package com.hardestgame.buttons;

import java.awt.image.BufferedImage;

public class Eraser extends Button {
	
	public static boolean eraserMode = false;

	public Eraser(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	public void tick() {
		if (clicked()) 
			eraserMode = !eraserMode;
		
		if (eraserMode) {
			pular(2, 8);
		}
		else
			y = 70;
	}
}
