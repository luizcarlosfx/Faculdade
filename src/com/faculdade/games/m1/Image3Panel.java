package com.faculdade.games.m1;

import static com.faculdade.games.m1.GraphicsUtils.drawShapeBorder;
import static com.faculdade.games.m1.GraphicsUtils.fillShape;
import static com.faculdade.games.m1.GraphicsUtils.generatePath;
import static com.faculdade.games.m1.GraphicsUtils.generateStarPoints;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

@SuppressWarnings("serial")
public class Image3Panel extends Panel2D
{
	@Override
	public void paintComponent2D(Graphics2D graphics)
	{
		super.paintComponent2D(graphics);

		int width = getWidth();
		int height = getHeight();

		int quarterWidth = width / 4;
		int quarterHeight = height / 4;

		Point first = new Point(quarterWidth, quarterHeight);
		Point second = new Point(quarterWidth * 3, quarterHeight);
		Point third = new Point(quarterWidth, quarterHeight * 3);
		Point fourth = new Point(quarterWidth * 3, quarterHeight * 3);

		Color[] colors =
			{ Color.white, Color.green, Color.blue, Color.red };

		Point[] points =
			{ first, second, third, fourth };

		int[] radius =
			{ 50, 42, 34, 26, 18, 10 };

		for (int i = 0; i < points.length; i++)
		{
			drawStarts(graphics, points[i], radius, colors[i], 270);
		}
	}

	void drawStarts(Graphics2D graphics, Point center, int[] radius, Color fillColor, double angle)
	{
		angle = Math.toRadians(angle);

		graphics.rotate(angle, center.x, center.y);

		Point origin = new Point(center);

		for (int i = 0; i < radius.length; i++)
		{
			int ray = radius[i];

			GeneralPath starPoints = generatePath(generateStarPoints(origin, 5, ray, ray * 3));

			drawShapeBorder(graphics, starPoints, Color.black);

			if (i == 0)
			{
				fillShape(graphics, starPoints, fillColor);
			}

			origin.translate(3, 0);
		}

		graphics.rotate(-angle, center.x, center.y);
	}
}
