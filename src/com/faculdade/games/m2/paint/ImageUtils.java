/*package com.faculdade.games.m2.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils
{
	public static BufferedImage getImage(String path)
	{
		try
		{
			return ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();

			return null;
		}
	}

	public static void saveImage(BufferedImage image, File file)
	{
		try
		{
			ImageIO.write(image, "jpg", file);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setPixels(BufferedImage image, Color[][] pixels)
	{
		for (int i = 0; i < pixels.length; i++)
		{
			for (int j = 0; j < pixels[0].length; j++)
			{
				setPixel(image, pixels[i][j], i, j);
			}
		}
	}

	public static void setPixel(BufferedImage image, Color color, int x, int y)
	{
		image.setRGB(x, y, color.getRGB());
	}

	public static Color[][] pixels(BufferedImage image)
	{
		Raster raster = image.getData();

		int[] rgba = new int[4];

		int columns = image.getWidth();

		int lines = image.getHeight();

		Color[][] pixels = new Color[columns][lines];

		for (int i = 0; i < lines; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				pixels[j][i] = getColor(raster, rgba, j, i);
			}
		}

		return pixels;
	}

	public static int rgb(BufferedImage img, int x, int y)
	{
		int pixel;
		pixel = img.getRGB(x, y);
		int r = (pixel >> 16) & 0xFF;
		int g = (pixel >> 8) & 0xFF;
		int b = pixel & 0xFF;
		return (r + g + b) / 3;
	}

	public static Color color(BufferedImage img, int x, int y)
	{
		int pixel;
		pixel = img.getRGB(x, y);
		int r = (pixel >> 16) & 0xFF;
		int g = (pixel >> 8) & 0xFF;
		int b = pixel & 0xFF;

		return new Color(r, g, b);
	}

	public static Color getColor(Raster raster, int[] rgba, int x, int y)
	{
		raster.getPixel(x, y, rgba);

		return new Color(rgba[0], rgba[1], rgba[2]);
	}
}
*/

package com.faculdade.games.m2.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mysql.jdbc.Buffer;

public class ImageUtils
{
	public static BufferedImage getImage(String path)
	{
		try
		{
			return ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();

			return null;
		}
	}

	public static void saveImage(BufferedImage image, File file)
	{
		try
		{
			String path = file.getPath();
			
			String extension = path.substring(path.length() - 3);
			
			ImageIO.write(image, "png", file);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setPixels(BufferedImage image, Color[][] pixels)
	{
		for (int i = 0; i < pixels.length; i++)
		{
			for (int j = 0; j < pixels[0].length; j++)
			{
				setPixel(image, pixels[i][j], i, j);
			}
		}
	}

	public static void setPixel(BufferedImage image, Color color, int x, int y)
	{
		image.setRGB(x, y, color.getRGB());
	}

	public static Color[][] getPixels(BufferedImage image)
	{
		int columns = image.getWidth();

		int lines = image.getHeight();

		Color[][] pixels = new Color[columns][lines];

		for (int i = 0; i < lines; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				pixels[j][i] = getPixel(image, j, i);
			}
		}

		return pixels;
	}


	public static Color getPixel(BufferedImage img, int x, int y)
	{
		return new Color(img.getRGB(x, y));
	}
}
