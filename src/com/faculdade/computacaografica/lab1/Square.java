package com.faculdade.computacaografica.lab1;

import java.awt.Graphics;

public class Square
{
	private Line top;
	private Line right;
	private Line bottom;
	private Line left;
	
	public Square(Point topLeft, Point topRight,
			Point bottomRight, Point bottomLeft)
	{
		top = new Line(topLeft, topRight);
		right = new Line(topRight, bottomRight);
		bottom = new Line(bottomRight, bottomLeft);
		left = new Line(bottomLeft, topLeft);
	}
	
	public void draw(Graphics graphics)
	{
		top.draw(graphics);
		right.draw(graphics);
		bottom.draw(graphics);
		left.draw(graphics);
	}
}
