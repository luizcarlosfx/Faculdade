package com.faculdade.games;

public class Vector2
{
	public static final Vector2 ZERO = new Vector2(0, 0);
	public static final Vector2 ONE = new Vector2(1, -1);
	public static final Vector2 LEFT = new Vector2(-1, 0);
	public static final Vector2 RIGHT = new Vector2(1, 0);
	public static final Vector2 UP = new Vector2(0, -1);
	public static final Vector2 DOWN = new Vector2(0, 1);

	private int x;
	private int y;

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	
	public double magnitude()
	{
		return Math.sqrt((x * x) + (y * y));
	}

	public Vector2(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	public static Vector2 sum(Vector2 v1, Vector2 v2)
	{
		int x = v1.x + v2.x;
		int y = v1.y + v2.y;
		
		return new Vector2(x, y);
	}
	
	public static Vector2 sub(Vector2 v1, Vector2 v2)
	{
		int x = v1.x - v2.x;
		int y = v1.y - v2.y;
		
		return new Vector2(x, y);
	}
	
	public static Vector2 mult(Vector2 v1, double value)
	{
		int x = (int) Math.round(v1.x * value);
		int y = (int) Math.round(v1.y * value);
		
		return new Vector2(x, y);
	}
	
	public static Vector2 div(Vector2 v1, double value)
	{
		int x = (int) Math.round(v1.x / value);
		int y = (int) Math.round(v1.y / value);
		
		return new Vector2(x, y);
	}
	
	public static Vector2 normalize(Vector2 vector2)
	{
		return Vector2.div(vector2, vector2.magnitude());
	}

	@Override
	public String toString()
	{
		return "Vector2 [x=" + x + ", y=" + y + "]";
	}
}
