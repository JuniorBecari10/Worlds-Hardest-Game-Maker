package com.hardestgame.buttons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class Play extends Button {
	
	private int wait = 0, maxWait = 5;
	private int voltWait = 0, voltMaxWait = 5;
	
	private int frame = 0, maxFrames = 3;
	
	public boolean animando = false;
	private boolean isPlay = true; // icone do botao play
	
	public boolean voltando = false;
	
	private boolean jaDeclarou = false, animJaDeclarou = false;

	public Play(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public boolean clickedPlay() {
		if (Game.mousePressed && (Game.mouseX > x && Game.mouseX < x + width) && (Game.mouseY > y && Game.mouseY < y + height)) {
			Game.mousePressed = false;
			
			return true;
		}
		
		return false;
	}

	public void tick() {
		if (clickedPlay() && !animando && !voltando) 
			animando = true;
		
		if (animando) {
			if (!animJaDeclarou) {
				frame = 0;
				maxFrames = 3;
				
				animJaDeclarou = true;
			}
			
			wait++;
			
			if (wait == maxWait) {
				wait = 0;
				
				frame++;
				
				if (frame == maxFrames) {
					frame = 0;
					
					isPlay = !isPlay;
					
					voltando = true;
					animando = false;
				}
			}
		}
		
		else
			animJaDeclarou = false;
		
		if (voltando) {
			if (!jaDeclarou) {
				frame = 2;
				maxFrames = 0;
				
				jaDeclarou = true;
			}
			
			voltWait++;
			
			if (voltWait == voltMaxWait) {
				voltWait = 0;
				
				if (frame != maxFrames)
					frame--;
				
				if (frame == maxFrames) {
					frame = 0;
					
					Editor.editMode = !Editor.editMode;
					
					if (Editor.editMode) {
						Game.player.setX(Editor.playerX);
						Game.player.setY(Editor.playerY);
						
						for (int i = 0; i < Game.coins.size(); i++) {
							Tile t = Game.coins.get(i);
							
							Game.level.tiles.add(t);
						}
					}
					
					voltando = false;
				}
			}
			
			if (frame < 0) {
				frame = 0;
				
				voltando = false;
				animando = false;
				
				Editor.editMode = true;
				
				Game.player.setX(Editor.playerX);
				Game.player.setY(Editor.playerY);
				
				for (int i = 0; i < Game.coins.size(); i++) {
					Tile t = Game.coins.get(i);
					
					Game.level.tiles.add(t);
				}
			}
			
			System.out.println(frame);
		}
		
		else
			jaDeclarou = false;
	}
	
	public void render(Graphics g) {
		if (isPlay)
			g.drawImage(Game.editor.playSpr[frame], x, y, width, height, null);
		else
			g.drawImage(Game.editor.pauseSpr[frame], x, y, width, height, null);
	}
}
