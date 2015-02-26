package com.faculdade.computacaografica.lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.text.NumberFormatter;

public class HistogramView extends JFrame
{
	private Graphics graphics;
	private int xPosition = 20;

	private static final long serialVersionUID = 1L;

	public HistogramView()
	{
		setSize(920, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		Map<Integer, Double> histogram = new ImageAnalize().generateHistogram();

		xPosition = 20;
		graphics = g;

		histogram.forEach(this::drawRectangle);
	}

	public void drawRectangle(Integer value, Double percentage)
	{
		int color = (int) ((value * 255) / 15);
		graphics.setColor(new Color(color, color, color));
		graphics.fillRect(xPosition, 500, 50, -percentage.intValue() * 20);

		graphics.setColor(Color.RED);
		graphics.drawString(round(percentage) + "%", xPosition + 10,
				500 - (int) (percentage / 2) * 20);
		xPosition += 55;
	}

	public static String round(double value)
	{
		return String.format("%.2f", value);
	}

	public static void main(String[] args)
	{
		new HistogramView().setVisible(true);
	}
}
