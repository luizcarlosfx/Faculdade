package com.faculdade.games.m2.tank;


public class Vector2
{
	public static final Vector2 ZERO = new Vector2(0, 0);
	public static final Vector2 ONE = new Vector2(1, -1);
	public static final Vector2 LEFT = new Vector2(-1, 0);
	public static final Vector2 RIGHT = new Vector2(1, 0);
	public static final Vector2 UP = new Vector2(0, 1);
	public static final Vector2 DOWN = new Vector2(0, -1);

	public double x;
	public double y;

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double magnitude()
	{
		return Math.sqrt((x * x) + (y * y));
	}

	public Vector2(double x, double y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	public Vector2(Vector2 vector)
	{
		this(vector.x, vector.y);
	}

	public void sum(Vector2 v2)
	{
		sum(v2.x, v2.y);
	}

	public void sum(double x, double y)
	{
		this.x += x;
		this.y += y;
	}
	
	public void sub(double x, double y)
	{
		this.x -= x;
		this.y -= y;
	}

	public void sub(Vector2 v2)
	{
		sub(v2.x, v2.y);
	}

	public void mult(double value)
	{
		this.x *= (int) Math.round(value);
		this.y *= (int) Math.round(value);
	}

	public void div(double value)
	{
		this.x /= (int) Math.round(value);
		this.y /= (int) Math.round(value);
	}
	
	public Vector2 normalized()
	{
		double mag = magnitude();
		
		this.x /= mag;
		
		this.y /= mag;
		
		return this;
	}

	public static Vector2 sum(Vector2 v1, Vector2 v2)
	{
		double x = v1.x + v2.x;
		double y = v1.y + v2.y;

		return new Vector2(x, y);
	}

	public static Vector2 sub(Vector2 v1, Vector2 v2)
	{
		double x = v1.x - v2.x;
		double y = v1.y - v2.y;

		return new Vector2(x, y);
	}

	public static Vector2 mult(Vector2 v1, double value)
	{
		double x = v1.x * value;
		double y = v1.y * value;

		return new Vector2(x, y);
	}

	public static Vector2 div(Vector2 v1, double value)
	{
		double x = v1.x / value;
		double y = v1.y / value;

		return new Vector2(x, y);
	}

	public static Vector2 normalize(Vector2 vector2)
	{
		return Vector2.div(vector2, vector2.magnitude());
	}
	
	public static double distance(Vector2 v1, Vector2 v2)
	{
		return sub(v2, v1).magnitude();
	}
	
	public static double angle(Vector2 v1, Vector2 v2)
	{
		double angle2 = MathUtils.rotation(v2);
		
		double angle1 = MathUtils.rotation(v1);
		
		return angle2 - angle1;
	}

	@Override
	public String toString()
	{
		return "Vector2 [x=" + x + ", y=" + y + "]";
	}
}
