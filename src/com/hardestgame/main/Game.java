package com.hardestgame.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.hardestgame.amostras.All;
import com.hardestgame.amostras.Amostra;
import com.hardestgame.amostras.DoubleColumn;
import com.hardestgame.amostras.DoubleCorner;
import com.hardestgame.amostras.End;
import com.hardestgame.amostras.None;
import com.hardestgame.amostras.One;
import com.hardestgame.amostras.Start;
import com.hardestgame.amostras.Triple;
import com.hardestgame.buttons.BeaconType;
import com.hardestgame.buttons.Button;
import com.hardestgame.buttons.Deselect;
import com.hardestgame.buttons.Eraser;
import com.hardestgame.buttons.GroundType;
import com.hardestgame.buttons.Play;
import com.hardestgame.buttons.Reset;
import com.hardestgame.buttons.Rotate;
import com.hardestgame.editor.Editor;
import com.hardestgame.editor.Level;
import com.hardestgame.editor.Pallete;
import com.hardestgame.entities.Entity;
import com.hardestgame.entities.Player;
import com.hardestgame.graficos.Spritesheet;
import com.hardestgame.interfaces.CourseReset;
import com.hardestgame.interfaces.GroundTypeSelector;
import com.hardestgame.interfaces.Interface;
import com.hardestgame.interfaces.ResetRocket;
import com.hardestgame.interfaces.Selected;
import com.hardestgame.palleteitems.BeaconPallete;
import com.hardestgame.palleteitems.CoinPallete;
import com.hardestgame.palleteitems.GroundPallete;
import com.hardestgame.palleteitems.PalleteItem;
import com.hardestgame.palleteitems.SpikePallete;
import com.hardestgame.tiles.Beacon;
import com.hardestgame.tiles.Coin;
import com.hardestgame.tiles.Ground;
import com.hardestgame.tiles.Spike;
import com.hardestgame.tiles.Tile;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	public static JFrame frame;
	private Thread thread;
	
	public static Spritesheet spritesheet;
	
	public List<Entity> entities;
	
	public Pallete pallete;
	public static Editor editor;
	
	public static Player player;
	
	public static int mouseX = 0, mouseY = 0;
	public static boolean mousePressed = false, mouseClicked = false;
	public static boolean playerMousePressed = false;
	
	public List<PalleteItem> palItems;
	
	public static GroundPallete groundPal;
	public static CoinPallete coinPal;
	public static SpikePallete spikePal;
	public static BeaconPallete beaconPal;
	
	public static Ground ground;
	public static Coin coin;
	public static Spike spike;
	public static Beacon beacon;
	
	public static List<Button> buttons;
	
	public static Reset reset;
	public static Eraser eraser;
	public static Rotate rotate;
	public static GroundType groundType;
	public static BeaconType beaconType;
	
	public static Deselect deselect;
	public static Play play;
	
	public static List<Interface> interfaces;
	
	public static CourseReset courseReset;
	public static ResetRocket resetRocket;
	public static GroundTypeSelector groundTypeSelector;
	public static Selected selected;
	
	public static List<Amostra> amostras;
	
	public static All all;
	public static One one;
	public static DoubleCorner doubleCorner;
	public static DoubleColumn doubleColumn;
	public static Triple triple;
	public static None none;
	
	public static Start start;
	public static End end;
	
	public static List<Coin> coins;
	
	public static Level level;
	
	private boolean isRunning = true;
	
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final int SCALE = 3;
	
	private BufferedImage image;
	
	private Image icon;
	
	public Game() {
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		
		initFrame();
		setImage("/icon.png");
		
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		spritesheet = new Spritesheet("/spritesheet.png");
		
		entities = new ArrayList<Entity>();
		buttons = new ArrayList<Button>();
		palItems = new ArrayList<PalleteItem>();
		interfaces = new ArrayList<Interface>();
		amostras = new ArrayList<Amostra>();
		coins = new ArrayList<Coin>();
		
		ground = new Ground(0, 0, 0, 0, null);
		
		level = new Level();
		
		pallete = new Pallete("/pallete.png");
		editor = new Editor("/bg.png");
		
		player = new Player(WIDTH / 2 - 5, HEIGHT / 2 + 3, 10, 10, spritesheet.getSprite(0, 0, 10, 10));
		
		groundPal = new GroundPallete(60, 8, 16, 16, spritesheet.getSprite(16, 0, 16, 16));
		coinPal = new CoinPallete(95, 12, 16, 16, spritesheet.getSprite(0, 16, 16, 16));
		spikePal = new SpikePallete(120, 11, 16, 16, spritesheet.getSprite(16, 16, 16, 16));
		beaconPal = new BeaconPallete(150, 8, 16, 16, spritesheet.getSprite(32, 16, 16, 16));
		
		eraser = new Eraser(218, 70, 16, 16, spritesheet.getSprite(0, 32, 16, 16));
		reset = new Reset(218, 40, 16, 16, spritesheet.getSprite(16, 48, 16, 16));
		rotate = new Rotate(218, 100, 16, 16, spritesheet.getSprite(16, 32, 16, 16));
		groundType = new GroundType(218, 130, 18, 17, spritesheet.getSprite(32, 64, 18, 17));
		beaconType = new BeaconType(WIDTH + 1, 130, 18, 17, spritesheet.getSprite(32, 16, 16, 16));
		
		deselect = new Deselect(180, 140, 32, 16, spritesheet.getSprite(32, 48, 32, 16));
		play = new Play(10, HEIGHT - 50, 32, 48, editor.playSpr[0]);
		
		try {
			courseReset = new CourseReset(30, 0, 200, 200, ImageIO.read(getClass().getResource("/resetAnimation/reset0.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		resetRocket = new ResetRocket(WIDTH / 2 - 10, HEIGHT, 16, 32, spritesheet.getSprite(16, 48, 16, 32));
		groundTypeSelector = new GroundTypeSelector(148, 84, 18 * 3, 16 * 4, spritesheet.getSprite(64, 64, 18, 16));
		selected = new Selected(0, 0, 16, 16, null);
		
		final int initY = 90;
		
		final int xOff = 16 + 2;
		final int yOff = 2;
		
		all = new All(152, initY, 16, 16, spritesheet.getSprite(16, 0, 16, 16));
		one = new One(152, initY + 16 + yOff, 16, 16, spritesheet.getSprite(64, 16, 16, 16));
		doubleCorner = new DoubleCorner(152, initY + (16 * 2) + yOff * 2, 16, 16, spritesheet.getSprite(64, 0, 16, 16));
		
		doubleColumn = new DoubleColumn(152 + xOff, initY, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		triple = new Triple(152 + xOff, initY + 16 + yOff, 16, 16, spritesheet.getSprite(48, 32, 16, 16));
		none = new None(152 + xOff, initY + (16 * 2) + yOff * 2, 16, 16, spritesheet.getSprite(112, 32, 16, 16));
		
		start = new Start(162, 98, 16, 16, BeaconPallete.sprites[0]);
		end = new End(162, 98 + 16 + 2, 16, 16, BeaconPallete.sprites[1]);
		
		entities.add(player);
		
		buttons.add(eraser);
		buttons.add(reset);
		buttons.add(rotate);
		buttons.add(groundType);
		buttons.add(play);
		buttons.add(beaconType);
		
		palItems.add(groundPal);
		palItems.add(coinPal);
		palItems.add(spikePal);
		palItems.add(beaconPal);
	}
	
	private void setImage(String path) {
		try {
			icon = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		frame.setIconImage(icon);
	}
	
	public void initFrame(){
		frame = new JFrame("World's Hardest Game Maker");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop(){
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Game game = new Game();
		game.start();
	}
	
	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			
			e.tick();
		}
		
		for (int i = 0; i < palItems.size(); i++) {
			PalleteItem p = palItems.get(i);
			
			p.tick();
		}
		
		for (int i = 0; i < level.tiles.size(); i++) {
			Tile t = level.tiles.get(i);
			
			t.tick();
		}
		
		for (int i = 0; i < buttons.size(); i++) {
			Button b = buttons.get(i);
			
			b.tick();
		}
		
		for (int i = 0; i < interfaces.size(); i++) {
			Interface f = interfaces.get(i);
			
			f.tick();
		}
		
		for (int i = 0; i < amostras.size(); i++) {
			Amostra a = amostras.get(i);
			
			a.tick();
		}
		
		if (Editor.editMode) {
			editor.tick();
			level.tick();
		}
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0,WIDTH,HEIGHT);
		
		/*Descomente a linha abaixo para usar o Graphics2D*/
		//Graphics2D g2 = (Graphics2D) g;
	
		editor.render(g);
		
		for (int i = 0; i < level.tiles.size(); i++) {
			Tile t = level.tiles.get(i);
			
			t.render(g);
		}

		if (Editor.editMode)
			pallete.render(g);
		
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			
			e.render(g);
		}
		
		if (Editor.editMode) {
			for (int i = 0; i < palItems.size(); i++) {
				PalleteItem p = palItems.get(i);
				
				p.render(g);
			}
			
			for (int i = 0; i < buttons.size(); i++) {
				Button b = buttons.get(i);
				
				b.render(g);
			}
			
			for (int i = 0; i < interfaces.size(); i++) {
				Interface f = interfaces.get(i);
				
				f.render(g);
			}
			
			for (int i = 0; i < amostras.size(); i++) {
				Amostra a = amostras.get(i);
				
				a.render(g);
			}
		}
		
		play.render(g);
		
		/***/
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0,WIDTH*SCALE,HEIGHT*SCALE,null);
		
		bs.show();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while(isRunning){
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000){
				System.out.println("FPS: "+ frames);
				frames = 0;
				timer+=1000;
			}
		}
		
		stop();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && !Editor.editMode)
			player.up = true;
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN && !Editor.editMode)
			player.down = true;
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			player.left = true;
		
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.right = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.up = false;
		player.down = false;
		player.left = false;
		player.right = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked = true;
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		Amostra.amostraMousePressed = true;
		playerMousePressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
		Amostra.amostraMousePressed = false;
		playerMousePressed = false;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX() / Game.SCALE;
		mouseY = e.getY() / Game.SCALE;
		
	}
}
	