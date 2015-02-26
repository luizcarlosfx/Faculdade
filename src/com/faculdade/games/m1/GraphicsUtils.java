package com.faculdade.games.m1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class GraphicsUtils
{
	public static List<Point> generateStarPoints(Point center, int pointCount, int minRadius,
			int maxRadius)
	{
		List<Point> points = new ArrayList<Point>();

		Point first = new Point(center);

		int radius = maxRadius;

		first.translate(radius, 0);

		points.add(first);

		pointCount *= 2;

		int step = 360 / pointCount;

		for (int i = 1; i <= pointCount; i++)
		{
			radius = (i % 2 == 0) ? maxRadius : minRadius;

			float degrees = i * step;

			Point next = new Point(center);

			int sin = (int) (radius * Math.sin(Math.toRadians(degrees)));

			int cos = (int) (radius * Math.cos(Math.toRadians(degrees)));

			next.translate(cos, sin);

			points.add(next);
		}

		return points;
	}

	public static void drawShapeBorder(Graphics2D g, Shape shape, Color borderColor)
	{
		g.setColor(borderColor);

		g.draw(shape);
	}

	public static void fillShape(Graphics2D g, Shape shape, Color fillColor)
	{
		g.setColor(fillColor);
		g.fill(shape);
	}

	public static GeneralPath generatePath(List<Point> points)
	{
		GeneralPath path = new GeneralPath();

		Point first = points.get(0);

		path.moveTo(first.x, first.y);

		for (int i = 1; i < points.size(); i++)
		{
			Point point = points.get(i);

			path.lineTo(point.x, point.y);
		}

		path.closePath();

		return path;
	}
}
