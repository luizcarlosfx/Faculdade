package com.faculdade.topicos_especiais;

import java.io.File;

import javax.swing.JOptionPane;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

import com.faculdade.topicos_especiais.polinomio_lagrange.Curve;

public class PolinomioLagrange
{
	public static void main(String[] args)
	{		
		Curve curve = new Curve();

		curve.addPoint(0, 1);
		curve.addPoint(0.1f, 1);
		curve.addPoint(0.2f, 2);
		curve.addPoint(0.3f, 3);
		curve.addPoint(0.4f, 4);
		curve.addPoint(0.5f, 5);
		curve.addPoint(0.6f, 6);
		curve.addPoint(0.7f, 7);
		curve.addPoint(0.8f, 8);
		curve.addPoint(0.9f, 9);
		curve.addPoint(1f, 10);
		curve.addPoint(1.1f, 11);
		curve.addPoint(1.2f, 12);
		curve.addPoint(1.3f, 13);
		curve.addPoint(1.4f, 14);
		curve.addPoint(1.5f, 15);

		double time = Double.parseDouble(JOptionPane.showInputDialog("Digite o tempo"));

		System.out.println(curve.evaluate(time));
	}
}