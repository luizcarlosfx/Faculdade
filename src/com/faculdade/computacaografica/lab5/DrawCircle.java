package com.faculdade.computacaografica.lab5;

// Exemplo de uso da classe Graphics
// Adaptado do original de Frans Coenen
// Dept. of Comp. Sci., University of Liverpool
import java.awt.Color;
import java.awt.Graphics; // Font, Color
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

class CirclePanel extends JPanel
{

	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		/*
		 * g.drawOval(200, 200, 200, 200); g.setColor(Color.WHITE);
		 * g.fillOval(20, 110, 120, 120); // corpo é um circulo branco
		 */
		/*Point center = new Point(200, 200);
		Point end = new Point(200, 100);
		g.drawLine(center.x, center.y, end.x, end.y);
		float angle = 10;
		for (int i = 1; i <= 36; i++)
		{
			double length = Math.sqrt(Math.pow(center.x - end.x, 2) + Math.pow(center.y - end.y, 2));
			end.x += center.x * Math.cos(Math.toRadians(angle));
			end.y -= center.y * Math.sin(Math.toRadians(angle));
			
			System.out.println(length);
			g.drawLine(center.x, center.y, end.x, end.y);
		}*/
		 drawNextPoint(g,10, 100, new Point(200, 200), new Point(200, 200), new Point(200,200));
		 drawNextPoint(g,50, 100, new Point(200, 200), new Point(200, 200), new Point(200,200));
		 drawNextPoint(g,100, 100, new Point(200, 200), new Point(200, 200), new Point(200,200));
		 drawNextPoint(g,200, 100, new Point(200, 200), new Point(200, 200), new Point(200,200));

	}

	private void drawNextPoint(Graphics graphics, int theta, int radius, Point center, Point p0,
			Point p1)
	{
		int i = 0;
		while (theta * i <= 2 * Math.PI)
		{
			p1.x = center.x + (int) (radius * Math.cos(theta * i));
			p1.y = center.y + (int) (radius * Math.sin(theta * i));
			graphics.drawLine(p0.x, p0.y, p1.x, p1.y);
			p0.x = p1.x;
			p0.y = p1.y;
			i++;
		}
	}
}

class GuiCircle extends JFrame
{

	public GuiCircle(String text)
	{
		super(text);
		setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new CirclePanel());
	}
}

class DrawCircle
{

	public static void main(String[] args)
	{
		GuiCircle gui = new GuiCircle("Circle");
		gui.setSize(500, 700);
		gui.setVisible(true);
	}
}
