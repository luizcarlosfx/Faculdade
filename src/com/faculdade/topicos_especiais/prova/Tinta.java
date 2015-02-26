package com.faculdade.topicos_especiais.prova;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tinta
{
	private static BufferedImage image;

	private static int black = 100;

	private static double larguraAreaEmMetros = 60;

	// Uma lata de tinta de 18 litros, custa R$200,00, e rende 150m2.

	private static int litrosLata = 18;

	private static int custoLata = 200;

	private static int rendimentoLata = 150;

	public static int rgb(BufferedImage img, int x, int y)
	{
		int pixel;
		pixel = img.getRGB(x, y);
		int r = (pixel >> 16) & 0xFF;
		int g = (pixel >> 8) & 0xFF;
		int b = pixel & 0xFF;
		return (r + g + b) / 3;
	}

	private static double calculaTotalLitros(double areaEmMetros)
	{
		return (litrosLata * areaEmMetros) / rendimentoLata;
	}

	public static void main(String[] args) throws IOException
	{
		image = ImageIO.read(new File("tinta.png"));
	
		int width = image.getWidth();

		int height = image.getHeight();

	
		System.out.println("width " + width + ", height: " + height);
		
		Pixel primeiroPreto = achaPrimeiroPreto(width, height);

		int largura = calcularLarguraEmPx(primeiroPreto.getX(), primeiroPreto.getY(), width);
		
		/*System.out.println(largura/60f);*/
		
		int altura = calcularAlturaEmPx(primeiroPreto.getX(), primeiroPreto.getY(), height);

		double alturaEmMetros = calculaAlturaEmMetros(altura, largura, larguraAreaEmMetros);

		int totalPixels = largura * altura;

		double areaTotal = larguraAreaEmMetros * alturaEmMetros;

		int pixelsBrancos = contaPixelsBrancosNaArea(primeiroPreto.getX(), primeiroPreto.getY(),
				largura, altura);

		double areaMetros = calculaArea(totalPixels, pixelsBrancos, areaTotal);
		
		System.out.println("Area em metros = " + areaMetros);
		
		double litrosNecessarios = calculaTotalLitros(areaMetros);
		
		int latasNecessarias = (int)Math.ceil(litrosNecessarios / litrosLata);
		
		System.out.println("São necessárias " + latasNecessarias + " latas");
		
		int gastoTotal = latasNecessarias * custoLata;
		
		System.out.println("Gasto total = R$" + gastoTotal);
		/*
		double gastoTotal = */
	}

	private static double calculaArea(int totalPixels, int inuteis, double areaTotal)
	{
		int pixeisPretos = totalPixels - inuteis;
		
		System.out.println(inuteis);

		return (areaTotal * pixeisPretos) / totalPixels;
	}

	private static int contaPixelsBrancosNaArea(int xInicial, int yInicial, int largura, int altura)
	{
		int brancos = 0;
		for (int x = xInicial; x < xInicial + largura; x++)
		{
			for (int y = yInicial; y < yInicial + altura; y++)
			{
				int rgb = rgb(image, x, y);

				if (rgb > black)
				{
					brancos++;
				}
			}
		}

		return brancos;
	}

	private static double calculaAlturaEmMetros(int alturaEmPixels, int larguraEmPixels,
			double larguraEmMetros)
	{
		return (alturaEmPixels * larguraEmMetros) / larguraEmPixels;
	}

	private static Pixel achaPrimeiroPreto(int width, int height)
	{
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				int rgb = rgb(image, x, y);

				if (rgb < black)
				{
					return new Pixel(x, y);
				}
			}
		}

		return null;
	}

	private static int calcularLarguraEmPx(int x, int y, int width)
	{
		int larguraArea = 0;

		for (int i = x; i < width; i++)
		{
			int rgb = rgb(image, i, y);

			if (rgb < black)
			{
				larguraArea++;
			}
			else
			{
				break;
			}
		}

		return larguraArea;
	}

	private static int calcularAlturaEmPx(int x, int y, int height)
	{
		int alturaArea = 0;

		for (int i = y; i < height; i++)
		{
			int rgb = rgb(image, x, i);

			if (rgb < black)
			{
				alturaArea++;
			}
			else
			{
				break;
			}
		}

		return alturaArea;
	}
}

class Pixel
{
	private int x;
	private int y;

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public Pixel(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
}
