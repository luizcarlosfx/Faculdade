package com.faculdade.topicos_especiais.prova;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Intersecção
{
	private static BufferedImage image;

	private static int origemPixelX = 47;
	private static int origemPixelY = 342;

	private static int maxYPixelX = 47;
	private static int maxYPixelY = 47;

	private static int maxXPixelX = 587;
	private static int maxXPixelY = 342;

	private static int maxX = 100;
	private static int maxY = 20;

	private static boolean isBlue(int r, int g, int b)
	{
		return b > 250 && r < 50 && g < 50;
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
		image = ImageIO.read(new File("interseccao.png"));

		int width = image.getWidth();
		int height = image.getHeight();

		for (int x = origemPixelX; x < maxXPixelX; x++)
		{
			int faixasAzuisNaColuna = 0;

			boolean ultimoEraAzul = false;

			for (int y = maxYPixelY; y < origemPixelY; y++)
			{
				int[] pixelRgb = pixel(image, x, y);

				int r = pixelRgb[0];
				int g = pixelRgb[1];
				int b = pixelRgb[2];

				if (isBlue(r, g, b))
				{
					if (!ultimoEraAzul)
					{
						faixasAzuisNaColuna++;
					}

					ultimoEraAzul = true;
				}
				else
				{
					ultimoEraAzul = false;
				}
			}

			
			if (faixasAzuisNaColuna == 1)
			{
				System.out.println("coluna: " + x + ", faixas: " + faixasAzuisNaColuna);
			}
		}
	}

}
