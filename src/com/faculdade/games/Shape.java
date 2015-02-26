package com.faculdade.games;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape
{
	private Color borderColor = Color.black;
	private Color fillColor = Color.black;
	
	private boolean useBorder = true;
	
	private boolean fill = false;
	
	private Transform transform = new Transform();

	public Transform getTransform()
	{
		return transform;
	}

	public Color getBorderColor()
	{
		return borderColor;
	}

	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}

	public Color getFillColor()
	{
		return fillColor;
	}

	public void setFillColor(Color fillColor)
	{
		this.fillColor = fillColor;
	}

	public boolean getUseBorder()
	{
		return useBorder;
	}

	public void setUseBorder(boolean useBorder)
	{
		this.useBorder = useBorder;
	}

	public boolean getFill()
	{
		return fill;
	}

	public void setFill(boolean fill)
	{
		this.fill = fill;
	}
	
	public abstract void paint(Graphics graphics);
}
