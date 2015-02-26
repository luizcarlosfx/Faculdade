package com.faculdade.topicos_especiais;

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Bilhar
{
	private static BufferedImage image;
	private final static String filename = "megasena1.png";

	private static List<Vector2> cacapas = new ArrayList<Vector2>();
	
	private static Vector2 whiteBallCenter;
	
	private static Vector2 targetBallCenter;
	
	private static float ballRadius = 13.5f;

	public static void main(String[] args)
	{
		try
		{
			image = ImageIO.read(new File(filename));
			
			cacapas.add(new Vector2(0, 0));
			cacapas.add(new Vector2(400, 0));
			cacapas.add(new Vector2(800, 0));
			cacapas.add(new Vector2(0, 400));
			cacapas.add(new Vector2(400, 400));
			cacapas.add(new Vector2(800, 400));
			
			whiteBallCenter = new Vector2(80, 254);
			targetBallCenter = new Vector2(635, 259);
			
			Vector2 targetCacapa = cacapas.get(5);
			
			Vector2 distanceFromTargetBallToTargetCacapa = targetCacapa.minus(targetBallCenter);
			
			Vector2 targetPoint = targetBallCenter.plus(distanceFromTargetBallToTargetCacapa.normalized().multiply(-2 * ballRadius));
		
			System.out.println(targetPoint);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

class Vector2
{
	private double x;
	private double y;

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public Vector2(double x, double y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	public Vector2 minus(Vector2 other)
	{
		return new Vector2(this.x - other.x, this.y - other.y);
	}
	
	public Vector2 plus(Vector2 other)
	{
		return new Vector2(this.x + other.x, this.y + other.y);
	}
	
	public Vector2 multiply(double other)
	{
		return new Vector2(this.x * other, this.y * other);
	}
	
	public Vector2 divide(double other)
	{
		return new Vector2(this.x / other, this.y / other);
	}
	
	public double magnitude()
	{
		return Math.sqrt( x * x + y * y);
	}
	
	public Vector2 normalized()
	{
		return this.divide(magnitude());
	}

	@Override
	public String toString()
	{
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
