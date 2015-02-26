package com.faculdade.games.m1;

import static com.faculdade.games.m1.GraphicsUtils.drawShapeBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Image4Panel extends Panel2D
{
	@Override
	protected void paintComponent2D(Graphics2D graphics)
	{
		super.paintComponent2D(graphics);

		drawFirstImage(graphics);
		drawSecondImage(graphics);
	}

	void drawFirstImage(Graphics2D graphics)
	{
		Dimension size = new Dimension(130, 35);

		int growX = 30;

		int growY = 35;

		Point position = new Point((getWidth() / 4) - (size.width / 2), (getHeight() / 2)
				- (size.height / 2));

		drawRects(graphics, position, size, 9, 1, 1, growX, growY, 0, 0);
	}

	void drawSecondImage(Graphics2D graphics)
	{
		Dimension dimension = new Dimension(45, 25);

		Point position = new Point((getWidth() * 3 / 4) - (dimension.width / 2), (getHeight() / 2)
				- dimension.height / 2);

		int translateX = -13;
		int translateY = -3;
		int growWidth = 10;
		int growHeight = 25;
		int diff = 3;
		int rects = 9;

		drawRects(graphics, position, dimension, rects, diff, 0, growWidth, growHeight, translateX,
				translateY);
	}

	void drawRects(Graphics2D graphics, Point position, Dimension dimension, int rectCount,
			float diffBetweenSmallerAndBigger, float diffGrow, int growWidth, int growHeight,
			int translateX, int translateY)
	{
		Rectangle bigger = new Rectangle(position, dimension);

		for (int i = 0; i < rectCount; i++)
		{
			drawShapeBorder(graphics, bigger, Color.black);

			Rectangle smaller = new Rectangle(bigger);

			smaller.grow(-(int) Math.ceil(diffBetweenSmallerAndBigger),
					-(int) Math.ceil(diffBetweenSmallerAndBigger));

			drawShapeBorder(graphics, smaller, Color.black);

			bigger.grow(growWidth / 2, growHeight / 2);

			bigger.translate(translateX, translateY);

			diffBetweenSmallerAndBigger += diffGrow;
		}
	}
}
