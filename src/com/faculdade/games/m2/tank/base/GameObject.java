package com.faculdade.games.m2.tank.base;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import com.faculdade.games.m2.tank.SceneController;

public class GameObject
{
	private AffineTransform transform = new AffineTransform();

	private List<Component> components = new ArrayList<Component>();

	private int instanceId;

	private Tag tag;

	public AffineTransform transform()
	{
		return transform;
	}

	public int getInstanceId()
	{
		return instanceId;
	}

	public Tag getTag()
	{
		return tag;
	}

	public void setTag(Tag tag)
	{
		this.tag = tag;
	}

	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<T> clazz)
	{
		for (Component behaviour : components)
		{
			if (behaviour.getClass().isAssignableFrom(clazz))
			{
				return (T) behaviour;
			}
		}

		return null;
	}

	public GameObject(int instanceId, Point position, double rotation)
	{
		this(instanceId);
		transform.setToTranslation(position.x, position.y);
		transform.rotate(Math.toRadians(rotation));
	}

	public GameObject(int instanceId, AffineTransform transform)
	{
		this(instanceId);
		this.transform = transform;
	}

	private GameObject(int instanceId)
	{
		this.instanceId = instanceId;
		new Thread(this::run).start();
	}

	public void addComponent(Component component)
	{
		component.setGameObject(this);
		components.add(component);
		component.start();
	}

	public void paint(Graphics2D g)
	{
		AffineTransform old = g.getTransform();

		g.setTransform(transform);

		for (int i = 0; i < components.size(); i++)
		{
			components.get(i).paint(g);
		}

		g.setTransform(old);
	}

	public void update()
	{
		for (int i = 0; i < components.size(); i++)
		{
			components.get(i).update();
		}
	}

	public void run()
	{
		while (true)
		{
			update();

			try
			{
				Thread.sleep(SceneController.DELTA_TIME);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
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
