package com.hardestgame.entities;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;
import com.hardestgame.palleteitems.BeaconPallete;
import com.hardestgame.tiles.Beacon;
import com.hardestgame.tiles.Coin;
import com.hardestgame.tiles.Spike;
import com.hardestgame.tiles.Tile;

public class Player extends Entity {
	
	public boolean up, down, left, right;
	
	private boolean jaColidiu = false;
	
	private double speed = 1.4;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if (!Editor.editMode) {
			if (up && !groundCollision(getX(), (int)(y - speed)))
				y -= speed;
			
			else if (down && !groundCollision(getX(), (int)(y + speed))) 
				y += speed;
			
			if (left && !groundCollision((int)(x - speed), getY())) 
				x -= speed;
			
			else if (right && !groundCollision((int)(x + speed), getY())) 
				x += speed;
		}
		
		for (int i = 0; i < Game.level.tiles.size(); i++) {
			Tile t = Game.level.tiles.get(i);
			
			if (t instanceof Coin) {
				if (isColliding(this, t))
					Game.level.tiles.remove(t);
			}
			
			if (t instanceof Beacon && t.getSprite() == BeaconPallete.sprites[1]) {
					if (isColliding(this, t)) {
						if (!jaColidiu) {
							Game.play.animando = true;
							
							jaColidiu = true;
						}
						else
							jaColidiu = false;
				}
			}
			
			if (t instanceof Spike) {
				if (isColliding(this, t)) {
					if (!jaColidiu) {
						Game.play.animando = true;
						
						jaColidiu = true;
					}
					else
						jaColidiu = false;
				}
			}
		}
	}
}
