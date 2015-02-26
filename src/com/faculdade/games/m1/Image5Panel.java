package com.faculdade.games.m1;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Image5Panel extends Panel2D
{
	@Override
	protected void paintComponent2D(Graphics2D graphics)
	{
		super.paintComponent2D(graphics);

		int growX = 10;
		int growY = 12;

		int width = getWidth();

		int height = getHeight();

		int midHeight = height / 2;

		int quarterWidth = width / 4;

		Point center = new Point(quarterWidth, midHeight);

		Dimension firstDimension = new Dimension(110, 65);

		ArrayList<Ellipse2D.Double> list = generateEllipses(graphics, center, firstDimension, 12,
				growX, growY);

		for (Ellipse2D.Double ellipse : list)
		{
			graphics.draw(ellipse);
		}

		center = new Point(quarterWidth * 3, midHeight);

		firstDimension = new Dimension(30, 90);

		growX = 3;

		growY = 15;

		ArrayList<Ellipse2D.Double> list2 = generateEllipses(graphics, center, firstDimension, 12,
				growX, growY);

		int displacementX = 0;
		int displacementY = 0;

		for (Ellipse2D.Double ellipse : list2)
		{
			ellipse.x += displacementX;
			ellipse.y += displacementY;

			displacementX += 8;
			displacementY += 5;
			graphics.draw(ellipse);
		}
	}

	private ArrayList<Ellipse2D.Double> generateEllipses(Graphics2D graphics, Point center,
			Dimension firstDimension, int ellipses, int growX, int growY)
	{
		Rectangle rect = new Rectangle(center.x, center.y, firstDimension.width,
				firstDimension.height);

		ArrayList<Ellipse2D.Double> list = new ArrayList<Ellipse2D.Double>();
		for (int i = 0; i < ellipses; i++)
		{
			Ellipse2D.Double ellipse = new Ellipse2D.Double();

			ellipse.setFrame(rect);

			rect.grow(growX, growY);

			list.add(ellipse);
		}

		return list;
	}
}
