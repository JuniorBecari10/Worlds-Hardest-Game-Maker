package com.hardestgame.tiles;

import java.awt.image.BufferedImage;

import com.hardestgame.main.Game;

public class Ground extends Tile {
	
	public BufferedImage[] sprOne;
	
	public BufferedImage[] sprDoubleCorner;
	public BufferedImage[] sprDoubleColumn;
	
	public BufferedImage[] sprTriple;
	
	public BufferedImage sprNone;
	public BufferedImage sprAll;

	public Ground(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		sprOne = new BufferedImage[4];
		sprDoubleCorner = new BufferedImage[4];
		sprDoubleColumn = new BufferedImage[4];
		sprTriple = new BufferedImage[4];
		
		sprNone = Game.spritesheet.getSprite(112, 32, 16, 16);
		sprAll = Game.spritesheet.getSprite(16, 0, 16, 16);
		
		for (int i = 0; i < 4; i++) {
			sprOne[i] = Game.spritesheet.getSprite(64 + (16 * i), 16, 16, 16);
			sprDoubleCorner[i] = Game.spritesheet.getSprite(64 + (16 * i), 0, 16, 16);
			sprTriple[i] = Game.spritesheet.getSprite(48 + (16 * i), 32, 16, 16);
		}
		
		for (int i = 0; i < 2; i++)
			sprDoubleColumn[i] = Game.spritesheet.getSprite(32 + (16 * i), 0, 16, 16);
		
		sprDoubleColumn[2] = sprDoubleColumn[0];
		sprDoubleColumn[3] = sprDoubleColumn[1];
	}
}
