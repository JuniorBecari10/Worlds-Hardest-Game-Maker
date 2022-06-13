package com.hardestgame.interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.buttons.Eraser;
import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class Interface {

	protected int x, y;
	protected int width, height;
	
	protected BufferedImage sprite;
	
	public Interface(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.sprite = sprite;
	}
	
	protected boolean clicked() {
		if (Game.mousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height) && Editor.editMode) {
			Game.mousePressed = false;
			Eraser.eraserMode = false;
				
			return true;
		}
		
		return false;
	}
	
	public void tick() {}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}
}
