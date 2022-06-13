package com.hardestgame.editor;

import java.util.ArrayList;
import java.util.List;

import com.hardestgame.buttons.Eraser;
import com.hardestgame.main.Game;
import com.hardestgame.palleteitems.BeaconPallete;
import com.hardestgame.tiles.Beacon;
import com.hardestgame.tiles.Coin;
import com.hardestgame.tiles.Ground;
import com.hardestgame.tiles.Spike;
import com.hardestgame.tiles.Tile;

public class Level {

	public List<Tile> tiles;
	
	public Level() {
		tiles = new ArrayList<Tile>();
	}
	
	public void tick() {
		//// <Check place blocks> ////
		
		if (Game.mousePressed && !Pallete.clicked() && !Eraser.eraserMode && !Editor.playerSelected && Editor.editMode) {
			if (Editor.selectedItem == "ground") {
				
				if (Tile.groundType == "all")
					Game.ground = new Ground(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, Game.ground.sprAll);
				
				else if (Tile.groundType == "one") 
					Game.ground = new Ground(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, Game.ground.sprOne[Tile.groundDirection]);
				
				else if (Tile.groundType == "doubleCorner")
					Game.ground = new Ground(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, Game.ground.sprDoubleCorner[Tile.groundDirection]);
				
				else if (Tile.groundType == "doubleColumn")
					Game.ground = new Ground(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, Game.ground.sprDoubleColumn[Tile.groundDirection]);
				
				else if (Tile.groundType == "triple")
					Game.ground = new Ground(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, Game.ground.sprTriple[Tile.groundDirection]);
				
				else if (Tile.groundType == "none")
					Game.ground = new Ground(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, Game.ground.sprNone);
					
				tiles.add(Game.ground);
			}
			if (Editor.selectedItem == "coin") {
				Game.coin = new Coin((Math.round(Game.mouseX / 16) * 16) + 4, (Math.round(Game.mouseY / 16) * 16) + 4, 7, 7, Game.spritesheet.getSprite(0, 16, 7, 7));
				tiles.add(Game.coin);
				Game.coins.add(Game.coin);
			}
			
			if (Editor.selectedItem == "spike") {
				Game.spike = new Spike((Math.round(Game.mouseX / 16) * 16) + 3, (Math.round(Game.mouseY / 16) * 16) + 3, 9, 9, Game.spritesheet.getSprite(16, 16, 9, 9));
				tiles.add(Game.spike);
			}
			
			if (Editor.selectedItem == "beacon") {
				
				if (Tile.beaconType == "start")
					Game.beacon = new Beacon(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, BeaconPallete.sprites[0]);
				
				else if (Tile.beaconType == "end")
					Game.beacon = new Beacon(Math.round(Game.mouseX / 16) * 16, Math.round(Game.mouseY / 16) * 16, 16, 16, BeaconPallete.sprites[1]);
					
				tiles.add(Game.beacon);
			}
			
			Game.mousePressed = false;	
		}
		
	//// </Check place blocks> ////
	}
}
