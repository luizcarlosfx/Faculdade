package com.faculdade.games.m2.tank;

import java.awt.Point;
import java.awt.geom.AffineTransform;

public class MathUtils
{
	public static double getRotation(AffineTransform transform)
	{
		double[] matrix = new double[6];

		transform.getMatrix(matrix);

		return Math.toDegrees(Math.atan2(matrix[1], matrix[0]));
	}

	public static Point getTranslation(AffineTransform transform)
	{
		double[] matrix = new double[6];

		transform.getMatrix(matrix);

		return new Point((int) matrix[4], (int) matrix[5]);
	}

	public static double rotation(Vector2 vector)
	{
		double rotation = Math.toDegrees(Math.atan2(vector.y, vector.x));

		return validateAngle(rotation);
	}

	public static double validateAngle(double rotation)
	{
		if (rotation > 359)
		{
			rotation -= 360;
		}
		else if (rotation < 0)
		{
			rotation += 360;
		}

		return rotation;
	}

	/**
	 * 
	 * @param angle1
	 * @param angle2
	 * @return return the minimun difference between two angles. Clockwise or CounterClockwise
	 */
	public static double minAngleDiff(double angle1, double angle2)
	{
		angle1 = validateAngle(angle1);
		angle2 = validateAngle(angle2);
		
		double sign = Math.signum(angle1 - angle2);
		
		if(angle1 <= angle2)
		{
			double helper = angle1;
			angle1 = angle2;
			angle2 = helper;
//			sign = -1;
		}
		
		double diff1 = angle1 - angle2;
		
		double diff2 = 360 - angle1 + angle2;
		
		double diff = diff1 <= diff2 ? diff1 : diff2;
		
//		System.out.println(angle1 + " " + angle2 + ", " + diff);
		/*if(Math.abs(diff) > 180)
		{
			System.out.println(angle1 + ", " + angle2 + ", " + diff1 + ", " + diff2);
			try
			{
				Thread.sleep(10000000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		double y1 = Math.cos(angle1);
		double y2 = Math.cos(angle2);
		
		System.out.println("y1: " + y1 + ", y2: " + y2);
		return 10;
	}

	public static int ceilToInt(double value)
	{
		return (int) Math.ceil(value);
	}
}
