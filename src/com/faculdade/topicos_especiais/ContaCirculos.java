package com.faculdade.topicos_especiais;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ContaCirculos
{
	private static BufferedImage image;

	public static void main(String[] args) throws IOException
	{
		image = ImageIO.read(new File("circulos.jpg"));

		int pretos = 0;
		double area = 0;

		for (int x = 0; x < image.getWidth(); x++)
		{
			for (int y = 0; y < image.getHeight(); y++)
			{
				if (isBlack(x, y))
				{
					if (pretos == 0)
					{
						int k = x;

						while (isBlack(k, y))
						{
							k++;
						}

						double raio = (k - x) / 2;
						area = Math.PI * Math.pow(raio, 2);
					}

					pretos++;
				}
			}
		}
		
		int circulos = (int)(pretos/area);
		
		System.out.println(circulos + " circulos");
	}

	private static boolean isBlack(int x, int y)
	{
		int rbg = rgb(image, x, y);

		return rbg < 100;
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
}
