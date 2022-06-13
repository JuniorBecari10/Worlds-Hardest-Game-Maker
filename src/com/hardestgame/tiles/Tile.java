package com.hardestgame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.buttons.Eraser;
import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class Tile {
	
	/*
	 * GroundType
	 * 
	 * all - todos os lados
	 * one - um lado
	 * doubleCorner - dois lados
	 * doubleColumn - dois lados um de cada lado
	 * triple - três lados
	 * none - somente meio
	 * 
	 * GroundDirection
	 * 
	 * 0 - 0°
	 * 1 - 90° direita
	 * 2 - 180°
	 * 3 - 90° esquerda
	 * 
	 * BeaconType
	 * 
	 * start - começo
	 * end - final, se o player tocar volta para o editor
	 */

	protected int x, y;

	protected int width, height;
	
	protected BufferedImage sprite;
	
	public static String groundType = "all";
	public static int groundDirection = 0;
	
	public static String beaconType = "start";

	public Tile(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.sprite = sprite;
	}
	
	public void tick() {
		// se tiver um tick separado para cada tile, colocar super.tick(); !!
		
		testarApagar();
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public boolean clicked() {
		if (Game.mousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height) && Editor.editMode) {
			Game.mousePressed = false;
			
			return true;
		}
		
		return false;
	}
	
	private void testarApagar() {
		if (clicked() && Eraser.eraserMode) {
			for (int i = 0; i < Game.level.tiles.size(); i++) {
				Tile t = Game.level.tiles.get(i);
				
				if (t instanceof Coin)
					Game.coins.remove((Coin) t);
			}
			
				Game.level.tiles.remove(this);
				return;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}
}
