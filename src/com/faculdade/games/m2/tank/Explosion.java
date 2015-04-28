package com.faculdade.games.m2.tank;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import kuusisto.tinysound.Sound;

public class Explosion extends GameObject
{
	private Sprite sprite;
	
	public Explosion(Sprite sprite, Sound sound, Vector2 position)
	{
		super(position);
		this.sprite = sprite;
		sound.play();
	}

	@Override
	public void awake()
	{
		new Thread(this::destroyThis).start();
	}

	void destroyThis()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (Exception e)
		{

		}
		Scene.destroy(this);
	}

	@Override
	public void paint(Graphics2D g)
	{
		AffineTransform before = g.getTransform();

		g.setTransform(transform.getAffineTransform());

		sprite.paint(g);

		g.setTransform(before);
	}
}
