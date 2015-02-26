package com.faculdade.games;

public class Transform
{
	private Vector2 position = Vector2.ZERO;

	public Vector2 getPosition()
	{
		return position;
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}
	
	public void translate(Vector2 translate)
	{
		position = Vector2.sum(position, translate);
	}
}
