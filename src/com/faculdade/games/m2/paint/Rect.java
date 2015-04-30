package com.faculdade.games.m2.paint;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rect
{
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	public int getMinX()
	{
		return minX;
	}

	public void setMinX(int minX)
	{
		this.minX = minX;
	}

	public int getMinY()
	{
		return minY;
	}

	public void setMinY(int minY)
	{
		this.minY = minY;
	}

	public int getMaxX()
	{
		return maxX;
	}

	public void setMaxX(int maxX)
	{
		this.maxX = maxX;
	}

	public int getMaxY()
	{
		return maxY;
	}

	public void setMaxY(int maxY)
	{
		this.maxY = maxY;
	}

	public int width()
	{
		return (maxX - minX) + 1;
	}

	public int height()
	{
		return (maxY - minY) + 1;
	}

	public Rect(int x, int y)
	{
		minX = maxX = x;
		minY = maxY = y;
	}

	public void grow(Color[][] pixels, boolean[][]visited, Color pixelColor)
	{
		boolean right, left, up, down;

		right = left = up = down = true;

		while (right || left || up || down)
		{
			if (right)
				right = grow(pixels, visited, pixelColor, 1, 0);
			if (left)
				left = grow(pixels, visited, pixelColor, -1, 0);
			if (up)
				up = grow(pixels, visited, pixelColor, 0, 1);
			if (down)
				down = grow(pixels, visited, pixelColor, 0, -1);
		}

	}

	private boolean grow(Color[][] pixels, boolean[][] visited, Color targetColor, int xDir, int yDir)
	{
		boolean right = xDir == 1;
		boolean left = xDir == -1;
		boolean up = yDir == 1;
		boolean down = yDir == -1;

		if (right)
		{
			int x = maxX + 1;

			for (int y = minY; y <= maxY; y++)
			{
				if (!PaintUtils.validPixel(pixels, targetColor, x, y) || visited[x][y])
				{
					return false;
				}
			}

			maxX += 1;
		}
		else if (left)
		{
			int x = minX - 1;

			for (int y = minY; y <= maxY; y++)
			{
				if (!PaintUtils.validPixel(pixels, targetColor, x, y) || visited[x][y])
					return false;
			}

			minX -= 1;
		}
		else if (up)
		{
			int y = minY - 1;

			for (int x = minX; x <= maxX; x++)
			{
				if (!PaintUtils.validPixel(pixels, targetColor, x, y) || visited[x][y])
					return false;
			}

			minY -= 1;
		}
		else if (down)
		{
			int y = maxY + 1;

			for (int x = minX; x <= maxX; x++)
			{
				if (!PaintUtils.validPixel(pixels, targetColor, x, y) || visited[x][y])
					return false;
			}

			maxY += 1;
		}

		return true;
	}

	public void paint(Graphics2D g, Color color)
	{
		g.setColor(color);

		g.fillRect(minX, minY, width(), height());
	}
}
