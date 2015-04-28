package com.faculdade.games.m2.tank;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class TankIA extends Tank
{
	private Vector2 randomDistance = Vector2.ZERO;

	private final boolean killOnlyPlayer = true;

	public TankIA(Color color, Vector2 position)
	{
		super(color, position);
		Timer timer = new Timer(5000, this::sortRandomDistance);
		timer.start();
		sortRandomDistance(null);
	}

	@Override
	public void update()
	{
		Tank target = null;

		boolean hasPlayer = false;

		for (int i = 0; i < getAllTanks().size(); i++)
		{
			Tank t = getAllTanks().get(i);

			if (killOnlyPlayer)
			{
				if (t.getTag().equals("Player"))
				{
					target = t;
				}
			}
			else
			{
				if (!t.equals(this))
				{
					if (target == null)
					{
						target = t;
					}
					else
					{
						if (Vector2.distance(target.getTransform().getPosition(),
								transform.getPosition()) > Vector2.distance(t.getTransform()
								.getPosition(), transform.getPosition()))
						{
							target = t;
						}
					}
				}
			}

			hasPlayer = target != null;
		}

		if (!hasPlayer)
			return;

		Transform playerTrannsform = target.getTransform();

		Vector2 playerPosition = playerTrannsform.getPosition();

		Vector2 localDir = transform.inverseTransformPoint(playerPosition);

//		localDir.sum(randomDistance);

		double rotInput = Math.signum(localDir.x);

		boolean rotate = Math.abs(localDir.x) > 5;

		boolean move = (Math.abs(localDir.y) > 100 || killOnlyPlayer);

		if (!rotate)
		{
			if (cannonCanShoot())
			{
				cannonShoot();
			}
			else if (machineGunCanShoot())
			{
				machineGunShoot();
			}
		}

		move(move ? -1 : 0, rotate ? rotInput : 0);
	}

	void sortRandomDistance(ActionEvent e)
	{
		double randomX = Math.random() * 200 - 100;
		double randomY = Math.random() * 100 - 50;

		if (!killOnlyPlayer)
		{
			randomX = 0;
			randomY = 0;
		}

		randomDistance = new Vector2(randomX, randomY);
	}

	/*
	 * @Override public void update() { Tank player = null;
	 * 
	 * boolean hasPlayer = false;
	 * 
	 * for(int i = 0; i < getAllTanks().size(); i++) { Tank t =
	 * getAllTanks().get(i);
	 * 
	 * if(t.getTag().equals("Player")) { player = t; hasPlayer = true; } }
	 * 
	 * if(!hasPlayer) return;
	 * 
	 * Transform playerTrannsform = player.getTransform();
	 * 
	 * Vector2 playerPosition = playerTrannsform.getPosition();
	 * 
	 * Vector2 localDir = transform.inverseTransformPoint(playerPosition);
	 * 
	 * double rotInput = Math.signum(localDir.x);
	 * 
	 * boolean rotate = Math.abs(localDir.x) > 5;
	 * 
	 * boolean move = Math.abs(localDir.y) > 100;
	 * 
	 * if (!move) { shoot(); }
	 * 
	 * move(move ? -1 : 0, rotate ? rotInput : 0); }
	 */
}
