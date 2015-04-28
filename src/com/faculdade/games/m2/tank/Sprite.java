package com.faculdade.games.m2.tank;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Sprite
{
	private BufferedImage image;

	private List<Rectangle> sprites = new ArrayList<Rectangle>();

	private int current = 0;

	private double scale = .5;

	private boolean loop;

	private double rotation;

	private double offsetX;

	private double offsetY;

	public Sprite(String imagePath, int spriteWidth, int spriteHeight, double rotation,
			double scale, boolean loop)
	{
		this(imagePath, spriteWidth, spriteHeight, 0, 0, rotation, scale, loop);
	}

	public Sprite(String imagePath, int spriteWidth, int spriteHeight, int offsetX, int offsetY,
			double rotation, double scale, boolean loop)
	{
		this(imagePath, spriteWidth, spriteHeight, offsetX, offsetY, rotation, scale, loop, 50);
	}

	public Sprite(String imagePath, int spriteWidth, int spriteHeight, int offsetX, int offsetY,
			double rotation, double scale, boolean loop, int time)
	{
		this.loop = loop;
		this.rotation = rotation;
		this.offsetX = offsetX;
		this.offsetY = offsetY;

		try
		{
			this.image = ImageIO.read(ClassLoader.getSystemClassLoader().getResource(imagePath));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		this.scale = scale;

		int imageWidth = image.getWidth();

		int imageHeight = image.getHeight();

		for (int line = 0; line <= imageHeight - spriteHeight; line += spriteHeight)
		{
			for (int column = 0; column <= imageWidth - spriteWidth; column += spriteWidth)
			{
				Rectangle sprite = new Rectangle(column, line, spriteWidth, spriteHeight);
				sprites.add(sprite);
			}
		}

		Timer timer = new Timer(time, this::update);

		timer.start();
	}

	public void update(ActionEvent e)
	{
		current++;

		if (current >= sprites.size())
		{
			if (loop)
				current = 0;
			else
				current = sprites.size() - 1;
		}
	}

	public void paint(Graphics2D g)
	{
		g.rotate(Math.toRadians(rotation));

		g.translate(offsetX, offsetY);

		Rectangle sprite = sprites.get(current);

		int width = (int) (sprite.width * scale);
		int height = (int) (sprite.height * scale);

		g.drawImage(image, 0, 0, width, height, sprite.x, sprite.y, sprite.x + sprite.width,
				sprite.y + sprite.height, null);

	}
}
