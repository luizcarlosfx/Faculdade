package com.faculdade.games.m2.tank;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import com.faculdade.games.m2.tank.base.Collider;
import com.faculdade.games.m2.tank.base.Component;
import com.faculdade.games.m2.tank.base.GameObject;
import com.faculdade.games.m2.tank.base.Tag;

public class Bullet extends Component
{
	private int velocity = 1;
	
	private Collider collider;
	
	private int radius = 3;
	
	private Color color = Color.BLACK;
	
	public static Bullet createNew(AffineTransform transform)
	{
		GameObject obj = SceneController.instantiateNew(transform);
		
		Bullet bullet = new Bullet();
		
		obj.addComponent(bullet);
		
		return bullet;
	}

	@Override
	public void start()
	{
		collider = new Collider(gameObject, 3);
		
		gameObject.addComponent(collider);
		
		gameObject.setTag(Tag.Bullet);
	}
	
	@Override
	public void paint(Graphics2D g)
	{
		g.setColor(color);
		g.fillOval(-radius, -radius, radius * 2, radius * 2);
	}

	@Override
	public void update()
	{
		transform.translate(0, -velocity * SceneController.DELTA_TIME);
	}
}
