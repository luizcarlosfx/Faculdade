package com.faculdade.games.m2.tank;

import java.awt.Graphics2D;

public class CollidableGameObject extends GameObject
{
	protected Collider collider;

	public Collider getCollider()
	{
		return collider;
	}

	public CollidableGameObject(Vector2 position, int colliderRadius)
	{
		this(position, 0, colliderRadius);
	}

	public CollidableGameObject(Vector2 position, double rotation, int colliderRadius)
	{
		super(position, rotation);
		this.collider = new Collider(this, colliderRadius);
	}

	@Override
	public void paint(Graphics2D g)
	{
		collider.paint(g);
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		collider.destroy();
	}
}
