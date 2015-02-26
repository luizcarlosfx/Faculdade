package com.faculdade.games.m1;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Image6Panel extends Panel2D
{
	@Override
	protected void paintComponent2D(Graphics2D graphics)
	{
		super.paintComponent2D(graphics);

		drawImage1(graphics);
		drawImage2(graphics);
	}

	void drawImage1(Graphics2D graphics)
	{
		graphics.rotate(Math.toRadians(-45));

		int padding = 5;

		Dimension size = new Dimension(50, 50);

		Point cube1Point = new Point(0, 60);

		Point cube2Point = new Point(cube1Point.x + size.width + padding, cube1Point.y);

		for (int i = 1; i <= 6; i++)
		{
			cube1Point.translate(0, size.width + padding);
			cube2Point.translate(0, size.width + padding);

			Rectangle cube1 = new Rectangle(cube1Point, size);
			Rectangle cube2 = new Rectangle(cube2Point, size);

			graphics.draw(cube1);
			graphics.draw(cube2);

			if (i == 3 || i == 4)
			{
				cube1.translate(size.width * 2 + padding * 2, 0);
				cube2.translate(size.width * 2 + padding * 2, 0);

				graphics.draw(cube1);
				graphics.draw(cube2);

				cube1.translate(-size.width * 4 - padding * 4, 0);
				cube2.translate(-size.width * 4 - padding * 4, 0);

				graphics.draw(cube1);
				graphics.draw(cube2);
			}
		}

		graphics.rotate(Math.toRadians(45));
	}

	void drawImage2(Graphics2D graphics)
	{
		Point point = new Point(600, 50);

		draw4Cubes(graphics, point, 4, 0, 5);
	}

	void draw4Cubes(Graphics2D graphics, Point point, int padding, int index, int max)
	{
		if (index >= max)
			return;

		Dimension size = new Dimension(50, 50);

		int displacement = 40;

		Rectangle cube1 = new Rectangle(point, size);

		Rectangle cube2 = new Rectangle(cube1);

		cube2.translate(displacement, displacement);

		Rectangle cube3 = new Rectangle(cube1);

		cube3.translate(-displacement, displacement);

		Rectangle cube4 = new Rectangle(cube2);

		cube4.translate(-displacement, displacement);

		graphics.draw(cube1);
		graphics.draw(cube2);
		graphics.draw(cube3);
		graphics.draw(cube4);

		index++;

		Point cube4Position = cube4.getLocation();

		int xDisplacement = size.width + padding;
		int yDisplacement = size.height - displacement + padding;

		if (index % 2 == 0)
		{
			xDisplacement *= -1;
		}

		cube4Position.translate(xDisplacement, yDisplacement);

		draw4Cubes(graphics, cube4Position, padding, index, max);
	}
}
