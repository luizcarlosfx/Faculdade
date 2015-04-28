package com.faculdade.games.m2.tank;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.List;

import kuusisto.tinysound.Sound;

public class CannonBullet extends CollidableGameObject
{
	private int velocity = 200;

	private Tank owner;

	private Sprite sprite = new Sprite("com/faculdade/games/m2/tank/resources/bullet.png", 45, 11, -40, -5, -90, 1, true);

	public Tank getOwner()
	{
		return owner;
	}

	public CannonBullet(Tank owner, int radius, Vector2 position, double rotation)
	{
		super(position, rotation, radius);
	}

	@Override
	public void awake()
	{
		setTag("Bullet");
	}

	@Override
	public void paint(Graphics2D g)
	{
		AffineTransform before = g.getTransform();

		g.setTransform(transform.getAffineTransform());

		collider.paint(g);

		sprite.paint(g);

		g.setTransform(before);
	}

	@Override
	public void update()
	{
		List<Tank> allTanks = Tank.getAllTanks();

		transform.translate(0, -velocity * deltaTime());

		for (int i = 0; i < allTanks.size(); i++)
		{
			Tank tank = allTanks.get(i);

			if (collider.checkCollision(tank.getCollider()))
			{
				Transform tankTransform = tank.getTransform();

				Vector2 explosionPosition = new Vector2(tankTransform.getPosition());

				explosionPosition.sum(-20, -80);

				Sprite explosionSprite = new Sprite("com/faculdade/games/m2/tank/resources/GrenadeExplosion.png", 50, 128,0, 1, false);
				
				Sound explosionSound = SoundUtils.getSound("com/faculdade/games/m2/tank/resources/explosion.wav");
				
				Explosion explosion = new Explosion(explosionSprite, explosionSound, explosionPosition);

				Scene.registerObject(explosion);

				Scene.destroy(this);

				tank.onCannonHit(this);

				break;
			}
		}
	}
}
