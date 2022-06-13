package com.hardestgame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class Entity {

	protected double x, y;
	protected int width, height;
	
	protected BufferedImage sprite;
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.sprite = sprite;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void tick() {}
	
	public boolean isColliding(Entity e, Tile t) {
		Rectangle boundsE = new Rectangle(e.getX(), e.getY(), e.width, e.height);
		Rectangle boundsT = new Rectangle(t.getX(), t.getY(), t.getWidth(), t.getHeight());
		
		return boundsE.intersects(boundsT);
		
	}
	
	public boolean groundCollision(int xNext, int yNext) {
		Rectangle nextBounds = new Rectangle(xNext, yNext, 16, 16);
		
		for (int i = 0; i < Game.level.tiles.size(); i++) {
			Tile t = Game.level.tiles.get(i);
			
			if (t != Game.ground) continue;
			
			Rectangle target = new Rectangle(t.getX(), t.getY(), t.getWidth(), t.getHeight());
			
			if (nextBounds.intersects(target)) return true;
		}
		
		return false;
	}
	
	public boolean clicked() {
		if (Game.playerMousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height)) {
			Game.playerMousePressed = false;
			
			return true;
		}
		
		return false;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, (int) x, (int) y, width, height, null);
		
		/*g.setColor(Color.green);
		
		g.fillRect(getX(), getY() + 1, 1, height - 2);
		g.fillRect(getX() + width - 1, getY() + 1, 1, height - 2);
		g.fillRect(getX() + 1, getY(), width - 2, 1);
		g.fillRect(getX() + 1, getY() + height - 1, width - 2, 1);*/
	}
}
