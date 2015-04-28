package com.faculdade.games.m2.tank;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Collider
{
	private GameObject gameObject;

	private int radius;

	private final boolean drawGizmos = false;

	public List<Collider> allColliders = new ArrayList<Collider>();

	public GameObject getGameObject()
	{
		return gameObject;
	}

	public int getRadius()
	{
		return radius;
	}

	public Collider(GameObject gameObject, int radius)
	{
		this.gameObject = gameObject;
		this.radius = radius;
	}

	public Vector2 position()
	{
		return gameObject.transform.getPosition();
	}

	public void paint(Graphics2D g)
	{
		if (!drawGizmos)
			return;

		AffineTransform before = g.getTransform();

		AffineTransform tr = AffineTransform.getTranslateInstance(position().x, position().y);
		
		g.setTransform(tr);
		
		Color oldColor = g.getColor();

		g.setColor(Color.GREEN);

		g.drawOval(-radius, -radius, radius * 2, radius * 2);

		g.setColor(oldColor);
		
		g.setTransform(before);
	}

	public boolean checkCollision(Collider other)
	{
		double distance = Vector2.distance(position(), other.position());

		return distance <= (radius + other.radius);
	}

	public boolean isInsideBattlefield()
	{
		Rectangle bounds = Scene.battleFieldBounds;

		int minX = (int) bounds.getMinX();

		int maxX = (int) bounds.getMaxX();

		int minY = (int) bounds.getMinY();

		int maxY = (int) bounds.getMaxY();

		Vector2 center = position();

		return center.x > minX + radius && center.x < maxX - radius && center.y > minY + radius
				&& center.y < maxY - radius;
	}

	public void destroy()
	{
		allColliders.remove(this);
	}
}

/*
 * package com.faculdade.games.m2.tank.base;
 * 
 * import java.awt.Color; import java.awt.Graphics2D; import java.awt.Rectangle;
 * import java.awt.geom.AffineTransform; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import com.faculdade.games.Vector2; import com.faculdade.games.m2.tank.Scene;
 * 
 * public class Collider { private GameObject gameObject;
 * 
 * private Rectangle bounds;
 * 
 * private final boolean drawGizmos = true;
 * 
 * public List<Collider> allColliders = new ArrayList<Collider>();
 * 
 * public Collider(GameObject gameObject, int width, int height) {
 * this.gameObject = gameObject; this.bounds = new Rectangle(width, height);
 * allColliders.add(this); }
 * 
 * public Vector2 position() { return gameObject.transform.getPosition(); }
 * 
 * public Rectangle getBounds() { bounds.setLocation((int) position().x -
 * bounds.width / 2, (int) position().y - bounds.height / 2);
 * 
 * return bounds; }
 * 
 * public void paint(Graphics2D g) { if (!drawGizmos) return;
 * 
 * AffineTransform before = g.getTransform();
 * 
 * AffineTransform tr = AffineTransform.getTranslateInstance(position().x,
 * position().y);
 * 
 * g.setTransform(tr);
 * 
 * Color oldColor = g.getColor();
 * 
 * g.setColor(Color.GREEN);
 * 
 * g.drawRect(-bounds.width / 2, -bounds.height / 2, bounds.width,
 * bounds.height);
 * 
 * g.setColor(oldColor);
 * 
 * g.setTransform(before); }
 * 
 * public boolean checkCollision(Collider other) { return
 * getBounds().intersects(other.getBounds()); }
 * 
 * public boolean isInsideBattlefield() { return
 * Scene.battleFieldBounds.contains(getBounds()); }
 * 
 * public void destroy() { allColliders.remove(this); } }
 */
