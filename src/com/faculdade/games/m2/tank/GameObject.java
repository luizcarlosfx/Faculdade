package com.faculdade.games.m2.tank;

import java.awt.Graphics2D;

public class GameObject extends Thread
{
	protected Transform transform = new Transform();

	private int instanceId;

	protected String tag = "";

	private boolean started = false;

	private boolean enabled = true;

	public String getTag()
	{
		return tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}

	public Transform getTransform()
	{
		return transform;
	}

	public int getInstanceId()
	{
		return instanceId;
	}

	public void setInstanceId(int instanceId)
	{
		this.instanceId = instanceId;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public GameObject(Vector2 position, double rotation)
	{
		this(position);
		transform.setRotation(rotation);
	}

	public GameObject(Vector2 position)
	{
		transform.setPosition(position);
		awake();
	}

	public void paint(Graphics2D g)
	{

	}

	public void awake()
	{

	}

	public void update()
	{

	}

	public void onDestroy()
	{
		enabled = false;
	}

	public void run()
	{
		while (enabled)
		{
			update();

			try
			{
				Thread.sleep(Scene.DELTA_TIME);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public double deltaTime()
	{
		return Scene.DELTA_TIME / 1000f;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + instanceId;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameObject other = (GameObject) obj;

		if (instanceId != other.instanceId)
			return false;

		return true;
	}
}
