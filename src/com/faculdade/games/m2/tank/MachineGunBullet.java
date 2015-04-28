package com.faculdade.games.m2.tank;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.List;

import kuusisto.tinysound.Sound;

public class MachineGunBullet extends CollidableGameObject
{
	private int velocity = 500;

	private Tank owner;

	private Sprite sprite = new Sprite(
			"com/faculdade/games/m2/tank/resources/MachineGunProjectile.png", 128, 28, -30, -1,
			-90, .15f, true);

	public Tank getOwner()
	{
		return owner;
	}

	public MachineGunBullet(Tank owner, int radius, Vector2 position, double rotation)
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
				Vector2 explosionPosition = new Vector2(transform.getPosition());

				Sprite explosionSprite = new Sprite(
						"com/faculdade/games/m2/tank/resources/explosion2.png", 100, 100, -10, -10, 0,
						.25, false, 7);

				Sound explosionSound = SoundUtils
						.getSound("com/faculdade/games/m2/tank/resources/explosion.wav");

				Explosion explosion = new Explosion(explosionSprite, explosionSound,
						explosionPosition);

				Scene.registerObject(explosion);

				Scene.destroy(this);

				tank.onMachineGunHit(this);

				break;
			}
		}
	}
}
