package com.faculdade.games;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TestPanel extends JPanel
{
	private Box _box;

	public TestPanel()
	{
		_box = new Box(100, 100);
		_box.setFill(true);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		_box.paint(g);

		System.out.println("before " + _box.getPosition());
		
		_box.getTransform().translate(Vector2.DOWN);
		
		System.out.println("after " + _box.getPosition());
		
		repaint();
	}
}
