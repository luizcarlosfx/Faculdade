package com.faculdade.sistemas_distribuidos.lab5;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Dolar extends JApplet
{
	private JLabel realLabel = new JLabel("Real R$");
	private JLabel dolarLabel = new JLabel("Dolar $");
	
	private JTextField realField = new JTextField("2");

	private JTextField dolarField = new JTextField("1");

	private double multiplier = 3.1;

	@Override
	public void init()
	{
		super.init();

		setLayout(new GridLayout(2, 2));

		setSize(200, 100);

		realField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				double real = Double.parseDouble(realField.getText());

				double dolar = real / multiplier;

				dolarField.setText(dolar + "");
			}
		});

		dolarField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				double dolar = Double.parseDouble(dolarField.getText());

				double real = dolar * multiplier;

				realField.setText(real + "");
			}
		});

		add(dolarLabel);
		add(dolarField);
		add(realLabel);
		add(realField);
	}
}
