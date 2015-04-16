package com.faculdade.games.m2.tank.base;

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
}
