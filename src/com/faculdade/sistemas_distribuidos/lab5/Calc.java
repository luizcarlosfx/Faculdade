package com.faculdade.sistemas_distribuidos.lab5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calc extends JApplet
{
	private JLabel num1 = new JLabel("Num 1");

	private JLabel num2 = new JLabel("Num 2");

	private JLabel total = new JLabel("Total");

	private JTextField num1Field = new JTextField();

	private JTextField num2Field = new JTextField();

	private JTextField result = new JTextField();

	private JButton sum = new JButton("+");

	private JButton sub = new JButton("-");

	private JButton div = new JButton("/");

	private JButton mult = new JButton("*");

	private JButton clean = new JButton("Limpar");

	@Override
	public void init()
	{
		// TODO Auto-generated method stub
		super.init();

		setLayout(new GridLayout(3, 4));

		sum.addActionListener(this::sum);
		sub.addActionListener(this::sub);
		div.addActionListener(this::div);
		mult.addActionListener(this::mult);
		clean.addActionListener(this::clean);

		add(num1, num1Field, sum, sub, num2, num2Field, mult, div, total, result, clean);

	}

	void sum(ActionEvent e)
	{
		double n1 = Double.parseDouble(num1Field.getText());
		double n2 = Double.parseDouble(num2Field.getText());

		result.setText((n1 + n2) + "");
	}

	void sub(ActionEvent e)
	{
		double n1 = Double.parseDouble(num1Field.getText());
		double n2 = Double.parseDouble(num2Field.getText());

		result.setText((n1 - n2) + "");
	}

	void div(ActionEvent e)
	{
		double n1 = Double.parseDouble(num1Field.getText());
		double n2 = Double.parseDouble(num2Field.getText());

		result.setText((n1 / n2) + "");
	}

	void mult(ActionEvent e)
	{
		double n1 = Double.parseDouble(num1Field.getText());
		double n2 = Double.parseDouble(num2Field.getText());

		result.setText((n1 * n2) + "");
	}

	void clean(ActionEvent e)
	{
		num1Field.setText("");
		num2Field.setText("");
		result.setText("");
	}

	void add(JComponent... components)
	{
		for (JComponent jComponent : components)
		{
			add(jComponent);
		}
	}
}
