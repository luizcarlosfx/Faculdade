package com.faculdade.games.m2.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BattleFieldPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private BufferedImage background;

	public BattleFieldPanel()
	{
		setSize(200, 200);

		loadBackgroundImage();

		Tank tank = new TankPlayer(Color.RED, new Vector2(100, 100));

		Tank tank2 = new TankIA(Color.BLUE, new Vector2(450, 450));

		Tank tank3 = new TankIA(Color.GREEN, new Vector2(450, 100));

		Tank tank4 = new TankIA(Color.YELLOW, new Vector2(100, 450));

		Tank tank5 = new TankIA(Color.PINK, new Vector2(300, 300));

		Scene.registerObject(tank);
		Scene.registerObject(tank2);
		Scene.registerObject(tank3);
		Scene.registerObject(tank4);
		Scene.registerObject(tank5);
	}

	void loadBackgroundImage()
	{
		try
		{
			background = ImageIO.read(ClassLoader
					.getSystemResource("com/faculdade/games/m2/tank/resources/background.jpg"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D graphics = (Graphics2D) g;

		List<GameObject> objs = Scene.getGameObjects();

		g.drawRect(0, 0, Scene.battleFieldBounds.width, Scene.battleFieldBounds.height);

		graphics.drawImage(background, 0, 0, getWidth(), getHeight(), null);

		// System.out.println(objs.size());

		for (int i = 0; i < objs.size(); i++)
		{
			objs.get(i).paint(graphics);
		}

		repaint();
	}
}
