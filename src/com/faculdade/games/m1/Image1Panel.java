package com.faculdade.games.m1;

import static com.faculdade.games.m1.GraphicsUtils.drawShapeBorder;
import static com.faculdade.games.m1.GraphicsUtils.generatePath;
import static com.faculdade.games.m1.GraphicsUtils.generateStarPoints;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.List;

@SuppressWarnings("serial")
public class Image1Panel extends Panel2D
{
	@Override
	protected void paintComponent2D(Graphics2D graphics)
	{
		super.paintComponent2D(graphics);

		int pointCount = 12;
		int minRadius = 60;
		int maxRadius = 135;
		int step = 15;
		double multiplyer = 1.45;

		Color blue = new Color(79, 129, 189);
		Color black = Color.black;

		graphics.setColor(Color.white);

		graphics.fillRect(15, 15, getWidth() - 30, getHeight() - 30);

		graphics.setColor(blue);

		graphics.drawRect(15, 15, getWidth() - 30, getHeight() - 30);

		graphics.setColor(black);

		Point firstImageCenter = new Point(getWidth() / 4, getHeight() / 2);

		for (int i = minRadius; i <= maxRadius; i += step)
		{
			int radius = i;
			int max = (int) (radius * multiplyer);

			List<Point> points = generateStarPoints(firstImageCenter, pointCount, radius, max);

			GeneralPath path = generatePath(points);

			drawShapeBorder(graphics, path, Color.black);
		}

		Point secondImageCenter = new Point((getWidth() / 4) * 3, getHeight() / 2);

		List<Point> otherPoints = generateStarPoints(secondImageCenter, pointCount, maxRadius,
				(int) (maxRadius * multiplyer));

		drawShapeBorder(graphics, generatePath(otherPoints), Color.black);
	}
}
