package com.faculdade.games.m2.tank;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Tank extends CollidableGameObject
{
	private final long cannonShootWaitTime = 2000;
	private final long machineGunShootWaitTime = 150;

	private double rotateSpeed = 75;

	private double translateSpeed = 75;

	private Vector2 cannonShootPosition = new Vector2(0, -50);
	
	private Vector2 machineGunShootPosition = new Vector2(-10, -20);

	private Color color;
	
	private int health = 100;

	private Instant lastCannonShoot;

	private Instant lastMachineGunShoot;

	private List<CannonBullet> cannonBullets = new ArrayList<CannonBullet>();
	private List<MachineGunBullet> machineGunBullets = new ArrayList<MachineGunBullet>();

	public Tank(Color color, Vector2 position)
	{
		super(position, 0, 18);
		this.color = color;
		allTanks.add(this);
	}

	private static List<Tank> allTanks = new ArrayList<Tank>();

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public static List<Tank> getAllTanks()
	{
		return allTanks;
	}

	public void move(double translate, double rotate)
	{
		Vector2 positionBefore = new Vector2(transform.getPosition().x, transform.getPosition().y);

		transform.translate(0, translate * translateSpeed * deltaTime());

		transform.rotate(rotate * rotateSpeed * deltaTime());

		boolean undo = false;

		for(int i = 0; i < allTanks.size(); i++)
		{
			Tank tank = allTanks.get(i);
			
			if (!tank.equals(this) && collider.checkCollision(tank.collider))
			{
				undo = true;
			}
		}
		
		if (!collider.isInsideBattlefield())
		{
			undo = true;
		}

		if (undo)
		{
			transform.setPosition(positionBefore);
		}
	}

	public long timeSince(Instant instant)
	{
		return instant.until(Instant.now(), ChronoUnit.MILLIS);
	}

	public boolean cannonCanShoot()
	{
		return (lastCannonShoot == null || timeSince(lastCannonShoot) > cannonShootWaitTime);
	}

	public void cannonShoot()
	{
		if(cannonCanShoot())
		{
			Vector2 bulletPos = transform.transformPoint(cannonShootPosition);

			CannonBullet bullet = new CannonBullet(this, 4, bulletPos, transform.getRotation());

			Scene.registerObject(bullet);

			lastCannonShoot = Instant.now();

			cannonBullets.add(bullet);
		}
	}
	
	public boolean machineGunCanShoot()
	{
		return (lastMachineGunShoot == null || timeSince(lastMachineGunShoot) > machineGunShootWaitTime);
	}
	
	public void machineGunShoot()
	{
		if (machineGunCanShoot())
		{
			Vector2 bulletPos = transform.transformPoint(machineGunShootPosition);

			MachineGunBullet bullet = new MachineGunBullet(this, 4, bulletPos, transform.getRotation());

			Scene.registerObject(bullet);

			lastMachineGunShoot = Instant.now();

			machineGunBullets.add(bullet);
//			myBullets.add(bullet);
		}
	}

	private Stroke stroke = new BasicStroke(2);

	@Override
	public void paint(Graphics2D g)
	{
		AffineTransform before = g.getTransform();

		g.setTransform(transform.getAffineTransform());

		collider.paint(g);
		
		Stroke defaultStroke = g.getStroke();
		
		g.setStroke(this.stroke);

		g.setColor(Color.BLACK);
		
		g.drawRect(-10, -12, 20, 24);

		g.setColor(color);

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

		drawMachineGun(g);
		
		drawCannon(g);
		
		drawHealthBar(g);
		
		g.setStroke(defaultStroke);
		
		g.setTransform(before);

		/*
		 * g.fillRect(-10, -12, 24, 20);
		 * 
		 * for (int e = -10; e <= 10; e += 4) { g.setColor(Color.LIGHT_GRAY);
		 * g.fillRect(e, -17, 4, 5); g.fillRect(e, 8, 4, 5);
		 * g.setColor(Color.BLACK); g.drawRect(e, -17, 4, 5); g.drawRect(e, 8,
		 * 4, 5); }
		 * 
		 * g.setColor(Color.LIGHT_GRAY);
		 * 
		 * g.fillRect(0, -4, 25, 6);
		 * 
		 * g.setColor(color);
		 * 
		 * g.drawRect(0, -4, 25, 6);
		 */
	}
	
	void drawMachineGun(Graphics2D g)
	{
		g.setColor(Color.LIGHT_GRAY);

		g.fillRect(-10, -20, 3, 10);

		g.setColor(Color.BLACK);

		g.drawRect(-10, -20, 3, 10);
	}

	void drawCannon(Graphics2D g)
	{
		g.setColor(Color.LIGHT_GRAY);

		g.fillRect(-3, -25, 6, 25);

		g.setColor(Color.BLACK);

		g.drawRect(-3, -25, 6, 25);
	}
	
	void drawHealthBar(Graphics2D g)
	{
		final int healthWidth = 40;
		
		int width = (int) ((health / 100f) * healthWidth);
		
		g.rotate(Math.toRadians(-transform.getRotation()));
		
		Color healthColor = Color.GREEN;
		
		if(health <= 30)
		{
			healthColor  = Color.RED;
		}
		else if(health <= 60)
		{
			healthColor = Color.YELLOW;
		}
		
		g.setColor(healthColor);

		g.fillRect(-healthWidth/2, -40, width, 7);

		g.setColor(Color.black);

		g.drawRect(-healthWidth/2, -40, healthWidth, 7);
	}
	
	public void onCannonHit(CannonBullet bullet)
	{
		health -= 25;
		
		if(health <= 0)
		{
			Scene.destroy(this);
		}
	}
	
	public void onMachineGunHit(MachineGunBullet bullet)
	{
		health -= 1;
		
		if(health <= 0)
		{
			Scene.destroy(this);
		}
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		allTanks.remove(this);
		
		for (CannonBullet bullet : cannonBullets)
		{
			Scene.destroy(bullet);
		}
		
		for (MachineGunBullet bullet : machineGunBullets)
		{
			Scene.destroy(bullet);
		}
	}
}
