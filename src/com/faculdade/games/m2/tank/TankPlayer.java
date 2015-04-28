package com.faculdade.games.m2.tank;

import java.awt.Color;

public class TankPlayer extends Tank
{
	public TankPlayer(Color color, Vector2 position)
	{
		super(color, position);
	}

	@Override
	public void awake()
	{
		setTag("Player");
	}

	@Override
	public void update()
	{
		double vertical = 0;
		double horizontal = 0;
		
//		System.out.println("here we are");

		if (Input.Up)
		{
			vertical -= 1;
		}
		if (Input.Down)
		{
			vertical += 1;
		}
		if (Input.Left)
		{
			horizontal -= 1;
		}
		if (Input.Right)
		{
			horizontal += 1;
		}
		
//		System.out.println("h=" + horizontal);

		move(vertical, horizontal);
		
		if(Input.Shoot)
		{
			cannonShoot();
		}
		
		if(Input.Shoot2)
		{
			machineGunShoot();
		}
	}
}
