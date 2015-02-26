package com.faculdade.computacaografica.lab1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TrianglePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Point pointA = new Point(75, 75);
	private Point pointB = new Point(0, 0);
	private Point pointC = new Point(50, 20);

	public TrianglePanel()
	{

	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.setColor(Color.red);
		graphics.drawLine(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY());
		graphics.drawLine(pointC.getX(), pointC.getY(), pointA.getX(), pointA.getY());
		graphics.drawLine(pointC.getX(), pointC.getY(), pointB.getX(), pointB.getY());
	}

	public void Transladar(int ammountX, int ammountY)
	{
		pointA.setX(pointA.getX() + ammountX);
		pointA.setY(pointA.getY() + ammountY);
		pointB.setX(pointB.getX() + ammountX);
		pointB.setY(pointB.getY() + ammountY);
		pointC.setX(pointC.getX() + ammountX);
		pointC.setY(pointC.getY() + ammountY);

		repaint();
	}

	public void Escalonar(int ammountX, int ammountY)
	{
		pointA.setX(pointA.getX() * ammountX);
		pointA.setY(pointA.getY() * ammountY);
		pointB.setX(pointB.getX() * ammountX);
		pointB.setY(pointB.getY() * ammountY);
		pointC.setX(pointC.getX() * ammountX);
		pointC.setY(pointC.getY() * ammountY);

		repaint();
	}

	public void Rotate(float angle)
	{

	}

	public void Reset()
	{
		pointA = new Point(75, 75);
		pointB = new Point(0, 0);
		pointC = new Point(50, 20);
	}
}
