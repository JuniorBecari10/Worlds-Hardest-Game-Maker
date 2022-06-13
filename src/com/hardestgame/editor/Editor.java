package com.hardestgame.editor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.hardestgame.main.Game;

public class Editor {

	private BufferedImage bg;
	
	public BufferedImage[] playSpr;
	public BufferedImage[] pauseSpr;
	
	public static boolean editMode = true;
	
	public static String selectedItem = "ground";
	
	public static boolean playerSelected = false;
	
	private boolean jaAdd = false;
	
	public static int playerX, playerY;
	
	public Editor(String bgPath) {
		try {
			bg = ImageIO.read(getClass().getResource(bgPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		playSpr = new BufferedImage[3];
		pauseSpr = new BufferedImage[3];
		
		for (int i = 0; i < 3; i++) {
			playSpr[i] = Game.spritesheet.getSprite(16 * i, 88, 16, 24);
			pauseSpr[i] = Game.spritesheet.getSprite(48 + (16 * i), 88, 16, 24);
		}
	}
	
	public void tick() {
		
		if (editMode) {
			playerX = Game.player.getX();
			playerY = Game.player.getY();
		}
		
		if (Game.player.clicked())
			playerSelected = true;
		
		if (playerSelected) {
			if (!jaAdd) {
				Game.buttons.add(Game.deselect);
				Game.interfaces.add(Game.selected);
				
				jaAdd = true;
				}
			
			if (Game.playerMousePressed) {
				Game.playerMousePressed = false;
				
				Game.player.setX((Math.round(Game.mouseX / 16) * 16) + 3);
				Game.player.setY((Math.round(Game.mouseY / 16) * 16) + 3);
			}
		}
		else {
			jaAdd = false;
			Game.interfaces.remove(Game.selected);
			}
		}
	
	public void render(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
