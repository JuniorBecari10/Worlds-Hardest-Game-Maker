package com.hardestgame.palleteitems;

import java.awt.image.BufferedImage;

import com.hardestgame.editor.Editor;
import com.hardestgame.main.Game;
import com.hardestgame.tiles.Tile;

public class GroundPallete extends PalleteItem {

	public GroundPallete(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

	public void tick() {
		if (clicked())
			Editor.selectedItem = "ground";
		
		if (Editor.selectedItem == "ground")
			pular(2, 8);
		
		else
			y = 8;
		
		if (Tile.groundType == "all")
			setSprite(Game.ground.sprAll);
			
		else if (Tile.groundType == "one")
			setSprite(Game.ground.sprOne[Tile.groundDirection]);
		
		else if (Tile.groundType == "doubleCorner")
			setSprite(Game.ground.sprDoubleCorner[Tile.groundDirection]);
			
		else if (Tile.groundType == "doubleColumn")
			setSprite(Game.ground.sprDoubleColumn[Tile.groundDirection]);
			
		else if (Tile.groundType == "triple")
			setSprite(Game.ground.sprTriple[Tile.groundDirection]);
		
		else if (Tile.groundType == "none")
			setSprite(Game.ground.sprNone);
			
	}
	
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
}
