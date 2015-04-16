package com.faculdade.games.m2.tank;

import com.faculdade.games.m2.tank.base.Component;
import com.faculdade.games.m2.tank.base.Input;
import com.faculdade.games.m2.tank.base.Tag;
import com.faculdade.games.m2.tank.base.Input.Button;

public class TankPlayer extends Component
{
	private Tank tank;

	public TankPlayer(Tank tank)
	{
		super();
		this.tank = tank;
	}

	@Override
	public void start()
	{
		gameObject.setTag(Tag.Player);
		Input.addButtonDownListener(this::onButtonDown);
	}

	@Override
	public void update()
	{
		double vertical = 0;
		double horizontal = 0;

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

		tank.move(vertical, horizontal);
	}

	void onButtonDown(Button button)
	{
		if (button == Button.Shoot)
		{
			tank.shoot();
		}
	}
}
