package com.faculdade.computacaografica.lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.text.NumberFormatter;

public class DrawImage extends JFrame
{
	private Graphics graphics;
	private int xPosition = 20;
	private int yPosition = 20;
	
	int size = 10;

	public DrawImage()
	{
		setSize(1300, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		int [][] matrix = new ImageAnalize().getImageMatrix();

		xPosition = 10;
		yPosition = 30;
		
		size = (getHeight()/ matrix.length) ;
		
		graphics = g;
		
		for (int[] line : matrix)
		{
			for (int i : line)
			{
				drawRectangle(i);
			}
			xPosition = 10;
			yPosition += size;
		}
	}

	public void drawRectangle(int value)
	{
		int color = (int) ((value * 255) / 15);
		
		graphics.setColor(new Color(color, color, color));
		
		System.out.println(xPosition + ":" + yPosition);
		
		graphics.fillRect(xPosition, yPosition, size, size);
		
		xPosition += size;
	}

	public static void main(String[] args)
	{
		new DrawImage().setVisible(true);
	}
}
