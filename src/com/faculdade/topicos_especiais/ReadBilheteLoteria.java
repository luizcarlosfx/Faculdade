package com.faculdade.topicos_especiais;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.ObjectInputStream.GetField;

import javax.imageio.ImageIO;

public class ReadBilheteLoteria
{
	private static BufferedImage image;
	private final static String filename = "megasena1.png";

	private final static int startPointX = 81;

	private final static int startPointY = 168;
	private final static int startPointY2 = 358;
	private final static int startPointY3 = 546;

	private final static int gapX = 18;
	private final static int gapY = 10;

	private final static int blockWidth = 31;
	private final static int blockHeight = 16;

	private final static int blankBlockColor = 200;

	public static void main(String[] args)
	{
		try
		{
			image = ImageIO.read(new File(filename));

			System.out.println(getStartPoint());

			System.out.println("Bloco 1: ");
			readEntireBlock(startPointY);

			System.out.println("\nBloco 2: ");
			readEntireBlock(startPointY2);

			System.out.println("\nBloco 3: ");
			readEntireBlock(startPointY3);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static Point getStartPoint()
	{
		int width = image.getWidth();

		int height = image.getHeight();

		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				int pixel = image.getRGB(i, j);

				int r = pixel >> 16 & 0xFF;
				int g = pixel >> 8 & 0xFF;
				int b = pixel & 0xFF;
				
				int black = 150;

				if (r < black && g < black && b < black)
				{
					return new Point(i, j);
				}
			}
		}
		
		return null;
	}
	
	private static void readEntireBlock(int startPointY)
	{
		for (int row = 0; row < 6; row++)
		{
			for (int column = 0; column < 10; column++)
			{
				if (readBlock(startPointY, row, column))
				{
					int number = row * 10 + (column + 1);

					System.out.print(number + " ");
				}
			}
		}
	}

	private static boolean readBlock(int startPointY, int row, int column)
	{
		int startX = startPointX + column * (gapX + blockWidth);

		int startY = startPointY + row * (gapY + blockHeight);

		int endX = startX + blockWidth;
		int endY = startY + blockHeight;

		int total = 0;
		int count = blockWidth * blockHeight;

		for (int x = startX; x <= endX; x++)
		{
			for (int y = startY; y <= endY; y++)
			{
				int pixel = image.getRGB(x, y);

				int r = pixel >> 16 & 0xFF;
				int g = pixel >> 8 & 0xFF;
				int b = pixel & 0xFF;

				int m = (r + g + b) / 3;

				total += m;
			}
		}

		int finalAverage = total / count;

		return finalAverage < blankBlockColor;
	}
}

class Point 
{
	private int x;
	private int y;
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
