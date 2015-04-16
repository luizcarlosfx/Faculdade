package com.faculdade.games;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;

public class Tanque
{
	private double x, y;
	private double angulo;
	private double velocidade;
	private Color cor;
	private boolean estaAtivo;
	
	public Tanque(int x, int y, int a, Color c)
	{
		this.x = x;
		this.y = y;
		this.angulo = 90 - a;
		this.cor = c;
	}
	
	public void aumentaVelocidade()
	{
		velocidade++;
	}
	
	public void giraHorario(int a)
	{
		angulo += a;
	}
	
	public void giraAntihorario(int a)
	{
		angulo -= a;
	}
	
	public void move()
	{
		x = x + Math.sin(Math.toRadians(angulo)) * velocidade;
		y = y - Math.cos(Math.toRadians(angulo)) * velocidade;
	}
	
	public void setEstaAtivo(boolean estaAtivo)
	{
		this.estaAtivo = estaAtivo;
	}
	
	public void draw(Graphics2D g)
	{
		AffineTransform antes = g.getTransform();
		
		AffineTransform at = new AffineTransform();
		
		at.translate(x, y);
		
		at.rotate(Math.toRadians(angulo));
		
		g.transform(at);
		
		g.setColor(cor);
		
		g.fillRect(-10, -12, 20, 24);
		
		for(int e = -12; e <= 8; e += 4)
		{
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(-15, e, 5, 4);
			g.fillRect(10, e, 5, 4);
			g.setColor(Color.BLACK);
			g.drawRect(-15, e, 5, 4);
			g.drawRect(10, e, 5, 4);
		}
		
		g.setColor(Color.LIGHT_GRAY);
		
		g.fillRect(-3, -25, 6, 25);
		
		g.setColor(cor);
		
		g.drawRect(-3, -25, 6, 25);
		
		if(estaAtivo)
		{
			g.setColor(new Color(120, 120, 120));
			
			Stroke linha = g.getStroke();
			
			g.setStroke(new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{8}, 0));
			
			g.drawRect(-24, -32, 48, 55);
			
			g.setStroke(linha);
		}
		
		g.setTransform(antes);
	}
}
