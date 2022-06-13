package com.hardestgame.buttons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class Button {

	protected int x, y;
	protected int width, height;
	
	protected BufferedImage sprite;
	
	protected int wait = 0;
	protected boolean cima = false;
	
	public Button(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.sprite = sprite;
	}
	
	public void tick() {}
	
	public boolean holded() {
		if (Game.mousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height)) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean clicked() {
		if (Game.mousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height) && Editor.editMode) {
			Game.mousePressed = false;
			
			return true;
		}
		
		return false;
	}
	
	protected void pular(int altura, int maxWait) {
		wait++;
		
		if (wait == maxWait) {
			wait = 0;
			
			if (!cima)
				y -= altura;
			
			else
				y += altura;
			
			cima = !cima;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}
}
