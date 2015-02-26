package com.faculdade.topicos_especiais.polinomio_lagrange;

import java.util.ArrayList;
import java.util.List;

public class Curve
{
	private List<CurvePoint> points = new ArrayList<CurvePoint>();

	public void addPoint(double time, double value)
	{
		points.add(new CurvePoint(time, value));
	}

	public double evaluate(double time)
	{
		double total = 0;

		for (int i = 0; i < points.size(); i++)
		{
			double upTotal = points.get(i).getValue();
			double downTotal = 1;

			for (int j = 0; j < points.size(); j++)
			{
				if (j != i)
				{
					upTotal *= (time - points.get(j).getTime());
					downTotal *= (points.get(i).getTime() - points.get(j).getTime());
				}
			}
			
			total += (upTotal / downTotal);
		}

		return total;
	}
}
