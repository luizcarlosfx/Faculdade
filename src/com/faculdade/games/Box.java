package com.faculdade.games;

import java.awt.Graphics;

public class Box extends Shape
{
	private int width;
	private int height;

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public Vector2 getPosition()
	{
		return getTransform().getPosition();
	}

	public void setPosition(Vector2 position)
	{
		getTransform().setPosition(position);
	}

	public Box(int width, int height)
	{
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(Graphics graphics)
	{
		if (this.getUseBorder())
		{
			graphics.setColor(getBorderColor());
			graphics.drawRect(getPosition().getX(), getPosition().getY(), width, height);
		}
		if (this.getFill())
		{
			graphics.setColor(getFillColor());
			graphics.fillRect(getPosition().getX(), getPosition().getY(), width, height);
		}
	}
}
