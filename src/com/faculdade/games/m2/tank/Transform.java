package com.faculdade.games.m2.tank;

import java.awt.geom.AffineTransform;

public class Transform
{
	private Vector2 position;

	private double rotation;

	public Vector2 up()
	{
		return transformVector(Vector2.UP);
	}

	public Vector2 left()
	{
		return transformVector(Vector2.LEFT);
	}

	public Vector2 down()
	{
		return transformVector(Vector2.DOWN);
	}

	public Vector2 right()
	{
		return transformVector(Vector2.RIGHT);
	}

	public Vector2 transformPoint(Vector2 vector)
	{
		Vector2 v = new Vector2(position);

		v.sum(transformVector(vector));

		return v;
	}

	public Vector2 inverseTransformPoint(Vector2 vector)
	{
		return inverseTransformVector(Vector2.sub(vector, position));
	}
	
	public Vector2 inverseTransformVector(Vector2 vector)
	{
		double n = Math.toRadians(-rotation);
		
		double x = vector.x;
		
		double y = vector.y;

		double rx = (x * Math.cos(n)) - (y * Math.sin(n));
		double ry = (x * Math.sin(n)) + (y * Math.cos(n));

		return new Vector2(rx, ry);
	}
	
	public Vector2 transformVector(Vector2 vector)
	{
		return transformVector(vector.x, vector.y);
	}

	public Vector2 transformVector(double x, double y)
	{
		double theta = Math.toRadians(rotation);

		double rx = (x * Math.cos(theta)) - (y * Math.sin(theta));
		double ry = (x * Math.sin(theta)) + (y * Math.cos(theta));

		return new Vector2(rx, ry);
	}

	private AffineTransform affineTransform = new AffineTransform();

	public Vector2 getPosition()
	{
		return position;
	}

	public double getRotation()
	{
		return rotation;
	}

	public AffineTransform getAffineTransform()
	{
		affineTransform.setToTranslation(position.x, position.y);
		affineTransform.rotate(Math.toRadians(rotation));

		return affineTransform;
	}

	public void rotate(double angle)
	{
		setRotation(rotation + angle);
	}

	public void setRotation(double angle)
	{
		this.rotation = MathUtils.validateAngle(angle);
	}

	public void translate(Vector2 vector)
	{
		translate(vector, Space.Local);
	}

	public void translate(Vector2 vector, Space space)
	{
		translate(vector.x, vector.y, space);
	}

	public void translate(double x, double y, Space space)
	{
		if (space == Space.Local)
		{
			position.sum(transformVector(x, y));
		}
		else
		{
			position.sum(x, y);
		}
	}

	public void translate(double x, double y)
	{
		translate(x, y, Space.Local);
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}

	public void setToPosition(int x, int y)
	{
		position.setX(x);
		position.setY(y);
	}
}