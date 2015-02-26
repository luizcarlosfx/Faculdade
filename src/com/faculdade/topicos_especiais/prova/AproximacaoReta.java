package com.faculdade.topicos_especiais.prova;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class AproximacaoReta
{
	private static BufferedImage image;

	private static List<Point> points = new ArrayList<>();

	private static Point origem = new Point(42, 340);

	private static Point maxYPixel = new Point(42, 39);
	private static Point maxXPixel = new Point(579, 340);

	private static int maxX = 100;
	private static int maxY = 10;

	private static boolean isRed(int x, int y)
	{
		int[] pixelRgb = pixel(image, x, y);

		int r = pixelRgb[0];
		int g = pixelRgb[1];
		int b = pixelRgb[2];

		return r > 250 && b < 50 && g < 50;
	}

	public static int[] pixel(BufferedImage img, int x, int y)
	{
		int pixel;
		int rgb[] = new int[3];
		pixel = img.getRGB(x, y);
		rgb[0] = (pixel >> 16) & 0xFF;
		rgb[1] = (pixel >> 8) & 0xFF;
		rgb[2] = pixel & 0xFF;
		return rgb;
	}

	public static void main(String[] args) throws IOException
	{
		image = ImageIO.read(new File("aprox.png"));

		int width = image.getWidth();

		int height = image.getHeight();

		maxXPixel = pixelEmRelacaoAOrigem(maxXPixel.x, maxXPixel.y);

		maxYPixel = pixelEmRelacaoAOrigem(maxYPixel.x, maxYPixel.y);

		/* System.out.println(maxYPixel); */

		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				if (isRed(x, y))
				{
					// top, left, right, bottom are red
					if (isRed(x, y - 1) && isRed(x - 1, y) && isRed(x + 1, y) && isRed(x, y + 1))
					{
						Point pixel = pixelEmRelacaoAOrigem(x, y);

						Point units = convertToUnits(pixel);

						points.add(units);
					}
				}
			}
		}

		int MAXN = points.size();
		int n = 0;
		double[] x = new double[MAXN];
		double[] y = new double[MAXN];

		// first pass: read in data, compute xbar and ybar
		double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
		for (int i = 0; i < points.size(); i++)
		{
			x[n] = points.get(i).x;
			y[n] = points.get(i).y;
			sumx += x[n];
			sumx2 += x[n] * x[n];
			sumy += y[n];
			n++;
		}
		double xbar = sumx / n;
		double ybar = sumy / n;

		// second pass: compute summary statistics
		double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
		for (int i = 0; i < n; i++)
		{
			xxbar += (x[i] - xbar) * (x[i] - xbar);
			yybar += (y[i] - ybar) * (y[i] - ybar);
			xybar += (x[i] - xbar) * (y[i] - ybar);
		}
		double beta1 = xybar / xxbar;
		double beta0 = ybar - beta1 * xbar;

		// print results
		System.out.println("ax+b   = " + beta1 + "x + " + beta0);

		for (System.out.println("abcd"); true; beta1++)
		{

		}
	}

	private static Point convertToUnits(Point point)
	{
		double xUnits = (point.x * maxX) / maxXPixel.x;
		double yUnits = (point.y * maxY) / maxYPixel.y;

		return new Point(xUnits, yUnits);
	}

	private static Point pixelEmRelacaoAOrigem(double x, double y)
	{
		int newX = (int) (x - origem.x);
		int newY = (int) (origem.y - y);

		return new Point(newX, newY);
	}

}

class Point
{
	public double x;
	public double y;

	public Point(double x, double y)
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
