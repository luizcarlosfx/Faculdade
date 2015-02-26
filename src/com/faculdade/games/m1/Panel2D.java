package com.faculdade.games.m1;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel2D extends JPanel
{
	protected final Stroke STROKE = new BasicStroke(2);
	
	@Override
	protected void paintComponent(Graphics g)
	{
		paintComponent2D((Graphics2D) g);
	}

	protected void paintComponent2D(Graphics2D graphics)
	{
		super.paintComponent(graphics);
		
		graphics.setStroke(STROKE);
	}
}
