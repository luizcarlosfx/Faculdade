package com.faculdade.computacaografica.lab1;

import java.awt.*;
import java.awt.event.*;

public class Triangles extends Frame
{
	public static void main(String[] args)
	{
		new Triangles().setVisible(true);
	}

	Triangles()
	{
		super("Triangles: 50 triangles inside each other");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(600, 400);
		add("Center", new CvTriangles());
	}
}

class CvTriangles extends Canvas
{
	int maxX, maxY, MinBetweenMaxXAndMaxY, xCenter, yCenter;

	void initialize()
	{
		Dimension d = getSize();
		maxX = d.width - 1;
		maxY = d.height - 1;
		MinBetweenMaxXAndMaxY = Math.min(maxX, maxY);
		xCenter = maxX / 2;
		yCenter = maxY / 2;
	}

	int iX(double x)
	{
		return (int) Math.round(x);
	}

	int iY(double y)
	{
		return (int) (maxY - Math.round(y));
	}

	public void paint(Graphics g)
	{
		initialize();
		double side = 0.95f * MinBetweenMaxXAndMaxY;
		double sideHalf = 0.5f * side;
		double height = sideHalf * Math.sqrt(3);
		
		double xA1, yA1, xB1, yB1, xC1, yC1;
		
		double q = 0.05F;
		double p = 1 - q;
		double xA = xCenter - sideHalf;
		double yA = yCenter - 0.5F * height;
		double xB = xCenter + sideHalf;
		double yB = yA;
		double xC = xCenter;
		double yC = yCenter + 0.5F * height;
		
		for (int i = 0; i < 50; i++)
		{
			g.drawLine(iX(xA), iY(yA), iX(xB), iY(yB));
			g.drawLine(iX(xB), iY(yB), iX(xC), iY(yC));
			g.drawLine(iX(xC), iY(yC), iX(xA), iY(yA));
			xA1 = p * xA + q * xB;
			yA1 = p * yA + q * yB;
			xB1 = p * xB + q * xC;
			yB1 = p * yB + q * yC;
			xC1 = p * xC + q * xA;
			yC1 = p * yC + q * yA;
			xA = xA1;
			xB = xB1;
			xC = xC1;
			yA = yA1;
			yB = yB1;
			yC = yC1;
		}
	}
}
