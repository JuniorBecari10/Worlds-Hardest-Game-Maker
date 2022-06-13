package com.hardestgame.palleteitems;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.buttons.Eraser;
import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class PalleteItem {

	protected int x, y;
	protected int width, height;
	
	protected BufferedImage sprite;
	
	protected int wait = 0;
	protected boolean cima = false;
	
	public PalleteItem(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.sprite = sprite;
	}
	
	public void tick() {}
	
	public boolean clicked() {
		if (Game.mousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height) && Editor.editMode) {
			Game.mousePressed = false;
			Eraser.eraserMode = false;
				
			return true;
		}
		
		else {
			if (Game.mousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height)) {
				Game.mousePressed = false;
				
				return true;
			}
		}
		return false;
	}
	
	protected void pular(int altura, int maxWait) {
		if (!Eraser.eraserMode) {
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
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}
}
