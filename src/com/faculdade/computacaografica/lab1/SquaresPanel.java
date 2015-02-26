package com.faculdade.computacaografica.lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SquaresPanel extends JPanel
{
	private float quocient = .05f;
	private float step= 1 - quocient;
	private Point topLeft;
	private Point topRight;
	private Point bottomLeft;
	private Point bottomRight;
	private Square square;
	
	private int squares = 50;

	public SquaresPanel(Dimension size)
	{
		this.setSize(size);
		
		int minX = 5;
		int minY = 5;
		int maxX = size.height - 50;
		int maxY = size.height - 50;

		topLeft = new Point(minX, minY);
		topRight = new Point(maxX, minY);
		bottomRight = new Point(maxX, maxY);
		bottomLeft = new Point(minX, maxY);
		
		square = new Square(topLeft, topRight, bottomRight, bottomLeft);
	}

	@Override
	public void paint(Graphics graphics)
	{
		graphics.setColor(Color.black);
		for (int i = 0; i < squares; i++)
		{
			square.draw(graphics);
			
			float x1 = step * topLeft.getX() + quocient * topRight.getX();
			float y1 = step * topLeft.getY() + quocient * topRight.getY();
			float x2 = step * topRight.getX() + quocient * bottomRight.getX();
			float y2 = step * topRight.getY() + quocient * bottomRight.getY();
			float x3 = step * bottomRight.getX() + quocient * bottomLeft.getX();
			float y3 = step * bottomRight.getY() + quocient * bottomLeft.getY();
			float x4 = step * bottomLeft.getX() + quocient * topLeft.getX();
			float y4 = step * bottomLeft.getY() + quocient * topLeft.getY();
			
			topLeft.setX(Math.round(x1));
			topLeft.setY(Math.round(y1));
			topRight.setX(Math.round(x2));
			topRight.setY(Math.round(y2));
			bottomRight.setX(Math.round(x3));
			bottomRight.setY(Math.round(y3));
			bottomLeft.setX(Math.round(x4));
			bottomLeft.setY(Math.round(y4));
			
			Color currentColor = graphics.getColor();
			graphics.setColor(new Color(currentColor.getRed() + 5, currentColor.getGreen(), currentColor.getBlue()));
		}
	}
}




