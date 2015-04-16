package com.faculdade.games.m2.tank.base;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import com.faculdade.games.m2.tank.SceneController;

public class Component
{
	protected GameObject gameObject;

	protected AffineTransform transform;

	public void setGameObject(GameObject gameObject)
	{
		this.gameObject = gameObject;
		this.transform = gameObject.transform();
	}
	
	public void addComponent(Component component)
	{
		gameObject.addComponent(component);
	}
	
	public <T extends Component> T getComponent(Class<T> clazz)
	{
		return gameObject.getComponent(clazz);
	}
	
	protected double deltaTime()
	{
		return SceneController.DELTA_TIME / 1000f;
	}

	public void start()
	{
	}

	public void update()
	{
	}

	public void paint(Graphics2D g)
	{
	}
}
