package com.hardestgame.interfaces;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;

public class ResetRocket extends Interface {

	public ResetRocket(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	public void tick() {
		if (y + height > 0)
			y -= 2;
		else {
			Game.interfaces.remove(this);
			return;
		}
	}
}
