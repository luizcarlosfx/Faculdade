package com.faculdade.games.m2.tank;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import com.faculdade.games.m2.tank.base.Collider;
import com.faculdade.games.m2.tank.base.Component;
import com.faculdade.games.m2.tank.base.MathUtils;
import com.faculdade.games.m2.tank.base.Tag;

public class Tank extends Component
{
	private double rotateSpeed = 75;
	private double translateSpeed = 75;

	private Point shootPosition = new Point(0, -25);

	private Collider collider;

	@Override
	public void start()
	{
		System.out.println("Tank Start");

		collider = new Collider(gameObject, 17);

		addComponent(collider);
	}

	public void move(double translate, double rotate)
	{
		AffineTransform before = (AffineTransform)transform.clone();

		transform.translate(0, translate * translateSpeed * deltaTime());

		transform.rotate(Math.toRadians(rotate * rotateSpeed * deltaTime()));

		boolean undo = false;

		if (!collider.checkInside(SceneController.battleField))
		{
			undo = true;
		}
		else if (collider.checkCollision(Tag.Enemy))
		{
			undo = true;
		}

		if (undo)
		{
			transform.setTransform(before);
		}
	}

	public void shoot()
	{
		AffineTransform bulletTransform = new AffineTransform(transform);

		bulletTransform.translate(shootPosition.x, shootPosition.y);

		Bullet.createNew(bulletTransform);
	}

	@Override
	public void paint(Graphics2D g)
	{
		g.setColor(Color.GREEN);

		g.fillRect(-10, -12, 20, 24);

		for (int e = -12; e <= 8; e += 4)
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

		g.setColor(Color.GREEN);

		g.drawRect(-3, -25, 6, 25);
	}
}
