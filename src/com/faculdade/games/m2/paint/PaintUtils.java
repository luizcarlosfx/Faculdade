package com.faculdade.games.m2.paint;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class PaintUtils
{
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
