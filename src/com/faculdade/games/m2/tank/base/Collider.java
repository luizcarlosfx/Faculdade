package com.faculdade.games.m2.tank.base;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Collider extends Component
{
	private GameObject gameObject;

	private int radius;

	public Collider(GameObject gameObject, int radius)
	{
		this.gameObject = gameObject;
		this.radius = radius;
	}

	public Point position()
	{
		AffineTransform tr = gameObject.transform();

		return new Point((int) tr.getTranslateX(), (int) tr.getTranslateY());
	}

	public void paint(Graphics2D g)
	{
		Color oldColor = g.getColor();
		
		g.setColor(Color.RED);

		g.drawOval(-radius, -radius, radius * 2, radius * 2);
		
		g.setColor(oldColor);
	}

	public boolean checkCollision(Tag tag)
	{
		/*List<GameObject> objs = SceneController.getGameObjects();

		for (GameObject other : objs)
		{
			if (other.collider != this && other.getTag() == tag && checkCollision(other.collider))
			{
				return true;
			}
		}*/

		return false;
	}

	public boolean checkCollision(Collider other)
	{
		double distance = position().distance(other.position());

		return distance <= (radius * 2);
	}

	public boolean checkInside(Rectangle bounds)
	{
		int minX = (int) bounds.getMinX();
		
		int maxX = (int) bounds.getMaxX();
		
		int minY = (int) bounds.getMinY();
		
		int maxY = (int) bounds.getMaxY();
		
		Point center = position();
		
		return center.x > minX + radius && center.x < maxX - radius && center.y > minY + radius && center.y < maxY - radius;
	}
}
