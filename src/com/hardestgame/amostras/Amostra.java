package com.hardestgame.amostras;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;

public class Amostra {
	
	protected int x, y;
	protected int width, height;
	
	protected BufferedImage sprite;
	
	public static boolean amostraMousePressed = false;
	
	public Amostra(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.sprite = sprite;
	}
	
	public void tick() {}
	
	public boolean clicked() {
		if (amostraMousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height) && Editor.editMode) {
			amostraMousePressed = false;
			
			return true;
		}
		
		return false;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}

}
