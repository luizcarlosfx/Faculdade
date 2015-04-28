package com.faculdade.games.m2.paint;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class PaintUtils
{
	public static  boolean validPixel(Color[][] pixels, Color targetColor, int x, int y)
	{
		boolean validIndex = x >= 0 && x < pixels.length && y >= 0 && y < pixels[0].length;

		return validIndex && compareColor(targetColor, pixels[x][y], 15);
	}

	public static boolean compareColor(Color c1, Color c2, int error)
	{
		error = 7;
		return compareRed(c1, c2, error) && compareGreen(c1, c2, error)
				&& compareBlue(c1, c2, error);
	}

	public static boolean compareRed(Color c1, Color c2, int error)
	{
		return Math.abs(c1.getRed() - c2.getRed()) <= error;
	}

	public static boolean compareGreen(Color c1, Color c2, int error)
	{
		return Math.abs(c1.getGreen() - c2.getGreen()) <= error;
	}

	public static boolean compareBlue(Color c1, Color c2, int error)
	{
		return Math.abs(c1.getBlue() - c2.getBlue()) <= error;
	}

	
	public static List<Point> getPixelsInLine(int x1, int y1, int x2, int y2)
	{
		List<Point> pixels = new ArrayList<Point>();

		// delta of exact value and rounded value of the dependant variable
		int d = 0;

		int dy = Math.abs(y2 - y1);
		int dx = Math.abs(x2 - x1);

		int dy2 = (dy << 1); // slope scaling factors to avoid floating
		int dx2 = (dx << 1); // point

		int ix = x1 < x2 ? 1 : -1; // increment direction
		int iy = y1 < y2 ? 1 : -1;

		if (dy <= dx)
		{
			while (true)
			{
				pixels.add(new Point(x1, y1));
				// plot(g, x1, y1);
				if (x1 == x2)
					break;
				x1 += ix;
				d += dy2;
				if (d > dx)
				{
					y1 += iy;
					d -= dx2;
				}
			}
		}
		else
		{
			while (true)
			{
				pixels.add(new Point(x1, y1));
				// plot(g, x1, y1);
				if (y1 == y2)
					break;
				y1 += iy;
				d += dx2;
				if (d > dy)
				{
					x1 += ix;
					d -= dy2;
				}
			}
		}

		return pixels;
	}
}
